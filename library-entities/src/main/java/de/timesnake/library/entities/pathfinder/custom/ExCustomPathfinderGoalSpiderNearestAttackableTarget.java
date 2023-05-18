/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.monster.EntitySpider;

public class ExCustomPathfinderGoalSpiderNearestAttackableTarget extends
    ExPathfinderGoalNearestAttackableTarget {

  public ExCustomPathfinderGoalSpiderNearestAttackableTarget(Class<? extends LivingEntity> target) {
    super(target, false);
  }

  @Override
  public void injectEntity(Mob entity) {
    super.pathfinderGoal = new PathfinderGoalSpiderNearestAttackableTarget<>(
        ((EntitySpider) entity.getNMS()), this.clazz);
  }

  static class PathfinderGoalSpiderNearestAttackableTarget<T extends EntityLiving> extends
      PathfinderGoalNearestAttackableTarget<T> {

    public PathfinderGoalSpiderNearestAttackableTarget(EntitySpider entityspider, Class<T> oclass) {
      super(entityspider, oclass, true);
    }

    public boolean a() {
      float f = this.e.bh();
      return !(f >= 0.5F) && super.a();
    }
  }
}
