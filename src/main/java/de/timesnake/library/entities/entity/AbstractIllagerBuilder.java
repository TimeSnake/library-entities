/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.monster.AbstractIllager;

public class AbstractIllagerBuilder<E extends AbstractIllager, B extends AbstractIllagerBuilder<E, B>> extends RaiderBuilder<E, B> {

  public AbstractIllagerBuilder(E entity) {
    super(entity);
  }
}
