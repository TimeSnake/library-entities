/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.monster.EntitySpider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSpider;

public class ExEntitySpider extends ExEntityMonster {
    public ExEntitySpider(CraftSpider entity) {
        super(entity);
    }

    @Override
    public EntitySpider getNMS() {
        return (EntitySpider) super.getNMS();
    }
}
