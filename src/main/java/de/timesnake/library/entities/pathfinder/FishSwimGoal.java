/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;

public class FishSwimGoal extends RandomSwimmingGoal {
  private final AbstractFish fish;

  public FishSwimGoal(AbstractFish fish) {
    super(fish, 1.0D, 40);
    this.fish = fish;
  }

  @Override
  public boolean canUse() {
    if (this.fish instanceof AbstractSchoolingFish schoolingFish) {
      return !schoolingFish.isFollower() && super.canUse();
    }
    return super.canUse();
  }
}
