package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;

import java.util.List;

@NmsReflection
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
