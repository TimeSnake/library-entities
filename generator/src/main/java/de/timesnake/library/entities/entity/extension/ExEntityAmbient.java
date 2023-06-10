/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.ambient.EntityAmbient;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAmbient;

public class ExEntityAmbient extends ExEntityInsentient {

	public ExEntityAmbient(CraftAmbient entity) {
		super(entity);
	}

	public ExEntityAmbient(EntityAmbient entity) {
		super(entity);
	}
}
