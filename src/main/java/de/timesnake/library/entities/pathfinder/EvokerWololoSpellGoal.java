/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GameRules;

import java.util.List;

public class EvokerWololoSpellGoal extends SpellcasterUseSpellGoal {

  private final TargetingConditions wololoTargeting = TargetingConditions.forNonCombat().range(16.0D).selector((entityliving) -> {
    return ((Sheep) entityliving).getColor() == DyeColor.BLUE;
  });

  private final Evoker entity;

  public EvokerWololoSpellGoal(Evoker entity) {
    super(entity);
    this.entity = entity;
  }

  @Override
  public boolean canUse() {
    if (this.entity.getTarget() != null) {
      return false;
    } else if (this.entity.isCastingSpell()) {
      return false;
    } else if (this.entity.tickCount < this.nextAttackTickCount) {
      return false;
    } else if (!this.entity.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
      return false;
    } else {
      List<Sheep> list = this.entity.level().getNearbyEntities(Sheep.class, this.wololoTargeting, this.entity, this.entity.getBoundingBox().inflate(16.0D, 4.0D, 16.0D));

      if (list.isEmpty()) {
        return false;
      } else {
        this.entity.setWololoTarget((Sheep) list.get(this.entity.getRandom().nextInt(list.size())));
        return true;
      }
    }
  }

  @Override
  public boolean canContinueToUse() {
    return this.entity.getWololoTarget() != null && this.attackWarmupDelay > 0;
  }

  @Override
  public void stop() {
    super.stop();
    this.entity.setWololoTarget((Sheep) null);
  }

  @Override
  protected void performSpellCasting() {
    Sheep entitysheep = this.entity.getWololoTarget();

    if (entitysheep != null && entitysheep.isAlive()) {
      entitysheep.setColor(DyeColor.RED);
    }

  }

  @Override
  protected int getCastWarmupTime() {
    return 40;
  }

  @Override
  protected int getCastingTime() {
    return 60;
  }

  @Override
  protected int getCastingInterval() {
    return 140;
  }

  @Override
  protected SoundEvent getSpellPrepareSound() {
    return SoundEvents.EVOKER_PREPARE_WOLOLO;
  }

  @Override
  protected SpellcasterIllager.IllagerSpell getSpell() {
    return SpellcasterIllager.IllagerSpell.WOLOLO;
  }
}
