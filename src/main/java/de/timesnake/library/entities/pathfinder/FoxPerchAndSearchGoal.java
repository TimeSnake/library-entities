/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Fox;

import java.util.EnumSet;

public class FoxPerchAndSearchGoal extends FoxBehaviorGoal {

  private double relX;
  private double relZ;
  private int lookTime;
  private int looksRemaining;

  public FoxPerchAndSearchGoal(Fox fox) {
    super(fox);
    this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
  }

  @Override
  public boolean canUse() {
    return this.fox.getLastHurtByMob() == null && this.fox.getRandom().nextFloat() < 0.02F && !this.fox.isSleeping()
        && this.fox.getTarget() == null && this.fox.getNavigation().isDone() && !this.alertable()
        && !this.fox.isPouncing() && !this.fox.isCrouching();
  }

  @Override
  public boolean canContinueToUse() {
    return this.looksRemaining > 0;
  }

  @Override
  public void start() {
    this.resetLook();
    this.looksRemaining = 2 + this.fox.getRandom().nextInt(3);
    this.fox.setSitting(true);
    this.fox.getNavigation().stop();
  }

  @Override
  public void stop() {
    this.fox.setSitting(false);
  }

  @Override
  public void tick() {
    --this.lookTime;
    if (this.lookTime <= 0) {
      --this.looksRemaining;
      this.resetLook();
    }

    this.fox.getLookControl().setLookAt(this.fox.getX() + this.relX, this.fox.getEyeY(),
        this.fox.getZ() + this.relZ, (float) this.fox.getMaxHeadYRot(), (float) this.fox.getMaxHeadXRot());
  }

  private void resetLook() {
    double d0 = 6.283185307179586D * this.fox.getRandom().nextDouble();

    this.relX = Math.cos(d0);
    this.relZ = Math.sin(d0);
    this.lookTime = this.adjustedTickDelay(80 + this.fox.getRandom().nextInt(20));
  }
}
