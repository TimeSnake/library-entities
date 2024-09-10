/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;

public class SlimeAttackGoal extends Goal {

  private final Slime slime;
  private int growTiredTimer;

  public SlimeAttackGoal(Slime slime) {
    this.slime = slime;
    this.setFlags(EnumSet.of(Goal.Flag.LOOK));
  }

  @Override
  public boolean canUse() {
    LivingEntity entityliving = this.slime.getTarget();

    // Paper start
    if (entityliving == null || !entityliving.isAlive()) {
      return false;
    }
    if (!this.slime.canAttack(entityliving)) {
      return false;
    }
    return this.slime.canWander() && new SlimeTargetLivingEntityEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity(),
        (org.bukkit.entity.LivingEntity) entityliving.getBukkitEntity()).callEvent();
    // Paper end
  }

  @Override
  public void start() {
    this.growTiredTimer = reducedTickDelay(300);
    super.start();
  }

  @Override
  public boolean canContinueToUse() {
    LivingEntity entityliving = this.slime.getTarget();

    // Paper start
    if (entityliving == null || !entityliving.isAlive()) {
      return false;
    }
    if (!this.slime.canAttack(entityliving)) {
      return false;
    }
    return --this.growTiredTimer > 0 && this.slime.canWander()
           && new SlimeTargetLivingEntityEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity(),
        (org.bukkit.entity.LivingEntity) entityliving.getBukkitEntity()).callEvent();
    // Paper end
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    LivingEntity entityliving = this.slime.getTarget();

    if (entityliving != null) {
      this.slime.lookAt(entityliving, 10.0F, 10.0F);
    }

    Class<?> moveControlClass;
    try {
      moveControlClass = Class.forName("net.minecraft.world.entity.monster.Slime$SlimeMoveControl");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    boolean result;
    try {
      Method isDealsDamage = this.slime.getClass().getMethod("isDealsDamage");
      isDealsDamage.setAccessible(true);
      result = (boolean) isDealsDamage.invoke(this.slime);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }

    try {
      Method setDirection = moveControlClass.getMethod("setDirection", float.class, boolean.class);
      setDirection.setAccessible(true);
      setDirection.invoke(this.slime.getMoveControl(), this.slime.getYRot(), result);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  // Paper start - clear timer and target when goal resets
  public void stop() {
    this.growTiredTimer = 0;
    this.slime.setTarget(null);
  }
  // Paper end
}
