/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Spider;

public class SpiderAttackGoal extends MeleeAttackGoal {

  public SpiderAttackGoal(Spider spider, double speed) {
    super(spider, speed, true);
  }

  public SpiderAttackGoal(Spider spider) {
    this(spider, 1);
  }

  @Override
  public boolean canUse() {
    return super.canUse() && !this.mob.isVehicle();
  }

  @Override
  public boolean canContinueToUse() {
    float f = this.mob.getLightLevelDependentMagicValue();

    if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
      this.mob.setTarget(null);
      return false;
    } else {
      return super.canContinueToUse();
    }
  }
}
