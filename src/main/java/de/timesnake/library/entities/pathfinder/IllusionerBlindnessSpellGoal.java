/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.SpellcasterIllager;

public class IllusionerBlindnessSpellGoal extends SpellcasterUseSpellGoal {

  private final Illusioner entity;
  private int lastTargetId;

  IllusionerBlindnessSpellGoal(Illusioner entity) {
    super(entity);
    this.entity = entity;
  }

  @Override
  public boolean canUse() {
    return super.canUse() && (this.entity.getTarget() != null && (this.entity.getTarget().getId() != this.lastTargetId
        && this.entity.level().getCurrentDifficultyAt(this.entity.blockPosition()).isHarderThan((float) Difficulty.NORMAL.ordinal())));
  }

  @Override
  public void start() {
    super.start();
    LivingEntity entityliving = this.entity.getTarget();

    if (entityliving != null) {
      this.lastTargetId = entityliving.getId();
    }

  }

  @Override
  protected int getCastingTime() {
    return 20;
  }

  @Override
  protected int getCastingInterval() {
    return 180;
  }

  @Override
  protected void performSpellCasting() {
    this.entity.getTarget().addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 400), this.entity, org.bukkit.event.entity.EntityPotionEffectEvent.Cause.ATTACK); // CraftBukkit
  }

  @Override
  protected SoundEvent getSpellPrepareSound() {
    return SoundEvents.ILLUSIONER_PREPARE_BLINDNESS;
  }

  @Override
  protected SpellcasterIllager.IllagerSpell getSpell() {
    return SpellcasterIllager.IllagerSpell.BLINDNESS;
  }
}
