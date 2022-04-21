package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.monster.EntitySpider;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftSpider;

public class ExEntitySpider extends ExEntityMonster {
    public ExEntitySpider(CraftSpider entity) {
        super(entity);
    }

    @Override
    public EntitySpider getNMS() {
        return (EntitySpider) super.getNMS();
    }
}
