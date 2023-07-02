/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Creeper;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class SwellGoal extends Goal {
  private final Creeper creeper;
  @Nullable
  private LivingEntity target;

  private final double swellDistance;
  private final double keepSwellingDistance;

  public SwellGoal(Creeper creeper, double swellDistance, double keepSwellingDistance) {
    this.creeper = creeper;
    this.swellDistance = swellDistance;
    this.keepSwellingDistance = keepSwellingDistance;
    this.setFlags(EnumSet.of(Goal.Flag.MOVE));
  }

  public SwellGoal(Creeper creeper) {
    this(creeper, 3, 7);
  }

  @Override
  public boolean canUse() {
    LivingEntity livingEntity = this.creeper.getTarget();
    return this.creeper.getSwellDir() > 0 || livingEntity != null && this.creeper.distanceToSqr(livingEntity) < this.swellDistance * this.swellDistance;
  }

  // Paper start - Fix MC-179072
  @Override
  public boolean canContinueToUse() {
    return !net.minecraft.world.entity.EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(this.creeper.getTarget()) && canUse();
  }
  // Paper end

  @Override
  public void start() {
    this.creeper.getNavigation().stop();
    this.target = this.creeper.getTarget();
  }

  @Override
  public void stop() {
    this.target = null;
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    if (this.target == null) {
      this.creeper.setSwellDir(-1);
    } else if (this.creeper.distanceToSqr(this.target) > this.keepSwellingDistance * this.keepSwellingDistance) {
      this.creeper.setSwellDir(-1);
    } else if (!this.creeper.getSensing().hasLineOfSight(this.target)) {
      this.creeper.setSwellDir(-1);
    } else {
      this.creeper.setSwellDir(1);
    }
  }
}

