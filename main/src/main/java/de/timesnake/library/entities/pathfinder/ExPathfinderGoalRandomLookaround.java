/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomLookaround;

import java.lang.reflect.Field;
import java.util.Optional;

public class ExPathfinderGoalRandomLookaround extends ExPathfinderGoal {


    public ExPathfinderGoalRandomLookaround() {

    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalRandomLookaround((net.minecraft.world.entity.EntityInsentient) entity.getNMS());
    }

}
