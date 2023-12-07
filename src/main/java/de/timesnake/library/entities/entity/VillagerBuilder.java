/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import com.mojang.serialization.Dynamic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class VillagerBuilder extends AbstractVillagerBuilder<Villager, VillagerBuilder> {

  public VillagerBuilder(Villager entity) {
    super(entity);
  }

  public VillagerBuilder(ServerLevel world, boolean loadDefaultPathfinders, boolean randomizeData, boolean preventDespawn) {
    super(new Villager(EntityType.VILLAGER, world) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinders) {
          super.registerGoals();
        }
      }

      @Override
      protected Brain<?> makeBrain(Dynamic<?> dynamic) {
        if (loadDefaultPathfinders) {
          return super.makeBrain(dynamic);
        }
        return this.brainProvider().makeBrain(dynamic);
      }

      @Override
      public void refreshBrain(ServerLevel world) {
        if (loadDefaultPathfinders) {
          super.refreshBrain(world);
          return;
        }

        Brain<Villager> behaviorcontroller = this.getBrain();
        behaviorcontroller.stopAll(world, this);
        this.brain = behaviorcontroller.copyWithoutBehaviors();
      }


      @Nullable
      @Override
      public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnReason, @Nullable SpawnGroupData entityData, @Nullable CompoundTag entityNbt) {
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
