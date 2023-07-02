/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.animal.AbstractFish;

public class AbstractFishBuilder<E extends AbstractFish, B extends AbstractFishBuilder<E, B>> extends CraftWaterMobBuilder<E, B> {

  public AbstractFishBuilder(E entity) {
    super(entity);
  }
}
