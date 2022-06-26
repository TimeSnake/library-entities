package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;

@NmsReflection(usesReflection = true)
public abstract class ExCustomPathfinderGoalTarget extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalTarget() {
    }

    public ExCustomPathfinderGoalTarget(PathfinderGoalTarget pathfinderGoalTarget) {
        super(pathfinderGoalTarget);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("e", entity.getNMS());
    }

    public ExCustomPathfinderGoalTarget a(int i) {
        ((PathfinderGoalTarget) this.getNMS()).c(i);
        return this;
    }
}
