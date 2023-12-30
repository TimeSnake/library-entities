/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.raid.Raider;

public abstract class RaiderBuilder<E extends Raider, B extends RaiderBuilder<E, B>> extends PatrollingMonsterBuilder<E, B> {

  public RaiderBuilder() {
    super();
  }
}
