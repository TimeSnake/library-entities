/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;

public class SlimeRandomDirectionGoal extends Goal {

  private final Slime slime;
  private float chosenDegrees;
  private int nextRandomizeTime;

  public SlimeRandomDirectionGoal(Slime slime) {
    this.slime = slime;
    this.setFlags(EnumSet.of(Goal.Flag.LOOK));
  }

  @Override
  public boolean canUse() {
    return this.slime.getTarget() == null && (this.slime.onGround() || this.slime.isInWater() || this.slime.isInLava()
        || this.slime.hasEffect(MobEffects.LEVITATION)) && this.slime.canWander(); // Paper - add canWander
  }

  @Override
  public void tick() {
    if (--this.nextRandomizeTime <= 0) {
      this.nextRandomizeTime = this.adjustedTickDelay(40 + this.slime.getRandom().nextInt(60));
      this.chosenDegrees = (float) this.slime.getRandom().nextInt(360);
      // Paper start
      SlimeChangeDirectionEvent event = new SlimeChangeDirectionEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity(), this.chosenDegrees);
      if (!this.slime.canWander() || !event.callEvent()) return;
      this.chosenDegrees = event.getNewYaw();
      // Paper end
    }

    Class<?> moveControlClass;
    try {
      moveControlClass = Class.forName("net.minecraft.world.entity.monster.Slime$SlimeMoveControl");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    try {
      Method setDirection = moveControlClass.getMethod("setDirection", float.class, boolean.class);
      setDirection.setAccessible(true);
      setDirection.invoke(this.slime.getMoveControl(), this.chosenDegrees, false);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
