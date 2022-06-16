package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ambient.EntityAmbient;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftAmbient;

@NmsReflection
public class ExEntityAmbient extends ExEntityInsentient {

    public ExEntityAmbient(CraftAmbient entity) {
        super(entity);
    }

    public ExEntityAmbient(EntityAmbient entity) {
        super(entity);
    }
}
