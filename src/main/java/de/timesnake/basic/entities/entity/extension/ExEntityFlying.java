package de.timesnake.library.entities.entity.extension;


import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityFlying;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftFlying;

@NmsReflection
public class ExEntityFlying extends ExEntityInsentient {

    public ExEntityFlying(CraftFlying entity) {
        super(entity);
    }

    public ExEntityFlying(EntityFlying entity) {
        super(entity);
    }
}
