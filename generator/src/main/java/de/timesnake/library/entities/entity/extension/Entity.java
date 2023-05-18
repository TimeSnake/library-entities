/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.entities.generator.Placeholder;

@Placeholder
public interface Entity {

  Class<net.minecraft.world.entity.Entity> NMS_CLASS = net.minecraft.world.entity.Entity.class;
}
