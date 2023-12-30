/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import com.mojang.serialization.Dynamic;
import de.timesnake.library.entities.entity.base.AbstractVillagerBuilder;
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

  public VillagerBuilder() {
    super();
  }

  @Override
  public Villager create(ServerLevel serverLevel) {
    return new Villager(EntityType.VILLAGER, serverLevel) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinderGoals) {
          super.registerGoals();
        }
      }

      @Override
      protected Brain<?> makeBrain(Dynamic<?> dynamic) {
        if (loadDefaultPathfinderGoals) {
          return super.makeBrain(dynamic);
        }
        return this.brainProvider().makeBrain(dynamic);
      }

      @Override
      public void refreshBrain(ServerLevel world) {
        if (loadDefaultPathfinderGoals) {
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
