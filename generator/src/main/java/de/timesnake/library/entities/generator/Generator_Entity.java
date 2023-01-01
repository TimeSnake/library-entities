/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.generator;

import java.util.LinkedList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityAreaEffectCloud;
import net.minecraft.world.entity.EntityExperienceOrb;
import net.minecraft.world.entity.EntityLightning;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.Marker;
import net.minecraft.world.entity.ambient.EntityBat;
import net.minecraft.world.entity.animal.EntityBee;
import net.minecraft.world.entity.animal.EntityCat;
import net.minecraft.world.entity.animal.EntityChicken;
import net.minecraft.world.entity.animal.EntityCod;
import net.minecraft.world.entity.animal.EntityCow;
import net.minecraft.world.entity.animal.EntityDolphin;
import net.minecraft.world.entity.animal.EntityFox;
import net.minecraft.world.entity.animal.EntityIronGolem;
import net.minecraft.world.entity.animal.EntityMushroomCow;
import net.minecraft.world.entity.animal.EntityOcelot;
import net.minecraft.world.entity.animal.EntityPanda;
import net.minecraft.world.entity.animal.EntityParrot;
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
import net.minecraft.world.entity.animal.EntityWolf;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.EntityHorse;
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
import net.minecraft.world.entity.decoration.EntityItemFrame;
import net.minecraft.world.entity.decoration.EntityLeash;
import net.minecraft.world.entity.decoration.EntityPainting;
import net.minecraft.world.entity.decoration.GlowItemFrame;
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
import net.minecraft.world.entity.monster.EntityIllagerIllusioner;
import net.minecraft.world.entity.monster.EntityMagmaCube;
import net.minecraft.world.entity.monster.EntityPhantom;
import net.minecraft.world.entity.monster.EntityPigZombie;
import net.minecraft.world.entity.monster.EntityPillager;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityShulker;
import net.minecraft.world.entity.monster.EntitySilverfish;
import net.minecraft.world.entity.monster.EntitySkeleton;
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
import net.minecraft.world.entity.monster.piglin.EntityPiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.EntityVillagerTrader;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.entity.projectile.EntityDragonFireball;
import net.minecraft.world.entity.projectile.EntityEgg;
import net.minecraft.world.entity.projectile.EntityEnderPearl;
import net.minecraft.world.entity.projectile.EntityEnderSignal;
import net.minecraft.world.entity.projectile.EntityEvokerFangs;
import net.minecraft.world.entity.projectile.EntityFireworks;
import net.minecraft.world.entity.projectile.EntityFishingHook;
import net.minecraft.world.entity.projectile.EntityLargeFireball;
import net.minecraft.world.entity.projectile.EntityLlamaSpit;
import net.minecraft.world.entity.projectile.EntityPotion;
import net.minecraft.world.entity.projectile.EntityShulkerBullet;
import net.minecraft.world.entity.projectile.EntitySmallFireball;
import net.minecraft.world.entity.projectile.EntitySnowball;
import net.minecraft.world.entity.projectile.EntitySpectralArrow;
import net.minecraft.world.entity.projectile.EntityThrownExpBottle;
import net.minecraft.world.entity.projectile.EntityThrownTrident;
import net.minecraft.world.entity.projectile.EntityTippedArrow;
import net.minecraft.world.entity.projectile.EntityWitherSkull;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.EntityBoat;
import net.minecraft.world.entity.vehicle.EntityMinecartRideable;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAllay;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAreaEffectCloud;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAxolotl;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftBat;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftBee;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftBoat;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftCat;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftCaveSpider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftChestBoat;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftChicken;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftCod;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftCow;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftDolphin;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftDonkey;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftDragonFireball;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftDrowned;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEgg;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftElderGuardian;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEnderCrystal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEnderPearl;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEnderSignal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEnderman;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEndermite;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEvoker;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEvokerFangs;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftExperienceOrb;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFallingBlock;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFirework;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFishHook;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFox;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftFrog;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGhast;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGiant;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGlowItemFrame;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGlowSquid;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGoat;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftGuardian;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHoglin;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHorse;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHusk;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftIllusioner;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftIronGolem;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftItem;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftItemFrame;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLargeFireball;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLeash;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLightningStrike;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLlama;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLlamaSpit;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMagmaCube;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMarker;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMinecartRideable;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMule;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMushroomCow;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftOcelot;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPainting;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPanda;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftParrot;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPhantom;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPig;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPigZombie;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPiglin;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPiglinBrute;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPillager;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPolarBear;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPufferFish;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftRabbit;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftRavager;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSalmon;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSheep;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftShulker;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftShulkerBullet;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSilverfish;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSkeleton;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSkeletonHorse;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSlime;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSmallFireball;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSnowball;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSnowman;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSpectralArrow;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSpider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftSquid;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftStray;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftStrider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTNTPrimed;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTadpole;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftThrownExpBottle;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftThrownPotion;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTippedArrow;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTraderLlama;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTrident;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTropicalFish;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTurtle;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftVex;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftVillager;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftVillagerZombie;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftVindicator;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWanderingTrader;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWarden;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWitch;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWither;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWitherSkeleton;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWitherSkull;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWolf;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftZoglin;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftZombie;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftZombieHorse;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Cat;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cod;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Dolphin;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Egg;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.EvokerFangs;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Firework;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Illusioner;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.LeashHitch;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Llama;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Mule;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinBrute;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.PufferFish;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Salmon;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.Slime;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Strider;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.TippedArrow;
import org.bukkit.entity.TraderLlama;
import org.bukkit.entity.Trident;
import org.bukkit.entity.TropicalFish;
import org.bukkit.entity.Turtle;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zoglin;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.entity.ZombieVillager;

