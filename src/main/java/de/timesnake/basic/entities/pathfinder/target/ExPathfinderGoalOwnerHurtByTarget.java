package de.timesnake.basic.entities.pathfinder.target;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalOwnerHurtByTarget;

public class ExPathfinderGoalOwnerHurtByTarget extends ExPathfinderGoalTarget {

    public ExPathfinderGoalOwnerHurtByTarget() {
        super(new PathfinderGoalOwnerHurtByTarget(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
        super.injectEntity(entity);
    }

}
