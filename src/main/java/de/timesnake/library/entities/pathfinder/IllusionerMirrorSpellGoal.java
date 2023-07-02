/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.SpellcasterIllager;

import javax.annotation.Nullable;

public class IllusionerMirrorSpellGoal extends SpellcasterUseSpellGoal {

  private final Illusioner entity;

  IllusionerMirrorSpellGoal(Illusioner entity) {
    super(entity);
    this.entity = entity;
  }

  @Override
  public boolean canUse() {
    return super.canUse() && !this.entity.hasEffect(MobEffects.INVISIBILITY);
  }

  @Override
  protected int getCastingTime() {
    return 20;
  }

  @Override
  protected int getCastingInterval() {
    return 340;
  }

  @Override
  protected void performSpellCasting() {
    this.entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1200), org.bukkit.event.entity.EntityPotionEffectEvent.Cause.ILLUSION); // CraftBukkit
  }

  @Nullable
  @Override
  protected SoundEvent getSpellPrepareSound() {
    return SoundEvents.ILLUSIONER_PREPARE_MIRROR;
  }

  @Override
  protected SpellcasterIllager.IllagerSpell getSpell() {
    return SpellcasterIllager.IllagerSpell.DISAPPEAR;
  }
}
