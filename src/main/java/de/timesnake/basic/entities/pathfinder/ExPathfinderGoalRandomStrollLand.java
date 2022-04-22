package de.timesnake.basic.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStrollLand;


public class ExPathfinderGoalRandomStrollLand extends ExPathfinderGoalRandomStroll {

    public ExPathfinderGoalRandomStrollLand(double speed) {
        super(new PathfinderGoalRandomStrollLand(null, speed));
    }
}
