/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.MonsterBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class SpiderBuilder<E extends Spider, B extends SpiderBuilder<E, B>> extends MonsterBuilder<E, B> {

  public SpiderBuilder() {
    super();
  }

  @Override
  protected E create(ServerLevel serverLevel) {
    return (E) new Spider(EntityType.SPIDER, serverLevel) {
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
