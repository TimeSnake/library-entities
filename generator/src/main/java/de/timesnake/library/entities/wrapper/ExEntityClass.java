/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityAgeable;
import net.minecraft.world.entity.EntityAreaEffectCloud;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityExperienceOrb;
import net.minecraft.world.entity.EntityFlying;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLightning;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTameableAnimal;
import net.minecraft.world.entity.ambient.EntityAmbient;
import net.minecraft.world.entity.ambient.EntityBat;
import net.minecraft.world.entity.animal.EntityAnimal;
import net.minecraft.world.entity.animal.EntityBee;
import net.minecraft.world.entity.animal.EntityCat;
import net.minecraft.world.entity.animal.EntityChicken;
import net.minecraft.world.entity.animal.EntityCod;
import net.minecraft.world.entity.animal.EntityCow;
import net.minecraft.world.entity.animal.EntityDolphin;
import net.minecraft.world.entity.animal.EntityFish;
import net.minecraft.world.entity.animal.EntityFishSchool;
import net.minecraft.world.entity.animal.EntityFox;
import net.minecraft.world.entity.animal.EntityGolem;
import net.minecraft.world.entity.animal.EntityIronGolem;
import net.minecraft.world.entity.animal.EntityMushroomCow;
import net.minecraft.world.entity.animal.EntityOcelot;
import net.minecraft.world.entity.animal.EntityPanda;
import net.minecraft.world.entity.animal.EntityParrot;
import net.minecraft.world.entity.animal.EntityPerchable;
import net.minecraft.world.entity.animal.EntityPig;
import net.minecraft.world.entity.animal.EntityPolarBear;
import net.minecraft.world.entity.animal.EntityPufferFish;
import net.minecraft.world.entity.animal.EntityRabbit;
import net.minecraft.world.entity.animal.EntitySalmon;
import net.minecraft.world.entity.animal.EntitySheep;
import net.minecraft.world.entity.animal.EntitySnowman;
import net.minecraft.world.entity.animal.EntitySquid;
import net.minecraft.world.entity.animal.EntityTropicalFish;
import net.minecraft.world.entity.animal.EntityTurtle;
import net.minecraft.world.entity.animal.EntityWaterAnimal;
import net.minecraft.world.entity.animal.EntityWolf;
import net.minecraft.world.entity.animal.horse.EntityHorse;
import net.minecraft.world.entity.animal.horse.EntityHorseAbstract;
import net.minecraft.world.entity.animal.horse.EntityHorseChestedAbstract;
import net.minecraft.world.entity.animal.horse.EntityHorseDonkey;
import net.minecraft.world.entity.animal.horse.EntityHorseMule;
import net.minecraft.world.entity.animal.horse.EntityHorseSkeleton;
import net.minecraft.world.entity.animal.horse.EntityHorseZombie;
import net.minecraft.world.entity.animal.horse.EntityLlama;
import net.minecraft.world.entity.animal.horse.EntityLlamaTrader;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderCrystal;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;
import net.minecraft.world.entity.boss.wither.EntityWither;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import net.minecraft.world.entity.decoration.EntityHanging;
import net.minecraft.world.entity.decoration.EntityItemFrame;
import net.minecraft.world.entity.decoration.EntityLeash;
import net.minecraft.world.entity.decoration.EntityPainting;
import net.minecraft.world.entity.item.EntityFallingBlock;
import net.minecraft.world.entity.item.EntityItem;
import net.minecraft.world.entity.item.EntityTNTPrimed;
import net.minecraft.world.entity.monster.EntityBlaze;
import net.minecraft.world.entity.monster.EntityCaveSpider;
import net.minecraft.world.entity.monster.EntityCreeper;
import net.minecraft.world.entity.monster.EntityDrowned;
import net.minecraft.world.entity.monster.EntityEnderman;
import net.minecraft.world.entity.monster.EntityEndermite;
import net.minecraft.world.entity.monster.EntityEvoker;
import net.minecraft.world.entity.monster.EntityGhast;
import net.minecraft.world.entity.monster.EntityGiantZombie;
import net.minecraft.world.entity.monster.EntityGuardian;
import net.minecraft.world.entity.monster.EntityGuardianElder;
import net.minecraft.world.entity.monster.EntityIllagerAbstract;
import net.minecraft.world.entity.monster.EntityIllagerIllusioner;
import net.minecraft.world.entity.monster.EntityMagmaCube;
import net.minecraft.world.entity.monster.EntityMonster;
import net.minecraft.world.entity.monster.EntityMonsterPatrolling;
import net.minecraft.world.entity.monster.EntityPhantom;
import net.minecraft.world.entity.monster.EntityPigZombie;
import net.minecraft.world.entity.monster.EntityPillager;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityShulker;
import net.minecraft.world.entity.monster.EntitySilverfish;
import net.minecraft.world.entity.monster.EntitySkeleton;
import net.minecraft.world.entity.monster.EntitySkeletonAbstract;
import net.minecraft.world.entity.monster.EntitySkeletonStray;
import net.minecraft.world.entity.monster.EntitySkeletonWither;
import net.minecraft.world.entity.monster.EntitySlime;
import net.minecraft.world.entity.monster.EntitySpider;
import net.minecraft.world.entity.monster.EntityStrider;
import net.minecraft.world.entity.monster.EntityVex;
import net.minecraft.world.entity.monster.EntityVindicator;
import net.minecraft.world.entity.monster.EntityWitch;
import net.minecraft.world.entity.monster.EntityZoglin;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.entity.monster.EntityZombieHusk;
import net.minecraft.world.entity.monster.EntityZombieVillager;
import net.minecraft.world.entity.monster.hoglin.EntityHoglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglinAbstract;
import net.minecraft.world.entity.monster.piglin.EntityPiglinBrute;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import net.minecraft.world.entity.npc.EntityVillagerTrader;
import net.minecraft.world.entity.projectile.EntityArrow;
import net.minecraft.world.entity.projectile.EntityDragonFireball;
import net.minecraft.world.entity.projectile.EntityEgg;
import net.minecraft.world.entity.projectile.EntityEnderPearl;
import net.minecraft.world.entity.projectile.EntityEnderSignal;
import net.minecraft.world.entity.projectile.EntityEvokerFangs;
import net.minecraft.world.entity.projectile.EntityFireball;
import net.minecraft.world.entity.projectile.EntityFireworks;
import net.minecraft.world.entity.projectile.EntityFishingHook;
import net.minecraft.world.entity.projectile.EntityLargeFireball;
import net.minecraft.world.entity.projectile.EntityLlamaSpit;
import net.minecraft.world.entity.projectile.EntityPotion;
import net.minecraft.world.entity.projectile.EntityProjectile;
import net.minecraft.world.entity.projectile.EntityProjectileThrowable;
import net.minecraft.world.entity.projectile.EntityShulkerBullet;
import net.minecraft.world.entity.projectile.EntitySmallFireball;
import net.minecraft.world.entity.projectile.EntitySnowball;
import net.minecraft.world.entity.projectile.EntitySpectralArrow;
import net.minecraft.world.entity.projectile.EntityThrownExpBottle;
import net.minecraft.world.entity.projectile.EntityThrownTrident;
import net.minecraft.world.entity.projectile.EntityTippedArrow;
import net.minecraft.world.entity.projectile.EntityWitherSkull;
import net.minecraft.world.entity.raid.EntityRaider;
import net.minecraft.world.entity.vehicle.EntityBoat;
import net.minecraft.world.entity.vehicle.EntityMinecartAbstract;
import net.minecraft.world.entity.vehicle.EntityMinecartChest;
import net.minecraft.world.entity.vehicle.EntityMinecartCommandBlock;
import net.minecraft.world.entity.vehicle.EntityMinecartContainer;
import net.minecraft.world.entity.vehicle.EntityMinecartFurnace;
import net.minecraft.world.entity.vehicle.EntityMinecartHopper;
import net.minecraft.world.entity.vehicle.EntityMinecartMobSpawner;
import net.minecraft.world.entity.vehicle.EntityMinecartRideable;
import net.minecraft.world.entity.vehicle.EntityMinecartTNT;


