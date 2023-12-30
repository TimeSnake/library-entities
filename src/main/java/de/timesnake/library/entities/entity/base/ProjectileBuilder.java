/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.projectile.Projectile;

public abstract class ProjectileBuilder<E extends Projectile, B extends ProjectileBuilder<E, B>> extends EntityBuilder<E, B> {

  public ProjectileBuilder() {
    super();
  }
}
