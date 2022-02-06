package de.timesnake.basic.entities.pathfinder;

import net.minecraft.world.level.pathfinder.PathfinderNormal;

public class ExPathfinderNormal extends ExPathfinderAbstract {

    public ExPathfinderNormal() {
        super(new PathfinderNormal());
    }

    protected ExPathfinderNormal(PathfinderNormal pathfinder) {
        super(pathfinder);
    }
}
