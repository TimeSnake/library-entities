/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Fox;

public abstract class FoxBehaviorGoal extends Goal {

  protected final Fox fox;

  private final TargetingConditions alertableTargeting;

  public FoxBehaviorGoal(Fox fox) {
    this.fox = fox;
    this.alertableTargeting = TargetingConditions.forCombat().range(12.0D)
        .ignoreLineOfSight().selector(this.fox.new FoxAlertableEntitiesSelector());
  }

  protected boolean hasShelter() {
    BlockPos blockposition = BlockPos.containing(this.fox.getX(), this.fox.getBoundingBox().maxY, this.fox.getZ());

    return !this.fox.level().canSeeSky(blockposition) && this.fox.getWalkTargetValue(blockposition) >= 0.0F;
  }

  protected boolean alertable() {
    return !this.fox.level().getNearbyEntities(LivingEntity.class, this.alertableTargeting, this.fox,
        this.fox.getBoundingBox().inflate(12.0D, 6.0D, 12.0D)).isEmpty();
  }
}
