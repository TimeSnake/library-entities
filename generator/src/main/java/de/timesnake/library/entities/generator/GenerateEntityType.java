package de.timesnake.library.entities.generator;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.EntityBat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
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
import net.minecraft.world.entity.monster.piglin.EntityPiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.EntityVillagerTrader;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.EntityBoat;
import net.minecraft.world.entity.vehicle.EntityMinecartRideable;
import org.bukkit.craftbukkit.v1_19_R1.entity.*;

import java.util.LinkedList;
import java.util.List;

public class GenerateEntityType<BukkitClass extends CraftEntity> {

    public static final GenerateEntityType<CraftAllay> ALLAY = new GenerateEntityType<>("Allay", "ALLAY",
            CraftAllay.class, "b", Allay.class);
    public static final GenerateEntityType<CraftAreaEffectCloud> AREA_EFFECT_CLOUD = new GenerateEntityType<>(
            "AreaEffectCloud", "AREA_EFFECT_CLOUD", CraftAreaEffectCloud.class, "c", EntityAreaEffectCloud.class);
    public static final GenerateEntityType<CraftArmorStand> ARMOR_STAND = new GenerateEntityType<>("ArmorStand",
            "ARMOR_STAND", CraftArmorStand.class, "d", EntityArmorStand.class);
    public static final GenerateEntityType<CraftTippedArrow> TIPPED_ARROW = new GenerateEntityType<>("TippedArrow",
            "TIPPED_ARROW", CraftTippedArrow.class, "e", EntityTippedArrow.class);
    public static final GenerateEntityType<CraftAxolotl> AXOLOTL = new GenerateEntityType<>("Axolotl", "AXOLOTL",
            CraftAxolotl.class, "f", Axolotl.class);
    public static final GenerateEntityType<CraftBat> BAT = new GenerateEntityType<>("Bat", "BAT", CraftBat.class, "g"
            , EntityBat.class);
    public static final GenerateEntityType<CraftBee> BEE = new GenerateEntityType<>("Bee", "BEE", CraftBee.class, "h"
            , EntityBee.class);
    public static final GenerateEntityType<CraftBlaze> BLAZE = new GenerateEntityType<>("Blaze", "BLAZE",
            CraftBlaze.class, "i", EntityBlaze.class);
    public static final GenerateEntityType<CraftBoat> BOAT = new GenerateEntityType<>("Boat", "BOAT", CraftBoat.class
            , "j", EntityBoat.class);
    public static final GenerateEntityType<CraftChestBoat> CHEST_BOAT = new GenerateEntityType<>("ChestBoat",
            "CHEST_BOAT", CraftChestBoat.class, "k", ChestBoat.class);
    public static final GenerateEntityType<CraftCat> CAT = new GenerateEntityType<>("Cat", "CAT", CraftCat.class, "l"
            , EntityCat.class);
    public static final GenerateEntityType<CraftCaveSpider> CAVE_SPIDER = new GenerateEntityType<>("CaveSpider",
            "CAVE_SPIDER", CraftCaveSpider.class, "m", EntityCaveSpider.class);
    public static final GenerateEntityType<CraftChicken> CHICKEN = new GenerateEntityType<>("Chicken", "CHICKEN",
            CraftChicken.class, "n", EntityChicken.class);
    public static final GenerateEntityType<CraftCod> COD = new GenerateEntityType<>("Cod", "COD", CraftCod.class, "o"
            , EntityCod.class);
    public static final GenerateEntityType<CraftCow> COW = new GenerateEntityType<>("Cow", "COW", CraftCow.class, "p"
            , EntityCow.class);
    public static final GenerateEntityType<CraftCreeper> CREEPER = new GenerateEntityType<>("Creeper", "CREEPER",
            CraftCreeper.class, "q", EntityCreeper.class);
    public static final GenerateEntityType<CraftDolphin> DOLPHIN = new GenerateEntityType<>("Dolphin", "DOLPHIN",
            CraftDolphin.class, "r", EntityDolphin.class);
    public static final GenerateEntityType<CraftDonkey> DONKEY = new GenerateEntityType<>("Donkey", "DONKEY",
            CraftDonkey.class, "s", EntityHorseDonkey.class);
    public static final GenerateEntityType<CraftDragonFireball> DRAGON_FIREBALL = new GenerateEntityType<>(
            "DragonFireball", "DRAGON_FIREBALL", CraftDragonFireball.class, "t", EntityDragonFireball.class);
    public static final GenerateEntityType<CraftDrowned> DROWNED = new GenerateEntityType<>("Drowned", "DROWNED",
            CraftDrowned.class, "u", EntityDrowned.class);
    public static final GenerateEntityType<CraftElderGuardian> ELDER_GUARDIAN = new GenerateEntityType<>(
            "ElderGuardian", "ELDER_GUARDIAN", CraftElderGuardian.class, "v", EntityGuardianElder.class);
    public static final GenerateEntityType<CraftEnderCrystal> ENDER_CRYSTAL = new GenerateEntityType<>("EnderCrystal"
            , "ENDER_CRYSTAL", CraftEnderCrystal.class, "w", EntityEnderCrystal.class);
    public static final GenerateEntityType<CraftEnderDragon> ENDER_DRAGON = new GenerateEntityType<>("EnderDragon",
            "ENDER_DRAGON", CraftEnderDragon.class, "x", EntityEnderDragon.class);
    public static final GenerateEntityType<CraftEnderman> ENDERMAN = new GenerateEntityType<>("Enderman", "ENDERMAN",
            CraftEnderman.class, "y", EntityEnderman.class);
    public static final GenerateEntityType<CraftEndermite> ENDERMITE = new GenerateEntityType<>("Endermite",
            "ENDERMITE", CraftEndermite.class, "z", EntityEndermite.class);
    public static final GenerateEntityType<CraftEvoker> EVOKER = new GenerateEntityType<>("Evoker", "EVOKER",
            CraftEvoker.class, "A", EntityEvoker.class);
    public static final GenerateEntityType<CraftEvokerFangs> EVOKER_FANGS = new GenerateEntityType<>("EvokerFangs",
            "EVOKER_FANGS", CraftEvokerFangs.class, "B", EntityEvokerFangs.class);
    public static final GenerateEntityType<CraftExperienceOrb> EXPERIENCE_ORB = new GenerateEntityType<>(
            "ExperienceOrb", "EXPERIENCE_ORB", CraftExperienceOrb.class, "C", EntityExperienceOrb.class);
    public static final GenerateEntityType<CraftEnderSignal> ENDER_SIGNAL = new GenerateEntityType<>("EnderSignal",
            "ENDER_SIGNAL", CraftEnderSignal.class, "D", EntityEnderSignal.class);
    public static final GenerateEntityType<CraftFallingBlock> FALLING_BLOCK = new GenerateEntityType<>("FallingBlock"
            , "FALLING_BLOCK", CraftFallingBlock.class, "E", EntityFallingBlock.class);
    public static final GenerateEntityType<CraftFirework> FIREWORK = new GenerateEntityType<>("Firework", "FIREWORK",
            CraftFirework.class, "F", EntityFireworks.class);
    public static final GenerateEntityType<CraftFox> FOX = new GenerateEntityType<>("Fox", "FOX", CraftFox.class, "G"
            , EntityFox.class);
    public static final GenerateEntityType<CraftFrog> FROG = new GenerateEntityType<>("Frog", "FROG", CraftFrog.class
            , "H", Frog.class);
    public static final GenerateEntityType<CraftGhast> GHAST = new GenerateEntityType<>("Ghast", "GHAST",
            CraftGhast.class, "I", EntityGhast.class);
    public static final GenerateEntityType<CraftGiant> GIANT = new GenerateEntityType<>("Giant", "GIANT",
            CraftGiant.class, "J", EntityGiantZombie.class);
    public static final GenerateEntityType<CraftGlowItemFrame> GLOW_ITEM_FRAME = new GenerateEntityType<>(
            "GlowItemFrame", "GLOW_ITEM_FRAME", CraftGlowItemFrame.class, "K", GlowItemFrame.class);
    public static final GenerateEntityType<CraftGlowSquid> GLOW_SQUID = new GenerateEntityType<>("GlowSquid",
            "GLOW_SQUID", CraftGlowSquid.class, "L", GlowSquid.class);
    public static final GenerateEntityType<CraftGoat> GOAT = new GenerateEntityType<>("Goat", "GOAT", CraftGoat.class
            , "M", Goat.class);
    public static final GenerateEntityType<CraftGuardian> GUARDIAN = new GenerateEntityType<>("Guardian", "GUARDIAN",
            CraftGuardian.class, "N", EntityGuardian.class);
    public static final GenerateEntityType<CraftHoglin> HOGLIN = new GenerateEntityType<>("Hoglin", "HOGLIN",
            CraftHoglin.class, "O", EntityHoglin.class);
    public static final GenerateEntityType<CraftHorse> HORSE = new GenerateEntityType<>("Horse", "HORSE",
            CraftHorse.class, "P", EntityHorse.class);
    public static final GenerateEntityType<CraftHusk> HUSK = new GenerateEntityType<>("Husk", "HUSK", CraftHusk.class
            , "Q", EntityZombieHusk.class);
    public static final GenerateEntityType<CraftIllusioner> ILLUSIONER = new GenerateEntityType<>("Illusioner",
            "ILLUSIONER", CraftIllusioner.class, "R", EntityIllagerIllusioner.class);
    public static final GenerateEntityType<CraftIronGolem> IRON_GOLEM = new GenerateEntityType<>("IronGolem",
            "IRON_GOLEM", CraftIronGolem.class, "S", EntityIronGolem.class);
    public static final GenerateEntityType<CraftItem> ITEM = new GenerateEntityType<>("Item", "ITEM", CraftItem.class
            , "T", EntityItem.class);
    public static final GenerateEntityType<CraftItemFrame> ITEM_FRAME = new GenerateEntityType<>("ItemFrame",
            "ITEM_FRAME", CraftItemFrame.class, "U", EntityItemFrame.class);
    public static final GenerateEntityType<CraftLargeFireball> LARGE_FIREBALL = new GenerateEntityType<>(
            "LargeFireball", "LARGE_FIREBALL", CraftLargeFireball.class, "V", EntityLargeFireball.class);
    public static final GenerateEntityType<CraftLeash> LEASH = new GenerateEntityType<>("Leash", "LEASH",
            CraftLeash.class, "W", EntityLeash.class);
    public static final GenerateEntityType<CraftLightningStrike> LIGHTNING_STRIKE = new GenerateEntityType<>(
            "LightningStrike", "LIGHTNING_STRIKE", CraftLightningStrike.class, "X", EntityLightning.class);
    public static final GenerateEntityType<CraftLlama> LLAMA = new GenerateEntityType<>("Llama", "LLAMA",
            CraftLlama.class, "Y", EntityLlama.class);
    public static final GenerateEntityType<CraftLlamaSpit> LLAMA_SPIT = new GenerateEntityType<>("LlamaSpit",
            "LLAMA_SPIT", CraftLlamaSpit.class, "Z", EntityLlamaSpit.class);
    public static final GenerateEntityType<CraftMagmaCube> MAGMA_CUBE = new GenerateEntityType<>("MagmaCube",
            "MAGMA_CUBE", CraftMagmaCube.class, "aa", EntityMagmaCube.class);
    public static final GenerateEntityType<CraftMarker> MARKER = new GenerateEntityType<>("Marker", "MARKER",
            CraftMarker.class, "ab", Marker.class);
    public static final GenerateEntityType<CraftMinecartRideable> MINECART_RIDEABLE = new GenerateEntityType<>(
            "MinecartRideable", "MINECART_RIDEABLE", CraftMinecartRideable.class, "ac", EntityMinecartRideable.class);
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
    public static final GenerateEntityType<CraftMule> MULE = new GenerateEntityType<>("Mule", "MULE", CraftMule.class
            , "aj", EntityHorseMule.class);
    public static final GenerateEntityType<CraftMushroomCow> MUSHROOM_COW = new GenerateEntityType<>("MushroomCow",
            "MUSHROOM_COW", CraftMushroomCow.class, "ak", EntityMushroomCow.class);
    public static final GenerateEntityType<CraftOcelot> OCELOT = new GenerateEntityType<>("Ocelot", "OCELOT",
            CraftOcelot.class, "al", EntityOcelot.class);
    public static final GenerateEntityType<CraftPainting> PAINTING = new GenerateEntityType<>("Painting", "PAINTING",
            CraftPainting.class, "am", EntityPainting.class);
    public static final GenerateEntityType<CraftPanda> PANDA = new GenerateEntityType<>("Panda", "PANDA",
            CraftPanda.class, "an", EntityPanda.class);
    public static final GenerateEntityType<CraftParrot> PARROT = new GenerateEntityType<>("Parrot", "PARROT",
            CraftParrot.class, "ao", EntityParrot.class);
    public static final GenerateEntityType<CraftPhantom> PHANTOM = new GenerateEntityType<>("Phantom", "PHANTOM",
            CraftPhantom.class, "ap", EntityPhantom.class);
    public static final GenerateEntityType<CraftPig> PIG = new GenerateEntityType<>("Pig", "PIG", CraftPig.class, "aq"
            , EntityPig.class);
    public static final GenerateEntityType<CraftPiglin> PIGLIN = new GenerateEntityType<>("Piglin", "PIGLIN",
            CraftPiglin.class, "ar", EntityPiglin.class);
    public static final GenerateEntityType<CraftPiglinBrute> PIGLIN_BRUTE = new GenerateEntityType<>("PiglinBrute",
            "PIGLIN_BRUTE", CraftPiglinBrute.class, "as", EntityPiglinBrute.class);
    public static final GenerateEntityType<CraftPillager> PILLAGER = new GenerateEntityType<>("Pillager", "PILLAGER",
            CraftPillager.class, "at", EntityPillager.class);
    public static final GenerateEntityType<CraftPolarBear> POLAR_BEAR = new GenerateEntityType<>("PolarBear",
            "POLAR_BEAR", CraftPolarBear.class, "au", EntityPolarBear.class);
    public static final GenerateEntityType<CraftTNTPrimed> TNT_PRIMED = new GenerateEntityType<>("TNTPrimed",
            "TNT_PRIMED", CraftTNTPrimed.class, "av", EntityTNTPrimed.class);
    public static final GenerateEntityType<CraftPufferFish> PUFFER_FISH = new GenerateEntityType<>("PufferFish",
            "PUFFER_FISH", CraftPufferFish.class, "aw", EntityPufferFish.class);
    public static final GenerateEntityType<CraftRabbit> RABBIT = new GenerateEntityType<>("Rabbit", "RABBIT",
            CraftRabbit.class, "ax", EntityRabbit.class);
    public static final GenerateEntityType<CraftRavager> RAVAGER = new GenerateEntityType<>("Ravager", "RAVAGER",
            CraftRavager.class, "ay", EntityRavager.class);
    public static final GenerateEntityType<CraftSalmon> SALMON = new GenerateEntityType<>("Salmon", "SALMON",
            CraftSalmon.class, "az", EntitySalmon.class);
    public static final GenerateEntityType<CraftSheep> SHEEP = new GenerateEntityType<>("Sheep", "SHEEP",
            CraftSheep.class, "aA", EntitySheep.class);
    public static final GenerateEntityType<CraftShulker> SHULKER = new GenerateEntityType<>("Shulker", "SHULKER",
            CraftShulker.class, "aB", EntityShulker.class);
    public static final GenerateEntityType<CraftShulkerBullet> SHULKER_BULLET = new GenerateEntityType<>(
            "ShulkerBullet", "SHULKER_BULLET", CraftShulkerBullet.class, "aC", EntityShulkerBullet.class);
    public static final GenerateEntityType<CraftSilverfish> SILVERFISH = new GenerateEntityType<>("Silverfish",
            "SILVERFISH", CraftSilverfish.class, "aD", EntitySilverfish.class);
    public static final GenerateEntityType<CraftSkeleton> SKELETON = new GenerateEntityType<>("Skeleton", "SKELETON",
            CraftSkeleton.class, "aE", EntitySkeleton.class);
    public static final GenerateEntityType<CraftSkeletonHorse> SKELETON_HORSE = new GenerateEntityType<>(
            "SkeletonHorse", "SKELETON_HORSE", CraftSkeletonHorse.class, "aF", EntityHorseSkeleton.class);
    public static final GenerateEntityType<CraftSlime> SLIME = new GenerateEntityType<>("Slime", "SLIME",
            CraftSlime.class, "aG", EntitySlime.class);
    public static final GenerateEntityType<CraftSmallFireball> SMALL_FIREBALL = new GenerateEntityType<>(
            "SmallFireball", "SMALL_FIREBALL", CraftSmallFireball.class, "aH", EntitySmallFireball.class);
    public static final GenerateEntityType<CraftSnowman> SNOWMAN = new GenerateEntityType<>("Snowman", "SNOWMAN",
            CraftSnowman.class, "aI", EntitySnowman.class);
    public static final GenerateEntityType<CraftSnowball> SNOWBALL = new GenerateEntityType<>("Snowball", "SNOWBALL",
            CraftSnowball.class, "aJ", EntitySnowball.class);
    public static final GenerateEntityType<CraftSpectralArrow> SPECTRAL_ARROW = new GenerateEntityType<>(
            "SpectralArrow", "SPECTRAL_ARROW", CraftSpectralArrow.class, "aK", EntitySpectralArrow.class);
    public static final GenerateEntityType<CraftSpider> SPIDER = new GenerateEntityType<>("Spider", "SPIDER",
            CraftSpider.class, "aL", EntitySpider.class);
    public static final GenerateEntityType<CraftSquid> SQUID = new GenerateEntityType<>("Squid", "SQUID",
            CraftSquid.class, "aM", EntitySquid.class);
    public static final GenerateEntityType<CraftStray> STRAY = new GenerateEntityType<>("Stray", "STRAY",
            CraftStray.class, "aN", EntitySkeletonStray.class);
    public static final GenerateEntityType<CraftStrider> STRIDER = new GenerateEntityType<>("Strider", "STRIDER",
            CraftStrider.class, "aO", EntityStrider.class);
    public static final GenerateEntityType<CraftTadpole> TADPOLE = new GenerateEntityType<>("Tadpole", "TADPOLE",
            CraftTadpole.class, "aP", Tadpole.class);
    public static final GenerateEntityType<CraftEgg> EGG = new GenerateEntityType<>("Egg", "EGG", CraftEgg.class, "aQ"
            , EntityEgg.class);
    public static final GenerateEntityType<CraftEnderPearl> ENDER_PEARL = new GenerateEntityType<>("EnderPearl",
            "ENDER_PEARL", CraftEnderPearl.class, "aR", EntityEnderPearl.class);
    public static final GenerateEntityType<CraftThrownExpBottle> THROWN_EXP_BOTTLE = new GenerateEntityType<>(
            "ThrownExpBottle", "THROWN_EXP_BOTTLE", CraftThrownExpBottle.class, "aS", EntityThrownExpBottle.class);
    public static final GenerateEntityType<CraftThrownPotion> THROWN_POTION = new GenerateEntityType<>("ThrownPotion"
            , "THROWN_POTION", CraftThrownPotion.class, "aT", EntityPotion.class);
    public static final GenerateEntityType<CraftTrident> TRIDENT = new GenerateEntityType<>("Trident", "TRIDENT",
            CraftTrident.class, "aU", EntityThrownTrident.class);
    public static final GenerateEntityType<CraftTraderLlama> TRADER_LLAMA = new GenerateEntityType<>("TraderLlama",
            "TRADER_LLAMA", CraftTraderLlama.class, "aV", EntityLlamaTrader.class);
    public static final GenerateEntityType<CraftTropicalFish> TROPICAL_FISH = new GenerateEntityType<>("TropicalFish"
            , "TROPICAL_FISH", CraftTropicalFish.class, "aW", EntityTropicalFish.class);
    public static final GenerateEntityType<CraftTurtle> TURTLE = new GenerateEntityType<>("Turtle", "TURTLE",
            CraftTurtle.class, "aX", EntityTurtle.class);
    public static final GenerateEntityType<CraftVex> VEX = new GenerateEntityType<>("Vex", "VEX", CraftVex.class, "aY"
            , EntityVex.class);
    public static final GenerateEntityType<CraftVillager> VILLAGER = new GenerateEntityType<>("Villager", "VILLAGER",
            CraftVillager.class, "aZ", EntityVillager.class);
    public static final GenerateEntityType<CraftVindicator> VINDICATOR = new GenerateEntityType<>("Vindicator",
            "VINDICATOR", CraftVindicator.class, "ba", EntityVindicator.class);
    public static final GenerateEntityType<CraftWanderingTrader> WANDERING_TRADER = new GenerateEntityType<>(
            "WanderingTrader", "WANDERING_TRADER", CraftWanderingTrader.class, "bb", EntityVillagerTrader.class);
    public static final GenerateEntityType<CraftWarden> WARDEN = new GenerateEntityType<>("Warden", "WARDEN",
            CraftWarden.class, "bc", Warden.class);
    public static final GenerateEntityType<CraftWitch> WITCH = new GenerateEntityType<>("Witch", "WITCH",
            CraftWitch.class, "bd", EntityWitch.class);
    public static final GenerateEntityType<CraftWither> WITHER = new GenerateEntityType<>("Wither", "WITHER",
            CraftWither.class, "be", EntityWither.class);
    public static final GenerateEntityType<CraftWitherSkeleton> WITHER_SKELETON = new GenerateEntityType<>(
            "WitherSkeleton", "WITHER_SKELETON", CraftWitherSkeleton.class, "bf", EntitySkeletonWither.class);
    public static final GenerateEntityType<CraftWitherSkull> WITHER_SKULL = new GenerateEntityType<>("WitherSkull",
            "WITHER_SKULL", CraftWitherSkull.class, "bg", EntityWitherSkull.class);
    public static final GenerateEntityType<CraftWolf> WOLF = new GenerateEntityType<>("Wolf", "WOLF", CraftWolf.class
            , "bh", EntityWolf.class);
    public static final GenerateEntityType<CraftZoglin> ZOGLIN = new GenerateEntityType<>("Zoglin", "ZOGLIN",
            CraftZoglin.class, "bi", EntityZoglin.class);
    public static final GenerateEntityType<CraftZombie> ZOMBIE = new GenerateEntityType<>("Zombie", "ZOMBIE",
            CraftZombie.class, "bj", EntityZombie.class);
    public static final GenerateEntityType<CraftZombieHorse> ZOMBIE_HORSE = new GenerateEntityType<>("ZombieHorse",
            "ZOMBIE_HORSE", CraftZombieHorse.class, "bk", EntityHorseZombie.class);
    public static final GenerateEntityType<CraftVillagerZombie> VILLAGER_ZOMBIE = new GenerateEntityType<>(
            "VillagerZombie", "VILLAGER_ZOMBIE", CraftVillagerZombie.class, "bl", EntityZombieVillager.class);
    public static final GenerateEntityType<CraftPigZombie> PIG_ZOMBIE = new GenerateEntityType<>("PigZombie",
            "PIG_ZOMBIE", CraftPigZombie.class, "bm", EntityPigZombie.class);
    public static final GenerateEntityType<CraftHumanEntity> HUMAN_ENTITY = new GenerateEntityType<>("HumanEntity",
            "HUMAN_ENTITY", CraftHumanEntity.class, "bn", EntityHuman.class);
    public static final GenerateEntityType<CraftFishHook> FISH_HOOK = new GenerateEntityType<>("FishHook", "FISH_HOOK"
            , CraftFishHook.class, "bo", EntityFishingHook.class);

    public static final List<GenerateEntityType<?>> TYPES = new LinkedList<>();

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
    private final String nmsTypeName;
    private final Class<? extends Entity> nmsClass;

    public GenerateEntityType(String name, String bukkitTypeName, Class<BukkitClass> bukkitClass, String nsmTypeName,
                              Class<? extends Entity> nmsClass) {
        this.name = name;
        this.bukkitTypeName = bukkitTypeName;
        this.bukkitClass = bukkitClass;
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

    public String getNmsTypeName() {
        return nmsTypeName;
    }

    public Class<? extends Entity> getNmsClass() {
        return nmsClass;
    }

}
