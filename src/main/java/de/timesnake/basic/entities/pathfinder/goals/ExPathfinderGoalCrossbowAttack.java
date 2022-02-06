package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalCrossbowAttack;

public class ExPathfinderGoalCrossbowAttack extends ExPathfinderGoal {

    public ExPathfinderGoalCrossbowAttack(double speed, float radius) {
        super(new PathfinderGoalCrossbowAttack(null, speed, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("b", entity.getNMS());
    }

}
