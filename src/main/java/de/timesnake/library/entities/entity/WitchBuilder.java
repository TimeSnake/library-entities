/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.RaiderBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableWitchTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestHealableRaiderTargetGoal;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;

public class WitchBuilder extends RaiderBuilder<Witch, WitchBuilder> {

  public WitchBuilder() {
    super();
  }

  @Override
  public Witch create(ServerLevel serverLevel) {
    return new Witch(EntityType.WITCH, serverLevel) {
      @Override
      protected void registerGoals() {
        if (loadDefaultPathfinderGoals) {
          super.registerGoals();
        } else {
          try {
            Field healRaidersGoal = Witch.class.getDeclaredField("healRaidersGoal");
            healRaidersGoal.setAccessible(true);
            healRaidersGoal.set(this, new NearestHealableRaiderTargetGoal<>(this, Raider.class, true,
                  (entityliving) -> entityliving != null && this.hasActiveRaid() && entityliving.getType() != EntityType.WITCH));
          } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
          }

          try {
            Field attackPlayersGoal = Witch.class.getDeclaredField("attackPlayersGoal");
            attackPlayersGoal.setAccessible(true);
            attackPlayersGoal.set(this, new NearestAttackableWitchTargetGoal<>(this, Player.class, 10, true,
                  false, null));
          } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
          }
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
