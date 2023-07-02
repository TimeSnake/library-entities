/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.projectile.Projectile;

public class ProjectileBuilder<E extends Projectile, B extends ProjectileBuilder<E, B>> extends EntityBuilder<E, B> {

  public ProjectileBuilder(E entity) {
    super(entity);
  }
}
