/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;

public abstract class ExPathfinderGoalTarget extends ExPathfinderGoal {

    public ExPathfinderGoalTarget() {
    }

    public ExPathfinderGoalTarget(PathfinderGoalTarget pathfinderGoalTarget) {
        super(pathfinderGoalTarget);
    }

}
