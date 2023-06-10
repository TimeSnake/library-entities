/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAbstractVillager;

public class ExEntityVillagerAbstract extends ExEntityAgeable {

	public ExEntityVillagerAbstract(CraftAbstractVillager entity) {
		super(entity);
	}

	public ExEntityVillagerAbstract(EntityVillagerAbstract entity) {
		super(entity);
	}

	@Override
	public EntityVillagerAbstract getNMS() {
		return ((EntityVillagerAbstract) super.getNMS());
	}
}
