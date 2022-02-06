package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;

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
