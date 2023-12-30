/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.decoration.HangingEntity;

public abstract class HangingEntityBuilder<E extends HangingEntity, B extends HangingEntityBuilder<E, B>> extends EntityBuilder<E, B> {

  public HangingEntityBuilder() {
    super();
  }

}
