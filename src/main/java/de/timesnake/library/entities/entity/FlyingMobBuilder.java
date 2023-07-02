/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;


import net.minecraft.world.entity.FlyingMob;

public class FlyingMobBuilder<E extends FlyingMob, B extends FlyingMobBuilder<E, B>> extends MobBuilder<E, B> {

  public FlyingMobBuilder(E entity) {
    super(entity);
  }
}
