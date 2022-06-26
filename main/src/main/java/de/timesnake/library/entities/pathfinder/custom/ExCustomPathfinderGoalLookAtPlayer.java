package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalLookAtPlayer extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalLookAtPlayer(EntityClass<? extends EntityLiving> exClass) {
        super.pathfinderGoal = new PathfinderGoalLookAtPlayer(null, exClass.getNMSClass(), 8.0F);
    }

    public ExCustomPathfinderGoalLookAtPlayer(EntityClass<? extends EntityLiving> exClass, float chance) {
        super.pathfinderGoal = new PathfinderGoalLookAtPlayer(null, exClass.getNMSClass(), 8.0F, chance);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("b", entity.getNMS());
    }

}
