package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;

@NmsReflection
public class ExCustomPathfinderGoalUpdatedLocation extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalUpdatedLocation() {
        super();
    }

    public ExCustomPathfinderGoalUpdatedLocation(CustomPathfinderGoalUpdatedLocation customPathfinderGoalUpdatedLocation) {
        super(customPathfinderGoalUpdatedLocation);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }


}
