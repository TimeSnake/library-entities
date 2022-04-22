package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalOwnerHurtTarget;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalOwnerHurtTarget extends ExPathfinderGoalTarget {

    public ExPathfinderGoalOwnerHurtTarget() {
        super(new PathfinderGoalOwnerHurtTarget(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
        super.injectEntity(entity);
    }
}
