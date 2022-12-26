/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityCreeper;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMonster;

public class ExEntityCreeper extends ExEntityMonster {

    public ExEntityCreeper(CraftMonster entity) {
        super(entity);
    }

    @Override
    public EntityCreeper getNMS() {
        return (EntityCreeper) super.getNMS();
    }

    public int q() {
        return this.getNMS().q();
    }

    public void a(int i) {
        this.getNMS().a(i);
    }

    public int eK() {
        return this.getNMS().q();
    }
}
