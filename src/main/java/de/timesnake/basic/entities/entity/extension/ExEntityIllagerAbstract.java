package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.monster.EntityIllagerAbstract;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftIllager;

@NmsReflection
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
