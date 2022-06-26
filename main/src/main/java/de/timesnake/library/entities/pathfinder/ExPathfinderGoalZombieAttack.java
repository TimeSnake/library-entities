/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalZombieAttack;

import java.lang.reflect.Field;
import java.util.Optional;

public class ExPathfinderGoalZombieAttack extends ExPathfinderGoal {

    private final double speed;
    private final boolean var0;

    public ExPathfinderGoalZombieAttack(double speed, boolean var0) {
        this.speed = speed;
        this.var0 = var0;
    }


    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalZombieAttack((net.minecraft.world.entity.monster.EntityZombie) entity.getNMS(), speed, var0);
    }

}
