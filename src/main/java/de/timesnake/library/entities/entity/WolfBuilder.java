/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.TamableAnimalBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class WolfBuilder extends TamableAnimalBuilder<Wolf, WolfBuilder> {

  public WolfBuilder() {
    super();
  }

  @Override
  public Wolf create(ServerLevel world) {
    return new Wolf(EntityType.WOLF, world) {
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
    };
  }
}
