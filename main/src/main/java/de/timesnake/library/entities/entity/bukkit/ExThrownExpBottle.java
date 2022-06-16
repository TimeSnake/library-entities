package de.timesnake.library.entities.entity.bukkit;

import de.timesnake.library.entities.entity.extension.EntityExtension;
import de.timesnake.library.entities.entity.extension.ExIProjectile;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityTypes;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

@NmsReflection
public class ExThrownExpBottle extends org.bukkit.craftbukkit.v1_18_R2.entity.CraftThrownExpBottle implements EntityExtension<ExIProjectile> {

    private final ExIProjectile extension = new ExIProjectile(this);

    public ExThrownExpBottle(World world) {
        super(((CraftServer) Bukkit.getServer()), new net.minecraft.world.entity.projectile.EntityThrownExpBottle(EntityTypes.aO, ((CraftWorld) world).getHandle()));
    }

    public ExIProjectile getExtension() {
        return extension;
    }

    // delegation to ExIProjectile

    public double b(net.minecraft.tags.TagKey<net.minecraft.world.level.material.FluidType> arg0) {
        return this.extension.b(arg0);
    }

    public double e(double arg0) {
        return this.extension.e(arg0);
    }

    public boolean isAlive() {
        return this.extension.isAlive();
    }

    public int getId() {
        return this.extension.getId();
    }

    public void move(de.timesnake.library.entities.wrapper.ExEntityMoveType arg0, double arg1, double arg2, double arg3) {
         this.extension.move(arg0, arg1, arg2, arg3);
    }

    public double cx() {
        return this.extension.cx();
    }

    public org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity getBukkitEntity() {
        return this.extension.getBukkitEntity();
    }

    public boolean isInvulnerable(de.timesnake.library.entities.wrapper.ExDamageSource arg0) {
        return this.extension.isInvulnerable(arg0);
    }

    public boolean aQ() {
        return this.extension.aQ();
    }

    public net.minecraft.world.entity.Entity getNMS() {
        return this.extension.getNMS();
    }

    public void setSecondsOnFire(int arg0, boolean arg1) {
         this.extension.setSecondsOnFire(arg0, arg1);
    }

    public void setSecondsOnFire(int arg0) {
         this.extension.setSecondsOnFire(arg0);
    }

    public void setYaw(float arg0) {
         this.extension.setYaw(arg0);
    }

    public void setPitch(float arg0) {
         this.extension.setPitch(arg0);
    }

    public double getX() {
        return this.extension.getX();
    }

    public double getY() {
        return this.extension.getY();
    }

    public double getZ() {
        return this.extension.getZ();
    }

    public float getYaw() {
        return this.extension.getYaw();
    }

    public float getPitch() {
        return this.extension.getPitch();
    }

    public boolean isInvisible() {
        return this.extension.isInvisible();
    }

    public double distanceSquared(de.timesnake.library.entities.entity.extension.ExEntity arg0) {
        return this.extension.distanceSquared(arg0);
    }

    public double distanceSquared(double arg0, double arg1, double arg2) {
        return this.extension.distanceSquared(arg0, arg1, arg2);
    }

    public double distanceSquared(net.minecraft.world.entity.Entity arg0) {
        return this.extension.distanceSquared(arg0);
    }

    public double distanceSquared(de.timesnake.library.reflection.wrapper.ExBlockPosition arg0) {
        return this.extension.distanceSquared(arg0);
    }

    public void playSound(net.minecraft.sounds.SoundEffect arg0, float arg1, float arg2) {
         this.extension.playSound(arg0, arg1, arg2);
    }

    public void setRemainingFireTicks(int arg0) {
         this.extension.setRemainingFireTicks(arg0);
    }

    public void setPositionRotation(de.timesnake.library.reflection.wrapper.ExBlockPosition arg0, float arg1, float arg2) {
         this.extension.setPositionRotation(arg0, arg1, arg2);
    }

    public void setPositionRotation(double arg0, double arg1, double arg2, float arg3, float arg4) {
         this.extension.setPositionRotation(arg0, arg1, arg2, arg3, arg4);
    }

    public void setNMSField(java.lang.String arg0, java.lang.Object arg1) {
         this.extension.setNMSField(arg0, arg1);
    }

    public void setNMSField(java.lang.Class<? extends net.minecraft.world.entity.Entity> arg0, java.lang.String arg1, java.lang.Object arg2) {
         this.extension.setNMSField(arg0, arg1, arg2);
    }

    public java.lang.Object getNMSField(java.lang.String arg0) {
        return this.extension.getNMSField(arg0);
    }

    public void kill() {
         this.extension.kill();
    }

    public int getRemainingFireTicks() {
        return this.extension.getRemainingFireTicks();
    }

    public void clearFire() {
         this.extension.clearFire();
    }

    public void setOnGround(boolean arg0) {
         this.extension.setOnGround(arg0);
    }

    public void setPosition(double arg0, double arg1, double arg2, boolean arg3) {
         this.extension.setPosition(arg0, arg1, arg2, arg3);
    }

    public void setPosition(double arg0, double arg1, double arg2) {
         this.extension.setPosition(arg0, arg1, arg2);
    }

    public boolean isNoGravity() {
        return this.extension.isNoGravity();
    }

    public void setNoGravity(boolean arg0) {
         this.extension.setNoGravity(arg0);
    }

    public de.timesnake.library.entities.wrapper.ExVec3D getPositionVector() {
        return this.extension.getPositionVector();
    }

    public java.util.Random getRandom() {
        return this.extension.getRandom();
    }

    public net.minecraft.server.level.WorldServer getNMSWorld() {
        return this.extension.getNMSWorld();
    }

    public de.timesnake.library.entities.wrapper.ExWorldServer getExWorld() {
        return this.extension.getExWorld();
    }

    public de.timesnake.library.entities.wrapper.ExAxisAlignedBB getExBoundingBox() {
        return this.extension.getExBoundingBox();
    }

    public boolean isSpectator() {
        return this.extension.isSpectator();
    }

    public boolean isPassenger() {
        return this.extension.isPassenger();
    }

    public boolean isVehicle() {
        return this.extension.isVehicle();
    }

    public net.minecraft.core.BlockPosition getChunkCoordinates() {
        return this.extension.getChunkCoordinates();
    }

    public de.timesnake.library.reflection.wrapper.ExBlockPosition getExChunkCoordinates() {
        return this.extension.getExChunkCoordinates();
    }

    public void setSlot(de.timesnake.library.reflection.wrapper.ExEnumItemSlot arg0, org.bukkit.inventory.ItemStack arg1) {
         this.extension.setSlot(arg0, arg1);
    }

    public void setPose(de.timesnake.library.reflection.wrapper.ExEntityPose arg0) {
         this.extension.setPose(arg0);
    }

    public net.minecraft.network.syncher.DataWatcher getDataWatcher() {
        return this.extension.getDataWatcher();
    }

}