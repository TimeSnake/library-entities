/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;

public class ExCustomPathfinderGoalLocation extends ExPathfinderGoal {

    public ExCustomPathfinderGoalLocation(double x, double y, double z, double speed, double trackingDistance,
                                          double minDistance) {
        super(new CustomPathfinderGoalLocation(null, x, y, z, speed, trackingDistance, minDistance));
    }

    @Override
    public void injectEntity(Mob entity) {
        this.setNMSField("entity", entity);
    }

}
