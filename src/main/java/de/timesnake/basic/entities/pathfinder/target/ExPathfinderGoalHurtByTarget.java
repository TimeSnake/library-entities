package de.timesnake.basic.entities.pathfinder.target;

import de.timesnake.basic.entities.wrapper.EntityClass;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;

public class ExPathfinderGoalHurtByTarget extends ExPathfinderGoalTarget {

    @SafeVarargs
    public ExPathfinderGoalHurtByTarget(EntityClass<? extends Entity>... excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.length];
        for (int i = 0; i < excludedClasses.length; i++) {
            nmsClasses[i] = excludedClasses[i].getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExPathfinderGoalHurtByTarget a(Class<?>... aclass) {
        ((PathfinderGoalHurtByTarget) super.getNMS()).a(aclass);
        return this;
    }
}
