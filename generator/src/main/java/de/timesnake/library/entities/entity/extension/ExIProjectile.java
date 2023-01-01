/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.projectile.IProjectile;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;

public class ExIProjectile extends ExEntity {

    public ExIProjectile(CraftEntity entity) {
        super(entity);
    }

    public ExIProjectile(IProjectile entity) {
        super(entity);
    }
}
