/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalOcelotAttack;

public class ExPathfinderGoalOcelotAttack extends ExPathfinderGoal {


    public ExPathfinderGoalOcelotAttack() {

    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalOcelotAttack((net.minecraft.world.entity.EntityInsentient) entity.getNMS());
    }

}
