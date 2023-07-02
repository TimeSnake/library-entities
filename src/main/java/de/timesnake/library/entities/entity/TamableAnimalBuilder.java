/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.TamableAnimal;

public class TamableAnimalBuilder<E extends TamableAnimal, B extends TamableAnimalBuilder<E, B>> extends AnimalBuilder<E, B> {

  public TamableAnimalBuilder(E entity) {
    super(entity);
  }

}
