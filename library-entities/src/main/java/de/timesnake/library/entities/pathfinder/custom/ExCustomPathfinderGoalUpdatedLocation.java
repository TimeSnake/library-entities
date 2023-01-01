/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;

public class ExCustomPathfinderGoalUpdatedLocation extends ExPathfinderGoal {

    public ExCustomPathfinderGoalUpdatedLocation() {
        super();
    }

    public ExCustomPathfinderGoalUpdatedLocation(CustomPathfinderGoalUpdatedLocation customPathfinderGoalUpdatedLocation) {
        super(customPathfinderGoalUpdatedLocation);
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity);
    }


}
