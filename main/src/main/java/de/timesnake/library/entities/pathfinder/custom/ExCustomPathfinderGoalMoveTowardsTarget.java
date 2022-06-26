package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMoveTowardsTarget;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalMoveTowardsTarget extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalMoveTowardsTarget(double speed, float radius) {
        super(new PathfinderGoalMoveTowardsTarget(null, speed, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
