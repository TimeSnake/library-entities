/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.timesnake.library.basic.util.Tuple;
import de.timesnake.library.entities.entity.base.LivingEntityBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.CraftServer;

import java.lang.reflect.Field;
import java.util.UUID;

public class PlayerBuilder<E extends Player, B extends PlayerBuilder<E, B>> extends LivingEntityBuilder<E, B> {

  public static PlayerBuilder<Player, ?> ofName(String name, String skinValue, String skinSignature) {
    return ofName(name, name, skinValue, skinSignature);
  }

  public static PlayerBuilder<Player, ?> ofName(String name, String tablistName, String skinValue,
                                                String skinSignature) {
    GameProfile profile = new GameProfile(UUID.randomUUID(), name);
    if (skinValue != null && skinSignature != null) {
      profile.getProperties().put("textures", new Property("textures", skinValue, skinSignature));
    }
    MinecraftServer server = ((CraftServer) Bukkit.getServer()).getHandle().getServer();
    ClientInformation clientInformation = ClientInformation.createDefault();
    Player player = new ServerPlayer(server, server.overworld(), profile, clientInformation);
    try {
      Field listName = player.getClass().getField("listName");
      listName.setAccessible(true);
      listName.set(player, Component.literal(tablistName));
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return new PlayerBuilder<>(player);
  }

  public static PlayerBuilder<Player, ?> ofName(String name) {
    return ofName(name, name, null, null);
  }

  public static PlayerBuilder<Player, ?> ofName(String name, String tablistName) {
    return ofName(name, tablistName, null, null);
  }

  private final E player;

  public PlayerBuilder(E player) {
    super();
    this.player = player;
  }

  public E build() {
    return this.build(null);
  }

  @Override
  protected E create(ServerLevel serverLevel) {
    return this.player;
  }

  public B setTextures(String value, String signature) {
    return this.applyOnEntity(e -> e.getGameProfile().getProperties().put("textures", new Property("textures", value,
        signature)));
  }

  public Tuple<String, String> getTextures() {
    Property property = this.player.getGameProfile().getProperties().get("textures").stream().findFirst().get();
    return new Tuple<>(property.value(), property.signature());
  }
}
