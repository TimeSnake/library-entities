/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldGetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldSetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(AbstractSkeleton.class)
public interface AbstractSkeletonProxy {

  @FieldSetter("bowGoal")
  void setBowGoal(AbstractSkeleton instance, RangedBowAttackGoal<AbstractSkeleton> goal);

  @FieldGetter("bowGoal")
  RangedBowAttackGoal<AbstractSkeleton> getBowGoal(AbstractSkeleton instance);

  @FieldSetter("meleeGoal")
  void setMeleeGoal(AbstractSkeleton instance, MeleeAttackGoal goal);

  @FieldGetter("meleeGoal")
  MeleeAttackGoal getMeleeGoal(AbstractSkeleton instance);
}
