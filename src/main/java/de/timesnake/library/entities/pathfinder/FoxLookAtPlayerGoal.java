/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.animal.Fox;

public class FoxLookAtPlayerGoal extends LookAtPlayerGoal {

  private final Fox fox;

  public FoxLookAtPlayerGoal(Fox fox, Class targetType, float range) {
    super(fox, targetType, range);
    this.fox = fox;
  }

  @Override
  public boolean canUse() {
    return super.canUse() && !this.fox.isFaceplanted() && !this.fox.isInterested();
  }

  @Override
  public boolean canContinueToUse() {
    return super.canContinueToUse() && !this.fox.isFaceplanted() && !this.fox.isInterested();
  }
}
