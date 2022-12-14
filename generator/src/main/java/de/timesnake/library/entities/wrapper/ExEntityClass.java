/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.EntityAmbient;
import net.minecraft.world.entity.ambient.EntityBat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderCrystal;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;
import net.minecraft.world.entity.boss.wither.EntityWither;
import net.minecraft.world.entity.decoration.*;
import net.minecraft.world.entity.item.EntityFallingBlock;
import net.minecraft.world.entity.item.EntityItem;
import net.minecraft.world.entity.item.EntityTNTPrimed;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.hoglin.EntityHoglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglin;
import net.minecraft.world.entity.monster.piglin.EntityPiglinAbstract;
import net.minecraft.world.entity.monster.piglin.EntityPiglinBrute;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import net.minecraft.world.entity.npc.EntityVillagerTrader;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.raid.EntityRaider;
import net.minecraft.world.entity.vehicle.*;


public class ExEntityClass<Nms extends Entity> {

    public static final ExEntityClass<EntityAreaEffectCloud> EntityAreaEffectCloud =
            new ExEntityClass<>(EntityAreaEffectCloud.class);
    public static final ExEntityClass<EntityArmorStand> EntityArmorStand = new ExEntityClass<>(EntityArmorStand.class);
    public static final ExEntityClass<EntityTippedArrow> EntityTippedArrow =
            new ExEntityClass<>(EntityTippedArrow.class);
    public static final ExEntityClass<EntityBat> EntityBat = new ExEntityClass<>(EntityBat.class);
    public static final ExEntityClass<EntityBee> EntityBee = new ExEntityClass<>(EntityBee.class);
    public static final ExEntityClass<EntityBlaze> EntityBlaze = new ExEntityClass<>(EntityBlaze.class);
    public static final ExEntityClass<EntityBoat> EntityBoat = new ExEntityClass<>(EntityBoat.class);
    public static final ExEntityClass<EntityCat> EntityCat = new ExEntityClass<>(EntityCat.class);
    public static final ExEntityClass<EntityCaveSpider> EntityCaveSpider = new ExEntityClass<>(EntityCaveSpider.class);
    public static final ExEntityClass<EntityChicken> EntityChicken = new ExEntityClass<>(EntityChicken.class);
    public static final ExEntityClass<EntityCod> EntityCod = new ExEntityClass<>(EntityCod.class);
    public static final ExEntityClass<EntityCow> EntityCow = new ExEntityClass<>(EntityCow.class);
    public static final ExEntityClass<EntityCreeper> EntityCreeper = new ExEntityClass<>(EntityCreeper.class);
    public static final ExEntityClass<EntityDolphin> EntityDolphin = new ExEntityClass<>(EntityDolphin.class);
    public static final ExEntityClass<EntityHorseDonkey> EntityHorseDonkey =
            new ExEntityClass<>(EntityHorseDonkey.class);
    public static final ExEntityClass<EntityDragonFireball> EntityDragonFireball =
            new ExEntityClass<>(EntityDragonFireball.class);
    public static final ExEntityClass<EntityDrowned> EntityDrowned = new ExEntityClass<>(EntityDrowned.class);
    public static final ExEntityClass<EntityGuardianElder> EntityGuardianElder =
            new ExEntityClass<>(EntityGuardianElder.class);
    public static final ExEntityClass<EntityEnderCrystal> EntityEnderCrystal =
            new ExEntityClass<>(EntityEnderCrystal.class);
    public static final ExEntityClass<EntityEnderDragon> EntityEnderDragon =
            new ExEntityClass<>(EntityEnderDragon.class);
    public static final ExEntityClass<EntityEnderman> EntityEnderman = new ExEntityClass<>(EntityEnderman.class);
    public static final ExEntityClass<EntityEndermite> EntityEndermite = new ExEntityClass<>(EntityEndermite.class);
    public static final ExEntityClass<EntityEvoker> EntityEvoker = new ExEntityClass<>(EntityEvoker.class);
    public static final ExEntityClass<EntityEvokerFangs> EntityEvokerFangs =
            new ExEntityClass<>(EntityEvokerFangs.class);
    public static final ExEntityClass<EntityExperienceOrb> EntityExperienceOrb =
            new ExEntityClass<>(EntityExperienceOrb.class);
    public static final ExEntityClass<EntityEnderSignal> EntityEnderSignal =
            new ExEntityClass<>(EntityEnderSignal.class);
    public static final ExEntityClass<EntityFallingBlock> EntityFallingBlock =
            new ExEntityClass<>(EntityFallingBlock.class);
    public static final ExEntityClass<EntityFireworks> EntityFireworks = new ExEntityClass<>(EntityFireworks.class);
    public static final ExEntityClass<EntityFox> EntityFox = new ExEntityClass<>(EntityFox.class);
    public static final ExEntityClass<EntityGhast> EntityGhast = new ExEntityClass<>(EntityGhast.class);
    public static final ExEntityClass<EntityGiantZombie> EntityGiantZombie =
            new ExEntityClass<>(EntityGiantZombie.class);
    public static final ExEntityClass<EntityGuardian> EntityGuardian = new ExEntityClass<>(EntityGuardian.class);
    public static final ExEntityClass<EntityHoglin> EntityHoglin = new ExEntityClass<>(EntityHoglin.class);
    public static final ExEntityClass<EntityHorse> EntityHorse = new ExEntityClass<>(EntityHorse.class);
    public static final ExEntityClass<EntityZombieHusk> EntityZombieHusk = new ExEntityClass<>(EntityZombieHusk.class);
    public static final ExEntityClass<EntityIllagerIllusioner> EntityIllagerIllusioner =
            new ExEntityClass<>(EntityIllagerIllusioner.class);
    public static final ExEntityClass<EntityIronGolem> EntityIronGolem = new ExEntityClass<>(EntityIronGolem.class);
    public static final ExEntityClass<EntityItem> EntityItem = new ExEntityClass<>(EntityItem.class);
    public static final ExEntityClass<EntityItemFrame> EntityItemFrame = new ExEntityClass<>(EntityItemFrame.class);
    public static final ExEntityClass<EntityLargeFireball> EntityLargeFireball =
            new ExEntityClass<>(EntityLargeFireball.class);
    public static final ExEntityClass<EntityLeash> EntityLeash = new ExEntityClass<>(EntityLeash.class);
    public static final ExEntityClass<EntityLightning> EntityLightning = new ExEntityClass<>(EntityLightning.class);
    public static final ExEntityClass<EntityLlama> EntityLlama = new ExEntityClass<>(EntityLlama.class);
    public static final ExEntityClass<EntityLlamaSpit> EntityLlamaSpit = new ExEntityClass<>(EntityLlamaSpit.class);
    public static final ExEntityClass<EntityMagmaCube> EntityMagmaCube = new ExEntityClass<>(EntityMagmaCube.class);
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
    public static final ExEntityClass<EntityHorseMule> EntityHorseMule = new ExEntityClass<>(EntityHorseMule.class);
    public static final ExEntityClass<EntityMushroomCow> EntityMushroomCow =
            new ExEntityClass<>(EntityMushroomCow.class);
    public static final ExEntityClass<EntityOcelot> EntityOcelot = new ExEntityClass<>(EntityOcelot.class);
    public static final ExEntityClass<EntityPainting> EntityPainting = new ExEntityClass<>(EntityPainting.class);
    public static final ExEntityClass<EntityPanda> EntityPanda = new ExEntityClass<>(EntityPanda.class);
    public static final ExEntityClass<EntityParrot> EntityParrot = new ExEntityClass<>(EntityParrot.class);
    public static final ExEntityClass<EntityPhantom> EntityPhantom = new ExEntityClass<>(EntityPhantom.class);
    public static final ExEntityClass<EntityPig> EntityPig = new ExEntityClass<>(EntityPig.class);
    public static final ExEntityClass<EntityPiglin> EntityPiglin = new ExEntityClass<>(EntityPiglin.class);
    public static final ExEntityClass<EntityPiglinBrute> EntityPiglinBrute =
            new ExEntityClass<>(EntityPiglinBrute.class);
    public static final ExEntityClass<EntityPillager> EntityPillager = new ExEntityClass<>(EntityPillager.class);
    public static final ExEntityClass<EntityPolarBear> EntityPolarBear = new ExEntityClass<>(EntityPolarBear.class);
    public static final ExEntityClass<EntityTNTPrimed> EntityTNTPrimed = new ExEntityClass<>(EntityTNTPrimed.class);
    public static final ExEntityClass<EntityPufferFish> EntityPufferFish = new ExEntityClass<>(EntityPufferFish.class);
    public static final ExEntityClass<EntityRabbit> EntityRabbit = new ExEntityClass<>(EntityRabbit.class);
    public static final ExEntityClass<EntityRavager> EntityRavager = new ExEntityClass<>(EntityRavager.class);
    public static final ExEntityClass<EntitySalmon> EntitySalmon = new ExEntityClass<>(EntitySalmon.class);
    public static final ExEntityClass<EntitySheep> EntitySheep = new ExEntityClass<>(EntitySheep.class);
    public static final ExEntityClass<EntityShulker> EntityShulker = new ExEntityClass<>(EntityShulker.class);
    public static final ExEntityClass<EntityShulkerBullet> EntityShulkerBullet =
            new ExEntityClass<>(EntityShulkerBullet.class);
    public static final ExEntityClass<EntitySilverfish> EntitySilverfish = new ExEntityClass<>(EntitySilverfish.class);
    public static final ExEntityClass<EntitySkeleton> EntitySkeleton = new ExEntityClass<>(EntitySkeleton.class);
    public static final ExEntityClass<EntityHorseSkeleton> EntityHorseSkeleton =
            new ExEntityClass<>(EntityHorseSkeleton.class);
    public static final ExEntityClass<EntitySlime> EntitySlime = new ExEntityClass<>(EntitySlime.class);
    public static final ExEntityClass<EntitySmallFireball> EntitySmallFireball =
            new ExEntityClass<>(EntitySmallFireball.class);
    public static final ExEntityClass<EntitySnowman> EntitySnowman = new ExEntityClass<>(EntitySnowman.class);
    public static final ExEntityClass<EntitySnowball> EntitySnowball = new ExEntityClass<>(EntitySnowball.class);
    public static final ExEntityClass<EntitySpectralArrow> EntitySpectralArrow =
            new ExEntityClass<>(EntitySpectralArrow.class);
    public static final ExEntityClass<EntitySpider> EntitySpider = new ExEntityClass<>(EntitySpider.class);
    public static final ExEntityClass<EntitySquid> EntitySquid = new ExEntityClass<>(EntitySquid.class);
    public static final ExEntityClass<EntitySkeletonStray> EntitySkeletonStray =
            new ExEntityClass<>(EntitySkeletonStray.class);
    public static final ExEntityClass<EntityStrider> EntityStrider = new ExEntityClass<>(EntityStrider.class);
    public static final ExEntityClass<EntityEgg> EntityEgg = new ExEntityClass<>(EntityEgg.class);
    public static final ExEntityClass<EntityEnderPearl> EntityEnderPearl = new ExEntityClass<>(EntityEnderPearl.class);
    public static final ExEntityClass<EntityThrownExpBottle> EntityThrownExpBottle =
            new ExEntityClass<>(EntityThrownExpBottle.class);
    public static final ExEntityClass<EntityPotion> EntityPotion = new ExEntityClass<>(EntityPotion.class);
    public static final ExEntityClass<EntityThrownTrident> EntityThrownTrident =
            new ExEntityClass<>(EntityThrownTrident.class);
    public static final ExEntityClass<EntityLlamaTrader> EntityLlamaTrader =
            new ExEntityClass<>(EntityLlamaTrader.class);
    public static final ExEntityClass<EntityTropicalFish> EntityTropicalFish =
            new ExEntityClass<>(EntityTropicalFish.class);
    public static final ExEntityClass<EntityTurtle> EntityTurtle = new ExEntityClass<>(EntityTurtle.class);
    public static final ExEntityClass<EntityVex> EntityEntityEntityVex = new ExEntityClass<>(EntityVex.class);
    public static final ExEntityClass<EntityVillager> EntityEntityEntityVillager =
            new ExEntityClass<>(EntityVillager.class);
    public static final ExEntityClass<EntityVindicator> EntityEntityEntityVindicator =
            new ExEntityClass<>(EntityVindicator.class);
    public static final ExEntityClass<EntityVillagerTrader> EntityVillagerTrader =
            new ExEntityClass<>(EntityVillagerTrader.class);
    public static final ExEntityClass<EntityWitch> EntityEntityEntityWitch = new ExEntityClass<>(EntityWitch.class);
    public static final ExEntityClass<EntityWither> EntityWither = new ExEntityClass<>(EntityWither.class);
    public static final ExEntityClass<EntitySkeletonWither> EntitySkeletonWither =
            new ExEntityClass<>(EntitySkeletonWither.class);
    public static final ExEntityClass<EntityWitherSkull> EntityWitherSkull =
            new ExEntityClass<>(EntityWitherSkull.class);
    public static final ExEntityClass<EntityWolf> EntityEntityEntityWolf = new ExEntityClass<>(EntityWolf.class);
    public static final ExEntityClass<EntityZoglin> EntityZoglin = new ExEntityClass<>(EntityZoglin.class);
    public static final ExEntityClass<EntityZombie> EntityEntityEntityZombie = new ExEntityClass<>(EntityZombie.class);
    public static final ExEntityClass<EntityHorseZombie> EntityHorseZombie =
            new ExEntityClass<>(EntityHorseZombie.class);
    public static final ExEntityClass<EntityZombieVillager> EntityZombieVillager =
            new ExEntityClass<>(EntityZombieVillager.class);
    public static final ExEntityClass<EntityPigZombie> EntityPigZombie = new ExEntityClass<>(EntityPigZombie.class);
    public static final ExEntityClass<EntityPlayer> EntityPlayer = new ExEntityClass<>(EntityPlayer.class);
    public static final ExEntityClass<EntityFishingHook> EntityFishingHook =
            new ExEntityClass<>(EntityFishingHook.class);
    public static final ExEntityClass<Entity> Entity = new ExEntityClass<>(Entity.class);
    public static final ExEntityClass<EntityAgeable> EntityAgeable = new ExEntityClass<>(EntityAgeable.class);
    public static final ExEntityClass<EntityAmbient> EntityAmbient = new ExEntityClass<>(EntityAmbient.class);
    public static final ExEntityClass<EntityCreature> EntityCreature = new ExEntityClass<>(EntityCreature.class);
    public static final ExEntityClass<EntityFlying> EntityFlying = new ExEntityClass<>(EntityFlying.class);
    public static final ExEntityClass<EntityInsentient> EntityMob = new ExEntityClass<>(EntityInsentient.class);
    public static final ExEntityClass<EntityLiving> EntityLivingEntity = new ExEntityClass<>(EntityLiving.class);
    public static final ExEntityClass<EntityAnimal> EntityAnimal = new ExEntityClass<>(EntityAnimal.class);
    public static final ExEntityClass<EntityPerchable> EntityPerchable = new ExEntityClass<>(EntityPerchable.class);
    public static final ExEntityClass<EntityTameableAnimal> EntityTameableAnimal =
            new ExEntityClass<>(EntityTameableAnimal.class);
    public static final ExEntityClass<EntityGolem> EntityGolem = new ExEntityClass<>(EntityGolem.class);
    public static final ExEntityClass<EntityHanging> EntityHanging = new ExEntityClass<>(EntityHanging.class);
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
    public static final ExEntityClass<EntityRaider> EntityRaider = new ExEntityClass<>(EntityRaider.class);
    public static final ExEntityClass<EntitySkeletonAbstract> EntitySkeletonAbstract =
            new ExEntityClass<>(EntitySkeletonAbstract.class);
    public static final ExEntityClass<EntityArrow> EntityArrow = new ExEntityClass<>(EntityArrow.class);
    public static final ExEntityClass<EntityFireball> EntityFireball = new ExEntityClass<>(EntityFireball.class);
    public static final ExEntityClass<EntityProjectile> EntityProjectile = new ExEntityClass<>(EntityProjectile.class);
    public static final ExEntityClass<EntityProjectileThrowable> EntityProjectileThrowable =
            new ExEntityClass<>(EntityProjectileThrowable.class);
    public static final ExEntityClass<EntityVillagerAbstract> EntityVillagerAbstract =
            new ExEntityClass<>(EntityVillagerAbstract.class);
    public static final ExEntityClass<EntityFish> EntityFish = new ExEntityClass<>(EntityFish.class);
    public static final ExEntityClass<EntityFishSchool> EntityFishSchool = new ExEntityClass<>(EntityFishSchool.class);
    public static final ExEntityClass<EntityWaterAnimal> EntityWaterAnimal =
            new ExEntityClass<>(EntityWaterAnimal.class);
    public static final ExEntityClass<EntityMonster> EntityMonster = new ExEntityClass<>(EntityMonster.class);

    private final Class<Nms> nms;

    public ExEntityClass(Class<Nms> nms) {
        this.nms = nms;
    }

    public Class<Nms> getNms() {
        return nms;
    }
}
