/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.animal.AbstractSchoolingFish;

public abstract class AbstractSchoolingFishBuilder<E extends AbstractSchoolingFish, B extends AbstractSchoolingFishBuilder<E,
    B>> extends AbstractFishBuilder<E, B> {

  public AbstractSchoolingFishBuilder() {
    super();
  }
}
