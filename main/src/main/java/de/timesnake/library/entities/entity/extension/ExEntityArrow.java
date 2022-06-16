package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.projectile.EntityArrow;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftArrow;

public class ExEntityArrow extends ExIProjectile {

    public ExEntityArrow(CraftArrow entity) {
        super(entity);
    }

    public ExEntityArrow(EntityArrow entity) {
        super(entity);
    }
}
