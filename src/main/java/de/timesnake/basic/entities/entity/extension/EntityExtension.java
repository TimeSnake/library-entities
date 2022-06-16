package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.entity.Entity;

import java.util.Random;

public interface EntityExtension<E extends ExEntity> {

    static boolean isVehicle(Entity entity) {
        return entity.bG();
    }

    static Random getRandom(Entity entity) {
        return (Random) RefUtil.getInstanceField(entity, "R");
    }

    static float getWidth(Entity entity) {
        return entity.cT();
    }

    static float aR(Entity entity) {
        return entity.bd();
    }

    static double getX(Entity entity) {
        return entity.getBukkitEntity().getLocation().getX();
    }

    static double getY(Entity entity) {
        return entity.getBukkitEntity().getLocation().getY();
    }

    static double getZ(Entity entity) {
        return entity.getBukkitEntity().getLocation().getZ();
    }

    E getExtension();

}
