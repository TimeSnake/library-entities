/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;
import org.bukkit.Location;

import java.util.*;

public class PathGoal extends Goal {


  protected final Mob entity;

  protected final double speed;
  protected final double minDistance;
  protected final Map<Integer, Location> pathPointsById = new HashMap<>();
  protected BlockPos currentPosition;

  public PathGoal(Mob entity, Location target, double speed, double minDistance,
                  Location... pathPoints) {
    this.entity = entity;
    this.speed = speed;
    this.minDistance = minDistance;

    int i = 0;
    for (; i < pathPoints.length; i++) {
      this.pathPointsById.put(i, pathPoints[i]);
    }
    this.pathPointsById.put(i, target);

    this.setFlags(EnumSet.of(Flag.MOVE));
  }

  public PathGoal(Mob entity, Location target, double speed, double minDistance,
                  LinkedList<Location> pathPoints) {
    this.entity = entity;
    this.speed = speed;
    this.minDistance = minDistance;

    int i = 0;
    Iterator<Location> iterator = pathPoints.iterator();
    for (; i < pathPoints.size() && iterator.hasNext(); i++) {
      this.pathPointsById.put(i, iterator.next());
    }
    this.pathPointsById.put(i, target);

    this.setFlags(EnumSet.of(Flag.MOVE));
  }

  private int calcRandom() {
    return (int) (Math.round(Math.random() * this.minDistance * 2) - this.minDistance);
  }

  @Override
  public boolean canUse() {
    for (int i = this.pathPointsById.size() - 1; i >= 0; i--) {
      Location target = this.pathPointsById.get(i);
      BlockPos position = new BlockPos(target.getBlockX(), target.getBlockY(), target.getBlockZ());

      if (this.entity.distanceToSqr(target.getX(), target.getY(), target.getZ()) > (32 * 32)) {
        continue;
      }

      Path pathEntity = this.entity.getNavigation().createPath(position, 1);

      if (pathEntity != null) {
        if (pathEntity.getEndNode().asBlockPos().closerThan(position, this.minDistance)) {
          do {
            position = new BlockPos(position.getX() + this.calcRandom(),
                position.getY(),
                position.getZ() + this.calcRandom());
            pathEntity = this.entity.getNavigation().createPath(position, 1);
          } while (pathEntity == null);
          this.currentPosition = position;
          return true;
        }
      }
    }

    return false;
  }

  public boolean canContinueToUse() {
    return !this.entity.getNavigation().isDone() &&
        this.entity.distanceToSqr(this.currentPosition.getX(),
            this.currentPosition.getY(), this.currentPosition.getZ()) < (this.minDistance * this.minDistance);
  }

  public void start() {
    this.entity.getNavigation().moveTo(this.currentPosition.getX(), this.currentPosition.getY(),
        this.currentPosition.getZ(), this.speed);
  }

}
