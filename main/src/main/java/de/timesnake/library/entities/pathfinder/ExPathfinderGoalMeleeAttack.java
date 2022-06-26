/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;

public class ExPathfinderGoalMeleeAttack extends ExPathfinderGoal {

    private final double speed;
    private final boolean flag;

    public ExPathfinderGoalMeleeAttack(double speed, boolean flag) {
        this.speed = speed;
        this.flag = flag;
    }

    public ExPathfinderGoalMeleeAttack(double speed) {
        this.speed = speed;
        this.flag = false;
    }


    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalMeleeAttack((net.minecraft.world.entity.EntityCreature) entity.getNMS(), speed, flag);
    }

}
