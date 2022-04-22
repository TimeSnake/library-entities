package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalOwnerHurtByTarget;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalOwnerHurtByTarget extends ExPathfinderGoalTarget {

    public ExPathfinderGoalOwnerHurtByTarget() {
        super(new PathfinderGoalOwnerHurtByTarget(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
        super.injectEntity(entity);
    }

}
