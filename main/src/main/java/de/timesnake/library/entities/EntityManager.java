/*
 * library-entities.library-entities.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.entities;

import com.mojang.authlib.GameProfile;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.UUID;

@NmsReflection
public class EntityManager {

    public static void spawnEntity(org.bukkit.entity.Entity entity) {
        ((CraftWorld) entity.getWorld()).addEntity(((CraftEntity) entity).getHandle(),
                CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    public static void spawnEntity(World world, org.bukkit.entity.Entity entity) {
        ((CraftWorld) world).addEntity(((CraftEntity) entity).getHandle(), CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    public static void spawnEntity(World world, org.bukkit.entity.Entity entity, boolean randomizeData) {
        ((CraftWorld) world).addEntity(((CraftEntity) entity).getHandle(), CreatureSpawnEvent.SpawnReason.CUSTOM,
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
