/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import org.bukkit.Location;

public abstract class UpdatedLocationGoal extends Goal {

  protected final Mob entity;
  protected final double trackingDistance;
  protected final double minDistance;
  protected double speed;
  protected double x;
  protected double y;
  protected double z;

  public UpdatedLocationGoal(Mob entity, double speed, double trackingDistance,
                             double minDistance) {
    this.entity = entity;
    this.speed = speed;
    this.trackingDistance = trackingDistance;
    this.minDistance = minDistance;
  }

  public boolean canUse() {
    Location loc = this.getNextLocation(new Location(this.entity.getBukkitEntity().getWorld(), this.entity.getX(),
        this.entity.getY(), this.entity.getZ()));

    if (loc == null) {
      return false;
    }

    this.x = loc.getX();
    this.y = loc.getY();
    this.z = loc.getZ();

    if (this.entity.distanceToSqr(x, y, z) < (this.minDistance
        * this.minDistance)) { // entity distance <
      // minDistance
      return false;
    } else {
      return !(this.entity.distanceToSqr(x, y, z) > (this.trackingDistance
          * this.trackingDistance));
    }

  }

  public boolean canContinueToUse() {
    return !this.entity.getNavigation().isDone() && this.entity.distanceToSqr(x, y, z) < (
        this.minDistance * this.minDistance);
  }

  public void start() {
    this.entity.getNavigation().moveTo(this.x, this.y, this.z, this.speed);
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public abstract Location getNextLocation(Location entityLoc);
}