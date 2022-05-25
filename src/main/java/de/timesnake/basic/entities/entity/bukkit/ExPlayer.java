package de.timesnake.basic.entities.entity.bukkit;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.entities.entity.extension.ExEntityHuman;
import de.timesnake.basic.entities.wrapper.ExDamageSource;
import de.timesnake.basic.entities.wrapper.ExEntityMoveType;
import de.timesnake.basic.entities.wrapper.ExVec3D;
import de.timesnake.basic.entities.wrapper.ExWorldServer;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEntityPose;
import de.timesnake.library.reflection.wrapper.ExEnumItemSlot;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.level.material.FluidType;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

@NmsReflection
public class ExPlayer extends CraftPlayer implements EntityExtension<ExEntityHuman> {

    private final ExEntityHuman extension = new ExEntityHuman(this);

    public ExPlayer(EntityPlayer entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

    public ExPlayer(Player player) {
        super(((CraftServer) Bukkit.getServer()), ((CraftPlayer) player).getHandle());
    }

    public ExPlayer(World world, String name) {
        super(((CraftServer) Bukkit.getServer()), new EntityPlayer(getMcServer(), getWorldServer(world),
                getNewGameProfile(name)));
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

    public ExEntityHuman getExtension() {
        return extension;
    }

    public void setTextures(String value, String signature) {
        this.getProfile().getProperties().put("textures", new Property("textures", value, signature));
    }

    // delegated extension


    public void setNMSField(String name, Object value) {
        getExtension().setNMSField(name, value);
    }

    public Object getNMSField(String name) {
        return getExtension().getNMSField(name);
    }

    public void kill() {
        getExtension().kill();
    }

    public int getId() {
        return getExtension().getId();
    }

    public CraftEntity getBukkitEntity() {
        return getExtension().getBukkitEntity();
    }

    public boolean isInvulnerable(ExDamageSource damagesource) {
        return getExtension().isInvulnerable(damagesource);
    }

    public void setSecondsOnFire(int seconds) {
        getExtension().setSecondsOnFire(seconds);
    }

    public void setSecondsOnFire(int seconds, boolean callEvent) {
        getExtension().setSecondsOnFire(seconds, callEvent);
    }

    public void setRemainingFireTicks(int ticks) {
        getExtension().setRemainingFireTicks(ticks);
    }

    public int getRemainingFireTicks() {
        return getExtension().getRemainingFireTicks();
    }

    public void clearFire() {
        getExtension().clearFire();
    }

    public void setOnGround(boolean flag) {
        getExtension().setOnGround(flag);
    }

    public void move(ExEntityMoveType moveType, double x, double y, double z) {
        getExtension().move(moveType, x, y, z);
    }

    public void setPosition(double x, double y, double z) {
        getExtension().setPosition(x, y, z);
    }

    public double getX() {
        return getExtension().getX();
    }

    public double getY() {
        return getExtension().getY();
    }

    public double getZ() {
        return getExtension().getZ();
    }

    public boolean isAlive() {
        return getExtension().isAlive();
    }

    public boolean isNoGravity() {
        return getExtension().isNoGravity();
    }

    public void setNoGravity(boolean flag) {
        getExtension().setNoGravity(flag);
    }

    public float getYaw() {
        return getExtension().getYaw();
    }

    public void setYaw(float yaw) {
        getExtension().setYaw(yaw);
    }

    public float getPitch() {
        return getExtension().getPitch();
    }

    public void setPitch(float pitch) {
        getExtension().setPitch(pitch);
    }

    public double distanceSquared(double x, double y, double z) {
        return getExtension().distanceSquared(x, y, z);
    }

    public double distanceSquared(ExEntity entity) {
        return getExtension().distanceSquared(entity);
    }

    public double distanceSquared(Entity entity) {
        return getExtension().distanceSquared(entity);
    }

    public ExVec3D getPositionVector() {
        return getExtension().getPositionVector();
    }

    public Random getRandom() {
        return getExtension().getRandom();
    }

    public WorldServer getNMSWorld() {
        return getExtension().getNMSWorld();
    }

    public ExWorldServer getExWorld() {
        return getExtension().getExWorld();
    }

    public void playSound(SoundEffect soundEffect, float f, float f1) {
        getExtension().playSound(soundEffect, f, f1);
    }

    public boolean isSpectator() {
        return getExtension().isSpectator();
    }

    public boolean isPassenger() {
        return getExtension().isPassenger();
    }

    public boolean isVehicle() {
        return getExtension().isVehicle();
    }

    public BlockPosition getChunkCoordinates() {
        return getExtension().getChunkCoordinates();
    }

    public ExBlockPosition getExChunkCoordinates() {
        return getExtension().getExChunkCoordinates();
    }

    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {
        getExtension().setPositionRotation(x, y, z, yaw, pitch);
    }

    public void setPositionRotation(ExBlockPosition position, float yaw, float pitch) {
        getExtension().setPositionRotation(position, yaw, pitch);
    }

    public void setSlot(ExEnumItemSlot slot, ItemStack item) {
        getExtension().setSlot(slot, item);
    }

    public void setPose(ExEntityPose pose) {
        getExtension().setPose(pose);
    }

    public double b(TagKey<FluidType> type) {
        return getExtension().b(type);
    }

    public double cx() {
        return getExtension().cx();
    }

    public boolean aQ() {
        return getExtension().aQ();
    }

    public double e(double d0) {
        return getExtension().e(d0);
    }

    public DataWatcher getDataWatcher() {
        return getExtension().getDataWatcher();
    }

    public EntityHuman getNMS() {
        return getExtension().getNMS();
    }

    public UUID getUniqueID() {
        return getExtension().getUniqueID();
    }

}
