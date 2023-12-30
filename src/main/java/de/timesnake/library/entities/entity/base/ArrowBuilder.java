/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.projectile.Arrow;

public abstract class ArrowBuilder<E extends Arrow, B extends ArrowBuilder<E, B>> extends ProjectileBuilder<E, B> {

  public ArrowBuilder() {
    super();
  }
}
