/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeSwimEvent;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    Class<?> moveControlClass;
    try {
      moveControlClass = Class.forName("net.minecraft.world.entity.monster.Slime$SlimeMoveControl");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    try {
      Method setWantedMovement = moveControlClass.getMethod("setWantedMovement", double.class);
      setWantedMovement.setAccessible(true);
      setWantedMovement.invoke(this.slime.getMoveControl(), 1.2D);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
