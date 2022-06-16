package de.timesnake.library.entities.entity.bukkit;

import de.timesnake.library.entities.entity.extension.EntityExtension;
import de.timesnake.library.entities.entity.extension.ExEntitySkeletonAbstract;
import net.minecraft.world.entity.monster.EntitySkeletonWither;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.entities.wrapper.*;
import de.timesnake.library.reflection.wrapper.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

import net.minecraft.world.entity.EntityTypes;

import java.util.*;

@NmsReflection
public class ExWitherSkeleton extends org.bukkit.craftbukkit.v1_18_R2.entity.CraftWitherSkeleton implements EntityExtension<ExEntitySkeletonAbstract> {

    private final ExEntitySkeletonAbstract extension = new ExEntitySkeletonAbstract(this);

    public ExWitherSkeleton(World world, boolean loadDefaultPathfinders) {
        super(((CraftServer) Bukkit.getServer()), new net.minecraft.world.entity.monster.EntitySkeletonWither(EntityTypes.ba,
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinders) {
                    super.u();
                }
            }
        });
    }

    public ExEntitySkeletonAbstract getExtension() {
        return extension;
    }

    // delegation to ExEntitySkeletonAbstract

    public net.minecraft.world.entity.EntityInsentient getNMS() {
        return this.extension.getNMS();
    }

    public void addPathfinderGoal(int arg0, de.timesnake.library.entities.pathfinder.ExPathfinderGoal arg1) {
         this.extension.addPathfinderGoal(arg0, arg1);
    }

    public void addPathfinderGoal(de.timesnake.library.entities.pathfinder.ExPathfinderGoal arg0) {
         this.extension.addPathfinderGoal(arg0);
    }

    public boolean c(net.minecraft.world.entity.EntityLiving arg0) {
        return this.extension.c(arg0);
    }

    public void a(de.timesnake.library.entities.wrapper.ExPathType arg0, float arg1) {
         this.extension.a(arg0, arg1);
    }

    public float a(de.timesnake.library.entities.wrapper.ExPathType arg0) {
        return this.extension.a(arg0);
    }

    public float a(net.minecraft.world.level.pathfinder.PathType arg0) {
        return this.extension.a(arg0);
    }

    public void a(net.minecraft.world.level.pathfinder.PathType arg0, float arg1) {
         this.extension.a(arg0, arg1);
    }

    public void setTarget(de.timesnake.library.entities.entity.extension.ExEntityLiving arg0) {
         this.extension.setTarget(arg0);
    }

    public void setTarget(net.minecraft.world.entity.EntityLiving arg0, org.bukkit.event.entity.EntityTargetEvent.TargetReason arg1, boolean arg2) {
         this.extension.setTarget(arg0, arg1, arg2);
    }

    public void setTarget(net.minecraft.world.entity.EntityLiving arg0) {
         this.extension.setTarget(arg0);
    }

    public int O() {
        return this.extension.O();
    }

    public int Q() {
        return this.extension.Q();
    }

    public int ep() {
        return this.extension.ep();
    }

    public net.minecraft.world.entity.ai.goal.PathfinderGoalSelector getGoalSelector() {
        return this.extension.getGoalSelector();
    }

    public net.minecraft.world.entity.ai.goal.PathfinderGoalSelector getTargetSelector() {
        return this.extension.getTargetSelector();
    }

    public net.minecraft.world.entity.EntityLiving getNMSTarget() {
        return this.extension.getNMSTarget();
    }

    public void removePathfinderGoal(de.timesnake.library.entities.pathfinder.ExPathfinderGoal arg0) {
         this.extension.removePathfinderGoal(arg0);
    }

    public void clearPathfinderGoals() {
         this.extension.clearPathfinderGoals();
    }

    public de.timesnake.library.entities.entity.extension.ExEntityLiving getExTarget() {
        return this.extension.getExTarget();
    }

    public void clearGoalTargets() {
         this.extension.clearGoalTargets();
    }

    public de.timesnake.library.entities.wrapper.ExPathEntity calcPath(double arg0, double arg1, double arg2, int arg3) {
        return this.extension.calcPath(arg0, arg1, arg2, arg3);
    }

    public de.timesnake.library.entities.wrapper.ExNavigationAbstract getNavigation() {
        return this.extension.getNavigation();
    }

    public de.timesnake.library.entities.wrapper.ExControllerLook getControllerLook() {
        return this.extension.getControllerLook();
    }

    public de.timesnake.library.entities.wrapper.ExControllerJump getControllerJump() {
        return this.extension.getControllerJump();
    }

    public de.timesnake.library.entities.wrapper.ExControllerMove getControllerMove() {
        return this.extension.getControllerMove();
    }

    public de.timesnake.library.entities.wrapper.ExEntitySenses getEntitySenses() {
        return this.extension.getEntitySenses();
    }

    public boolean isNoAI() {
        return this.extension.isNoAI();
    }

    public void setNoAI(boolean arg0) {
         this.extension.setNoAI(arg0);
    }

    public boolean isLeftHanded() {
        return this.extension.isLeftHanded();
    }

    public void setLeftHanded(boolean arg0) {
         this.extension.setLeftHanded(arg0);
    }

    public boolean isAggressive() {
        return this.extension.isAggressive();
    }

    public void setAggressive(boolean arg0) {
         this.extension.setAggressive(arg0);
    }

    public boolean isNmsLeashed() {
        return this.extension.isNmsLeashed();
    }

    public boolean a(net.minecraft.world.entity.EntityLiving arg0, net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition arg1) {
        return this.extension.a(arg0, arg1);
    }

    public void setMaxHealth(float arg0) {
         this.extension.setMaxHealth(arg0);
    }

    public org.bukkit.attribute.AttributeInstance getBukkitAttribute(org.bukkit.attribute.Attribute arg0) {
        return this.extension.getBukkitAttribute(arg0);
    }

    public void setDeathLoot(java.util.Collection<org.bukkit.inventory.ItemStack> arg0) {
         this.extension.setDeathLoot(arg0);
    }

    public void addDeathLoot(java.util.Collection<org.bukkit.inventory.ItemStack> arg0) {
         this.extension.addDeathLoot(arg0);
    }

    public java.util.List<org.bukkit.inventory.ItemStack> getDeathLoot() {
        return this.extension.getDeathLoot();
    }

    public int getMaxNoDamageTicks() {
        return this.extension.getMaxNoDamageTicks();
    }

    public void setMaxNoDamageTicks(int arg0) {
         this.extension.setMaxNoDamageTicks(arg0);
    }

    public void swingHand(de.timesnake.library.reflection.wrapper.ExEnumHand arg0) {
         this.extension.swingHand(arg0);
    }

    public net.minecraft.world.entity.EntityLiving getLastDamager() {
        return this.extension.getLastDamager();
    }

    public de.timesnake.library.entities.entity.extension.ExEntityLiving getExLastDamager() {
        return this.extension.getExLastDamager();
    }

    public int getHurtTimestamp() {
        return this.extension.getHurtTimestamp();
    }

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