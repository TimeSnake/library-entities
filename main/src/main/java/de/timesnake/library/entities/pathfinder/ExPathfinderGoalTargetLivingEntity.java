package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.reflection.NmsReflection;

@NmsReflection
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
