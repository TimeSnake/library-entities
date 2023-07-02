/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import org.jetbrains.annotations.Nullable;

public class TargetLivingEntityGoal<E extends LivingEntity> extends NearestAttackableTargetGoal<E> {

  private final E target;

  public TargetLivingEntityGoal(Mob entity, E target) {
    super(entity, (Class<E>) target.getClass(), true);
    this.target = target;
    super.target = target;
  }

  @Override
  public void setTarget(@Nullable LivingEntity targetEntity) {
    super.target = this.target;
  }
}
