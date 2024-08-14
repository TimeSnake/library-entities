/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

public interface LocationTargetable {

  void setTarget(int x, int y, int z);

  void clearTarget();
}
