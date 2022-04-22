package de.timesnake.basic.entities;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.Entity;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;

@NmsReflection
public class EntityManager {

    public static void spawnEntity(World world, org.bukkit.entity.Entity entity) {
        ((CraftWorld) world).getHandle().b(((CraftEntity) entity).getHandle());
    }

    public static void spawnExEntity(World world, EntityExtension<?> entity) {
        ((CraftWorld) world).getHandle().b(entity.getExtension().getNMS());
    }

    public static void spawnEntity(net.minecraft.world.level.World world, Entity entity) {
        world.b(entity);
    }

}
