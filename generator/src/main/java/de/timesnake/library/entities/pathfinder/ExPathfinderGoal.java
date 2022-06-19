package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

public interface ExPathfinderGoal {

    void injectEntity(ExEntityInsentient entity);

    PathfinderGoal getNMS();

    int getPriority();
}
