package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMoveTowardsTarget;

public class ExPathfinderGoalMoveTowardsTarget extends ExPathfinderGoal {

    public ExPathfinderGoalMoveTowardsTarget(double speed, float radius) {
        super(new PathfinderGoalMoveTowardsTarget(null, speed, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
