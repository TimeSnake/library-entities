package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;

import java.util.List;

@NmsReflection
public class ExCustomPathfinderGoalHurtByTarget extends ExCustomPathfinderGoalTarget {

    @SafeVarargs
    public ExCustomPathfinderGoalHurtByTarget(EntityClass<? extends EntityLiving>... excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.length];
        for (int i = 0; i < excludedClasses.length; i++) {
            nmsClasses[i] = excludedClasses[i].getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExCustomPathfinderGoalHurtByTarget(List<EntityClass<? extends EntityLiving>> excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.size()];
        for (int i = 0; i < excludedClasses.size(); i++) {
            nmsClasses[i] = excludedClasses.get(i).getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExCustomPathfinderGoalHurtByTarget a(Class<?>... aclass) {
        ((PathfinderGoalHurtByTarget) super.getNMS()).a(aclass);
        return this;
    }
}
