/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.PathfinderMob;

public class PathfinderMobBuilder<E extends PathfinderMob, B extends PathfinderMobBuilder<E, B>> extends MobBuilder<E, B> {

  public PathfinderMobBuilder(E entity) {
    super(entity);
  }

}
