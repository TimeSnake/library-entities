/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.world.entity.npc.AbstractVillager;

public class AbstractVillagerBuilder<E extends AbstractVillager, B extends AbstractVillagerBuilder<E, B>> extends AgeableMobBuilder<E, B> {

  public AbstractVillagerBuilder(E entity) {
    super(entity);
  }

}
