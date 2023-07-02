/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Spider;

public class SpiderTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {

  public SpiderTargetGoal(Spider spider, Class<T> targetEntityClass) {
    super(spider, targetEntityClass, true);
  }

  @Override
  public boolean canUse() {
    float f = this.mob.getLightLevelDependentMagicValue();

    return !(f >= 0.5F) && super.canUse();
  }
}
