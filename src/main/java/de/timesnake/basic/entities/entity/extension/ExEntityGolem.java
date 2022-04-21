package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityGolem;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftGolem;

public class ExEntityGolem extends ExEntityInsentient {

    public ExEntityGolem(EntityGolem entity) {
        super(entity);
    }

    public ExEntityGolem(CraftGolem entity) {
        super(entity);
    }
}
