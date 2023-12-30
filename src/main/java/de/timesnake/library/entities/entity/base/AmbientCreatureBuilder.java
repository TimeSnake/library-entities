/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.ambient.AmbientCreature;

public abstract class AmbientCreatureBuilder<E extends AmbientCreature, B extends AmbientCreatureBuilder<E, B>> extends MobBuilder<E, B> {

  public AmbientCreatureBuilder() {
    super();
  }
}
