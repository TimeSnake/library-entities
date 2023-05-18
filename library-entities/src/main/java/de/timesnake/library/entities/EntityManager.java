/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EntityManager {

  public static void spawnEntity(org.bukkit.entity.Entity entity) {
    ((CraftWorld) entity.getWorld()).addEntity(((CraftEntity) entity).getHandle(),
        CreatureSpawnEvent.SpawnReason.CUSTOM);
  }

  public static void spawnEntity(World world, org.bukkit.entity.Entity entity) {
    ((CraftWorld) world).addEntity(((CraftEntity) entity).getHandle(),
        CreatureSpawnEvent.SpawnReason.CUSTOM);
  }

  public static void spawnEntity(World world, org.bukkit.entity.Entity entity,
      boolean randomizeData) {
    ((CraftWorld) world).addEntity(((CraftEntity) entity).getHandle(),
        CreatureSpawnEvent.SpawnReason.CUSTOM,
        null, randomizeData);
  }

  public static MinecraftServer getPlayerMcServer() {
    return ((CraftServer) Bukkit.getServer()).getServer();
  }

  public static WorldServer getPlayerWorldServer(World world) {
    return (((CraftWorld) world).getHandle());
  }

  public static GameProfile getPlayerNewGameProfile(String name) {
    return new GameProfile(UUID.randomUUID(), name);
  }


}
