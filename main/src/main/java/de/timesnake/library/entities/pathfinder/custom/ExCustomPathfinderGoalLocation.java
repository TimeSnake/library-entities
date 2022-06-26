package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;

@NmsReflection
public class ExCustomPathfinderGoalLocation extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalLocation(double x, double y, double z, double speed, double trackingDistance,
                                          double minDistance) {
        super(new CustomPathfinderGoalLocation(null, x, y, z, speed, trackingDistance, minDistance));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity);
    }

}
