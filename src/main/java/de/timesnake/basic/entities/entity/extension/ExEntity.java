package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.RefUtil;
import de.timesnake.basic.entities.wrapper.*;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEntityPose;
import de.timesnake.library.reflection.wrapper.ExEnumItemSlot;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FluidType;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ExEntity {

    protected final CraftEntity entity;


    public ExEntity(CraftEntity entity) {
        this.entity = entity;
    }

    public ExEntity(Entity entity) {
        this.entity = entity.getBukkitEntity();
    }

    public void setNMSField(String name, Object value) {
        RefUtil.setInstanceField(this.entity.getHandle(), name, value);
    }

    public void setNMSField(Class<? extends Entity> clazz, String name, Object value) {
        RefUtil.setInstanceField(clazz, this.entity.getHandle(), name, value);
    }

    public Object getNMSField(String name) {
        return RefUtil.getInstanceField(this.entity, name);
    }

    public Entity getNMS() {
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

    public void setCustomName(String name) {
        this.getNMS().a(new ChatComponentText(name));
    }

    public String getCustomName() {
        IChatBaseComponent name = this.getNMS().Z();
        if (name == null) {
            return null;
        }
        return name.a();
    }

    public void setCustomNameVisible(boolean flag) {
        this.getNMS().n(flag);
    }

    public boolean isCustomNameVisible() {
        return this.getNMS().cr();
    }

    public void setInvulnerable(boolean flag) {
        this.getNMS().m(flag);
    }

    public boolean isInvulnerable() {
        return this.getNMS().cg();
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

    public void setRemainingFireTicks(int ticks) {
        this.getNMS().g(ticks);
    }

    public int getRemainingFireTicks() {
        return this.getNMS().at();
    }

    public void clearFire() {
        this.setRemainingFireTicks(0);
    }

    public void setOnGround(boolean flag) {
        this.getNMS().c(flag);
    }

    public boolean isOnGround() {
        return this.getNMS().aw();
    }

    public void move(ExEntityMoveType moveType, double x, double y, double z) {
        this.getNMS().a(moveType.getNMSType(), new Vec3D(x, y, z));
    }

    public void setPosition(double x, double y, double z) {
        this.getNMS().o(x, y, z);
    }

    public double getX() {
        return this.entity.getLocation().getX();
    }

    public double getY() {
        return this.entity.getLocation().getY();
    }

    public double getZ() {
        return this.entity.getLocation().getZ();
    }

    public boolean isAlive() {
        return !this.entity.isDead();
    }

    public boolean isSilent() {
        return this.entity.getHandle().aL();
    }

    public void setSilent(boolean flag) {
        this.entity.getHandle().d(flag);
    }

    public boolean isNoGravity() {
        return this.entity.getHandle().aM();
    }

    public void setNoGravity(boolean flag) {
        this.entity.getHandle().e(flag);
    }

    public boolean isInWater() {
        return this.entity.getHandle().aQ();
    }

    public float getYaw() {
        return this.entity.getHandle().dm();
    }

    public void setYaw(float yaw) {
        this.entity.getHandle().o(yaw);
    }

    public float getPitch() {
        return this.entity.getHandle().dn();
    }

    public void setPitch(float pitch) {
        this.entity.getHandle().p(pitch);
    }

    public double distanceSquared(ExBlockPosition position) {
        return this.entity.getLocation().distanceSquared(new Location(this.entity.getWorld(), position.getX(), position.getY(), position.getZ()));
    }


    public double distanceSquared(double x, double y, double z) {
        return this.entity.getLocation().distanceSquared(new Location(this.entity.getWorld(), x, y, z));
    }

    public double distanceSquared(ExEntity entity) {
        return this.entity.getLocation().distanceSquared(entity.getLocation());
    }

    public double distanceSquared(Entity entity) {
        return this.entity.getLocation().distanceSquared(entity.getBukkitEntity().getLocation());
    }

    public Location getLocation() {
        return this.entity.getLocation();
    }

    public ExVec3D getPositionVector() {
        return new ExVec3D(this.getNMS().cV());
    }

    public Random getRandom() {
        return (Random) RefUtil.getInstanceField(this.getNMS(), "R");
    }

    public WorldServer getNMSWorld() {
        return ((CraftWorld) this.entity.getWorld()).getHandle();
    }

    public ExWorldServer getExWorld() {
        return new ExWorldServer(((CraftWorld) this.entity.getWorld()).getHandle());
    }

    public ExAxisAlignedBB getExBoundingBox() {
        return new ExAxisAlignedBB(this.getNMS().cx());
    }

    public int getTicksLived() {
        return this.getNMS().S;
    }

    public void playSound(SoundEffect soundEffect, float f, float f1) {
        this.getNMS().a(soundEffect, f, f1);
    }

    public float getWidth() {
        return this.getNMS().cT();
    }

    public float getHeight() {
        return this.getNMS().cU();
    }

    public boolean isInvisible() {
        return this.getNMS().bU();
    }

    public boolean isSpectator() {
        return this.getNMS().B_();
    }

    public boolean isPassenger() {
        return this.getNMS().bF();
    }

    public Entity getVehicle() {
        return this.getNMS().cN();
    }

    public boolean isVehicle() {
        return this.getNMS().bG();
    }

    public BlockPosition getChunkCoordinates() {
        return this.getNMS().cW();
    }

    public ExBlockPosition getExChunkCoordinates() {
        return new ExBlockPosition(this.getNMS().cW());
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

    public double b(Tag<FluidType> type) {
        return this.getNMS().b(type);
    }

    public double cx() {
        return this.getNMS().cS();
    }

    public boolean aQ() {
        return this.getNMS().aQ();
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


}
