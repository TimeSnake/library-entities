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
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class ZombieBuilder extends MonsterBuilder<Zombie, ZombieBuilder> {

  public ZombieBuilder(Zombie entity) {
    super(entity);
  }

  public ZombieBuilder(ServerLevel world, boolean loadDefaultPathfinders, boolean randomizeData) {
    super(new Zombie(EntityType.ZOMBIE, world) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinders) {
          super.registerGoals();
        }
      }

      @Nullable
      @Override
      public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnReason, @Nullable SpawnGroupData entityData, @Nullable CompoundTag entityNbt) {
        if (randomizeData) {
          return super.finalizeSpawn(world, difficulty, spawnReason, entityData, entityNbt);
        }
        return entityData;
      }
    });
  }
}
