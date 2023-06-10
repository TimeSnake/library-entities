/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHumanEntity;

public class ExHumanEntity extends CraftHumanEntity {

	public ExHumanEntity(EntityHuman entity) {
		super(((CraftServer) Bukkit.getServer()), entity);
	}

	public ExHumanEntity(CraftServer server, EntityHuman entity) {
		super(server, entity);
	}
}
