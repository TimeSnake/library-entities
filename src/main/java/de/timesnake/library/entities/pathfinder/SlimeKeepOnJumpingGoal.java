/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeWanderEvent;
import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.util.EnumSet;

public class SlimeKeepOnJumpingGoal extends Goal {

  private final Slime slime;

  public SlimeKeepOnJumpingGoal(Slime slime) {
    this.slime = slime;
    this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
  }

  @Override
  public boolean canUse() {
    return !this.slime.isPassenger() && this.slime.canWander()
        && new SlimeWanderEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity()).callEvent(); // Paper
  }

  @Override
  public void tick() {
    ProxyManager.getInstance().getSlimeMoveControlProxy().setWantedMovement(this.slime.getMoveControl(), 1.0D);
  }
}
