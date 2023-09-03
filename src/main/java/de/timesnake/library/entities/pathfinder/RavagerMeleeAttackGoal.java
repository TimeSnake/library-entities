package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Ravager;

public class RavagerMeleeAttackGoal extends MeleeAttackGoal {

  public RavagerMeleeAttackGoal(Ravager ravager, double speed) {
    super(ravager, speed, true);
  }

  @Override
  protected double getAttackReachSqr(LivingEntity entity) {
    float f = this.mob.getBbWidth() - 0.1F;
    return f * 2.0F * f * 2.0F + entity.getBbWidth();
  }
}