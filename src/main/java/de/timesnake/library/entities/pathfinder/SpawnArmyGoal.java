/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;
import java.util.List;

public abstract class SpawnArmyGoal extends Goal {

  private final Mob entity;
  private final Class<? extends Mob> armyClass;

  private final TargetingConditions targetCondition;

  private final int spawn;

  private final int cooldown;
  private int currentCooldown = 0;

  public SpawnArmyGoal(Mob entity, Class<? extends Mob> armyClass, int spawn) {
    this(entity, armyClass, spawn, 0);
  }

  public SpawnArmyGoal(Mob entity, Class<? extends Mob> armyClass, int spawn, int cooldown) {
    this.entity = entity;
    this.armyClass = armyClass;
    this.spawn = spawn;
    this.cooldown = cooldown;
    this.targetCondition = TargetingConditions.forCombat().range(8.0D)
        .ignoreInvisibilityTesting()
        .ignoreLineOfSight();
    this.setFlags(EnumSet.of(Flag.MOVE));
  }

  public boolean canUse() {
    int size = entity.level().getNearbyEntities(this.armyClass, this.targetCondition,
        entity, entity.getBoundingBox().inflate(8.0D)).size();
    this.currentCooldown--;
    return entity.getRandom().nextInt(spawn) >= size && this.currentCooldown <= 0;
  }

  public boolean canContinueToUse() {
    return this.canUse();
  }

  public void start() {
    for (Mob entity : this.getArmy()) {
      entity.setPos(this.entity.getPosition(3));
      entity.setTarget(this.entity.getTarget(), EntityTargetEvent.TargetReason.CUSTOM, true);
      entity.setRot(0, 0);

      this.entity.level().addFreshEntity(entity);
    }

    this.currentCooldown = this.cooldown;
  }

  public Mob getEntity() {
    return entity;
  }

  public abstract List<? extends Mob> getArmy();


}
