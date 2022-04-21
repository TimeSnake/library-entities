package de.timesnake.basic.entities.entity.extension;


import net.minecraft.world.entity.EntityFlying;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftFlying;

public class ExEntityFlying extends ExEntityInsentient {

    public ExEntityFlying(CraftFlying entity) {
        super(entity);
    }

    public ExEntityFlying(EntityFlying entity) {
        super(entity);
    }
}
