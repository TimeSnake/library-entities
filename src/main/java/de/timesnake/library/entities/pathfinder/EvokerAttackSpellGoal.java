/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EvokerAttackSpellGoal extends SpellcasterUseSpellGoal {

  private final Evoker entity;

  EvokerAttackSpellGoal(Evoker evoker) {
    super(evoker);
    this.entity = evoker;
  }

  @Override
  protected int getCastingTime() {
    return 40;
  }

  @Override
  protected int getCastingInterval() {
    return 100;
  }

  @Override
  protected void performSpellCasting() {
    LivingEntity entityliving = this.entity.getTarget();
    double d0 = Math.min(entityliving.getY(), this.entity.getY());
    double d1 = Math.max(entityliving.getY(), this.entity.getY()) + 1.0D;
    float f = (float) Mth.atan2(entityliving.getZ() - this.entity.getZ(), entityliving.getX() - this.entity.getX());
    int i;

    if (this.entity.distanceToSqr((Entity) entityliving) < 9.0D) {
      float f1;

      for (i = 0; i < 5; ++i) {
        f1 = f + (float) i * 3.1415927F * 0.4F;
        this.createSpellEntity(this.entity.getX() + (double) Mth.cos(f1) * 1.5D, this.entity.getZ() + (double) Mth.sin(f1) * 1.5D, d0, d1, f1, 0);
      }

      for (i = 0; i < 8; ++i) {
        f1 = f + (float) i * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
        this.createSpellEntity(this.entity.getX() + (double) Mth.cos(f1) * 2.5D, this.entity.getZ() + (double) Mth.sin(f1) * 2.5D, d0, d1, f1, 3);
      }
    } else {
      for (i = 0; i < 16; ++i) {
        double d2 = 1.25D * (double) (i + 1);
        int j = 1 * i;

        this.createSpellEntity(this.entity.getX() + (double) Mth.cos(f) * d2, this.entity.getZ() + (double) Mth.sin(f) * d2, d0, d1, f, j);
      }
    }

  }

  private void createSpellEntity(double x, double z, double maxY, double y, float yaw, int warmup) {
    BlockPos blockposition = BlockPos.containing(x, y, z);
    boolean flag = false;
    double d4 = 0.0D;

    do {
      BlockPos blockposition1 = blockposition.below();
      BlockState iblockdata = this.entity.level().getBlockState(blockposition1);

      if (iblockdata.isFaceSturdy(this.entity.level(), blockposition1, Direction.UP)) {
        if (!this.entity.level().isEmptyBlock(blockposition)) {
          BlockState iblockdata1 = this.entity.level().getBlockState(blockposition);
          VoxelShape voxelshape = iblockdata1.getCollisionShape(this.entity.level(), blockposition);

          if (!voxelshape.isEmpty()) {
            d4 = voxelshape.max(Direction.Axis.Y);
          }
        }

        flag = true;
        break;
      }

      blockposition = blockposition.below();
    } while (blockposition.getY() >= Mth.floor(maxY) - 1);

    if (flag) {
      this.entity.level().addFreshEntity(new EvokerFangs(this.entity.level(), x, (double) blockposition.getY() + d4, z, yaw, warmup, this.entity));
    }

  }

  @Override
  protected SoundEvent getSpellPrepareSound() {
    return SoundEvents.EVOKER_PREPARE_ATTACK;
  }

  @Override
  protected SpellcasterIllager.IllagerSpell getSpell() {
    return SpellcasterIllager.IllagerSpell.FANGS;
  }
}
