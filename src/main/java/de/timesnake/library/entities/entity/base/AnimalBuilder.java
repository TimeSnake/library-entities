/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.animal.Animal;

public abstract class AnimalBuilder<E extends Animal, B extends AnimalBuilder<E, B>> extends AgeableMobBuilder<E, B> {

  public AnimalBuilder() {
    super();
  }

}
