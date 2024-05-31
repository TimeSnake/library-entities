/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.event.entity.EntityTeleportEvent;

import java.util.EnumSet;

public class PetGoal extends Goal {

  private final Mob mob;
  private final LivingEntity owner;
  private final LevelReader level;
  private final double speedModifier;
  private final PathNavigation navigation;
  private int timeToRecalcPath;
  private final float stopDistance;
  private final float startDistance;
  private float oldWaterCost;
  private final boolean canFly;

  public PetGoal(Mob tameable, LivingEntity owner, double speed, float startDistance, float stopDistance,
                 boolean leavesAllowed) {
    this.mob = tameable;
    this.owner = owner;
    this.level = tameable.level();
    this.speedModifier = speed;
    this.navigation = tameable.getNavigation();
    this.startDistance = startDistance;
    this.stopDistance = stopDistance;
    this.canFly = leavesAllowed;
    this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    if (!(tameable.getNavigation() instanceof GroundPathNavigation) && !(tameable.getNavigation() instanceof FlyingPathNavigation)) {
      throw new IllegalArgumentException("Unsupported mob type for PetGoal");
    }
  }

  @Override
  public boolean canUse() {
    if (this.owner == null) {
      return false;
    } else if (this.owner.isSpectator()) {
      return false;
    } else if (this.unableToMove()) {
      return false;
    } else if (this.mob.distanceToSqr(this.owner) < (double) (this.startDistance * this.startDistance)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean canContinueToUse() {
    return !this.navigation.isDone() && !this.unableToMove()
        && this.mob.distanceToSqr(this.owner) > (double) (this.stopDistance * this.stopDistance);
  }

  private boolean unableToMove() {
    return this.mob.isPassenger() || this.mob.isLeashed();
  }

  @Override
  public void start() {
    this.timeToRecalcPath = 0;
    this.oldWaterCost = this.mob.getPathfindingMalus(PathType.WATER);
    this.mob.setPathfindingMalus(PathType.WATER, 0.0F);
  }

  @Override
  public void stop() {
    this.navigation.stop();
    this.mob.setPathfindingMalus(PathType.WATER, this.oldWaterCost);
  }

  @Override
  public void tick() {
    if (this.mob.distanceToSqr(this.owner) <= 16 * 16) {
      this.mob.getLookControl().setLookAt(this.owner, 10.0F, (float) this.mob.getMaxHeadXRot());
    }
    if (--this.timeToRecalcPath <= 0) {
      this.timeToRecalcPath = this.adjustedTickDelay(10);
      if (this.mob.distanceToSqr(this.owner) >= 144.0D) {
        this.teleportToOwner();
      } else {
        this.navigation.moveTo(this.owner, this.speedModifier);
      }

    }
  }

  private void teleportToOwner() {
    BlockPos blockposition = this.owner.blockPosition();

    for (int i = 0; i < 10; ++i) {
      int j = this.randomIntInclusive(-3, 3);
      int k = this.randomIntInclusive(-1, 1);
      int l = this.randomIntInclusive(-3, 3);
      boolean flag = this.maybeTeleportTo(blockposition.getX() + j, blockposition.getY() + k, blockposition.getZ() + l);

      if (flag) {
        return;
      }
    }

  }

  private boolean maybeTeleportTo(int x, int y, int z) {
    if (Math.abs((double) x - this.owner.getX()) < 2.0D && Math.abs((double) z - this.owner.getZ()) < 2.0D) {
      return false;
    } else if (!this.canTeleportTo(new BlockPos(x, y, z))) {
      return false;
    } else {
      CraftEntity entity = this.mob.getBukkitEntity();
      Location to = new Location(entity.getWorld(), x + 0.5, y, z + 0.5, this.mob.getYRot(), this.mob.getXRot());
      EntityTeleportEvent event = new org.bukkit.event.entity.EntityTeleportEvent(entity, entity.getLocation(), to);

      Bukkit.getPluginManager().callEvent(event);

      if (event.isCancelled()) {
        return false;
      }

      to = event.getTo();
      this.mob.moveTo(to.getX(), to.getY(), to.getZ(), to.getYaw(), to.getPitch());
      this.navigation.stop();
      return true;
    }
  }

  private boolean canTeleportTo(BlockPos pos) {
    PathType pathtype = WalkNodeEvaluator.getPathTypeStatic(this.mob, pos.mutable());

    if (pathtype != PathType.WALKABLE) {
      return false;
    } else {
      BlockState iblockdata = this.level.getBlockState(pos.below());

      if (!this.canFly && iblockdata.getBlock() instanceof LeavesBlock) {
        return false;
      } else {
        BlockPos blockposition1 = pos.subtract(this.mob.blockPosition());

        return this.level.noCollision(this.mob, this.mob.getBoundingBox().move(blockposition1));
      }
    }
  }

  private int randomIntInclusive(int min, int max) {
    return this.mob.getRandom().nextInt(max - min + 1) + min;
  }
}
