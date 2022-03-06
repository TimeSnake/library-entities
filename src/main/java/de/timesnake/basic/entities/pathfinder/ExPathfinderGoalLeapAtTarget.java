package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLeapAtTarget;

public class ExPathfinderGoalLeapAtTarget extends ExPathfinderGoal {

    public ExPathfinderGoalLeapAtTarget(float height) {
        super(new PathfinderGoalLeapAtTarget(null, height));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
