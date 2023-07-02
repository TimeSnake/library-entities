/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.projectile.Fireball;

public class FireballBuilder<E extends Fireball, B extends FireballBuilder<E, B>> extends ProjectileBuilder<E, B> {

  public FireballBuilder(E entity) {
    super(entity);
  }
}
