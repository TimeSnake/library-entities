/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFloat;

public class ExPathfinderGoalFloat extends ExPathfinderGoal {


    public ExPathfinderGoalFloat() {

    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalFloat((net.minecraft.world.entity.EntityInsentient) entity.getNMS());
    }

}
