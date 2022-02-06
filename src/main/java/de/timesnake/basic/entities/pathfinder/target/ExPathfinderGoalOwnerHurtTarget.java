package de.timesnake.basic.entities.pathfinder.target;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalOwnerHurtTarget;

public class ExPathfinderGoalOwnerHurtTarget extends ExPathfinderGoalTarget {

    public ExPathfinderGoalOwnerHurtTarget() {
        super(new PathfinderGoalOwnerHurtTarget(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
        super.injectEntity(entity);
    }
}
