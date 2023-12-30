/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.monster.AbstractIllager;

public abstract class AbstractIllagerBuilder<E extends AbstractIllager, B extends AbstractIllagerBuilder<E, B>> extends RaiderBuilder<E, B> {

  public AbstractIllagerBuilder() {
    super();
  }
}