public class ExEntityClass<Nms extends Entity> {

    public static final ExEntityClass<EntityAreaEffectCloud> EntityAreaEffectCloud =
            new ExEntityClass<>(EntityAreaEffectCloud.class);
    public static final ExEntityClass<EntityArmorStand> EntityArmorStand = new ExEntityClass<>(
            EntityArmorStand.class);
    public static final ExEntityClass<EntityTippedArrow> EntityTippedArrow =
            new ExEntityClass<>(EntityTippedArrow.class);
    public static final ExEntityClass<EntityBat> EntityBat = new ExEntityClass<>(EntityBat.class);
    public static final ExEntityClass<EntityBee> EntityBee = new ExEntityClass<>(EntityBee.class);
    public static final ExEntityClass<EntityBlaze> EntityBlaze = new ExEntityClass<>(
            EntityBlaze.class);
    public static final ExEntityClass<EntityBoat> EntityBoat = new ExEntityClass<>(
            EntityBoat.class);
    public static final ExEntityClass<EntityCat> EntityCat = new ExEntityClass<>(EntityCat.class);
    public static final ExEntityClass<EntityCaveSpider> EntityCaveSpider = new ExEntityClass<>(
            EntityCaveSpider.class);
    public static final ExEntityClass<EntityChicken> EntityChicken = new ExEntityClass<>(
            EntityChicken.class);
    public static final ExEntityClass<EntityCod> EntityCod = new ExEntityClass<>(EntityCod.class);
    public static final ExEntityClass<EntityCow> EntityCow = new ExEntityClass<>(EntityCow.class);
    public static final ExEntityClass<EntityCreeper> EntityCreeper = new ExEntityClass<>(
            EntityCreeper.class);
    public static final ExEntityClass<EntityDolphin> EntityDolphin = new ExEntityClass<>(
            EntityDolphin.class);
    public static final ExEntityClass<EntityHorseDonkey> EntityHorseDonkey =
            new ExEntityClass<>(EntityHorseDonkey.class);
    public static final ExEntityClass<EntityDragonFireball> EntityDragonFireball =
            new ExEntityClass<>(EntityDragonFireball.class);
    public static final ExEntityClass<EntityDrowned> EntityDrowned = new ExEntityClass<>(
            EntityDrowned.class);
    public static final ExEntityClass<EntityGuardianElder> EntityGuardianElder =
            new ExEntityClass<>(EntityGuardianElder.class);
    public static final ExEntityClass<EntityEnderCrystal> EntityEnderCrystal =
            new ExEntityClass<>(EntityEnderCrystal.class);
    public static final ExEntityClass<EntityEnderDragon> EntityEnderDragon =
            new ExEntityClass<>(EntityEnderDragon.class);
    public static final ExEntityClass<EntityEnderman> EntityEnderman = new ExEntityClass<>(
            EntityEnderman.class);
    public static final ExEntityClass<EntityEndermite> EntityEndermite = new ExEntityClass<>(
            EntityEndermite.class);
    public static final ExEntityClass<EntityEvoker> EntityEvoker = new ExEntityClass<>(
            EntityEvoker.class);
    public static final ExEntityClass<EntityEvokerFangs> EntityEvokerFangs =
            new ExEntityClass<>(EntityEvokerFangs.class);
    public static final ExEntityClass<EntityExperienceOrb> EntityExperienceOrb =
            new ExEntityClass<>(EntityExperienceOrb.class);
    public static final ExEntityClass<EntityEnderSignal> EntityEnderSignal =
            new ExEntityClass<>(EntityEnderSignal.class);
    public static final ExEntityClass<EntityFallingBlock> EntityFallingBlock =
            new ExEntityClass<>(EntityFallingBlock.class);
    public static final ExEntityClass<EntityFireworks> EntityFireworks = new ExEntityClass<>(
            EntityFireworks.class);
    public static final ExEntityClass<EntityFox> EntityFox = new ExEntityClass<>(EntityFox.class);
    public static final ExEntityClass<EntityGhast> EntityGhast = new ExEntityClass<>(
            EntityGhast.class);
    public static final ExEntityClass<EntityGiantZombie> EntityGiantZombie =
            new ExEntityClass<>(EntityGiantZombie.class);
    public static final ExEntityClass<EntityGuardian> EntityGuardian = new ExEntityClass<>(
            EntityGuardian.class);
    public static final ExEntityClass<EntityHoglin> EntityHoglin = new ExEntityClass<>(
            EntityHoglin.class);
    public static final ExEntityClass<EntityHorse> EntityHorse = new ExEntityClass<>(
            EntityHorse.class);
    public static final ExEntityClass<EntityZombieHusk> EntityZombieHusk = new ExEntityClass<>(
            EntityZombieHusk.class);
    public static final ExEntityClass<EntityIllagerIllusioner> EntityIllagerIllusioner =
            new ExEntityClass<>(EntityIllagerIllusioner.class);
    public static final ExEntityClass<EntityIronGolem> EntityIronGolem = new ExEntityClass<>(
            EntityIronGolem.class);
    public static final ExEntityClass<EntityItem> EntityItem = new ExEntityClass<>(
            EntityItem.class);
    public static final ExEntityClass<EntityItemFrame> EntityItemFrame = new ExEntityClass<>(
            EntityItemFrame.class);
    public static final ExEntityClass<EntityLargeFireball> EntityLargeFireball =
            new ExEntityClass<>(EntityLargeFireball.class);
    public static final ExEntityClass<EntityLeash> EntityLeash = new ExEntityClass<>(
            EntityLeash.class);
    public static final ExEntityClass<EntityLightning> EntityLightning = new ExEntityClass<>(
            EntityLightning.class);
    public static final ExEntityClass<EntityLlama> EntityLlama = new ExEntityClass<>(
            EntityLlama.class);
    public static final ExEntityClass<EntityLlamaSpit> EntityLlamaSpit = new ExEntityClass<>(
            EntityLlamaSpit.class);
    public static final ExEntityClass<EntityMagmaCube> EntityMagmaCube = new ExEntityClass<>(
            EntityMagmaCube.class);
    public static final ExEntityClass<EntityMinecartRideable> EntityMinecartRideable =
            new ExEntityClass<>(EntityMinecartRideable.class);
    public static final ExEntityClass<EntityMinecartChest> EntityMinecartChest =
            new ExEntityClass<>(EntityMinecartChest.class);
    public static final ExEntityClass<EntityMinecartCommandBlock> EntityMinecartCommandBlock =
            new ExEntityClass<>(EntityMinecartCommandBlock.class);
    public static final ExEntityClass<EntityMinecartFurnace> EntityMinecartFurnace =
            new ExEntityClass<>(EntityMinecartFurnace.class);
    public static final ExEntityClass<EntityMinecartHopper> EntityMinecartHopper =
            new ExEntityClass<>(EntityMinecartHopper.class);
    public static final ExEntityClass<EntityMinecartMobSpawner> EntityMinecartMobSpawner =
            new ExEntityClass<>(EntityMinecartMobSpawner.class);
    public static final ExEntityClass<EntityMinecartTNT> EntityMinecartTNT =
            new ExEntityClass<>(EntityMinecartTNT.class);
    public static final ExEntityClass<EntityHorseMule> EntityHorseMule = new ExEntityClass<>(
            EntityHorseMule.class);
    public static final ExEntityClass<EntityMushroomCow> EntityMushroomCow =
            new ExEntityClass<>(EntityMushroomCow.class);
    public static final ExEntityClass<EntityOcelot> EntityOcelot = new ExEntityClass<>(
            EntityOcelot.class);
    public static final ExEntityClass<EntityPainting> EntityPainting = new ExEntityClass<>(
            EntityPainting.class);
    public static final ExEntityClass<EntityPanda> EntityPanda = new ExEntityClass<>(
            EntityPanda.class);
    public static final ExEntityClass<EntityParrot> EntityParrot = new ExEntityClass<>(
            EntityParrot.class);
    public static final ExEntityClass<EntityPhantom> EntityPhantom = new ExEntityClass<>(
            EntityPhantom.class);
    public static final ExEntityClass<EntityPig> EntityPig = new ExEntityClass<>(EntityPig.class);
    public static final ExEntityClass<EntityPiglin> EntityPiglin = new ExEntityClass<>(
            EntityPiglin.class);
    public static final ExEntityClass<EntityPiglinBrute> EntityPiglinBrute =
            new ExEntityClass<>(EntityPiglinBrute.class);
    public static final ExEntityClass<EntityPillager> EntityPillager = new ExEntityClass<>(
            EntityPillager.class);
    public static final ExEntityClass<EntityPolarBear> EntityPolarBear = new ExEntityClass<>(
            EntityPolarBear.class);
    public static final ExEntityClass<EntityTNTPrimed> EntityTNTPrimed = new ExEntityClass<>(
            EntityTNTPrimed.class);
    public static final ExEntityClass<EntityPufferFish> EntityPufferFish = new ExEntityClass<>(
            EntityPufferFish.class);
    public static final ExEntityClass<EntityRabbit> EntityRabbit = new ExEntityClass<>(
            EntityRabbit.class);
    public static final ExEntityClass<EntityRavager> EntityRavager = new ExEntityClass<>(
            EntityRavager.class);
    public static final ExEntityClass<EntitySalmon> EntitySalmon = new ExEntityClass<>(
            EntitySalmon.class);
    public static final ExEntityClass<EntitySheep> EntitySheep = new ExEntityClass<>(
            EntitySheep.class);
    public static final ExEntityClass<EntityShulker> EntityShulker = new ExEntityClass<>(
            EntityShulker.class);
    public static final ExEntityClass<EntityShulkerBullet> EntityShulkerBullet =
            new ExEntityClass<>(EntityShulkerBullet.class);
    public static final ExEntityClass<EntitySilverfish> EntitySilverfish = new ExEntityClass<>(
            EntitySilverfish.class);
    public static final ExEntityClass<EntitySkeleton> EntitySkeleton = new ExEntityClass<>(
            EntitySkeleton.class);
    public static final ExEntityClass<EntityHorseSkeleton> EntityHorseSkeleton =
            new ExEntityClass<>(EntityHorseSkeleton.class);
    public static final ExEntityClass<EntitySlime> EntitySlime = new ExEntityClass<>(
            EntitySlime.class);
    public static final ExEntityClass<EntitySmallFireball> EntitySmallFireball =
            new ExEntityClass<>(EntitySmallFireball.class);
    public static final ExEntityClass<EntitySnowman> EntitySnowman = new ExEntityClass<>(
            EntitySnowman.class);
    public static final ExEntityClass<EntitySnowball> EntitySnowball = new ExEntityClass<>(
            EntitySnowball.class);
    public static final ExEntityClass<EntitySpectralArrow> EntitySpectralArrow =
            new ExEntityClass<>(EntitySpectralArrow.class);
    public static final ExEntityClass<EntitySpider> EntitySpider = new ExEntityClass<>(
            EntitySpider.class);
    public static final ExEntityClass<EntitySquid> EntitySquid = new ExEntityClass<>(
            EntitySquid.class);
    public static final ExEntityClass<EntitySkeletonStray> EntitySkeletonStray =
            new ExEntityClass<>(EntitySkeletonStray.class);
    public static final ExEntityClass<EntityStrider> EntityStrider = new ExEntityClass<>(
            EntityStrider.class);
    public static final ExEntityClass<EntityEgg> EntityEgg = new ExEntityClass<>(EntityEgg.class);
    public static final ExEntityClass<EntityEnderPearl> EntityEnderPearl = new ExEntityClass<>(
            EntityEnderPearl.class);
    public static final ExEntityClass<EntityThrownExpBottle> EntityThrownExpBottle =
            new ExEntityClass<>(EntityThrownExpBottle.class);
    public static final ExEntityClass<EntityPotion> EntityPotion = new ExEntityClass<>(
            EntityPotion.class);
    public static final ExEntityClass<EntityThrownTrident> EntityThrownTrident =
            new ExEntityClass<>(EntityThrownTrident.class);
    public static final ExEntityClass<EntityLlamaTrader> EntityLlamaTrader =
            new ExEntityClass<>(EntityLlamaTrader.class);
    public static final ExEntityClass<EntityTropicalFish> EntityTropicalFish =
            new ExEntityClass<>(EntityTropicalFish.class);
    public static final ExEntityClass<EntityTurtle> EntityTurtle = new ExEntityClass<>(
            EntityTurtle.class);
    public static final ExEntityClass<EntityVex> EntityEntityEntityVex = new ExEntityClass<>(
            EntityVex.class);
    public static final ExEntityClass<EntityVillager> EntityEntityEntityVillager =
            new ExEntityClass<>(EntityVillager.class);
    public static final ExEntityClass<EntityVindicator> EntityEntityEntityVindicator =
            new ExEntityClass<>(EntityVindicator.class);
    public static final ExEntityClass<EntityVillagerTrader> EntityVillagerTrader =
            new ExEntityClass<>(EntityVillagerTrader.class);
    public static final ExEntityClass<EntityWitch> EntityEntityEntityWitch = new ExEntityClass<>(
            EntityWitch.class);
    public static final ExEntityClass<EntityWither> EntityWither = new ExEntityClass<>(
            EntityWither.class);
    public static final ExEntityClass<EntitySkeletonWither> EntitySkeletonWither =
            new ExEntityClass<>(EntitySkeletonWither.class);
    public static final ExEntityClass<EntityWitherSkull> EntityWitherSkull =
            new ExEntityClass<>(EntityWitherSkull.class);
    public static final ExEntityClass<EntityWolf> EntityEntityEntityWolf = new ExEntityClass<>(
            EntityWolf.class);
    public static final ExEntityClass<EntityZoglin> EntityZoglin = new ExEntityClass<>(
            EntityZoglin.class);
    public static final ExEntityClass<EntityZombie> EntityEntityEntityZombie = new ExEntityClass<>(
            EntityZombie.class);
    public static final ExEntityClass<EntityHorseZombie> EntityHorseZombie =
            new ExEntityClass<>(EntityHorseZombie.class);
    public static final ExEntityClass<EntityZombieVillager> EntityZombieVillager =
            new ExEntityClass<>(EntityZombieVillager.class);
    public static final ExEntityClass<EntityPigZombie> EntityPigZombie = new ExEntityClass<>(
            EntityPigZombie.class);
    public static final ExEntityClass<EntityPlayer> EntityPlayer = new ExEntityClass<>(
            EntityPlayer.class);
    public static final ExEntityClass<EntityFishingHook> EntityFishingHook =
            new ExEntityClass<>(EntityFishingHook.class);
    public static final ExEntityClass<Entity> Entity = new ExEntityClass<>(Entity.class);
    public static final ExEntityClass<EntityAgeable> EntityAgeable = new ExEntityClass<>(
            EntityAgeable.class);
    public static final ExEntityClass<EntityAmbient> EntityAmbient = new ExEntityClass<>(
            EntityAmbient.class);
    public static final ExEntityClass<EntityCreature> EntityCreature = new ExEntityClass<>(
            EntityCreature.class);
    public static final ExEntityClass<EntityFlying> EntityFlying = new ExEntityClass<>(
            EntityFlying.class);
    public static final ExEntityClass<EntityInsentient> EntityMob = new ExEntityClass<>(
            EntityInsentient.class);
    public static final ExEntityClass<EntityLiving> EntityLivingEntity = new ExEntityClass<>(
            EntityLiving.class);
    public static final ExEntityClass<EntityAnimal> EntityAnimal = new ExEntityClass<>(
            EntityAnimal.class);
    public static final ExEntityClass<EntityPerchable> EntityPerchable = new ExEntityClass<>(
            EntityPerchable.class);
    public static final ExEntityClass<EntityTameableAnimal> EntityTameableAnimal =
            new ExEntityClass<>(EntityTameableAnimal.class);
    public static final ExEntityClass<EntityGolem> EntityGolem = new ExEntityClass<>(
            EntityGolem.class);
    public static final ExEntityClass<EntityHanging> EntityHanging = new ExEntityClass<>(
            EntityHanging.class);
    public static final ExEntityClass<EntityHorseAbstract> EntityHorseAbstract =
            new ExEntityClass<>(EntityHorseAbstract.class);
    public static final ExEntityClass<EntityHorseChestedAbstract> EntityHorseChestedAbstract =
            new ExEntityClass<>(EntityHorseChestedAbstract.class);
    public static final ExEntityClass<EntityMinecartAbstract> EntityMinecartAbstract =
            new ExEntityClass<>(EntityMinecartAbstract.class);
    public static final ExEntityClass<EntityMinecartContainer> EntityMinecartContainer =
            new ExEntityClass<>(EntityMinecartContainer.class);
    public static final ExEntityClass<EntityIllagerAbstract> EntityIllagerAbstract =
            new ExEntityClass<>(EntityIllagerAbstract.class);
    public static final ExEntityClass<EntityMonsterPatrolling> EntityMonsterPatrolling =
            new ExEntityClass<>(EntityMonsterPatrolling.class);
    public static final ExEntityClass<EntityPiglinAbstract> EntityPiglinAbstract =
            new ExEntityClass<>(EntityPiglinAbstract.class);
    public static final ExEntityClass<EntityRaider> EntityRaider = new ExEntityClass<>(
            EntityRaider.class);
    public static final ExEntityClass<EntitySkeletonAbstract> EntitySkeletonAbstract =
            new ExEntityClass<>(EntitySkeletonAbstract.class);
    public static final ExEntityClass<EntityArrow> EntityArrow = new ExEntityClass<>(
            EntityArrow.class);
    public static final ExEntityClass<EntityFireball> EntityFireball = new ExEntityClass<>(
            EntityFireball.class);
    public static final ExEntityClass<EntityProjectile> EntityProjectile = new ExEntityClass<>(
            EntityProjectile.class);
    public static final ExEntityClass<EntityProjectileThrowable> EntityProjectileThrowable =
            new ExEntityClass<>(EntityProjectileThrowable.class);
    public static final ExEntityClass<EntityVillagerAbstract> EntityVillagerAbstract =
            new ExEntityClass<>(EntityVillagerAbstract.class);
    public static final ExEntityClass<EntityFish> EntityFish = new ExEntityClass<>(
            EntityFish.class);
    public static final ExEntityClass<EntityFishSchool> EntityFishSchool = new ExEntityClass<>(
            EntityFishSchool.class);
    public static final ExEntityClass<EntityWaterAnimal> EntityWaterAnimal =
            new ExEntityClass<>(EntityWaterAnimal.class);
    public static final ExEntityClass<EntityMonster> EntityMonster = new ExEntityClass<>(
            EntityMonster.class);

    private final Class<Nms> nms;

    public ExEntityClass(Class<Nms> nms) {
        this.nms = nms;
    }

    public Class<Nms> getNms() {
        return nms;
    }
}
