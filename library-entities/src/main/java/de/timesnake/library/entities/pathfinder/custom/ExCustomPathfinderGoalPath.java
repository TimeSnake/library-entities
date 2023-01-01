/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import java.util.LinkedList;
import org.bukkit.Location;

public class ExCustomPathfinderGoalPath extends ExPathfinderGoal {

    protected ExCustomPathfinderGoalPath(CustomPathfinderGoalPath customPathfinderGoalPath) {
        super(customPathfinderGoalPath);
    }

    public ExCustomPathfinderGoalPath(Location target, double speed, double minDistance,
            Location... pathPoints) {
        super(new CustomPathfinderGoalPath(null, target, speed, minDistance, pathPoints));
    }

    public ExCustomPathfinderGoalPath(Location target, double speed, double minDistance,
            LinkedList<Location> pathPoints) {
        super(new CustomPathfinderGoalPath(null, target, speed, minDistance, pathPoints));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity.getNMS());
    }


}