public class Generator_Entity<BukkitClass extends CraftEntity, BukkitInterface extends org.bukkit.entity.Entity> {

    public static final Generator_Entity<CraftAllay, org.bukkit.entity.Allay> ALLAY = new Generator_Entity<>(
            "Allay", "ALLAY", CraftAllay.class, org.bukkit.entity.Allay.class, "b", Allay.class);
    public static final Generator_Entity<CraftAreaEffectCloud, AreaEffectCloud> AREA_EFFECT_CLOUD = new Generator_Entity<>(
            "AreaEffectCloud", "AREA_EFFECT_CLOUD", CraftAreaEffectCloud.class,
            org.bukkit.entity.AreaEffectCloud.class, "c", EntityAreaEffectCloud.class);
    public static final Generator_Entity<CraftArmorStand, ArmorStand> ARMOR_STAND = new Generator_Entity<>(
            "ArmorStand", "ARMOR_STAND", CraftArmorStand.class, org.bukkit.entity.ArmorStand.class,
            "d", EntityArmorStand.class);
    public static final Generator_Entity<CraftTippedArrow, TippedArrow> TIPPED_ARROW = new Generator_Entity<>(
            "TippedArrow", "TIPPED_ARROW", CraftTippedArrow.class,
            org.bukkit.entity.TippedArrow.class, "e", EntityTippedArrow.class);
    public static final Generator_Entity<CraftAxolotl, org.bukkit.entity.Axolotl> AXOLOTL = new Generator_Entity<>(
            "Axolotl", "AXOLOTL", CraftAxolotl.class, org.bukkit.entity.Axolotl.class, "f",
            Axolotl.class);
    public static final Generator_Entity<CraftBat, Bat> BAT = new Generator_Entity<>("Bat", "BAT",
            CraftBat.class, org.bukkit.entity.Bat.class, "g", EntityBat.class);
    public static final Generator_Entity<CraftBee, Bee> BEE = new Generator_Entity<>("Bee", "BEE",
            CraftBee.class, org.bukkit.entity.Bee.class, "h", EntityBee.class);
    public static final Generator_Entity<CraftBlaze, Blaze> BLAZE = new Generator_Entity<>("Blaze",
            "BLAZE", CraftBlaze.class, org.bukkit.entity.Blaze.class, "i", EntityBlaze.class);
    public static final Generator_Entity<CraftBoat, Boat> BOAT = new Generator_Entity<>("Boat",
            "BOAT", CraftBoat.class, org.bukkit.entity.Boat.class, "j", EntityBoat.class);
    public static final Generator_Entity<CraftChestBoat, org.bukkit.entity.ChestBoat> CHEST_BOAT = new Generator_Entity<>(
            "ChestBoat", "CHEST_BOAT", CraftChestBoat.class, org.bukkit.entity.ChestBoat.class, "k",
            ChestBoat.class);
    public static final Generator_Entity<CraftCat, Cat> CAT = new Generator_Entity<>("Cat", "CAT",
            CraftCat.class, org.bukkit.entity.Cat.class, "l", EntityCat.class);
    public static final Generator_Entity<CraftCaveSpider, CaveSpider> CAVE_SPIDER = new Generator_Entity<>(
            "CaveSpider", "CAVE_SPIDER", CraftCaveSpider.class, org.bukkit.entity.CaveSpider.class,
            "m", EntityCaveSpider.class);
    public static final Generator_Entity<CraftChicken, Chicken> CHICKEN = new Generator_Entity<>(
            "Chicken", "CHICKEN", CraftChicken.class, org.bukkit.entity.Chicken.class, "n",
            EntityChicken.class);
    public static final Generator_Entity<CraftCod, Cod> COD = new Generator_Entity<>("Cod", "COD",
            CraftCod.class, org.bukkit.entity.Cod.class, "o", EntityCod.class);
    public static final Generator_Entity<CraftCow, Cow> COW = new Generator_Entity<>("Cow", "COW",
            CraftCow.class, org.bukkit.entity.Cow.class, "p", EntityCow.class);
    public static final Generator_Entity<CraftCreeper, Creeper> CREEPER = new Generator_Entity<>(
            "Creeper", "CREEPER", CraftCreeper.class, org.bukkit.entity.Creeper.class, "q",
            EntityCreeper.class);
    public static final Generator_Entity<CraftDolphin, Dolphin> DOLPHIN = new Generator_Entity<>(
            "Dolphin", "DOLPHIN", CraftDolphin.class, org.bukkit.entity.Dolphin.class, "r",
            EntityDolphin.class);
    public static final Generator_Entity<CraftDonkey, Donkey> DONKEY = new Generator_Entity<>(
            "Donkey", "DONKEY", CraftDonkey.class, org.bukkit.entity.Donkey.class, "s",
            EntityHorseDonkey.class);
    public static final Generator_Entity<CraftDragonFireball, DragonFireball> DRAGON_FIREBALL = new Generator_Entity<>(
            "DragonFireball", "DRAGON_FIREBALL", CraftDragonFireball.class,
            org.bukkit.entity.DragonFireball.class, "t", EntityDragonFireball.class);
    public static final Generator_Entity<CraftDrowned, Drowned> DROWNED = new Generator_Entity<>(
            "Drowned", "DROWNED", CraftDrowned.class, org.bukkit.entity.Drowned.class, "u",
            EntityDrowned.class);
    public static final Generator_Entity<CraftElderGuardian, ElderGuardian> ELDER_GUARDIAN = new Generator_Entity<>(
            "ElderGuardian", "ELDER_GUARDIAN", CraftElderGuardian.class,
            org.bukkit.entity.ElderGuardian.class, "v", EntityGuardianElder.class);
    public static final Generator_Entity<CraftEnderCrystal, EnderCrystal> ENDER_CRYSTAL = new Generator_Entity<>(
            "EnderCrystal", "ENDER_CRYSTAL", CraftEnderCrystal.class,
            org.bukkit.entity.EnderCrystal.class, "w", EntityEnderCrystal.class);
    public static final Generator_Entity<CraftEnderDragon, EnderDragon> ENDER_DRAGON = new Generator_Entity<>(
            "EnderDragon", "ENDER_DRAGON", CraftEnderDragon.class,
            org.bukkit.entity.EnderDragon.class, "x", EntityEnderDragon.class);
    public static final Generator_Entity<CraftEnderman, Enderman> ENDERMAN = new Generator_Entity<>(
            "Enderman", "ENDERMAN", CraftEnderman.class, org.bukkit.entity.Enderman.class, "y",
            EntityEnderman.class);
    public static final Generator_Entity<CraftEndermite, Endermite> ENDERMITE = new Generator_Entity<>(
            "Endermite", "ENDERMITE", CraftEndermite.class, org.bukkit.entity.Endermite.class, "z",
            EntityEndermite.class);
    public static final Generator_Entity<CraftEvoker, Evoker> EVOKER = new Generator_Entity<>(
            "Evoker", "EVOKER", CraftEvoker.class, org.bukkit.entity.Evoker.class, "A",
            EntityEvoker.class);
    public static final Generator_Entity<CraftEvokerFangs, EvokerFangs> EVOKER_FANGS = new Generator_Entity<>(
            "EvokerFangs", "EVOKER_FANGS", CraftEvokerFangs.class,
            org.bukkit.entity.EvokerFangs.class, "B", EntityEvokerFangs.class);
    public static final Generator_Entity<CraftExperienceOrb, ExperienceOrb> EXPERIENCE_ORB = new Generator_Entity<>(
            "ExperienceOrb", "EXPERIENCE_ORB", CraftExperienceOrb.class,
            org.bukkit.entity.ExperienceOrb.class, "C", EntityExperienceOrb.class);
    public static final Generator_Entity<CraftEnderSignal, EnderSignal> ENDER_SIGNAL = new Generator_Entity<>(
            "EnderSignal", "ENDER_SIGNAL", CraftEnderSignal.class,
            org.bukkit.entity.EnderSignal.class, "D", EntityEnderSignal.class);
    public static final Generator_Entity<CraftFallingBlock, FallingBlock> FALLING_BLOCK = new Generator_Entity<>(
            "FallingBlock", "FALLING_BLOCK", CraftFallingBlock.class,
            org.bukkit.entity.FallingBlock.class, "E", EntityFallingBlock.class);
    public static final Generator_Entity<CraftFirework, Firework> FIREWORK = new Generator_Entity<>(
            "Firework", "FIREWORK", CraftFirework.class, org.bukkit.entity.Firework.class, "F",
            EntityFireworks.class);
    public static final Generator_Entity<CraftFox, Fox> FOX = new Generator_Entity<>("Fox", "FOX",
            CraftFox.class, org.bukkit.entity.Fox.class, "G", EntityFox.class);
    public static final Generator_Entity<CraftFrog, org.bukkit.entity.Frog> FROG = new Generator_Entity<>(
            "Frog", "FROG", CraftFrog.class, org.bukkit.entity.Frog.class, "H", Frog.class);
    public static final Generator_Entity<CraftGhast, Ghast> GHAST = new Generator_Entity<>("Ghast",
            "GHAST", CraftGhast.class, org.bukkit.entity.Ghast.class, "I", EntityGhast.class);
    public static final Generator_Entity<CraftGiant, Giant> GIANT = new Generator_Entity<>("Giant",
            "GIANT", CraftGiant.class, org.bukkit.entity.Giant.class, "J", EntityGiantZombie.class);
    public static final Generator_Entity<CraftGlowItemFrame, org.bukkit.entity.GlowItemFrame> GLOW_ITEM_FRAME = new Generator_Entity<>(
            "GlowItemFrame", "GLOW_ITEM_FRAME", CraftGlowItemFrame.class,
            org.bukkit.entity.GlowItemFrame.class, "K", GlowItemFrame.class);
    public static final Generator_Entity<CraftGlowSquid, org.bukkit.entity.GlowSquid> GLOW_SQUID = new Generator_Entity<>(
            "GlowSquid", "GLOW_SQUID", CraftGlowSquid.class, org.bukkit.entity.GlowSquid.class, "L",
            GlowSquid.class);
    public static final Generator_Entity<CraftGoat, org.bukkit.entity.Goat> GOAT = new Generator_Entity<>(
            "Goat", "GOAT", CraftGoat.class, org.bukkit.entity.Goat.class, "M", Goat.class);
    public static final Generator_Entity<CraftGuardian, Guardian> GUARDIAN = new Generator_Entity<>(
            "Guardian", "GUARDIAN", CraftGuardian.class, org.bukkit.entity.Guardian.class, "N",
            EntityGuardian.class);
    public static final Generator_Entity<CraftHoglin, Hoglin> HOGLIN = new Generator_Entity<>(
            "Hoglin", "HOGLIN", CraftHoglin.class, org.bukkit.entity.Hoglin.class, "O",
            EntityHoglin.class);
    public static final Generator_Entity<CraftHorse, Horse> HORSE = new Generator_Entity<>("Horse",
            "HORSE", CraftHorse.class, org.bukkit.entity.Horse.class, "P", EntityHorse.class);
    public static final Generator_Entity<CraftHusk, Husk> HUSK = new Generator_Entity<>("Husk",
            "HUSK", CraftHusk.class, org.bukkit.entity.Husk.class, "Q", EntityZombieHusk.class);
    public static final Generator_Entity<CraftIllusioner, Illusioner> ILLUSIONER = new Generator_Entity<>(
            "Illusioner", "ILLUSIONER", CraftIllusioner.class, org.bukkit.entity.Illusioner.class,
            "R", EntityIllagerIllusioner.class);
    public static final Generator_Entity<CraftIronGolem, IronGolem> IRON_GOLEM = new Generator_Entity<>(
            "IronGolem", "IRON_GOLEM", CraftIronGolem.class, org.bukkit.entity.IronGolem.class, "S",
            EntityIronGolem.class);
    public static final Generator_Entity<CraftItem, Item> ITEM = new Generator_Entity<>("Item",
            "ITEM", CraftItem.class, org.bukkit.entity.Item.class, "T", EntityItem.class);
    public static final Generator_Entity<CraftItemFrame, ItemFrame> ITEM_FRAME = new Generator_Entity<>(
            "ItemFrame", "ITEM_FRAME", CraftItemFrame.class, org.bukkit.entity.ItemFrame.class, "U",
            EntityItemFrame.class);
    public static final Generator_Entity<CraftLargeFireball, LargeFireball> LARGE_FIREBALL = new Generator_Entity<>(
            "LargeFireball", "LARGE_FIREBALL", CraftLargeFireball.class,
            org.bukkit.entity.LargeFireball.class, "V", EntityLargeFireball.class);
    public static final Generator_Entity<CraftLeash, LeashHitch> LEASH = new Generator_Entity<>(
            "Leash", "LEASH", CraftLeash.class, org.bukkit.entity.LeashHitch.class, "W",
            EntityLeash.class);
    public static final Generator_Entity<CraftLightningStrike, LightningStrike> LIGHTNING_STRIKE = new Generator_Entity<>(
            "LightningStrike", "LIGHTNING_STRIKE", CraftLightningStrike.class,
            org.bukkit.entity.LightningStrike.class, "X", EntityLightning.class);
    public static final Generator_Entity<CraftLlama, Llama> LLAMA = new Generator_Entity<>("Llama",
            "LLAMA", CraftLlama.class, org.bukkit.entity.Llama.class, "Y", EntityLlama.class);
    public static final Generator_Entity<CraftLlamaSpit, LlamaSpit> LLAMA_SPIT = new Generator_Entity<>(
            "LlamaSpit", "LLAMA_SPIT", CraftLlamaSpit.class, org.bukkit.entity.LlamaSpit.class, "Z",
            EntityLlamaSpit.class);
    public static final Generator_Entity<CraftMagmaCube, MagmaCube> MAGMA_CUBE = new Generator_Entity<>(
            "MagmaCube", "MAGMA_CUBE", CraftMagmaCube.class, org.bukkit.entity.MagmaCube.class,
            "aa", EntityMagmaCube.class);
    public static final Generator_Entity<CraftMarker, org.bukkit.entity.Marker> MARKER = new Generator_Entity<>(
            "Marker", "MARKER", CraftMarker.class, org.bukkit.entity.Marker.class, "ab",
            Marker.class);
    public static final Generator_Entity<CraftMinecartRideable, Minecart> MINECART_RIDEABLE = new Generator_Entity<>(
            "MinecartRideable", "MINECART_RIDEABLE", CraftMinecartRideable.class,
            org.bukkit.entity.Minecart.class, "ac", EntityMinecartRideable.class);
    //  public static final GenerateEntityType<CraftMinecartChest> MINECART_CHEST = new GenerateEntityType<>
    //  ("MinecartChest", "MINECART_CHEST", CraftMinecartChest.class, "ad", EntityMinecartChest.class);
    //  public static final GenerateEntityType<CraftMinecartCommand> MINECART_COMMAND = new GenerateEntityType<>
    //  ("MinecartCommand", "MINECART_COMMAND", CraftMinecartCommand.class, "ae", EntityMinecartCommandBlock.class);
    //  public static final GenerateEntityType<CraftMinecartFurnace> MINECART_FURNACE = new GenerateEntityType<>
    //  ("MinecartFurnace", "MINECART_FURNACE", CraftMinecartFurnace.class, "af", EntityMinecartFurnace.class);
    //  public static final GenerateEntityType<CraftMinecartHopper> MINECART_HOPPER = new GenerateEntityType<>
    //  ("MinecartHopper", "MINECART_HOPPER", CraftMinecartHopper.class, "ag", EntityMinecartHopper.class);
    //  public static final GenerateEntityType<CraftMinecartContainer> MINECART_CONTAINER = new GenerateEntityType<>
    //  ("MinecartContainer", "MINECART_CONTAINER", CraftMinecartContainer.class, "ae", EntityMinecartMobSpawner.classah
    //  public static final GenerateEntityType<CraftMinecartContainer> MINECART_CONTAINER = new GenerateEntityType<>
    //  ("MinecartContainer", "MINECART_CONTAINER", CraftMinecartContainer.class, "af", EntityMinecartTNT.classai
    public static final Generator_Entity<CraftMule, Mule> MULE = new Generator_Entity<>("Mule",
            "MULE", CraftMule.class, org.bukkit.entity.Mule.class, "aj", EntityHorseMule.class);
    public static final Generator_Entity<CraftMushroomCow, MushroomCow> MUSHROOM_COW = new Generator_Entity<>(
            "MushroomCow", "MUSHROOM_COW", CraftMushroomCow.class,
            org.bukkit.entity.MushroomCow.class, "ak", EntityMushroomCow.class);
    public static final Generator_Entity<CraftOcelot, Ocelot> OCELOT = new Generator_Entity<>(
            "Ocelot", "OCELOT", CraftOcelot.class, org.bukkit.entity.Ocelot.class, "al",
            EntityOcelot.class);
    public static final Generator_Entity<CraftPainting, Painting> PAINTING = new Generator_Entity<>(
            "Painting", "PAINTING", CraftPainting.class, org.bukkit.entity.Painting.class, "am",
            EntityPainting.class);
    public static final Generator_Entity<CraftPanda, Panda> PANDA = new Generator_Entity<>("Panda",
            "PANDA", CraftPanda.class, org.bukkit.entity.Panda.class, "an", EntityPanda.class);
    public static final Generator_Entity<CraftParrot, Parrot> PARROT = new Generator_Entity<>(
            "Parrot", "PARROT", CraftParrot.class, org.bukkit.entity.Parrot.class, "ao",
            EntityParrot.class);
    public static final Generator_Entity<CraftPhantom, Phantom> PHANTOM = new Generator_Entity<>(
            "Phantom", "PHANTOM", CraftPhantom.class, org.bukkit.entity.Phantom.class, "ap",
            EntityPhantom.class);
    public static final Generator_Entity<CraftPig, Pig> PIG = new Generator_Entity<>("Pig", "PIG",
            CraftPig.class, org.bukkit.entity.Pig.class, "aq", EntityPig.class);
    public static final Generator_Entity<CraftPiglin, Piglin> PIGLIN = new Generator_Entity<>(
            "Piglin", "PIGLIN", CraftPiglin.class, org.bukkit.entity.Piglin.class, "ar",
            EntityPiglin.class);
    public static final Generator_Entity<CraftPiglinBrute, PiglinBrute> PIGLIN_BRUTE = new Generator_Entity<>(
            "PiglinBrute", "PIGLIN_BRUTE", CraftPiglinBrute.class,
            org.bukkit.entity.PiglinBrute.class, "as", EntityPiglinBrute.class);
    public static final Generator_Entity<CraftPillager, Pillager> PILLAGER = new Generator_Entity<>(
            "Pillager", "PILLAGER", CraftPillager.class, org.bukkit.entity.Pillager.class, "at",
            EntityPillager.class);
    public static final Generator_Entity<CraftPolarBear, PolarBear> POLAR_BEAR = new Generator_Entity<>(
            "PolarBear", "POLAR_BEAR", CraftPolarBear.class, org.bukkit.entity.PolarBear.class,
            "au", EntityPolarBear.class);
    public static final Generator_Entity<CraftTNTPrimed, TNTPrimed> TNT_PRIMED = new Generator_Entity<>(
            "TNTPrimed", "TNT_PRIMED", CraftTNTPrimed.class, org.bukkit.entity.TNTPrimed.class,
            "av", EntityTNTPrimed.class);
    public static final Generator_Entity<CraftPufferFish, PufferFish> PUFFER_FISH = new Generator_Entity<>(
            "PufferFish", "PUFFER_FISH", CraftPufferFish.class, org.bukkit.entity.PufferFish.class,
            "aw", EntityPufferFish.class);
    public static final Generator_Entity<CraftRabbit, Rabbit> RABBIT = new Generator_Entity<>(
            "Rabbit", "RABBIT", CraftRabbit.class, org.bukkit.entity.Rabbit.class, "ax",
            EntityRabbit.class);
    public static final Generator_Entity<CraftRavager, Ravager> RAVAGER = new Generator_Entity<>(
            "Ravager", "RAVAGER", CraftRavager.class, org.bukkit.entity.Ravager.class, "ay",
            EntityRavager.class);
    public static final Generator_Entity<CraftSalmon, Salmon> SALMON = new Generator_Entity<>(
            "Salmon", "SALMON", CraftSalmon.class, org.bukkit.entity.Salmon.class, "az",
            EntitySalmon.class);
    public static final Generator_Entity<CraftSheep, Sheep> SHEEP = new Generator_Entity<>("Sheep",
            "SHEEP", CraftSheep.class, org.bukkit.entity.Sheep.class, "aA", EntitySheep.class);
    public static final Generator_Entity<CraftShulker, Shulker> SHULKER = new Generator_Entity<>(
            "Shulker", "SHULKER", CraftShulker.class, org.bukkit.entity.Shulker.class, "aB",
            EntityShulker.class);
    public static final Generator_Entity<CraftShulkerBullet, ShulkerBullet> SHULKER_BULLET = new Generator_Entity<>(
            "ShulkerBullet", "SHULKER_BULLET", CraftShulkerBullet.class,
            org.bukkit.entity.ShulkerBullet.class, "aC", EntityShulkerBullet.class);
    public static final Generator_Entity<CraftSilverfish, Silverfish> SILVERFISH = new Generator_Entity<>(
            "Silverfish", "SILVERFISH", CraftSilverfish.class, org.bukkit.entity.Silverfish.class,
            "aD", EntitySilverfish.class);
    public static final Generator_Entity<CraftSkeleton, Skeleton> SKELETON = new Generator_Entity<>(
            "Skeleton", "SKELETON", CraftSkeleton.class, org.bukkit.entity.Skeleton.class, "aE",
            EntitySkeleton.class);
    public static final Generator_Entity<CraftSkeletonHorse, SkeletonHorse> SKELETON_HORSE = new Generator_Entity<>(
            "SkeletonHorse", "SKELETON_HORSE", CraftSkeletonHorse.class,
            org.bukkit.entity.SkeletonHorse.class, "aF", EntityHorseSkeleton.class);
    public static final Generator_Entity<CraftSlime, Slime> SLIME = new Generator_Entity<>("Slime",
            "SLIME", CraftSlime.class, org.bukkit.entity.Slime.class, "aG", EntitySlime.class);
    public static final Generator_Entity<CraftSmallFireball, SmallFireball> SMALL_FIREBALL = new Generator_Entity<>(
            "SmallFireball", "SMALL_FIREBALL", CraftSmallFireball.class,
            org.bukkit.entity.SmallFireball.class, "aH", EntitySmallFireball.class);
    public static final Generator_Entity<CraftSnowman, Snowman> SNOWMAN = new Generator_Entity<>(
            "Snowman", "SNOWMAN", CraftSnowman.class, org.bukkit.entity.Snowman.class, "aI",
            EntitySnowman.class);
    public static final Generator_Entity<CraftSnowball, Snowball> SNOWBALL = new Generator_Entity<>(
            "Snowball", "SNOWBALL", CraftSnowball.class, org.bukkit.entity.Snowball.class, "aJ",
            EntitySnowball.class);
    public static final Generator_Entity<CraftSpectralArrow, SpectralArrow> SPECTRAL_ARROW = new Generator_Entity<>(
            "SpectralArrow", "SPECTRAL_ARROW", CraftSpectralArrow.class,
            org.bukkit.entity.SpectralArrow.class, "aK", EntitySpectralArrow.class);
    public static final Generator_Entity<CraftSpider, Spider> SPIDER = new Generator_Entity<>(
            "Spider", "SPIDER", CraftSpider.class, org.bukkit.entity.Spider.class, "aL",
            EntitySpider.class);
    public static final Generator_Entity<CraftSquid, Squid> SQUID = new Generator_Entity<>("Squid",
            "SQUID", CraftSquid.class, org.bukkit.entity.Squid.class, "aM", EntitySquid.class);
    public static final Generator_Entity<CraftStray, Stray> STRAY = new Generator_Entity<>("Stray",
            "STRAY", CraftStray.class, org.bukkit.entity.Stray.class, "aN",
            EntitySkeletonStray.class);
    public static final Generator_Entity<CraftStrider, Strider> STRIDER = new Generator_Entity<>(
            "Strider", "STRIDER", CraftStrider.class, org.bukkit.entity.Strider.class, "aO",
            EntityStrider.class);
    public static final Generator_Entity<CraftTadpole, org.bukkit.entity.Tadpole> TADPOLE = new Generator_Entity<>(
            "Tadpole", "TADPOLE", CraftTadpole.class, org.bukkit.entity.Tadpole.class, "aP",
            Tadpole.class);
    public static final Generator_Entity<CraftEgg, Egg> EGG = new Generator_Entity<>("Egg", "EGG",
            CraftEgg.class, org.bukkit.entity.Egg.class, "aQ", EntityEgg.class);
    public static final Generator_Entity<CraftEnderPearl, EnderPearl> ENDER_PEARL = new Generator_Entity<>(
            "EnderPearl", "ENDER_PEARL", CraftEnderPearl.class, org.bukkit.entity.EnderPearl.class,
            "aR", EntityEnderPearl.class);
    public static final Generator_Entity<CraftThrownExpBottle, ThrownExpBottle> THROWN_EXP_BOTTLE = new Generator_Entity<>(
            "ThrownExpBottle", "THROWN_EXP_BOTTLE", CraftThrownExpBottle.class,
            org.bukkit.entity.ThrownExpBottle.class, "aS", EntityThrownExpBottle.class);
    public static final Generator_Entity<CraftThrownPotion, ThrownPotion> THROWN_POTION = new Generator_Entity<>(
            "ThrownPotion", "THROWN_POTION", CraftThrownPotion.class,
            org.bukkit.entity.ThrownPotion.class, "aT", EntityPotion.class);
    public static final Generator_Entity<CraftTrident, Trident> TRIDENT = new Generator_Entity<>(
            "Trident", "TRIDENT", CraftTrident.class, org.bukkit.entity.Trident.class, "aU",
            EntityThrownTrident.class);
    public static final Generator_Entity<CraftTraderLlama, TraderLlama> TRADER_LLAMA = new Generator_Entity<>(
            "TraderLlama", "TRADER_LLAMA", CraftTraderLlama.class,
            org.bukkit.entity.TraderLlama.class, "aV", EntityLlamaTrader.class);
    public static final Generator_Entity<CraftTropicalFish, TropicalFish> TROPICAL_FISH = new Generator_Entity<>(
            "TropicalFish", "TROPICAL_FISH", CraftTropicalFish.class,
            org.bukkit.entity.TropicalFish.class, "aW", EntityTropicalFish.class);
    public static final Generator_Entity<CraftTurtle, Turtle> TURTLE = new Generator_Entity<>(
            "Turtle", "TURTLE", CraftTurtle.class, org.bukkit.entity.Turtle.class, "aX",
            EntityTurtle.class);
    public static final Generator_Entity<CraftVex, Vex> VEX = new Generator_Entity<>("Vex", "VEX",
            CraftVex.class, org.bukkit.entity.Vex.class, "aY", EntityVex.class);
    public static final Generator_Entity<CraftVillager, Villager> VILLAGER = new Generator_Entity<>(
            "Villager", "VILLAGER", CraftVillager.class, org.bukkit.entity.Villager.class, "aZ",
            EntityVillager.class);
    public static final Generator_Entity<CraftVindicator, Vindicator> VINDICATOR = new Generator_Entity<>(
            "Vindicator", "VINDICATOR", CraftVindicator.class, org.bukkit.entity.Vindicator.class,
            "ba", EntityVindicator.class);
    public static final Generator_Entity<CraftWanderingTrader, WanderingTrader> WANDERING_TRADER = new Generator_Entity<>(
            "WanderingTrader", "WANDERING_TRADER", CraftWanderingTrader.class,
            org.bukkit.entity.WanderingTrader.class, "bb", EntityVillagerTrader.class);
    public static final Generator_Entity<CraftWarden, org.bukkit.entity.Warden> WARDEN = new Generator_Entity<>(
            "Warden", "WARDEN", CraftWarden.class, org.bukkit.entity.Warden.class, "bc",
            Warden.class);
    public static final Generator_Entity<CraftWitch, Witch> WITCH = new Generator_Entity<>("Witch",
            "WITCH", CraftWitch.class, org.bukkit.entity.Witch.class, "bd", EntityWitch.class);
    public static final Generator_Entity<CraftWither, Wither> WITHER = new Generator_Entity<>(
            "Wither", "WITHER", CraftWither.class, org.bukkit.entity.Wither.class, "be",
            EntityWither.class);
    public static final Generator_Entity<CraftWitherSkeleton, WitherSkeleton> WITHER_SKELETON = new Generator_Entity<>(
            "WitherSkeleton", "WITHER_SKELETON", CraftWitherSkeleton.class,
            org.bukkit.entity.WitherSkeleton.class, "bf", EntitySkeletonWither.class);
    public static final Generator_Entity<CraftWitherSkull, WitherSkull> WITHER_SKULL = new Generator_Entity<>(
            "WitherSkull", "WITHER_SKULL", CraftWitherSkull.class,
            org.bukkit.entity.WitherSkull.class, "bg", EntityWitherSkull.class);
    public static final Generator_Entity<CraftWolf, Wolf> WOLF = new Generator_Entity<>("Wolf",
            "WOLF", CraftWolf.class, org.bukkit.entity.Wolf.class, "bh", EntityWolf.class);
    public static final Generator_Entity<CraftZoglin, Zoglin> ZOGLIN = new Generator_Entity<>(
            "Zoglin", "ZOGLIN", CraftZoglin.class, org.bukkit.entity.Zoglin.class, "bi",
            EntityZoglin.class);
    public static final Generator_Entity<CraftZombie, Zombie> ZOMBIE = new Generator_Entity<>(
            "Zombie", "ZOMBIE", CraftZombie.class, org.bukkit.entity.Zombie.class, "bj",
            EntityZombie.class);
    public static final Generator_Entity<CraftZombieHorse, ZombieHorse> ZOMBIE_HORSE = new Generator_Entity<>(
            "ZombieHorse", "ZOMBIE_HORSE", CraftZombieHorse.class,
            org.bukkit.entity.ZombieHorse.class, "bk", EntityHorseZombie.class);
    public static final Generator_Entity<CraftVillagerZombie, ZombieVillager> VILLAGER_ZOMBIE = new Generator_Entity<>(
            "VillagerZombie", "VILLAGER_ZOMBIE", CraftVillagerZombie.class,
            org.bukkit.entity.ZombieVillager.class, "bl", EntityZombieVillager.class);
    public static final Generator_Entity<CraftPigZombie, PigZombie> PIG_ZOMBIE = new Generator_Entity<>(
            "PigZombie", "PIG_ZOMBIE", CraftPigZombie.class, org.bukkit.entity.PigZombie.class,
            "bm", EntityPigZombie.class);
    public static final Generator_Entity<CraftHumanEntity, HumanEntity> HUMAN_ENTITY = new Generator_Entity<>(
            "HumanEntity", "HUMAN_ENTITY", CraftHumanEntity.class,
            org.bukkit.entity.HumanEntity.class, "bn", EntityHuman.class);
    public static final Generator_Entity<CraftFishHook, FishHook> FISH_HOOK = new Generator_Entity<>(
            "FishHook", "FISH_HOOK", CraftFishHook.class, org.bukkit.entity.FishHook.class, "bo",
            EntityFishingHook.class);

