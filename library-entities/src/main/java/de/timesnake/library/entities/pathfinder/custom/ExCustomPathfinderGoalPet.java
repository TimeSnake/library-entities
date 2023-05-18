/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import org.bukkit.entity.Player;

public class ExCustomPathfinderGoalPet extends ExPathfinderGoal {

  public ExCustomPathfinderGoalPet(Player owner, double entitySpeed, float minDistance,
      float teleportDistance) {
    super(new CustomPathfinderGoalPet(null, owner, entitySpeed, minDistance, teleportDistance));
  }

  @Override
  public void injectEntity(Mob entity) {
    this.setNMSField("pet", entity.getExtension());
  }

}