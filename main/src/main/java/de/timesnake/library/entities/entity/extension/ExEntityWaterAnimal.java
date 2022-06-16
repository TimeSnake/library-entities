package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityWaterAnimal;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftWaterMob;

public class ExEntityWaterAnimal extends ExEntityCreature {

    public ExEntityWaterAnimal(CraftWaterMob entity) {
        super(entity);
    }

    public ExEntityWaterAnimal(EntityWaterAnimal entity) {
        super(entity);
    }
}
