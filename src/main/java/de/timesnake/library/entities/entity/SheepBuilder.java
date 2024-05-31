/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.AnimalBuilder;
import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class SheepBuilder extends AnimalBuilder<Sheep, SheepBuilder> {

  public SheepBuilder() {
    super();
  }

  @Override
  public Sheep create(ServerLevel world) {
    return new Sheep(EntityType.SHEEP, world) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinderGoals) {
          super.registerGoals();
        } else {
          ProxyManager.getInstance().getSheepProxy().setEatBlockGoal(this, new NotEatBlockGoal(this));
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

  public static class NotEatBlockGoal extends EatBlockGoal {

    public NotEatBlockGoal(Mob mob) {
      super(mob);
    }

    @Override
    public boolean canUse() {
      return false;
    }
  }
}
