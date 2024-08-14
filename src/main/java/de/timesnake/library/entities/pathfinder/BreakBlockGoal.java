/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;

import java.util.*;

public class BreakBlockGoal extends Goal implements LocationTargetable {

  private final Mob entity;
  private final List<Material> materials;
  private final double speedModifier;
  private final boolean ignoreTarget;
  private final BreakEvent event;
  private Integer targetX;
  private Integer targetY;
  private Integer targetZ;
  private Block currentBlock;
  private BlockPos position;
  private Material currentBlockType;
  private double remainTime;
  private int soundDelay;

  public BreakBlockGoal(Mob entity, double speedModifier, boolean ignoreTarget, Material... materials) {
    this(entity, speedModifier, ignoreTarget, null, Arrays.asList(materials));
  }

  public BreakBlockGoal(Mob entity, double speedModifier, boolean ignoreTarget, Collection<Material> materials) {
    this(entity, speedModifier, ignoreTarget, null, materials);
  }

  public BreakBlockGoal(Mob entity, double speedModifier, boolean ignoreTarget, BreakEvent event,
                        Collection<Material> materials) {
    this.entity = entity;
    this.speedModifier = speedModifier;
    this.ignoreTarget = ignoreTarget;
    this.materials = new ArrayList<>(materials);
    this.event = event;
    this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE, Flag.LOOK));
  }

  @Override
  public boolean canUse() {
    if (targetX == null || targetY == null || targetZ == null) {
      return false;
    }

    int x = this.entity.getBlockX();
    int y = this.entity.getBlockY();
    int z = this.entity.getBlockZ();

    BlockPos target = this.entity.getNavigation().getTargetPos();

    if (target == null && !this.ignoreTarget) {
      return false;
    }

    PathNavigation navigation = this.entity.getNavigation();
    Path pathEntity = navigation.getPath();

    if (remainTime > 0) {
      return false;
    }

    if (pathEntity != null && navigation.isDone()) {
      this.position = new BlockPos(x, y, z);

      if (this.isBlockBreakable(this.position)) {
        this.setCurrentBlock(this.position);
        return true;
      }

      // calc look block, check reachable
      double deltaX = this.targetX - x;
      double deltaZ = this.targetZ - z;

      if (deltaX != 0) {
        if (deltaX > 0) {
          if (this.checkBlock(x + 1, y, z)) {
            return true;
          }
        } else {
          if (this.checkBlock(x - 1, y, z)) {
            return true;
          }
        }
      }

      if (deltaZ != 0) {
        if (deltaZ > 0) {
          if (this.checkBlock(x, y, z + 1)) {
            return true;
          }
        } else {
          if (this.checkBlock(x, y, z - 1)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  @Override
  public boolean canContinueToUse() {
    boolean cancel = !(this.currentBlock.getType().equals(this.currentBlockType) ||
        this.entity.getPosition(0).distanceToSqr(this.currentBlock.getX() + 0.5,
            this.currentBlock.getY(), this.currentBlock.getZ() + 0.5) > 3.5);

    if (cancel) {
      this.currentBlock = null;
    }

    if (this.remainTime <= 0 || cancel) {
      return false;
    }

    return true;
  }

  @Override
  public boolean isInterruptable() {
    return true;
  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {
    if (this.currentBlock != null) {
      this.currentBlock.getWorld().playEffect(this.currentBlock.getLocation(), Effect.STEP_SOUND, this.currentBlock.getType());
      this.currentBlock.setType(Material.AIR);

      if (this.event != null) {
        this.event.onBlockBreak(this.currentBlock);
      }
    }

    this.entity.setAggressive(false);

    this.remainTime = 0;
    this.soundDelay = 0;
    this.currentBlockType = null;
    this.currentBlock = null;

    this.targetX = null;
    this.targetY = null;
    this.targetZ = null;
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    this.entity.setAggressive(true);
    this.entity.setTarget(null);
    this.remainTime -= this.speedModifier / 20;
    this.entity.getLookControl().setLookAt(this.currentBlock.getX() + 0.5, this.currentBlock.getY() + 0.5, this.currentBlock.getZ() + 0.5);
    this.entity.getNavigation().createPath(this.position, 1);
    if (this.soundDelay <= 0) {
      this.entity.swing(InteractionHand.MAIN_HAND);
      this.currentBlock.getWorld().playSound(this.currentBlock.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 0.5F, 1F);
      this.soundDelay = 10;
    }
    this.soundDelay--;
  }

  protected int adjustedTickDelay(int ticks) {
    return this.requiresUpdateEveryTick() ? ticks : reducedTickDelay(ticks);
  }

  protected static int reducedTickDelay(int serverTicks) {
    return Mth.positiveCeilDiv(serverTicks, 2);
  }

  private boolean checkBlock(int x, int y, int z) {
    BlockPos position = new BlockPos(x, y, z);

    double deltaY = this.targetY - y;

    if (this.isBlockBreakable(position)) {
      this.setCurrentBlock(position);
      return true;
    }

    position = new BlockPos(x, y + 1, z);

    if (this.isBlockBreakable(position)) {
      this.setCurrentBlock(position);
      return true;
    }

    if (deltaY > 0) {
      position = new BlockPos(x, y + 2, z); // make stairs
    } else {
      position = new BlockPos(x, y - 1, z); // make tunnel
    }

    if (this.isBlockBreakable(position)) {
      this.setCurrentBlock(position);
      return true;
    }

    return false;
  }

  private void setCurrentBlock(BlockPos block) {
    this.position = block;
    this.currentBlock = this.entity.getBukkitEntity().getWorld().getBlockAt(block.getX(), block.getY(), block.getZ());
    this.currentBlockType = this.currentBlock.getType();
    this.remainTime = this.currentBlock.getType().getHardness();
    this.soundDelay = 0;
  }

  private boolean isBlockBreakable(BlockPos block) {
    BlockState blockData = this.entity.level().getBlockState(block);
    if (blockData.isAir() || blockData.liquid()) {
      return false;
    }

    if (this.materials.isEmpty()) {
      return true;
    }

    if (this.materials.contains(this.entity.getBukkitEntity().getWorld().getBlockAt(block.getX(), block.getY(),
        block.getZ()).getType())) {
      return true;
    }

    return false;
  }

  public void setTarget(int x, int y, int z) {
    this.targetX = x;
    this.targetY = y;
    this.targetZ = z;
  }

  @Override
  public void clearTarget() {
    this.targetX = null;
    this.targetY = null;
    this.targetZ = null;
  }

  @FunctionalInterface
  public interface BreakEvent {

    void onBlockBreak(Block block);
  }
}
