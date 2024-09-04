/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import org.bukkit.craftbukkit.event.CraftEventFactory;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    try {
      Field spellCastingTickCount = SpellcasterIllager.class.getDeclaredField("spellCastingTickCount");
      spellCastingTickCount.setAccessible(true);
      spellCastingTickCount.set(this.entity, this.getCastingTime());
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    this.nextAttackTickCount = this.entity.tickCount + this.getCastingInterval();
    SoundEvent soundeffect = this.getSpellPrepareSound();

    if (soundeffect != null) {
      this.entity.playSound(soundeffect, 1.0F, 1.0F);
    }

    this.entity.setIsCastingSpell(this.getSpell());
  }

  @Override
  public void tick() {
    this.attackWarmupDelay--;
    if (this.attackWarmupDelay == 0) {
      // CraftBukkit start

      if (!CraftEventFactory.handleEntitySpellCastEvent(this.entity, this.getSpell())) {
        return;
      }
      // CraftBukkit end
      this.performSpellCasting();

      SoundEvent soundEvent;
      try {
        Method getCastingSoundEvent = this.entity.getClass().getMethod("getCastingSoundEvent");
        getCastingSoundEvent.setAccessible(true);
        soundEvent = (SoundEvent) getCastingSoundEvent.invoke(this.entity);
      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        throw new RuntimeException(e);
      }
      this.entity.playSound(soundEvent, 1.0F, 1.0F);
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
