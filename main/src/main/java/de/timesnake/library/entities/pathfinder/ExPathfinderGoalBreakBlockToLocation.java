package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.Material;

@NmsReflection
public class ExPathfinderGoalBreakBlockToLocation extends ExPathfinderGoal {

    public ExPathfinderGoalBreakBlockToLocation(double x, double y, double z, double speedModifier,
                                                Material... materials) {
        super(new PathfinderGoalBreakBlockToLocation(null, x, y, z, speedModifier, materials));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }

}
