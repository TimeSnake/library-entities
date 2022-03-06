package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import org.bukkit.Material;

public class ExPathfinderGoalBreakBlockToLocation extends ExPathfinderGoal {

    public ExPathfinderGoalBreakBlockToLocation(double x, double y, double z, double speedModifier, Material... materials) {
        super(new PathfinderGoalBreakBlockToLocation(null, x, y, z, speedModifier, materials));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }

}