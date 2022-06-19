package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.monster.EntitySpider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSpider;

@NmsReflection
public class ExEntitySpider extends ExEntityMonster {
    public ExEntitySpider(CraftSpider entity) {
        super(entity);
    }

    @Override
    public EntitySpider getNMS() {
        return (EntitySpider) super.getNMS();
    }
}
