package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
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
