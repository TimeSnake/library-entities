package de.timesnake.basic.entities.entity.bukkit;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.entities.wrapper.*;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEntityPose;
import de.timesnake.library.reflection.wrapper.ExEnumItemSlot;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.EntityItem;
import net.minecraft.world.level.material.FluidType;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftItem;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ExItem extends CraftItem {

    private final ExEntity extension = new ExEntity(this);

    public ExItem(World world) {
        super(((CraftServer) Bukkit.getServer()), new EntityItem(ExEntityType.ITEM.getNMSType(),
                ((CraftWorld) world).getHandle()));
    }

    public ExItem(EntityItem entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

    public ExEntity getExtension() {
        return extension;
    }


    public void setNMSField(String name, Object value) {getExtension().setNMSField(name, value);}

    public void setNMSField(Class<? extends Entity> clazz, String name, Object value) {getExtension().setNMSField(clazz, name, value);}

    public Object getNMSField(String name) {return getExtension().getNMSField(name);}

    public Entity getNMS() {return getExtension().getNMS();}

    public void kill() {getExtension().kill();}

    public int getId() {return getExtension().getId();}

    public CraftEntity getBukkitEntity() {return getExtension().getBukkitEntity();}

    public boolean isInvulnerable(ExDamageSource damagesource) {return getExtension().isInvulnerable(damagesource);}

    public void setSecondsOnFire(int seconds) {getExtension().setSecondsOnFire(seconds);}

    public void setSecondsOnFire(int seconds, boolean callEvent) {getExtension().setSecondsOnFire(seconds, callEvent);}

    public int getRemainingFireTicks() {return getExtension().getRemainingFireTicks();}

    public void setRemainingFireTicks(int ticks) {getExtension().setRemainingFireTicks(ticks);}

    public void clearFire() {getExtension().clearFire();}

    public void setOnGround(boolean flag) {getExtension().setOnGround(flag);}

    public void move(ExEntityMoveType moveType, double x, double y, double z) {getExtension().move(moveType, x, y, z);}

    public void setPosition(double x, double y, double z) {getExtension().setPosition(x, y, z);}

    public void setPosition(double x, double y, double z, boolean fixSpawnInBlock) {
        getExtension().setPosition(x, y,
                z, fixSpawnInBlock);
    }

    public double getX() {return getExtension().getX();}

    public double getY() {return getExtension().getY();}

    public double getZ() {return getExtension().getZ();}

    public boolean isAlive() {return getExtension().isAlive();}

    public boolean isNoGravity() {return getExtension().isNoGravity();}

    public void setNoGravity(boolean flag) {getExtension().setNoGravity(flag);}

    public float getYaw() {return getExtension().getYaw();}

    public void setYaw(float yaw) {getExtension().setYaw(yaw);}

    public float getPitch() {return getExtension().getPitch();}

    public void setPitch(float pitch) {getExtension().setPitch(pitch);}

    public double distanceSquared(ExBlockPosition position) {return getExtension().distanceSquared(position);}

    public double distanceSquared(double x, double y, double z) {return getExtension().distanceSquared(x, y, z);}

    public double distanceSquared(ExEntity entity) {return getExtension().distanceSquared(entity);}

    public double distanceSquared(Entity entity) {return getExtension().distanceSquared(entity);}

    public ExVec3D getPositionVector() {return getExtension().getPositionVector();}

    public Random getRandom() {return getExtension().getRandom();}

    public WorldServer getNMSWorld() {return getExtension().getNMSWorld();}

    public ExWorldServer getExWorld() {return getExtension().getExWorld();}

    public ExAxisAlignedBB getExBoundingBox() {return getExtension().getExBoundingBox();}

    public void playSound(SoundEffect soundEffect, float f, float f1) {getExtension().playSound(soundEffect, f, f1);}

    public boolean isInvisible() {return getExtension().isInvisible();}

    public boolean isSpectator() {return getExtension().isSpectator();}

    public boolean isPassenger() {return getExtension().isPassenger();}

    public boolean isVehicle() {return getExtension().isVehicle();}

    public BlockPosition getChunkCoordinates() {return getExtension().getChunkCoordinates();}

    public ExBlockPosition getExChunkCoordinates() {return getExtension().getExChunkCoordinates();}

    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {getExtension().setPositionRotation(x, y, z, yaw, pitch);}

    public void setPositionRotation(ExBlockPosition position, float yaw, float pitch) {getExtension().setPositionRotation(position, yaw, pitch);}

    public void setSlot(ExEnumItemSlot slot, ItemStack item) {getExtension().setSlot(slot, item);}

    public void setPose(ExEntityPose pose) {getExtension().setPose(pose);}

    public double b(TagKey<FluidType> type) {return getExtension().b(type);}

    public double cx() {return getExtension().cx();}

    public boolean aQ() {return getExtension().aQ();}

    public double e(double d0) {return getExtension().e(d0);}

    public DataWatcher getDataWatcher() {return getExtension().getDataWatcher();}
}
