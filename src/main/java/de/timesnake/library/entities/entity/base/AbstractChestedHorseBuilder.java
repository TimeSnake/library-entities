/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;

public abstract class AbstractChestedHorseBuilder<E extends AbstractChestedHorse, B extends AbstractHorseBuilder<E,
    B>> extends AbstractHorseBuilder<E, B> {
}
