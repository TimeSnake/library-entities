/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.decoration.HangingEntity;

public class HangingEntityBuilder<E extends HangingEntity, B extends HangingEntityBuilder<E, B>> extends EntityBuilder<E, B> {

  public HangingEntityBuilder(E entity) {
    super(entity);
  }

}
