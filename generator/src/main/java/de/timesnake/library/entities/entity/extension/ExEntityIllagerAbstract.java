/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityIllagerAbstract;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftIllager;

public class ExEntityIllagerAbstract extends ExEntityRaider {

    public ExEntityIllagerAbstract(CraftIllager entity) {
        super(entity);
    }

    public ExEntityIllagerAbstract(EntityIllagerAbstract entity) {
        super(entity);
    }

    @Override
    public EntityIllagerAbstract getNMS() {
        return (EntityIllagerAbstract) super.getNMS();
    }
}
