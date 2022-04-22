package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalLookAtPlayer extends ExPathfinderGoal {

    public ExPathfinderGoalLookAtPlayer(EntityClass<? extends EntityLiving> exClass) {
        super.pathfinderGoal = new PathfinderGoalLookAtPlayer(null, exClass.getNMSClass(), 8.0F);
    }

    public ExPathfinderGoalLookAtPlayer(EntityClass<? extends EntityLiving> exClass, float chance) {
        super.pathfinderGoal = new PathfinderGoalLookAtPlayer(null, exClass.getNMSClass(), 8.0F, chance);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("b", entity.getNMS());
    }

}
