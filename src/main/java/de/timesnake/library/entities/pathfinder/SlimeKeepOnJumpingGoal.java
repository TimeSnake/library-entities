/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeWanderEvent;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    Class<?> moveControlClass;
    try {
      moveControlClass = Class.forName("net.minecraft.world.entity.monster.Slime$SlimeMoveControl");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    try {
      Method setWantedMovement = moveControlClass.getMethod("setWantedMovement", double.class);
      setWantedMovement.setAccessible(true);
      setWantedMovement.invoke(this.slime.getMoveControl(), 1.0D);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
