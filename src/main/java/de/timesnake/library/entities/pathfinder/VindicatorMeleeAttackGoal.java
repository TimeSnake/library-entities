/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Vindicator;

public class VindicatorMeleeAttackGoal extends MeleeAttackGoal {
  public VindicatorMeleeAttackGoal(Vindicator vindicator, double speed) {
    super(vindicator, speed, false);
  }

  @Override
  protected double getAttackReachSqr(LivingEntity entity) {
    if (this.mob.getVehicle() instanceof Ravager) {
      float f = this.mob.getVehicle().getBbWidth() - 0.1F;
      return (double) (f * 2.0F * f * 2.0F + entity.getBbWidth());
    } else {
      return super.getAttackReachSqr(entity);
    }
  }
}
