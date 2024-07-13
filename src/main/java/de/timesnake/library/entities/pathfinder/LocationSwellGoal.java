/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Creeper;

import java.util.EnumSet;

public class LocationSwellGoal extends Goal implements LocationTargetable {

  private final Creeper creeper;

  private Double targetX;
  private Double targetY;
  private Double targetZ;

  private final double swellDistance;
  private final double keepSwellingDistance;

  public LocationSwellGoal(Creeper creeper, double swellDistance, double keepSwellingDistance) {
    this.creeper = creeper;
    this.swellDistance = swellDistance;
    this.keepSwellingDistance = keepSwellingDistance;
    this.setFlags(EnumSet.of(Goal.Flag.MOVE));
  }

  public LocationSwellGoal(Creeper creeper) {
    this(creeper, 3, 7);
  }

  @Override
  public boolean canUse() {
    return this.creeper.getSwellDir() > 0
           || this.targetX != null
              && this.creeper.distanceToSqr(this.targetX, this.targetY, this.targetZ) < this.swellDistance * this.swellDistance;
  }

  // Paper start - Fix MC-179072
  @Override
  public boolean canContinueToUse() {
    return canUse();
  }
  // Paper end

  @Override
  public void start() {
    this.creeper.getNavigation().stop();
  }

  @Override
  public void stop() {
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    if (this.targetX == null) {
      this.creeper.setSwellDir(-1);
    } else if (this.creeper.distanceToSqr(this.targetX, this.targetY, this.targetZ) > this.keepSwellingDistance * this.keepSwellingDistance) {
      this.creeper.setSwellDir(-1);
    } else {
      this.creeper.setSwellDir(1);
    }
  }

  @Override
  public void setTarget(Double x, Double y, Double z) {
    this.targetX = x;
    this.targetY = y;
    this.targetZ = z;
  }
}
