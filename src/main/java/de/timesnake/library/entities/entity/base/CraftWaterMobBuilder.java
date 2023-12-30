/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.animal.WaterAnimal;

public abstract class CraftWaterMobBuilder<E extends WaterAnimal, B extends CraftWaterMobBuilder<E, B>> extends PathfinderMobBuilder<E, B> {

  public CraftWaterMobBuilder() {
    super();
  }
}
