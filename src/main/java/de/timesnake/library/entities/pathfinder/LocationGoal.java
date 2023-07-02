/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class LocationGoal extends Goal {


  private final Mob entity;

  private final double speed;
  private final double trackingDistance;
  private final double minDistance;

  private final double x;
  private final double y;
  private final double z;

  public LocationGoal(Mob entity, double x, double y, double z, double speed,
                      double trackingDistance, double minDistance) {
    this.entity = entity;
    this.speed = speed;
    this.trackingDistance = trackingDistance;
    this.minDistance = minDistance;
    this.x = x;
    this.y = y;
    this.z = z;
    this.setFlags(EnumSet.of(Flag.MOVE));
  }

  @Override
  public boolean canUse() {
    if (this.entity.distanceToSqr(x, y, z) < (this.minDistance
        * this.minDistance)) { // entity distance <
      // minDistance
      return false;
    } else if (this.entity.distanceToSqr(x, y, z) > (this.trackingDistance
        * this.trackingDistance)) { //
      // entity not in tracking distance
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean canContinueToUse() {
    return !this.entity.getNavigation().isDone() && this.entity.distanceToSqr(x, y, z) < (
        this.minDistance * this.minDistance);
  }

  public void start() {
    this.entity.getNavigation().moveTo(this.x, this.y, this.z, this.speed);
  }

}
