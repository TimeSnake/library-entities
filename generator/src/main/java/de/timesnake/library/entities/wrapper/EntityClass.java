package de.timesnake.library.entities.wrapper;

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
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.raid.EntityRaider;
import net.minecraft.world.entity.vehicle.*;

public class EntityClass<E extends Entity> {

    public static final EntityClass<EntityAreaEffectCloud> EntityAreaEffectCloud =
            new EntityClass<>(EntityAreaEffectCloud.class);
    public static final EntityClass<EntityArmorStand> EntityArmorStand = new EntityClass<>(EntityArmorStand.class);
    public static final EntityClass<EntityTippedArrow> EntityTippedArrow = new EntityClass<>(EntityTippedArrow.class);
    public static final EntityClass<EntityBat> EntityBat = new EntityClass<>(EntityBat.class);
    public static final EntityClass<EntityBee> EntityBee = new EntityClass<>(EntityBee.class);
    public static final EntityClass<EntityBlaze> EntityBlaze = new EntityClass<>(EntityBlaze.class);
    public static final EntityClass<EntityBoat> EntityBoat = new EntityClass<>(EntityBoat.class);
    public static final EntityClass<EntityCat> EntityCat = new EntityClass<>(EntityCat.class);
    public static final EntityClass<EntityCaveSpider> EntityCaveSpider = new EntityClass<>(EntityCaveSpider.class);
    public static final EntityClass<EntityChicken> EntityChicken = new EntityClass<>(EntityChicken.class);
    public static final EntityClass<EntityCod> EntityCod = new EntityClass<>(EntityCod.class);
    public static final EntityClass<EntityCow> EntityCow = new EntityClass<>(EntityCow.class);
    public static final EntityClass<EntityCreeper> EntityCreeper = new EntityClass<>(EntityCreeper.class);
    public static final EntityClass<EntityDolphin> EntityDolphin = new EntityClass<>(EntityDolphin.class);
    public static final EntityClass<EntityHorseDonkey> EntityHorseDonkey = new EntityClass<>(EntityHorseDonkey.class);
    public static final EntityClass<EntityDragonFireball> EntityDragonFireball =
            new EntityClass<>(EntityDragonFireball.class);
    public static final EntityClass<EntityDrowned> EntityDrowned = new EntityClass<>(EntityDrowned.class);
    public static final EntityClass<EntityGuardianElder> EntityGuardianElder =
            new EntityClass<>(EntityGuardianElder.class);
    public static final EntityClass<EntityEnderCrystal> EntityEnderCrystal =
            new EntityClass<>(EntityEnderCrystal.class);
    public static final EntityClass<EntityEnderDragon> EntityEnderDragon = new EntityClass<>(EntityEnderDragon.class);
    public static final EntityClass<EntityEnderman> EntityEnderman = new EntityClass<>(EntityEnderman.class);
    public static final EntityClass<EntityEndermite> EntityEndermite = new EntityClass<>(EntityEndermite.class);
    public static final EntityClass<EntityEvoker> EntityEvoker = new EntityClass<>(EntityEvoker.class);
    public static final EntityClass<EntityEvokerFangs> EntityEvokerFangs = new EntityClass<>(EntityEvokerFangs.class);
    public static final EntityClass<EntityExperienceOrb> EntityExperienceOrb =
            new EntityClass<>(EntityExperienceOrb.class);
    public static final EntityClass<EntityEnderSignal> EntityEnderSignal = new EntityClass<>(EntityEnderSignal.class);
    public static final EntityClass<EntityFallingBlock> EntityFallingBlock =
            new EntityClass<>(EntityFallingBlock.class);
    public static final EntityClass<EntityFireworks> EntityFireworks = new EntityClass<>(EntityFireworks.class);
    public static final EntityClass<EntityFox> EntityFox = new EntityClass<>(EntityFox.class);
    public static final EntityClass<EntityGhast> EntityGhast = new EntityClass<>(EntityGhast.class);
    public static final EntityClass<EntityGiantZombie> EntityGiantZombie = new EntityClass<>(EntityGiantZombie.class);
    public static final EntityClass<EntityGuardian> EntityGuardian = new EntityClass<>(EntityGuardian.class);
    public static final EntityClass<EntityHoglin> EntityHoglin = new EntityClass<>(EntityHoglin.class);
    public static final EntityClass<EntityHorse> EntityHorse = new EntityClass<>(EntityHorse.class);
    public static final EntityClass<EntityZombieHusk> EntityZombieHusk = new EntityClass<>(EntityZombieHusk.class);
    public static final EntityClass<EntityIllagerIllusioner> EntityIllagerIllusioner =
            new EntityClass<>(EntityIllagerIllusioner.class);
    public static final EntityClass<EntityIronGolem> EntityIronGolem = new EntityClass<>(EntityIronGolem.class);
    public static final EntityClass<EntityItem> EntityItem = new EntityClass<>(EntityItem.class);
    public static final EntityClass<EntityItemFrame> EntityItemFrame = new EntityClass<>(EntityItemFrame.class);
    public static final EntityClass<EntityLargeFireball> EntityLargeFireball =
            new EntityClass<>(EntityLargeFireball.class);
    public static final EntityClass<EntityLeash> EntityLeash = new EntityClass<>(EntityLeash.class);
    public static final EntityClass<EntityLightning> EntityLightning = new EntityClass<>(EntityLightning.class);
    public static final EntityClass<EntityLlama> EntityLlama = new EntityClass<>(EntityLlama.class);
    public static final EntityClass<EntityLlamaSpit> EntityLlamaSpit = new EntityClass<>(EntityLlamaSpit.class);
    public static final EntityClass<EntityMagmaCube> EntityMagmaCube = new EntityClass<>(EntityMagmaCube.class);
    public static final EntityClass<EntityMinecartRideable> EntityMinecartRideable =
            new EntityClass<>(EntityMinecartRideable.class);
    public static final EntityClass<EntityMinecartChest> EntityMinecartChest =
            new EntityClass<>(EntityMinecartChest.class);
    public static final EntityClass<EntityMinecartCommandBlock> EntityMinecartCommandBlock =
            new EntityClass<>(EntityMinecartCommandBlock.class);
    public static final EntityClass<EntityMinecartFurnace> EntityMinecartFurnace =
            new EntityClass<>(EntityMinecartFurnace.class);
    public static final EntityClass<EntityMinecartHopper> EntityMinecartHopper =
            new EntityClass<>(EntityMinecartHopper.class);
    public static final EntityClass<EntityMinecartMobSpawner> EntityMinecartMobSpawner =
            new EntityClass<>(EntityMinecartMobSpawner.class);
    public static final EntityClass<EntityMinecartTNT> EntityMinecartTNT = new EntityClass<>(EntityMinecartTNT.class);
    public static final EntityClass<EntityHorseMule> EntityHorseMule = new EntityClass<>(EntityHorseMule.class);
    public static final EntityClass<EntityMushroomCow> EntityMushroomCow = new EntityClass<>(EntityMushroomCow.class);
    public static final EntityClass<EntityOcelot> EntityOcelot = new EntityClass<>(EntityOcelot.class);
    public static final EntityClass<EntityPainting> EntityPainting = new EntityClass<>(EntityPainting.class);
    public static final EntityClass<EntityPanda> EntityPanda = new EntityClass<>(EntityPanda.class);
    public static final EntityClass<EntityParrot> EntityParrot = new EntityClass<>(EntityParrot.class);
    public static final EntityClass<EntityPhantom> EntityPhantom = new EntityClass<>(EntityPhantom.class);
    public static final EntityClass<EntityPig> EntityPig = new EntityClass<>(EntityPig.class);
    public static final EntityClass<EntityPiglin> EntityPiglin = new EntityClass<>(EntityPiglin.class);
    public static final EntityClass<EntityPiglinBrute> EntityPiglinBrute = new EntityClass<>(EntityPiglinBrute.class);
    public static final EntityClass<EntityPillager> EntityPillager = new EntityClass<>(EntityPillager.class);
    public static final EntityClass<EntityPolarBear> EntityPolarBear = new EntityClass<>(EntityPolarBear.class);
    public static final EntityClass<EntityTNTPrimed> EntityTNTPrimed = new EntityClass<>(EntityTNTPrimed.class);
    public static final EntityClass<EntityPufferFish> EntityPufferFish = new EntityClass<>(EntityPufferFish.class);
    public static final EntityClass<EntityRabbit> EntityRabbit = new EntityClass<>(EntityRabbit.class);
    public static final EntityClass<EntityRavager> EntityRavager = new EntityClass<>(EntityRavager.class);
    public static final EntityClass<EntitySalmon> EntitySalmon = new EntityClass<>(EntitySalmon.class);
    public static final EntityClass<EntitySheep> EntitySheep = new EntityClass<>(EntitySheep.class);
    public static final EntityClass<EntityShulker> EntityShulker = new EntityClass<>(EntityShulker.class);
    public static final EntityClass<EntityShulkerBullet> EntityShulkerBullet =
            new EntityClass<>(EntityShulkerBullet.class);
    public static final EntityClass<EntitySilverfish> EntitySilverfish = new EntityClass<>(EntitySilverfish.class);
    public static final EntityClass<EntitySkeleton> EntitySkeleton = new EntityClass<>(EntitySkeleton.class);
    public static final EntityClass<EntityHorseSkeleton> EntityHorseSkeleton =
            new EntityClass<>(EntityHorseSkeleton.class);
    public static final EntityClass<EntitySlime> EntitySlime = new EntityClass<>(EntitySlime.class);
    public static final EntityClass<EntitySmallFireball> EntitySmallFireball =
            new EntityClass<>(EntitySmallFireball.class);
    public static final EntityClass<EntitySnowman> EntitySnowman = new EntityClass<>(EntitySnowman.class);
    public static final EntityClass<EntitySnowball> EntitySnowball = new EntityClass<>(EntitySnowball.class);
    public static final EntityClass<EntitySpectralArrow> EntitySpectralArrow =
            new EntityClass<>(EntitySpectralArrow.class);
    public static final EntityClass<EntitySpider> EntitySpider = new EntityClass<>(EntitySpider.class);
    public static final EntityClass<EntitySquid> EntitySquid = new EntityClass<>(EntitySquid.class);
    public static final EntityClass<EntitySkeletonStray> EntitySkeletonStray =
            new EntityClass<>(EntitySkeletonStray.class);
    public static final EntityClass<EntityStrider> EntityStrider = new EntityClass<>(EntityStrider.class);
    public static final EntityClass<EntityEgg> EntityEgg = new EntityClass<>(EntityEgg.class);
    public static final EntityClass<EntityEnderPearl> EntityEnderPearl = new EntityClass<>(EntityEnderPearl.class);
    public static final EntityClass<EntityThrownExpBottle> EntityThrownExpBottle =
            new EntityClass<>(EntityThrownExpBottle.class);
    public static final EntityClass<EntityPotion> EntityPotion = new EntityClass<>(EntityPotion.class);
    public static final EntityClass<EntityThrownTrident> EntityThrownTrident =
            new EntityClass<>(EntityThrownTrident.class);
    public static final EntityClass<EntityLlamaTrader> EntityLlamaTrader = new EntityClass<>(EntityLlamaTrader.class);
    public static final EntityClass<EntityTropicalFish> EntityTropicalFish =
            new EntityClass<>(EntityTropicalFish.class);
    public static final EntityClass<EntityTurtle> EntityTurtle = new EntityClass<>(EntityTurtle.class);
    public static final EntityClass<EntityVex> EntityVex = new EntityClass<>(EntityVex.class);
    public static final EntityClass<EntityVillager> EntityVillager = new EntityClass<>(EntityVillager.class);
    public static final EntityClass<EntityVindicator> EntityVindicator = new EntityClass<>(EntityVindicator.class);
    public static final EntityClass<EntityVillagerTrader> EntityVillagerTrader =
            new EntityClass<>(EntityVillagerTrader.class);
    public static final EntityClass<EntityWitch> EntityWitch = new EntityClass<>(EntityWitch.class);
    public static final EntityClass<EntityWither> EntityWither = new EntityClass<>(EntityWither.class);
    public static final EntityClass<EntitySkeletonWither> EntitySkeletonWither =
            new EntityClass<>(EntitySkeletonWither.class);
    public static final EntityClass<EntityWitherSkull> EntityWitherSkull = new EntityClass<>(EntityWitherSkull.class);
    public static final EntityClass<EntityWolf> EntityWolf = new EntityClass<>(EntityWolf.class);
    public static final EntityClass<EntityZoglin> EntityZoglin = new EntityClass<>(EntityZoglin.class);
    public static final EntityClass<EntityZombie> EntityZombie = new EntityClass<>(EntityZombie.class);
    public static final EntityClass<EntityHorseZombie> EntityHorseZombie = new EntityClass<>(EntityHorseZombie.class);
    public static final EntityClass<EntityZombieVillager> EntityZombieVillager =
            new EntityClass<>(EntityZombieVillager.class);
    public static final EntityClass<EntityPigZombie> EntityPigZombie = new EntityClass<>(EntityPigZombie.class);
    public static final EntityClass<EntityHuman> EntityHuman = new EntityClass<>(EntityHuman.class);
    public static final EntityClass<EntityFishingHook> EntityFishingHook = new EntityClass<>(EntityFishingHook.class);
    public static final EntityClass<Entity> Entity = new EntityClass<>(Entity.class);
    public static final EntityClass<EntityAgeable> EntityAgeable = new EntityClass<>(EntityAgeable.class);
    public static final EntityClass<EntityAmbient> EntityAmbient = new EntityClass<>(EntityAmbient.class);
    public static final EntityClass<EntityCreature> EntityCreature = new EntityClass<>(EntityCreature.class);
    public static final EntityClass<EntityFlying> EntityFlying = new EntityClass<>(EntityFlying.class);
    public static final EntityClass<EntityInsentient> EntityInsentient = new EntityClass<>(EntityInsentient.class);
    public static final EntityClass<EntityLiving> EntityLiving = new EntityClass<>(EntityLiving.class);
    public static final EntityClass<EntityAnimal> EntityAnimal = new EntityClass<>(EntityAnimal.class);
    public static final EntityClass<EntityPerchable> EntityPerchable = new EntityClass<>(EntityPerchable.class);
    public static final EntityClass<EntityTameableAnimal> EntityTameableAnimal =
            new EntityClass<>(EntityTameableAnimal.class);
    public static final EntityClass<EntityGolem> EntityGolem = new EntityClass<>(EntityGolem.class);
    public static final EntityClass<EntityHanging> EntityHanging = new EntityClass<>(EntityHanging.class);
    public static final EntityClass<EntityHorseAbstract> EntityHorseAbstract =
            new EntityClass<>(EntityHorseAbstract.class);
    public static final EntityClass<EntityHorseChestedAbstract> EntityHorseChestedAbstract =
            new EntityClass<>(EntityHorseChestedAbstract.class);
    public static final EntityClass<EntityMinecartAbstract> EntityMinecartAbstract =
            new EntityClass<>(EntityMinecartAbstract.class);
    public static final EntityClass<EntityMinecartContainer> EntityMinecartContainer =
            new EntityClass<>(EntityMinecartContainer.class);
    public static final EntityClass<EntityIllagerAbstract> EntityIllagerAbstract =
            new EntityClass<>(EntityIllagerAbstract.class);
    public static final EntityClass<EntityMonsterPatrolling> EntityMonsterPatrolling =
            new EntityClass<>(EntityMonsterPatrolling.class);
    public static final EntityClass<EntityPiglinAbstract> EntityPiglinAbstract =
            new EntityClass<>(EntityPiglinAbstract.class);
    public static final EntityClass<EntityRaider> EntityRaider = new EntityClass<>(EntityRaider.class);
    public static final EntityClass<EntitySkeletonAbstract> EntitySkeletonAbstract =
            new EntityClass<>(EntitySkeletonAbstract.class);
    public static final EntityClass<EntityArrow> EntityArrow = new EntityClass<>(EntityArrow.class);
    public static final EntityClass<EntityFireball> EntityFireball = new EntityClass<>(EntityFireball.class);
    public static final EntityClass<EntityProjectile> EntityProjectile = new EntityClass<>(EntityProjectile.class);
    public static final EntityClass<EntityProjectileThrowable> EntityProjectileThrowable =
            new EntityClass<>(EntityProjectileThrowable.class);
    public static final EntityClass<IProjectile> IProjectile = new EntityClass<>(IProjectile.class);
    public static final EntityClass<EntityVillagerAbstract> EntityVillagerAbstract =
            new EntityClass<>(EntityVillagerAbstract.class);
    public static final EntityClass<EntityFish> EntityFish = new EntityClass<>(EntityFish.class);
    public static final EntityClass<EntityFishSchool> EntityFishSchool = new EntityClass<>(EntityFishSchool.class);
    public static final EntityClass<EntityWaterAnimal> EntityWaterAnimal = new EntityClass<>(EntityWaterAnimal.class);
    public static final EntityClass<EntityMonster> EntityMonster = new EntityClass<>(EntityMonster.class);


    private final Class<E> entityClass;

    EntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<E> getNMSClass() {
        return this.entityClass;
    }

}
