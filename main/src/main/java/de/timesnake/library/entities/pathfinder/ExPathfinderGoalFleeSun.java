/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFleeSun;

public class ExPathfinderGoalFleeSun extends ExPathfinderGoal {

    private final double speed;

    public ExPathfinderGoalFleeSun(double speed) {
        this.speed = speed;
    }


    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalFleeSun((net.minecraft.world.entity.EntityCreature) entity.getNMS(), speed);
    }

}
