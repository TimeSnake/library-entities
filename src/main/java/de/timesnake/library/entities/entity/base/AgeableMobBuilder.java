/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.AgeableMob;

public abstract class AgeableMobBuilder<E extends AgeableMob, B extends AgeableMobBuilder<E, B>> extends MobBuilder<E, B> {

  public AgeableMobBuilder() {
    super();
  }

}
