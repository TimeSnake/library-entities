package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLeapAtTarget;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalLeapAtTarget extends ExPathfinderGoal {

    public ExPathfinderGoalLeapAtTarget(float height) {
        super(new PathfinderGoalLeapAtTarget(null, height));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
