/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.animal.Fox;

public class FoxFloatGoal extends FloatGoal {

  private final Fox fox;

  public FoxFloatGoal(Fox fox) {
    super(fox);
    this.fox = fox;
  }

  @Override
  public void start() {
    super.start();
    this.fox.setIsInterested(false);
    this.fox.setIsCrouching(false);
    this.fox.setSitting(false);
    this.fox.setSleeping(false);
    this.fox.setDefending(false);
    this.fox.setFaceplanted(false);
  }

  @Override
  public boolean canUse() {
    return this.fox.isInWater() && this.fox.getFluidHeight(FluidTags.WATER) > 0.25D || this.fox.isInLava();
  }
}
