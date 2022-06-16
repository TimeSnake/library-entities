package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import org.bukkit.Location;

import java.util.LinkedList;

public class ExPathfinderGoalPath extends ExPathfinderGoal {

    protected ExPathfinderGoalPath(PathfinderGoalPath pathfinderGoalPath) {
        super(pathfinderGoalPath);
    }

    public ExPathfinderGoalPath(Location target, double speed, double minDistance, Location... pathPoints) {
        super(new PathfinderGoalPath(null, target, speed, minDistance, pathPoints));
    }

    public ExPathfinderGoalPath(Location target, double speed, double minDistance, LinkedList<Location> pathPoints) {
        super(new PathfinderGoalPath(null, target, speed, minDistance, pathPoints));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }


}
