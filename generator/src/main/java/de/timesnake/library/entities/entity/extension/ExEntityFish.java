/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityFish;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFish;

public class ExEntityFish extends ExEntityWaterAnimal {

	public ExEntityFish(CraftFish entity) {
		super(entity);
	}

	public ExEntityFish(EntityFish entity) {
		super(entity);
	}
}
