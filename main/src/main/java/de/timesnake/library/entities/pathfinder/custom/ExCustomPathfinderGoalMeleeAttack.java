package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalMeleeAttack extends ExCustomPathfinderGoal {

    protected ExCustomPathfinderGoalMeleeAttack(PathfinderGoalMeleeAttack pathfinderGoal) {
        super(pathfinderGoal);
    }

    public ExCustomPathfinderGoalMeleeAttack(double speed) {
        super(new PathfinderGoalMeleeAttack(null, speed, false));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
