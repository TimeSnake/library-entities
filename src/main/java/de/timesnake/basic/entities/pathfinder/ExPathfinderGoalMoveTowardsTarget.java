package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMoveTowardsTarget;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalMoveTowardsTarget extends ExPathfinderGoal {

    public ExPathfinderGoalMoveTowardsTarget(double speed, float radius) {
        super(new PathfinderGoalMoveTowardsTarget(null, speed, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
