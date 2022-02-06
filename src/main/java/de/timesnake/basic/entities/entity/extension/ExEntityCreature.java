package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.EntityCreature;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftCreature;

public class ExEntityCreature extends ExEntityInsentient {

    public ExEntityCreature(CraftCreature entity) {
        super(entity);
    }

    public ExEntityCreature(EntityCreature entity) {
        super(entity);
    }

    @Override
    public EntityCreature getNMS() {
        return (EntityCreature) super.getNMS();
    }
}
