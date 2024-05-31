/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.monster.Vex;

public class EvokerSummonSpellGoal extends SpellcasterUseSpellGoal {

  private final TargetingConditions vexCountTargeting = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().ignoreInvisibilityTesting();

  private final Evoker entity;

  EvokerSummonSpellGoal(Evoker entity) {
    super(entity);
    this.entity = entity;
  }

  @Override
  public boolean canUse() {
    if (!super.canUse()) {
      return false;
    } else {
      int i = this.entity.level().getNearbyEntities(Vex.class, this.vexCountTargeting, this.entity, this.entity.getBoundingBox().inflate(16.0D)).size();

      return this.entity.getRandom().nextInt(8) + 1 > i;
    }
  }

  @Override
  protected int getCastingTime() {
    return 100;
  }

  @Override
  protected int getCastingInterval() {
    return 340;
  }

  @Override
  protected void performSpellCasting() {
    ServerLevel worldserver = (ServerLevel) this.entity.level();

    for (int i = 0; i < 3; ++i) {
      BlockPos blockposition = this.entity.blockPosition().offset(-2 + this.entity.getRandom().nextInt(5), 1, -2 + this.entity.getRandom().nextInt(5));
      Vex entityvex = (Vex) EntityType.VEX.create(this.entity.level());

      if (entityvex != null) {
        entityvex.moveTo(blockposition, 0.0F, 0.0F);
        entityvex.finalizeSpawn(worldserver, this.entity.level().getCurrentDifficultyAt(blockposition),
            MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null);
        entityvex.setOwner(this.entity);
        entityvex.setBoundOrigin(blockposition);
        entityvex.setLimitedLife(20 * (30 + this.entity.getRandom().nextInt(90)));
        worldserver.addFreshEntityWithPassengers(entityvex, org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason.SPELL); // CraftBukkit - Add SpawnReason
      }
    }

  }

  @Override
  protected SoundEvent getSpellPrepareSound() {
    return SoundEvents.EVOKER_PREPARE_SUMMON;
  }

  @Override
  protected SpellcasterIllager.IllagerSpell getSpell() {
    return SpellcasterIllager.IllagerSpell.SUMMON_VEX;
  }
}
