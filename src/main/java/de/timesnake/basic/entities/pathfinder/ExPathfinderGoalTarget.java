package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;

public abstract class ExPathfinderGoalTarget extends ExPathfinderGoal {

    public ExPathfinderGoalTarget() {
    }

    public ExPathfinderGoalTarget(PathfinderGoalTarget pathfinderGoalTarget) {
        super(pathfinderGoalTarget);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("e", entity.getNMS());
    }

    public ExPathfinderGoalTarget a(int i) {
        ((PathfinderGoalTarget) this.getNMS()).c(i);
        return this;
    }
}
