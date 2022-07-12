<#include "Header.ftl">

package ${moduleName};

import de.timesnake.library.basic.util.Tuple;
import ${entityModuleName}.ExtendedCraftEntity;
import ${extensionModuleName}.ExEntityHuman;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.CraftWorld;
import org.bukkit.craftbukkit.${version}.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

@NmsReflection
public class ExPlayer extends CraftPlayer implements ExtendedCraftEntity<ExEntityHuman> {

    private static MinecraftServer getMcServer() {
        return ((CraftServer) Bukkit.getServer()).getServer();
    }

    private static WorldServer getWorldServer(World world) {
        return (((CraftWorld) world).getHandle());
    }

    private static GameProfile getNewGameProfile(String name) {
        return new GameProfile(UUID.randomUUID(), name);
    }

    public ExPlayer(EntityPlayer entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

    public ExPlayer(Player player) {
        super(((CraftServer) Bukkit.getServer()), ((CraftPlayer) player).getHandle());
    }

    public ExPlayer(World world, String name) {
        super(((CraftServer) Bukkit.getServer()), new EntityPlayer(getMcServer(), getWorldServer(world),
                getNewGameProfile(name), null));
    }

    public void setTextures(String value, String signature) {
        this.getProfile().getProperties().put("textures", new Property("textures", value, signature));
    }

    public Tuple<String, String> getTextureValueSiganture() {
        Property property = this.getProfile().getProperties().get("textures").stream().findFirst().get();
        return new Tuple<>(property.getValue(), property.getSignature());
    }

    <#include "core/ExEntityExtension.ftl">
}
