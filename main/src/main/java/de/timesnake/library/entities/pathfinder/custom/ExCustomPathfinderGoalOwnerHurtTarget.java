package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalOwnerHurtTarget;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalOwnerHurtTarget extends ExCustomPathfinderGoalTarget {

    public ExCustomPathfinderGoalOwnerHurtTarget() {
        super(new PathfinderGoalOwnerHurtTarget(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
        super.injectEntity(entity);
    }
}
