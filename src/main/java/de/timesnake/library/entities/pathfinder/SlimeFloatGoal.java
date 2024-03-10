/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeSwimEvent;
import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.util.EnumSet;

public class SlimeFloatGoal extends Goal {

  private final Slime slime;

  public SlimeFloatGoal(Slime slime) {
    this.slime = slime;
    this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    slime.getNavigation().setCanFloat(true);
  }

  @Override
  public boolean canUse() {
    return (this.slime.isInWater() || this.slime.isInLava()) && this.slime.canWander()
        && new SlimeSwimEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity()).callEvent(); // Paper
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    if (this.slime.getRandom().nextFloat() < 0.8F) {
      this.slime.getJumpControl().jump();
    }

    ProxyManager.getInstance().getSlimeMoveControlProxy().setWantedMovement(this.slime.getMoveControl(), 1.2D);
  }
}
