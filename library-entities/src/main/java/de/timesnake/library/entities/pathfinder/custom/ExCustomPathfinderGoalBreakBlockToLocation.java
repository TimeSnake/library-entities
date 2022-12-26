/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import org.bukkit.Material;

public class ExCustomPathfinderGoalBreakBlockToLocation extends ExPathfinderGoal {

    public ExCustomPathfinderGoalBreakBlockToLocation(double x, double y, double z, double speedModifier,
                                                      Material... materials) {
        super(new CustomPathfinderGoalBreakBlockToLocation(null, x, y, z, speedModifier, materials));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity);
    }

}
