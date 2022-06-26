package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

@NmsReflection
public abstract class ExCustomPathfinderGoal extends ExPathfinderGoal {

    public ExCustomPathfinderGoal(PathfinderGoal pathfinderGoal) {
        super(pathfinderGoal);
    }

    public ExCustomPathfinderGoal() {
        super();
    }

}
