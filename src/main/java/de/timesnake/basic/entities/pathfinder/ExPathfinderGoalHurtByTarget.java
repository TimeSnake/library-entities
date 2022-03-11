package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.wrapper.EntityClass;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;

import java.util.List;

public class ExPathfinderGoalHurtByTarget extends ExPathfinderGoalTarget {

    @SafeVarargs
    public ExPathfinderGoalHurtByTarget(EntityClass<? extends EntityLiving>... excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.length];
        for (int i = 0; i < excludedClasses.length; i++) {
            nmsClasses[i] = excludedClasses[i].getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExPathfinderGoalHurtByTarget(List<EntityClass<? extends EntityLiving>> excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.size()];
        for (int i = 0; i < excludedClasses.size(); i++) {
            nmsClasses[i] = excludedClasses.get(i).getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExPathfinderGoalHurtByTarget a(Class<?>... aclass) {
        ((PathfinderGoalHurtByTarget) super.getNMS()).a(aclass);
        return this;
    }
}
