package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.entities.wrapper.*;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEntityPose;
import de.timesnake.library.reflection.wrapper.ExEnumItemSlot;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FluidType;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;
import java.util.Random;

@NmsReflection(usesReflection = true)
public class ExEntity {

    protected final CraftEntity entity;


    public ExEntity(CraftEntity entity) {
        this.entity = entity;
    }

    public ExEntity(Entity entity) {
        this.entity = entity.getBukkitEntity();
    }

    public void setNMSField(String name, Object value) {
        RefUtil.setInstanceField(this.getHandle(), name, value);
    }

    public void setNMSField(Class<? extends Entity> clazz, String name, Object value) {
        RefUtil.setInstanceField(clazz, this.getHandle(), name, value);
    }

    public Object getNMSField(String name) {
        return RefUtil.getInstanceField(this, name);
    }

    public Entity getNMS() {
        return this.getHandle();
    }

    public Entity getHandle() {
        return this.entity.getHandle();
    }

    public void kill() {
        this.getNMS().ag();
    }

    public int getId() {
        return this.getNMS().ae();
    }

    public CraftEntity getBukkitEntity() {
        return this.entity;
    }

    public String getCustomName() {
        return this.getNMS().getBukkitEntity().getCustomName();
    }

    public void setCustomName(String name) {
        this.getNMS().getBukkitEntity().setCustomName(name);
    }

    public boolean isCustomNameVisible() {
        return this.getNMS().getBukkitEntity().isCustomNameVisible();
    }

    public void setCustomNameVisible(boolean flag) {
        this.getNMS().n(flag);
    }

    public boolean isInvulnerable() {
        return this.getNMS().getBukkitEntity().isInvulnerable();
    }

    public void setInvulnerable(boolean flag) {
        this.getNMS().getBukkitEntity().setInvulnerable(flag);
    }

    public boolean isInvulnerable(ExDamageSource damagesource) {
        return this.getNMS().b(damagesource.getNMS());
    }

    public void setSecondsOnFire(int seconds) {
        this.getNMS().setSecondsOnFire(seconds, true);
    }

    public void setSecondsOnFire(int seconds, boolean callEvent) {
        this.getNMS().setSecondsOnFire(seconds, callEvent);
    }

    public int getRemainingFireTicks() {
        return this.getNMS().at();
    }

    public void setRemainingFireTicks(int ticks) {
        this.getNMS().g(ticks);
    }

    public void clearFire() {
        this.setRemainingFireTicks(0);
    }

    public boolean isOnGround() {
        return this.getNMS().aw();
    }

    public void setOnGround(boolean flag) {
        this.getNMS().c(flag);
    }

    public void move(ExEntityMoveType moveType, double x, double y, double z) {
        this.getNMS().a(moveType.getNMSType(), new Vec3D(x, y, z));
    }

    public void setPosition(double x, double y, double z) {
        this.getNMS().o(x, y + 0.1, z);
    }

    public void setPosition(double x, double y, double z, boolean fixSpawnInBlock) {
        this.getNMS().o(x, y + (fixSpawnInBlock ? 0.1 : 0), z);
    }

    public double getX() {
        return this.getLocation().getX();
    }

    public double getY() {
        return this.getLocation().getY();
    }

    public double getZ() {
        return this.getLocation().getZ();
    }

    public boolean isAlive() {
        return !this.getBukkitEntity().isDead();
    }

    public boolean isSilent() {
        return this.getHandle().aM();
    }

    public void setSilent(boolean flag) {
        this.getHandle().d(flag);
    }

    public boolean isNoGravity() {
        return this.getNMS().getBukkitEntity().hasGravity();
    }

    public void setNoGravity(boolean flag) {
        this.getNMS().getBukkitEntity().setGravity(!flag);
    }

    public boolean isInWater() {
        return this.getNMS().getBukkitEntity().isInWater();
    }

