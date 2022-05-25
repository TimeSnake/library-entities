package de.timesnake.basic.entities.entity.bukkit;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.entities.entity.extension.ExEntityAgeable;
import de.timesnake.basic.entities.entity.extension.ExEntityAnimal;
import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.basic.entities.wrapper.*;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEntityPose;
import de.timesnake.library.reflection.wrapper.ExEnumHand;
import de.timesnake.library.reflection.wrapper.ExEnumItemSlot;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalSelector;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.animal.EntityAnimal;
import net.minecraft.world.entity.animal.EntityBee;
import net.minecraft.world.level.material.FluidType;
import net.minecraft.world.level.pathfinder.PathType;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftBee;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@NmsReflection
public class ExBee extends CraftBee {

    private final ExEntityAnimal extension = new ExEntityAnimal(this);

    public ExBee(World world, boolean loadDefaultPathfinders) {
        super(((CraftServer) Bukkit.getServer()), new EntityBee(ExEntityType.BEE.getNMSType(),
                ((CraftWorld) world).getHandle()) {
            @Override
            protected void u() {
                if (loadDefaultPathfinders) {
                    super.u();
                }
            }
        });
    }

    public ExEntityAnimal getExtension() {
        return extension;
    }

    // delegated


    public void setNMSField(String name, Object value) {
        getExtension().setNMSField(name, value);
    }

    public void setNMSField(Class<? extends Entity> clazz, String name, Object value) {
        getExtension().setNMSField(clazz, name, value);
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

    public int getRemainingFireTicks() {
        return getExtension().getRemainingFireTicks();
    }

    public void setRemainingFireTicks(int ticks) {
        getExtension().setRemainingFireTicks(ticks);
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

    public double distanceSquared(ExBlockPosition position) {
        return getExtension().distanceSquared(position);
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

    public ExAxisAlignedBB getExBoundingBox() {
        return getExtension().getExBoundingBox();
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

    public void createChild(ExEntityAgeable entity) {
        getExtension().createChild(entity);
    }

    public void setBaby(boolean flag) {
        getExtension().setBaby(flag);
    }

    public EntityAnimal getNMS() {
        return getExtension().getNMS();
    }

    public void setLoveTicks(int i) {
        getExtension().setLoveTicks(i);
    }

    public boolean isInLove() {
        return getExtension().isInLove();
    }

    public void resetLove() {
        getExtension().resetLove();
    }

    public boolean mate(ExEntityAnimal entity) {
        return getExtension().mate(entity);
    }

    public void makeLove(WorldServer worldServer, ExEntityAnimal entity) {
        getExtension().makeLove(worldServer, entity);
    }

    public void makeLove(WorldServer worldServer, EntityAnimal entity) {
        getExtension().makeLove(worldServer, entity);
    }

    public PathfinderGoalSelector getGoalSelector() {
        return getExtension().getGoalSelector();
    }

    public PathfinderGoalSelector getTargetSelector() {
        return getExtension().getTargetSelector();
    }

    public void addPathfinderGoal(ExPathfinderGoal pathfinderGoal) {
        getExtension().addPathfinderGoal(pathfinderGoal);
    }

    public void addPathfinderGoal(int priority, ExPathfinderGoal pathfinderGoal) {
        getExtension().addPathfinderGoal(priority, pathfinderGoal);
    }

    public void removePathfinderGoal(ExPathfinderGoal pathfinderGoal) {
        getExtension().removePathfinderGoal(pathfinderGoal);
    }

    public void clearPathfinderGoals() {
        getExtension().clearPathfinderGoals();
    }

    public void setTarget(ExEntityLiving target) {
        getExtension().setTarget(target);
    }

    public void setTarget(EntityLiving target) {
        getExtension().setTarget(target);
    }

    public void setTarget(EntityLiving entityliving, EntityTargetEvent.TargetReason reason, boolean fireEvent) {
        getExtension().setTarget(entityliving, reason, fireEvent);
    }

    public ExEntityLiving getExTarget() {
        return getExtension().getExTarget();
    }

    public EntityLiving getNMSTarget() {
        return getExtension().getNMSTarget();
    }

    public void clearGoalTargets() {
        getExtension().clearGoalTargets();
    }

    public ExPathEntity calcPath(double x, double y, double z, int minDistance) {
        return getExtension().calcPath(x, y, z, minDistance);
    }

    public ExNavigationAbstract getNavigation() {
        return getExtension().getNavigation();
    }

    public ExControllerLook getControllerLook() {
        return getExtension().getControllerLook();
    }

    public ExControllerJump getControllerJump() {
        return getExtension().getControllerJump();
    }

    public ExControllerMove getControllerMove() {
        return getExtension().getControllerMove();
    }

    public ExEntitySenses getEntitySenses() {
        return getExtension().getEntitySenses();
    }

    public boolean isNoAI() {
        return getExtension().isNoAI();
    }

    public void setNoAI(boolean flag) {
        getExtension().setNoAI(flag);
    }

    public boolean isLeftHanded() {
        return getExtension().isLeftHanded();
    }

    public void setLeftHanded(boolean flag) {
        getExtension().setLeftHanded(flag);
    }

    public boolean isAggressive() {
        return getExtension().isAggressive();
    }

    public void setAggressive(boolean flag) {
        getExtension().setAggressive(flag);
    }

    public boolean isNmsLeashed() {
        return getExtension().isNmsLeashed();
    }

    public int O() {
        return getExtension().O();
    }

    public int Q() {
        return getExtension().Q();
    }

    public int ep() {
        return getExtension().ep();
    }

    public float a(PathType pathType) {
        return getExtension().a(pathType);
    }

    public void a(PathType pathType, float f) {
        getExtension().a(pathType, f);
    }

    public float a(ExPathType pathType) {
        return getExtension().a(pathType);
    }

    public void a(ExPathType pathType, float f) {
        getExtension().a(pathType, f);
    }

    public boolean c(EntityLiving entity) {
        return getExtension().c(entity);
    }

    public void setMaxHealth(float maxHealth) {
        getExtension().setMaxHealth(maxHealth);
    }

    public AttributeInstance getBukkitAttribute(Attribute attribute) {
        return getExtension().getBukkitAttribute(attribute);
    }

    public void addDeathLoot(Collection<ItemStack> items) {
        getExtension().addDeathLoot(items);
    }

    public List<ItemStack> getDeathLoot() {
        return getExtension().getDeathLoot();
    }

    public void setDeathLoot(Collection<ItemStack> items) {
        getExtension().setDeathLoot(items);
    }

    public int getMaxNoDamageTicks() {
        return getExtension().getMaxNoDamageTicks();
    }

    public void setMaxNoDamageTicks(int ticks) {
        getExtension().setMaxNoDamageTicks(ticks);
    }

    public void swingHand(ExEnumHand hand) {
        getExtension().swingHand(hand);
    }

    public boolean a(EntityLiving entity, PathfinderTargetCondition condition) {
        return getExtension().a(entity, condition);
    }

    public EntityLiving getLastDamager() {
        return getExtension().getLastDamager();
    }

    public ExEntityLiving getExLastDamager() {
        return getExtension().getExLastDamager();
    }

    public int getHurtTimestamp() {
        return getExtension().getHurtTimestamp();
    }
}
