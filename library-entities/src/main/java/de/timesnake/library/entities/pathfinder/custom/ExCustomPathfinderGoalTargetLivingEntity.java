/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalTarget;

public class ExCustomPathfinderGoalTargetLivingEntity extends ExPathfinderGoalTarget {

  private final LivingEntity target;

  public ExCustomPathfinderGoalTargetLivingEntity(LivingEntity target) {
    super();
    this.target = target;
  }

  @Override
  public void injectEntity(Mob entity) {
    super.pathfinderGoal = new CustomPathfinderGoalTargetLivingEntity(entity.getNMS(),
        target.getNMS());
  }

}
