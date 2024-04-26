/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ParrotWanderGoal extends WaterAvoidingRandomFlyingGoal {

  public ParrotWanderGoal(PathfinderMob mob, double speed) {
    super(mob, speed);
  }

  @Nullable
  @Override
  protected Vec3 getPosition() {
    Vec3 vec3d = null;

    if (this.mob.isInWater()) {
      vec3d = LandRandomPos.getPos(this.mob, 15, 15);
    }

    if (this.mob.getRandom().nextFloat() >= this.probability) {
      vec3d = this.getTreePos();
    }

    return vec3d == null ? super.getPosition() : vec3d;
  }

  @Nullable
  private Vec3 getTreePos() {
    BlockPos blockposition = this.mob.blockPosition();
    BlockPos.MutableBlockPos blockposition_mutableblockposition = new BlockPos.MutableBlockPos();
    BlockPos.MutableBlockPos blockposition_mutableblockposition1 = new BlockPos.MutableBlockPos();
    Iterable<BlockPos> iterable = BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 3.0D),
        Mth.floor(this.mob.getY() - 6.0D), Mth.floor(this.mob.getZ() - 3.0D), Mth.floor(this.mob.getX() + 3.0D),
        Mth.floor(this.mob.getY() + 6.0D), Mth.floor(this.mob.getZ() + 3.0D));

    for (BlockPos blockposition1 : iterable) {
      if (!blockposition.equals(blockposition1)) {
        BlockState iblockdata =
            this.mob.level().getBlockState(blockposition_mutableblockposition1.setWithOffset(blockposition1,
                Direction.DOWN));
        boolean flag = iblockdata.getBlock() instanceof LeavesBlock || iblockdata.is(BlockTags.LOGS);

        if (flag && this.mob.level().isEmptyBlock(blockposition1) && this.mob.level().isEmptyBlock(blockposition_mutableblockposition.setWithOffset(blockposition1, Direction.UP))) {
          return Vec3.atBottomCenterOf(blockposition1);
        }
      }
    }

    return null;
  }
}
