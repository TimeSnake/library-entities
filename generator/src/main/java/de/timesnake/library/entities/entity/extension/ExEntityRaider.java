/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.raid.EntityRaider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftRaider;

public class ExEntityRaider extends ExEntityMonsterPatrolling {

    public ExEntityRaider(CraftRaider entity) {
        super(entity);
    }

    public ExEntityRaider(EntityRaider entity) {
        super(entity);
    }
}
