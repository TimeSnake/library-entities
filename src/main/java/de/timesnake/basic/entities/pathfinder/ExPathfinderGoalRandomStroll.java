package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStroll;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalRandomStroll extends ExPathfinderGoal {

    public ExPathfinderGoalRandomStroll(double speed) {
        super(new PathfinderGoalRandomStroll(null, speed));
    }

    public ExPathfinderGoalRandomStroll(PathfinderGoalRandomStroll pathfinder) {
        super(pathfinder);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("b", entity.getNMS());
    }

}
