package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStroll;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalRandomStroll extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalRandomStroll(double speed) {
        super(new PathfinderGoalRandomStroll(null, speed));
    }

    public ExCustomPathfinderGoalRandomStroll(PathfinderGoalRandomStroll pathfinder) {
        super(pathfinder);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("b", entity.getNMS());
    }

}
