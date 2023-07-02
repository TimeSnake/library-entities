/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.animal.Animal;

public class AnimalBuilder<E extends Animal, B extends AnimalBuilder<E, B>> extends AgeableMobBuilder<E, B> {

  public AnimalBuilder(E entity) {
    super(entity);
  }

}
