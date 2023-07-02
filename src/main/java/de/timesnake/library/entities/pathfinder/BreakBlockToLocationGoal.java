/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.Path;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class BreakBlockToLocationGoal extends Goal {

  private final Mob entity;
  private final List<Material> materials;
  private final double speedModifier;

  private final double targetX;
  private final double targetY;
  private final double targetZ;

  private Block currentBlock;
  private BlockPos position;
  private Material currentBlockType;
  private double remainTime;
  private int soundDelay;

  public BreakBlockToLocationGoal(Mob entity, double x, double y, double z,
                                  double speedModifier, Material... materials) {
    this.entity = entity;
    this.targetX = x;
    this.targetY = y;
    this.targetZ = z;
    this.speedModifier = speedModifier;
    this.materials = Arrays.asList(materials);
    this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE, Flag.LOOK));
  }

  public List<Material> getMaterials() {
    return materials;
  }

  private void setCurrentBlock(BlockPos block) {
    this.currentBlock = this.entity.getBukkitEntity().getWorld().getBlockAt(block.getX(), block.getY(), block.getZ());
    this.currentBlockType = this.currentBlock.getType();
    this.remainTime = this.currentBlock.getType().getHardness();
    this.soundDelay = 0;
  }

  private boolean isBlockBreakable(BlockPos block) {
    Material blockData = this.entity.getBukkitEntity().getWorld().getType(block.getX(), block.getY(), block.getZ());
    if (blockData.isAir() || !blockData.isCollidable()) {
      return false;
    }

    if (this.materials.isEmpty()) {
      return true;
    }

    if (this.materials.contains(this.entity.getBukkitEntity().getWorld()
        .getBlockAt(block.getX(), block.getY(), block.getZ()).getType())) {
      return true;
    }

    return false;
  }

  @Override
  public boolean canUse() {
    int x = this.entity.getBlockX();
    int y = this.entity.getBlockY();
    int z = this.entity.getBlockZ();

    BlockPos target = this.entity.getNavigation().getTargetPos();

    if (target == null) {
      return false;
    }

    PathNavigation navigation = this.entity.getNavigation();
    Path path = navigation.getPath();

    if (remainTime > 0) {
      return false;
    }

    if (path != null && navigation.isDone()) {
      if (path.getNodeCount() <= 1) {
        this.position = new BlockPos(x, y, z);

        if (this.isBlockBreakable(position)) {
          this.setCurrentBlock(position);
          return true;
        }

        // calc look block, check reachable
        double deltaX = this.targetX - x;
        double deltaY = this.targetY - y;
        double deltaZ = this.targetZ - z;

        if (deltaX * deltaX > deltaZ * deltaZ) {
          x = deltaX > 0 ? x + 1 : x - 1;
        } else {
          z = deltaZ > 0 ? z + 1 : z - 1;
        }

        y++; //select head block

        BlockPos position = new BlockPos(x, y, z);

        if (this.isBlockBreakable(position)) {
          this.setCurrentBlock(position);
          return true;
        }

        if (deltaY > 0) {
          position = new BlockPos(x, y + 1, z); // make stairs
        } else {
          position = new BlockPos(x, y - 1, z); // make tunnel
        }

        if (this.isBlockBreakable(position)) {
          this.setCurrentBlock(position);
          return true;
        }

      }
    }
    return false;
  }

  @Override
  public boolean canContinueToUse() {
    return this.canUse();
  }

  @Override
  public boolean isInterruptable() {
    this.remainTime -= this.speedModifier / 20;
    this.entity.getLookControl().setLookAt(this.currentBlock.getX() + 0.5, this.currentBlock.getY() + 0.5,
        this.currentBlock.getZ() + 0.5);
    this.entity.getNavigation().createPath(this.position, 1);
    if (this.soundDelay <= 0) {
      this.entity.swing(InteractionHand.MAIN_HAND);
      this.currentBlock.getWorld().playSound(this.currentBlock.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 0.5F, 1F);
      this.soundDelay = 20;
    }
    this.soundDelay--;

    boolean cancel =
        !(this.currentBlock.getType().equals(this.currentBlockType) &&
            this.entity.distanceToSqr(this.currentBlock.getX() + 0.5, this.currentBlock.getY(), this.currentBlock.getZ() + 0.5) < 2.5);

    if (cancel) {
      this.currentBlock = null;
    }

    return this.remainTime > 0 && !cancel;
  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {
    if (this.currentBlock != null) {
      this.currentBlock.getWorld()
          .playEffect(this.currentBlock.getLocation(), Effect.STEP_SOUND,
              this.currentBlock.getType());
      this.currentBlock.setType(Material.AIR);
    }

    this.remainTime = 0;
    this.soundDelay = 0;
    this.currentBlockType = null;
    this.currentBlock = null;
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return false;
  }

  @Override
  public void tick() {

  }
}