    public float getYaw() {
        return this.getNMS().getBukkitEntity().getLocation().getYaw();
    }

    public void setYaw(float yaw) {
        this.getHandle().o(yaw);
    }

    public float getPitch() {
        return (float) RefUtil.getInstanceField(this.getHandle(), "aB");
    }

    public void setPitch(float pitch) {
        this.getHandle().p(pitch);
    }

    public double distanceSquared(ExBlockPosition position) {
        return this.getLocation().distanceSquared(new Location(this.getBukkitEntity().getWorld(), position.getX(),
                position.getY(), position.getZ()));
    }


    public double distanceSquared(double x, double y, double z) {
        return this.getLocation().distanceSquared(new Location(this.getBukkitEntity().getWorld(), x, y, z));
    }

    public double distanceSquared(ExEntity entity) {
        return this.getLocation().distanceSquared(entity.getLocation());
    }

    public double distanceSquared(Entity entity) {
        return this.getLocation().distanceSquared(entity.getBukkitEntity().getLocation());
    }

    public Location getLocation() {
        return this.getLocation();
    }

    public ExVec3D getPositionVector() {
        return new ExVec3D(this.getNMS().cZ());
    }

    public Random getRandom() {
        return (Random) RefUtil.getInstanceField(this.getNMS(), "R");
    }

    public RandomSource getRandomSource() {
        RandomSource rs;
        try {
            Field rsField = this.getNMS().getClass().getField("rs");
            rsField.setAccessible(true);
            rs = (RandomSource) rsField.get(this.getNMS());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public WorldServer getNMSWorld() {
        return ((CraftWorld) this.getBukkitEntity().getWorld()).getHandle();
    }

    public ExWorldServer getExWorld() {
        return new ExWorldServer(((CraftWorld) this.getBukkitEntity().getWorld()).getHandle());
    }

    public ExAxisAlignedBB getExBoundingBox() {
        return new ExAxisAlignedBB(this.getNMS().cz());
    }

    public int getTicksLived() {
        return this.getNMS().S;
    }

    public void playSound(SoundEffect soundEffect, float f, float f1) {
        this.getNMS().a(soundEffect, f, f1);
    }

    public boolean isInvisible() {
        return this.getNMS().bU();
    }

    public boolean isSpectator() {
        return this.getNMS().B_();
    }

    public BlockPosition getChunkCoordinates() {
        return this.getNMS().db();
    }

    public ExBlockPosition getExChunkCoordinates() {
        return new ExBlockPosition(this.getChunkCoordinates());
    }

    public void setPositionRotation(double x, double y, double z, float yaw, float pitch) {
        this.getNMS().b(x, y, z, yaw, pitch);
    }

    public void setPositionRotation(ExBlockPosition position, float yaw, float pitch) {
        this.setPositionRotation(position.getX(), position.getY(), position.getZ(), yaw, pitch);
    }

    public void setSlot(ExEnumItemSlot slot, ItemStack item) {
        this.getNMS().a(slot.getNmsSlot(), CraftItemStack.asNMSCopy(item));
    }

    public void setPose(ExEntityPose pose) {
        this.getNMS().b(pose.getPose());
    }

    public double b(TagKey<FluidType> type) {
        return this.getNMS().b(type);
    }

    public double cx() {
        return this.getNMS().cW();
    }

    public boolean aQ() {
        return this.getNMS().aS();
    }

    public double e(double d0) {
        return this.getNMS().e(d0);
    }

    public DataWatcher getDataWatcher() {
        return this.getNMS().ai();
    }

    public void setPersistent(boolean flag) {
        this.getNMS().persist = flag;
    }

    public boolean isPassenger() {
        return this.getNMS().bJ();
    }

    public Entity getVehicle() {
        return ((CraftEntity) this.getBukkitEntity().getVehicle()).getHandle();
    }

    public boolean isVehicle() {
        return this.getNMS().bK();
    }


}
