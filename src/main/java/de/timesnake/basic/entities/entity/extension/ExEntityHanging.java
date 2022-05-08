package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.Entity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;

@NmsReflection
public class ExEntityHanging extends ExEntity {

    public ExEntityHanging(CraftEntity entity) {
        super(entity);
    }

    public ExEntityHanging(Entity entity) {
        super(entity);
    }
}
