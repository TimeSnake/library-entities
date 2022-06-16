package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.projectile.IProjectile;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;

public class ExIProjectile extends ExEntity {

    public ExIProjectile(CraftEntity entity) {
        super(entity);
    }

    public ExIProjectile(IProjectile entity) {
        super(entity);
    }
}
