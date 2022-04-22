package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.monster.EntityMonster;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftMonster;

@NmsReflection
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
