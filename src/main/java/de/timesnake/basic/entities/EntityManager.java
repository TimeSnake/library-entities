package de.timesnake.basic.entities;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;

@NmsReflection
public class EntityManager {

    public static void spawnEntity(org.bukkit.entity.Entity entity) {
        ((CraftWorld) entity.getWorld()).addEntity(((CraftEntity) entity).getHandle(),
                CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    public static void spawnEntity(World world, org.bukkit.entity.Entity entity) {
        ((CraftWorld) world).addEntity(((CraftEntity) entity).getHandle(), CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    public static void spawnExEntity(World world, EntityExtension<?> entity) {
        ((CraftWorld) world).addEntity(entity.getExtension().getNMS(), CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

}
