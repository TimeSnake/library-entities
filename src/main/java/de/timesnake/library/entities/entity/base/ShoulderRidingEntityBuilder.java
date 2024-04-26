/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.animal.ShoulderRidingEntity;

public abstract class ShoulderRidingEntityBuilder<E extends ShoulderRidingEntity,
    B extends ShoulderRidingEntityBuilder<E, B>> extends TamableAnimalBuilder<E, B> {
}
