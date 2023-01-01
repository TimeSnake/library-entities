/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.projectile.EntityFireball;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFireball;

public class ExEntityFireball extends ExIProjectile {

    public ExEntityFireball(CraftFireball entity) {
        super(entity);
    }

    public ExEntityFireball(EntityFireball entity) {
        super(entity);
    }
}