    public static final List<Generator_Entity<?, ?>> TYPES = new LinkedList<>();

    static {
        TYPES.add(AREA_EFFECT_CLOUD);
        TYPES.add(ARMOR_STAND);
        TYPES.add(TIPPED_ARROW);
        TYPES.add(AXOLOTL);
        TYPES.add(BAT);
        TYPES.add(BEE);
        TYPES.add(BLAZE);
        TYPES.add(BOAT);
        TYPES.add(CAT);
        TYPES.add(CAVE_SPIDER);
        TYPES.add(CHICKEN);
        TYPES.add(COD);
        TYPES.add(COW);
        TYPES.add(CREEPER);
        TYPES.add(DOLPHIN);
        TYPES.add(DONKEY);
        TYPES.add(DRAGON_FIREBALL);
        TYPES.add(DROWNED);
        TYPES.add(ELDER_GUARDIAN);
        TYPES.add(ENDER_CRYSTAL);
        TYPES.add(ENDER_DRAGON);
        TYPES.add(ENDERMAN);
        TYPES.add(ENDERMITE);
        TYPES.add(EVOKER);
        TYPES.add(EVOKER_FANGS);
        TYPES.add(EXPERIENCE_ORB);
        TYPES.add(ENDER_SIGNAL);
        TYPES.add(FALLING_BLOCK);
        TYPES.add(FIREWORK);
        TYPES.add(FOX);
        TYPES.add(GHAST);
        TYPES.add(GIANT);
        TYPES.add(GLOW_ITEM_FRAME);
        TYPES.add(GLOW_SQUID);
        TYPES.add(GOAT);
        TYPES.add(GUARDIAN);
        TYPES.add(HOGLIN);
        TYPES.add(HORSE);
        TYPES.add(HUSK);
        TYPES.add(ILLUSIONER);
        TYPES.add(IRON_GOLEM);
        TYPES.add(ITEM);
        TYPES.add(ITEM_FRAME);
        TYPES.add(LARGE_FIREBALL);
        TYPES.add(LEASH);
        TYPES.add(LIGHTNING_STRIKE);
        TYPES.add(LLAMA);
        TYPES.add(LLAMA_SPIT);
        TYPES.add(MAGMA_CUBE);
        TYPES.add(MARKER);
        TYPES.add(MINECART_RIDEABLE);
        //      TYPES.add(MINECART_CHEST);
        //      TYPES.add(MINECART_COMMAND);
        //      TYPES.add(MINECART_FURNACE);
        //      TYPES.add(MINECART_HOPPER);
        //      TYPES.add(MINECART_CONTAINER);
        //      TYPES.add(MINECART_CONTAINER);
        TYPES.add(MULE);
        TYPES.add(MUSHROOM_COW);
        TYPES.add(OCELOT);
        TYPES.add(PAINTING);
        TYPES.add(PANDA);
        TYPES.add(PARROT);
        TYPES.add(PHANTOM);
        TYPES.add(PIG);
        TYPES.add(PIGLIN);
        TYPES.add(PIGLIN_BRUTE);
        TYPES.add(PILLAGER);
        TYPES.add(POLAR_BEAR);
        TYPES.add(TNT_PRIMED);
        TYPES.add(PUFFER_FISH);
        TYPES.add(RABBIT);
        TYPES.add(RAVAGER);
        TYPES.add(SALMON);
        TYPES.add(SHEEP);
        TYPES.add(SHULKER);
        TYPES.add(SHULKER_BULLET);
        TYPES.add(SILVERFISH);
        TYPES.add(SKELETON);
        TYPES.add(SKELETON_HORSE);
        TYPES.add(SLIME);
        TYPES.add(SMALL_FIREBALL);
        TYPES.add(SNOWMAN);
        TYPES.add(SNOWBALL);
        TYPES.add(SPECTRAL_ARROW);
        TYPES.add(SPIDER);
        TYPES.add(SQUID);
        TYPES.add(STRAY);
        TYPES.add(STRIDER);
        TYPES.add(EGG);
        TYPES.add(ENDER_PEARL);
        TYPES.add(THROWN_EXP_BOTTLE);
        TYPES.add(THROWN_POTION);
        TYPES.add(TRIDENT);
        TYPES.add(TRADER_LLAMA);
        TYPES.add(TROPICAL_FISH);
        TYPES.add(TURTLE);
        TYPES.add(VEX);
        TYPES.add(VILLAGER);
        TYPES.add(VINDICATOR);
        TYPES.add(WANDERING_TRADER);
        TYPES.add(WITCH);
        TYPES.add(WITHER);
        TYPES.add(WITHER_SKELETON);
        TYPES.add(WITHER_SKULL);
        TYPES.add(WOLF);
        TYPES.add(ZOGLIN);
        TYPES.add(ZOMBIE);
        TYPES.add(ZOMBIE_HORSE);
        TYPES.add(VILLAGER_ZOMBIE);
        TYPES.add(PIG_ZOMBIE);
        TYPES.add(HUMAN_ENTITY);
        TYPES.add(FISH_HOOK);
    }

    private final String name;
    private final String bukkitTypeName;
    private final Class<BukkitClass> bukkitClass;
    private final Class<BukkitInterface> bukkitInterface;
    private final String nmsTypeName;
    private final Class<? extends Entity> nmsClass;

    public Generator_Entity(String name, String bukkitTypeName, Class<BukkitClass> bukkitClass,
            Class<BukkitInterface> bukkitInterface, String nsmTypeName,
            Class<? extends Entity> nmsClass) {
        this.name = name;
        this.bukkitTypeName = bukkitTypeName;
        this.bukkitClass = bukkitClass;
        this.bukkitInterface = bukkitInterface;
        this.nmsTypeName = nsmTypeName;
        this.nmsClass = nmsClass;
    }

    public String getName() {
        return name;
    }

    public String getBukkitTypeName() {
        return bukkitTypeName;
    }

    public Class<BukkitClass> getBukkitClass() {
        return bukkitClass;
    }

    public Class<BukkitInterface> getBukkitInterface() {
        return bukkitInterface;
    }

    public String getNmsTypeName() {
        return nmsTypeName;
    }

    public Class<? extends Entity> getNmsClass() {
        return nmsClass;
    }

}
