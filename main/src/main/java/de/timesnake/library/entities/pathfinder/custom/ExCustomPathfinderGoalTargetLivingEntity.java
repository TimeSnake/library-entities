package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.reflection.NmsReflection;

@NmsReflection
public class ExCustomPathfinderGoalTargetLivingEntity extends ExCustomPathfinderGoalTarget {

    private final ExEntityLiving target;

    public ExCustomPathfinderGoalTargetLivingEntity(ExEntityLiving target) {
        super();
        this.target = target;
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new CustomPathfinderGoalTargetLivingEntity(entity.getNMS(), target.getNMS());
    }

}
