/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.animal.AbstractGolem;

public class AbstractGolemBuilder<E extends AbstractGolem, B extends AbstractGolemBuilder<E, B>> extends MobBuilder<E, B> {

  public AbstractGolemBuilder(E entity) {
    super(entity);
  }

}
