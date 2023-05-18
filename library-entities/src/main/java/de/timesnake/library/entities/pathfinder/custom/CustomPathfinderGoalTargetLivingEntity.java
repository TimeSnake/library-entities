/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;

public class CustomPathfinderGoalTargetLivingEntity extends PathfinderGoalNearestAttackableTarget {

  private final EntityLiving target;

  public CustomPathfinderGoalTargetLivingEntity(EntityInsentient entity, EntityLiving target) {
    super(entity, target.getClass(), true);
    this.target = target;
  }

  @Override
  public void h() {
    super.c = target;
  }
}
