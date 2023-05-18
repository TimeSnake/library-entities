/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Entity;
import de.timesnake.library.entities.entity.extension.HumanEntity;
import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.extension.Mob;
import java.util.LinkedList;
import org.bukkit.Location;

public class ExCustomPathfinderGoalPathLeader extends ExCustomPathfinderGoalPath {

  public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance,
      LivingEntity follower,
      double maxfollowerDistance, Location... pathPoints) {
    super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower,
        maxfollowerDistance,
        pathPoints));
  }

  public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance,
      HumanEntity follower,
      double maxfollowerDistance, Location... pathPoints) {
    super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower,
        maxfollowerDistance,
        pathPoints));
  }

  public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance,
      LivingEntity follower,
      double maxfollowerDistance, LinkedList<Location> pathPoints) {
    super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower,
        maxfollowerDistance,
        pathPoints));
  }

  public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance,
      HumanEntity follower,
      double maxfollowerDistance, LinkedList<Location> pathPoints) {
    super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower,
        maxfollowerDistance,
        pathPoints));
  }

  public static class CustomPathfinderGoalPathLeader extends CustomPathfinderGoalPath {

    private final Entity follower;
    private final double maxFollowerDistance;

    public CustomPathfinderGoalPathLeader(Mob entity, Location target, double speed,
        double minDistance,
        Entity follower, double maxfollowerDistance, Location... pathPoints) {
      super(entity, target, speed, minDistance, pathPoints);
      this.follower = follower;
      this.maxFollowerDistance = maxfollowerDistance;
    }

    public CustomPathfinderGoalPathLeader(Mob entity, Location target, double speed,
        double minDistance,
        Entity follower, double maxfollowerDistance,
        LinkedList<Location> pathPoints) {
      super(entity, target, speed, minDistance, pathPoints);
      this.follower = follower;
      this.maxFollowerDistance = maxfollowerDistance;
    }

    @Override
    public boolean a() {

      boolean run = super.a();

      if (!run) {
        return false;
      }

      // folower is
      if (this.follower.distanceSquared(this.currentPosition) < this.entity.distanceSquared(
          this.currentPosition)) {
        return true;
      }

      if (this.follower.distanceSquared(this.entity.getNMS()) < this.maxFollowerDistance) {
        return true;
      }

      return false;
    }

    @Override
    public boolean b() {
      return !this.entity.getNavigation().isPathFinished()
          && this.entity.distanceSquared(this.currentPosition.getX(),
          this.currentPosition.getY(),
          this.currentPosition.getZ()) < (this.minDistance * this.minDistance)
          && this.follower.distanceSquared(this.entity.getNMS())
          < this.maxFollowerDistance;
    }


  }
}
