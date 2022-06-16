package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomLookaround;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalRandomLookaround extends ExPathfinderGoal {

    public ExPathfinderGoalRandomLookaround() {
        super(new PathfinderGoalRandomLookaround(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
    }

}
