package de.timesnake.library.entities.pathfinder.custom;

import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStrollLand;


public class ExCustomPathfinderGoalRandomStrollLand extends ExCustomPathfinderGoalRandomStroll {

    public ExCustomPathfinderGoalRandomStrollLand(double speed) {
        super(new PathfinderGoalRandomStrollLand(null, speed));
    }
}
