package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.ambient.EntityAmbient;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftAmbient;

public class ExEntityAmbient extends ExEntityInsentient {

    public ExEntityAmbient(CraftAmbient entity) {
        super(entity);
    }

    public ExEntityAmbient(EntityAmbient entity) {
        super(entity);
    }
}
