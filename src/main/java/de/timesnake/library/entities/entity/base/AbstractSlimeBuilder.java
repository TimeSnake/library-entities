/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.monster.Slime;

import java.util.function.Supplier;

public abstract class AbstractSlimeBuilder<E extends Slime, B extends AbstractSlimeBuilder<E, B>> extends MobBuilder<E, B> {

  protected Supplier<Integer> jumpDelay = null;
  protected Boolean dealsDamage = null;

  public AbstractSlimeBuilder() {
    super();
  }

  public B setJumpDelay(Supplier<Integer> jumpDelay) {
    this.jumpDelay = jumpDelay;
    return this.self;
  }

  public B setDealsDamage(boolean dealsDamage) {
    this.dealsDamage = dealsDamage;
    return this.self;
  }
}
