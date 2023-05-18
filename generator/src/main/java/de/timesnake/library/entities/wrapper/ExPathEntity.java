/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.world.level.pathfinder.PathEntity;
import net.minecraft.world.level.pathfinder.PathPoint;

public class ExPathEntity {

  private final PathEntity path;

  public ExPathEntity(PathEntity pathEntity) {
    this.path = pathEntity;
  }

  public PathEntity getNMS() {
    return this.path;
  }

  public boolean isCurrentLowerEqualsZero() {
    return this.path.b();
  }

  public boolean isCurrentHigherEqualsPathLength() {
    return this.path.c();
  }

  public PathPoint getLastPathPoint() {
    return this.path.d();
  }

  public ExPathPoint getLastExPathPoint() {
    return ExWrapper.wrapPathPoint(this.getLastPathPoint());
  }

  public int getPathLength() {
    return this.path.e();
  }

  public PathPoint getPathPoint(int index) {
    return this.path.a(index);
  }

  public ExPathPoint getExPathPoint(int index) {
    return ExWrapper.wrapPathPoint(this.getPathPoint(index));
  }

  public void removePathPointsHigherEquals(int index) {
    this.path.b(index);
  }

  public void setPathPoint(int index, PathPoint point) {
    this.path.a(index, point);
  }

  public int getCurrentIndex() {
    return this.path.f();
  }

  public void setCurrentIndex(int index) {
    this.path.c(index);
  }

  public List<PathPoint> getPathPoints() {
    try {
      Field pathListField = PathEntity.class.getDeclaredField("a");
      pathListField.setAccessible(true);
      return (List<PathPoint>) pathListField.get(this.getNMS());
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  public List<ExPathPoint> getExPathPoints() {
    return this.getPathPoints().stream().map(ExPathPoint::new).toList();
  }

}
