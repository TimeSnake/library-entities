/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityWaterAnimal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWaterMob;

public class ExEntityWaterAnimal extends ExEntityCreature {

    public ExEntityWaterAnimal(CraftWaterMob entity) {
        super(entity);
    }

    public ExEntityWaterAnimal(EntityWaterAnimal entity) {
        super(entity);
    }
}
