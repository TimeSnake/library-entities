/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.AbstractSkeletonBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class StrayBuilder extends AbstractSkeletonBuilder<Stray, StrayBuilder> {

  public StrayBuilder() {
    super();
  }

  @Override
  public Stray create(ServerLevel serverLevel) {
    return new Stray(EntityType.STRAY, serverLevel) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinderGoals) {
          super.registerGoals();
        }
      }

      @Nullable
      @Override
      public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
                                          MobSpawnType spawnReason, @Nullable SpawnGroupData entityData) {
        if (randomizeDataOnSpawn) {
          return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
        }
        return entityData;
      }

      @Override
      public boolean removeWhenFarAway(double distanceSquared) {
        return !preventDespawning && super.removeWhenFarAway(distanceSquared);
      }

      @Override
      public boolean isVehicle() {
        return !neverVehicle && super.isVehicle();
      }

      @Override
      public void reassessWeaponGoal() {
        if (loadDefaultPathfinderGoals) {
          super.reassessWeaponGoal();
        } else {
          if (!this.level().isClientSide) {
            this.goalSelector.removeGoal(StrayBuilder.this.meleeGoal);
            this.goalSelector.removeGoal(StrayBuilder.this.bowGoal);
            ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW));

            if (itemstack.is(Items.BOW)) {
              int i = this.getHardAttackInterval();

              if (this.level().getDifficulty() != Difficulty.HARD) {
                i = this.getAttackInterval();
              }

              if (StrayBuilder.this.bowGoal != null) {
                StrayBuilder.this.bowGoal.setMinAttackInterval(i);
                this.goalSelector.addGoal(4, StrayBuilder.this.bowGoal);
              }
            } else if (StrayBuilder.this.meleeGoal != null) {
              this.goalSelector.addGoal(4, StrayBuilder.this.meleeGoal);
            }
          }
        }
      }
    };
  }
}
