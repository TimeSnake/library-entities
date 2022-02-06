package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;

public class ExPathfinderGoalLocation extends ExPathfinderGoal {

    public ExPathfinderGoalLocation(double x, double y, double z, double speed, double trackingDistance, double minDistance) {
        super(new PathfinderGoalLocation(null, x, y, z, speed, trackingDistance, minDistance));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity);
    }

}
