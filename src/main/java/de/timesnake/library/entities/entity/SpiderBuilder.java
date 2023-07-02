/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.monster.Spider;

public class SpiderBuilder<E extends Spider, B extends SpiderBuilder<E, B>> extends MonsterBuilder<E, B> {

  public SpiderBuilder(E entity) {
    super(entity);
  }

}
