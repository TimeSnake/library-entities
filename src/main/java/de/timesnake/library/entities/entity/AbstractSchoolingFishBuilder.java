/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.animal.AbstractSchoolingFish;

public class AbstractSchoolingFishBuilder<E extends AbstractSchoolingFish, B extends AbstractSchoolingFishBuilder<E,
    B>> extends AbstractFishBuilder<E, B> {

  public AbstractSchoolingFishBuilder(E entity) {
    super(entity);
  }
}
