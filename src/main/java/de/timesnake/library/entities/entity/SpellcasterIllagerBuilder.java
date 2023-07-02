/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.monster.SpellcasterIllager;

public class SpellcasterIllagerBuilder<E extends SpellcasterIllager, B extends SpellcasterIllagerBuilder<E, B>> extends AbstractIllagerBuilder<E, B> {

  public SpellcasterIllagerBuilder(E entity) {
    super(entity);
  }

}
