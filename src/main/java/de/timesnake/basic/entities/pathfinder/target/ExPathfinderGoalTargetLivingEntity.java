package de.timesnake.basic.entities.pathfinder.target;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.basic.entities.pathfinder.goals.PathfinderGoalTargetLivingEntity;

public class ExPathfinderGoalTargetLivingEntity extends ExPathfinderGoalTarget {

    private final ExEntityLiving target;

    public ExPathfinderGoalTargetLivingEntity(ExEntityLiving target) {
        super();
        this.target = target;
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalTargetLivingEntity(entity.getNMS(), target.getNMS());
    }

}
