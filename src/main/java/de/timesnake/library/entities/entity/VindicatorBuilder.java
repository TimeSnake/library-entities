/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.AbstractIllagerBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class VindicatorBuilder extends AbstractIllagerBuilder<Vindicator, VindicatorBuilder> {

  public VindicatorBuilder() {
    super();
  }

  @Override
  public Vindicator create(ServerLevel serverLevel) {
    return new Vindicator(EntityType.VINDICATOR, serverLevel) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinderGoals) {
          super.registerGoals();
        }
      }

      @Nullable
      @Override
      public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
                                          MobSpawnType spawnReason, @Nullable SpawnGroupData entityData,
                                          @Nullable CompoundTag entityNbt) {
        if (randomizeDataOnSpawn) {
          return super.finalizeSpawn(world, difficulty, spawnReason, entityData, entityNbt);
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
    };
  }
}
