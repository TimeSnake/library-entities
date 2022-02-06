package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;

public class ExPathfinderGoalUpdatedLocation extends ExPathfinderGoal {

    public ExPathfinderGoalUpdatedLocation() {
        super();
    }

    public ExPathfinderGoalUpdatedLocation(PathfinderGoalUpdatedLocation pathfinderGoalUpdatedLocation) {
        super(pathfinderGoalUpdatedLocation);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }


}
