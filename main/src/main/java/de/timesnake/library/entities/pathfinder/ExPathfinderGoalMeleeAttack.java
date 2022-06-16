package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalMeleeAttack extends ExPathfinderGoal {

    protected ExPathfinderGoalMeleeAttack(PathfinderGoalMeleeAttack pathfinderGoal) {
        super(pathfinderGoal);
    }

    public ExPathfinderGoalMeleeAttack(double speed) {
        super(new PathfinderGoalMeleeAttack(null, speed, false));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
