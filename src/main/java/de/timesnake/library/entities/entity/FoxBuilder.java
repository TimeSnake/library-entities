/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class FoxBuilder extends AnimalBuilder<Fox, FoxBuilder> {

  public FoxBuilder(Fox entity) {
    super(entity);
  }

  public FoxBuilder(ServerLevel world, boolean loadDefaultPathfinders, boolean randomizeData, boolean preventDespawn) {
    super(new Fox(EntityType.FOX, world) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinders) {
          super.registerGoals();
        }
      }

      @Nullable
      @Override
      public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
                                          MobSpawnType spawnReason, @Nullable SpawnGroupData entityData,
                                          @Nullable CompoundTag entityNbt) {
        if (randomizeData) {
          return super.finalizeSpawn(world, difficulty, spawnReason, entityData, entityNbt);
        }
        return entityData;
      }

      @Override
      public boolean removeWhenFarAway(double distanceSquared) {
        return preventDespawn;
      }

    });
    this.entity.persist = preventDespawn;
  }
}
