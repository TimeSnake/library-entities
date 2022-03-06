package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalZombieAttack;

public class ExPathfinderGoalZombieAttack extends ExPathfinderGoal {

    public ExPathfinderGoalZombieAttack(double speed) {
        super(new PathfinderGoalZombieAttack(null, speed, false));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
        this.setNMSField("b", entity.getNMS());
    }

}