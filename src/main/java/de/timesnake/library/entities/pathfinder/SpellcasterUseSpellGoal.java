/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.SpellcasterIllager;

import javax.annotation.Nullable;

public abstract class SpellcasterUseSpellGoal extends Goal {

  protected int attackWarmupDelay;
  protected int nextAttackTickCount;

  protected final SpellcasterIllager entity;

  protected SpellcasterUseSpellGoal(SpellcasterIllager entity) {
    this.entity = entity;
  }

  @Override
  public boolean canUse() {
    LivingEntity entityliving = this.entity.getTarget();
    return entityliving != null && entityliving.isAlive() && (!this.entity.isCastingSpell() && this.entity.tickCount >= this.nextAttackTickCount);
  }

  @Override
  public boolean canContinueToUse() {
    LivingEntity entityliving = this.entity.getTarget();
    return entityliving != null && entityliving.isAlive() && this.attackWarmupDelay > 0;
  }

  @Override
  public void start() {
    this.attackWarmupDelay = this.adjustedTickDelay(this.getCastWarmupTime());
    ProxyManager.getInstance().getSpellcasterIllagerProxy().setSpellCastingTickCount(this.entity, this.getCastingTime());
    this.nextAttackTickCount = this.entity.tickCount + this.getCastingInterval();
    SoundEvent soundeffect = this.getSpellPrepareSound();

    if (soundeffect != null) {
      this.entity.playSound(soundeffect, 1.0F, 1.0F);
    }

    this.entity.setIsCastingSpell(this.getSpell());
  }

  @Override
  public void tick() {
    --this.attackWarmupDelay;
    if (this.attackWarmupDelay == 0) {
      // CraftBukkit start
      if (!org.bukkit.craftbukkit.v1_20_R1.event.CraftEventFactory.handleEntitySpellCastEvent(this.entity, this.getSpell())) {
        return;
      }
      // CraftBukkit end
      this.performSpellCasting();
      this.entity.playSound(ProxyManager.getInstance().getSpellcasterIllagerProxy().getCastingSoundEvent(this.entity), 1.0F, 1.0F);
    }

  }

  protected abstract void performSpellCasting();

  protected int getCastWarmupTime() {
    return 20;
  }

  protected abstract int getCastingTime();

  protected abstract int getCastingInterval();

  @Nullable
  protected abstract SoundEvent getSpellPrepareSound();

  protected abstract SpellcasterIllager.IllagerSpell getSpell();
}
