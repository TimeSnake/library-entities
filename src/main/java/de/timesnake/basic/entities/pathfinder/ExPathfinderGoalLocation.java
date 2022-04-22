package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;

@NmsReflection
public class ExPathfinderGoalLocation extends ExPathfinderGoal {

    public ExPathfinderGoalLocation(double x, double y, double z, double speed, double trackingDistance, double minDistance) {
        super(new PathfinderGoalLocation(null, x, y, z, speed, trackingDistance, minDistance));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity);
    }

}
