/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class MobBuilder<E extends Mob, B extends MobBuilder<E, B>> extends LivingEntityBuilder<E, B> {

  public MobBuilder() {
    super();
  }

  public B addPathfinderGoal(int priority, Function<E, ? extends Goal> pathfinderGoal) {
    return this.applyOnEntity(e -> {
      Goal goal = pathfinderGoal.apply(e);
      if (goal instanceof TargetGoal) {
        e.targetSelector.addGoal(priority, goal);
      } else {
        e.goalSelector.addGoal(priority, goal);
      }
    });
  }

  public B addPathfinderGoals(int priority, Iterable<Function<E, ? extends Goal>> pathfinderGoals) {
    pathfinderGoals.forEach(p -> this.addPathfinderGoal(priority, p));
    return this.self;
  }

  public B addPathfinderGoals(int priority, Stream<Function<E, ? extends Goal>> pathfinderGoals) {
    pathfinderGoals.forEach(p -> this.addPathfinderGoal(priority, p));
    return this.self;
  }

  public B addTargetGoal(int priority, Function<E, ? extends TargetGoal> pathfinderGoal) {
    this.addPathfinderGoal(priority, pathfinderGoal);
    return this.self;
  }

  public B addTargetGoals(int priority, Iterable<Function<E, ? extends TargetGoal>> pathfinderGoal) {
    pathfinderGoal.forEach(p -> this.addPathfinderGoal(priority, p));
    return this.self;
  }

  public B addTargetGoals(int priority, Stream<Function<E, TargetGoal>> pathfinderGoal) {
    pathfinderGoal.forEach(p -> this.addPathfinderGoal(priority, p));
    return this.self;
  }

  public B removePathfinderGoal(Function<E, ? extends Goal> pathfinderGoal) {
    return this.applyOnEntity(e -> {
      Goal goal = pathfinderGoal.apply(e);
      if (goal instanceof TargetGoal) {
        e.targetSelector.removeGoal(goal);
      } else {
        e.goalSelector.removeGoal(goal);
      }
    });
  }

  public B removeTargetGoal(Function<E, ? extends TargetGoal> pathfinderGoal) {
    return this.removePathfinderGoal(pathfinderGoal);
  }

  public B clearPathfinderGoals() {
    return this.applyOnEntity(e -> e.goalSelector.removeAllGoals(p -> true));
  }

  public B clearGoalTargets() {
    return this.applyOnEntity(e -> e.targetSelector.removeAllGoals(p -> true));
  }

  public B setTarget(LivingEntity target) {
    return this.applyOnEntity(e -> {
      if (target != null) {
        e.setTarget(target, EntityTargetEvent.TargetReason.CUSTOM, true);
      } else {
        e.setTarget(null);
      }
    });
  }
}
