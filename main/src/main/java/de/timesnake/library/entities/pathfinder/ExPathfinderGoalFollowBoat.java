/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFollowBoat;

public class ExPathfinderGoalFollowBoat extends ExPathfinderGoal {


    public ExPathfinderGoalFollowBoat() {

    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalFollowBoat((net.minecraft.world.entity.EntityCreature) entity.getNMS());
    }

}
