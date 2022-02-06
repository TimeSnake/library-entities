package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStroll;

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
