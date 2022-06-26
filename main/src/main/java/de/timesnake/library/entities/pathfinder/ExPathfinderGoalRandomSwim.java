/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomSwim;

import java.lang.reflect.Field;
import java.util.Optional;

public class ExPathfinderGoalRandomSwim extends ExPathfinderGoal {

    private final double speed;
    private final int var0;

    public ExPathfinderGoalRandomSwim(double speed, int var0) {
        this.speed = speed;
        this.var0 = var0;
    }


    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalRandomSwim((net.minecraft.world.entity.EntityCreature) entity.getNMS(), speed, var0);
    }

}
