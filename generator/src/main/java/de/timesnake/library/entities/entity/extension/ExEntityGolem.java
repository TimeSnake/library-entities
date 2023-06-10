/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityGolem;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGolem;

public class ExEntityGolem extends ExEntityInsentient {

	public ExEntityGolem(EntityGolem entity) {
		super(entity);
	}

	public ExEntityGolem(CraftGolem entity) {
		super(entity);
	}
}
