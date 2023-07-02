/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.level.pathfinder.Path;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.function.Function;
import java.util.stream.Stream;

public class MobBuilder<E extends Mob, B extends MobBuilder<E, B>> extends LivingEntityBuilder<E, B> {

  public MobBuilder(E entity) {
    super(entity);
  }

  public GoalSelector getGoalSelector() {
    return this.getNMS().goalSelector;
  }

  public GoalSelector getTargetSelector() {
    return this.getNMS().targetSelector;
  }

  public B addPathfinderGoal(int priority, Function<E, Goal> pathfinderGoal) {
    Goal goal = pathfinderGoal.apply(this.entity);
    if (goal instanceof TargetGoal) {
      this.getTargetSelector().addGoal(priority, goal);
    } else {
      this.getGoalSelector().addGoal(priority, goal);
    }
    return this.self;
  }

  public B addPathfinderGoals(int priority, Iterable<Function<E, Goal>> pathfinderGoals) {
    pathfinderGoals.forEach(p -> this.getGoalSelector().addGoal(priority, p.apply(this.entity)));
    return this.self;
  }

  public B addPathfinderGoals(int priority, Stream<Function<E, Goal>> pathfinderGoals) {
    pathfinderGoals.forEach(p -> this.getGoalSelector().addGoal(priority, p.apply(this.entity)));
    return this.self;
  }

  public B addTargetGoal(int priority, Function<E, TargetGoal> pathfinderGoal) {
    this.getTargetSelector().addGoal(priority, pathfinderGoal.apply(this.entity));
    return this.self;
  }

  public B addTargetGoals(int priority, Iterable<Function<E, TargetGoal>> pathfinderGoal) {
    pathfinderGoal.forEach(p -> this.getTargetSelector().addGoal(priority, p.apply(this.entity)));
    return this.self;
  }

  public B addTargetGoals(int priority, Stream<Function<E, TargetGoal>> pathfinderGoal) {
    pathfinderGoal.forEach(p -> this.getTargetSelector().addGoal(priority, p.apply(this.entity)));
    return this.self;
  }

  public B removePathfinderGoal(Function<E, Goal> pathfinderGoal) {
    Goal goal = pathfinderGoal.apply(this.entity);
    if (goal instanceof TargetGoal) {
      this.getTargetSelector().removeGoal(goal);
    } else {
      this.getGoalSelector().removeGoal(goal);
    }

    return this.self;
  }

  public B removeTargetGoal(Function<E, TargetGoal> pathfinderGoal) {
    this.getTargetSelector().removeGoal(pathfinderGoal.apply(this.entity));
    return this.self;
  }

  public B clearPathfinderGoals() {
    this.getGoalSelector().removeAllGoals(g -> true);
    return this.self;
  }

  public B clearGoalTargets() {
    this.getTargetSelector().removeAllGoals(g -> true);
    return this.self;
  }

  public B setTarget(LivingEntity target) {
    if (target != null) {
      this.getNMS().setTarget(target, EntityTargetEvent.TargetReason.CUSTOM, true);
    } else {
      this.getNMS().setTarget(null);
    }
    return this.self;
  }

  public LivingEntity getExTarget() {
    if (this.getNMS().getTarget() == null) {
      return null;
    }
    return this.getNMS().getTarget();
  }

  public Path calcPath(double x, double y, double z, int minDistance) {
    return this.getNMS().getNavigation().createPath(x, y, z, minDistance);
  }
}
