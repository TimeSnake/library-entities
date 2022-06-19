package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.animal.EntityGolem;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGolem;

@NmsReflection
public class ExEntityGolem extends ExEntityInsentient {

    public ExEntityGolem(EntityGolem entity) {
        super(entity);
    }

    public ExEntityGolem(CraftGolem entity) {
        super(entity);
    }
}
