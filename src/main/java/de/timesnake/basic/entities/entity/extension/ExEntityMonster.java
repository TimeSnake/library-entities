package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityMonster;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftMonster;

public class ExEntityMonster extends ExEntityInsentient {

    public ExEntityMonster(CraftMonster entity) {
        super(entity);
    }

    public ExEntityMonster(EntityMonster entity) {
        super(entity);
    }

    @Override
    public EntityMonster getNMS() {
        return (EntityMonster) super.getNMS();
    }
}
