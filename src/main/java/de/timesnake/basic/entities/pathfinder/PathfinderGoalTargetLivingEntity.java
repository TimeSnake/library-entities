package de.timesnake.basic.entities.pathfinder;

import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;

public class PathfinderGoalTargetLivingEntity extends PathfinderGoalNearestAttackableTarget {

    private final EntityLiving target;

    public PathfinderGoalTargetLivingEntity(EntityInsentient entity, EntityLiving target) {
        super(entity, target.getClass(), true);
        this.target = target;
    }

    @Override
    public void g() {
        super.c = target;
    }
}