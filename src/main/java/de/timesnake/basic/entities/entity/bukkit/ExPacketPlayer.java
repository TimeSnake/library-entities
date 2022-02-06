package de.timesnake.basic.entities.entity.bukkit;

import com.destroystokyo.paper.profile.ProfileProperty;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R1.CraftServer;
import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;

import java.util.Set;
import java.util.UUID;

public class ExPacketPlayer {

    private final EntityPlayer entity;

    public ExPacketPlayer(EntityPlayer entity) {
        this.entity = entity;
    }

    public ExPacketPlayer(World world, String name) {
        this.entity = new EntityPlayer(getMcServer(), getWorldServer(world), getNewGameProfile(name));
    }

    private static MinecraftServer getMcServer() {
        return ((CraftServer) Bukkit.getServer()).getServer();
    }

    private static WorldServer getWorldServer(World world) {
        return (((CraftWorld) world).getHandle());
    }

    private static GameProfile getNewGameProfile(String name) {
        return new GameProfile(UUID.randomUUID(), name);
    }


    public void setTextures(Set<ProfileProperty> profileProperties) {
        ProfileProperty textures = null;

        for (ProfileProperty prop : profileProperties) {
            if (prop.getName().equals("textures")) {
                textures = prop;
            }
        }

        //this.entity.getProfile().getProperties().put("textures", new Property("textures", textures.getValue(), textures.getSignature()));
    }

}
