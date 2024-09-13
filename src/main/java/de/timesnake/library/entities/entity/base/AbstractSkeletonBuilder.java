/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;

import java.util.function.Function;


public abstract class AbstractSkeletonBuilder<E extends AbstractSkeleton, B extends AbstractSkeletonBuilder<E, B>> extends MonsterBuilder<E, B> {

  protected RangedBowAttackGoal<AbstractSkeleton> bowGoal;
  protected MeleeAttackGoal meleeGoal;

  public AbstractSkeletonBuilder() {
    super();
  }

  @Override
  public B addPathfinderGoal(int priority, Function<E, ? extends Goal> pathfinderGoal) {
    super.addPathfinderGoal(priority, pathfinderGoal);
    return this.applyOnEntity(e -> {
      Goal goal = pathfinderGoal.apply(e);
      if (goal instanceof RangedBowAttackGoal<?> bowAttackGoal) {
        this.bowGoal = (RangedBowAttackGoal<AbstractSkeleton>) bowAttackGoal;
      } else if (goal instanceof MeleeAttackGoal meleeAttackGoal) {
        this.meleeGoal = meleeAttackGoal;
      }
    });
  }
}
