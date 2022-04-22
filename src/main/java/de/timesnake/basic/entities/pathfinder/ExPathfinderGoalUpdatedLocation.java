package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;

@NmsReflection
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
