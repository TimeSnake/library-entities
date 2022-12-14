/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import com.mojang.authlib.properties.Property;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHumanEntity;

public class ExEntityPlayer extends ExEntityHuman {

    public ExEntityPlayer(CraftHumanEntity entityHuman) {
        super(entityHuman);
    }

    public ExEntityPlayer(EntityHuman entityHuman) {
        super(entityHuman);
    }

    public void setTextures(String value, String signature) {
        this.getProfile().getProperties().put("textures", new Property("textures", value, signature));
    }
}
