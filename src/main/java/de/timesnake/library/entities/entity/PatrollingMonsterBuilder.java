/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.monster.PatrollingMonster;

public class PatrollingMonsterBuilder<E extends PatrollingMonster, B extends PatrollingMonsterBuilder<E, B>> extends MonsterBuilder<E, B> {

  public PatrollingMonsterBuilder(E entity) {
    super(entity);
  }
}
