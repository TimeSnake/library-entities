/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Fox;

import java.util.EnumSet;

public class FoxSleepGoal extends FoxBehaviorGoal {

  private static final int WAIT_TIME_BEFORE_SLEEP = reducedTickDelay(140);
  private int countdown;

  public FoxSleepGoal(Fox fox) {
    super(fox);
    this.countdown = this.fox.getRandom().nextInt(WAIT_TIME_BEFORE_SLEEP);
    this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
  }

  @Override
  public boolean canUse() {
    return this.fox.xxa == 0.0F && this.fox.yya == 0.0F && this.fox.zza == 0.0F && (this.canSleep() || this.fox.isSleeping());
  }

  @Override
  public boolean canContinueToUse() {
    return this.canSleep();
  }

  private boolean canSleep() {
    if (this.countdown > 0) {
      --this.countdown;
      return false;
    } else {
      return this.fox.level().isDay() && this.hasShelter() && !this.alertable() && !this.fox.isInPowderSnow;
    }
  }

  @Override
  public void stop() {
    this.countdown = this.fox.getRandom().nextInt(WAIT_TIME_BEFORE_SLEEP);
    this.fox.setIsInterested(false);
    this.fox.setIsCrouching(false);
    this.fox.setSitting(false);
    this.fox.setSleeping(false);
    this.fox.setDefending(false);
    this.fox.setFaceplanted(false);
  }

  @Override
  public void start() {
    this.fox.setSitting(false);
    this.fox.setIsCrouching(false);
    this.fox.setIsInterested(false);
    this.fox.setJumping(false);
    this.fox.setSleeping(true);
    this.fox.getNavigation().stop();
    this.fox.getMoveControl().setWantedPosition(this.fox.getX(), this.fox.getY(), this.fox.getZ(), 0.0D);
  }
}
