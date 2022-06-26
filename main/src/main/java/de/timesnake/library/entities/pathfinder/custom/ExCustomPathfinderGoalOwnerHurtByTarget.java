package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalOwnerHurtByTarget;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalOwnerHurtByTarget extends ExCustomPathfinderGoalTarget {

    public ExCustomPathfinderGoalOwnerHurtByTarget() {
        super(new PathfinderGoalOwnerHurtByTarget(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
        super.injectEntity(entity);
    }

}
