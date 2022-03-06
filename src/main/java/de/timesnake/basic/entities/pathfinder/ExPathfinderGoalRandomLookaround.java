package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomLookaround;

public class ExPathfinderGoalRandomLookaround extends ExPathfinderGoal {

    public ExPathfinderGoalRandomLookaround() {
        super(new PathfinderGoalRandomLookaround(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
    }

}