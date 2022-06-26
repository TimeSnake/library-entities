package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import org.bukkit.Location;

import java.util.LinkedList;

public class ExCustomPathfinderGoalPath extends ExCustomPathfinderGoal {

    protected ExCustomPathfinderGoalPath(CustomPathfinderGoalPath customPathfinderGoalPath) {
        super(customPathfinderGoalPath);
    }

    public ExCustomPathfinderGoalPath(Location target, double speed, double minDistance, Location... pathPoints) {
        super(new CustomPathfinderGoalPath(null, target, speed, minDistance, pathPoints));
    }

    public ExCustomPathfinderGoalPath(Location target, double speed, double minDistance,
                                      LinkedList<Location> pathPoints) {
        super(new CustomPathfinderGoalPath(null, target, speed, minDistance, pathPoints));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }


}
