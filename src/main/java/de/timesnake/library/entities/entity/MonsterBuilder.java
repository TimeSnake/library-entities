/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.monster.Monster;

public class MonsterBuilder<E extends Monster, B extends MonsterBuilder<E, B>> extends MobBuilder<E, B> {

  public MonsterBuilder(E entity) {
    super(entity);
  }

}
