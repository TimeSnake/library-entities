package de.timesnake.library.entities_generator;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.EntityBat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
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
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.EntityVillagerTrader;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.vehicle.*;
import org.bukkit.craftbukkit.v1_18_R2.entity.*;

import java.util.ArrayList;
import java.util.List;

public class GenerateEntityType<BukkitClass extends CraftEntity> {

    public static final GenerateEntityType<CraftAreaEffectCloud> AREA_EFFECT_CLOUD = new GenerateEntityType<>(
            "AreaEffectCloud", "AREA_EFFECT_CLOUD", CraftAreaEffectCloud.class, "b", EntityAreaEffectCloud.class);
    public static final GenerateEntityType<CraftArmorStand> ARMOR_STAND = new GenerateEntityType<>("ArmorStand",
            "ARMOR_STAND", CraftArmorStand.class, "c", EntityArmorStand.class);
    public static final GenerateEntityType<CraftTippedArrow> TIPPED_ARROW = new GenerateEntityType<>("TippedArrow",
            "TIPPED_ARROW", CraftTippedArrow.class, "d", EntityTippedArrow.class);
    public static final GenerateEntityType<CraftAxolotl> AXOLOTL = new GenerateEntityType<>("Axolotl", "AXOLOTL",
            CraftAxolotl.class, "e", Axolotl.class);
    public static final GenerateEntityType<CraftBat> BAT = new GenerateEntityType<>("Bat", "BAT", CraftBat.class, "f"
            , EntityBat.class);
    public static final GenerateEntityType<CraftBee> BEE = new GenerateEntityType<>("Bee", "BEE", CraftBee.class, "g"
            , EntityBee.class);
    public static final GenerateEntityType<CraftBlaze> BLAZE = new GenerateEntityType<>("Blaze", "BLAZE",
            CraftBlaze.class, "h", EntityBlaze.class);
    public static final GenerateEntityType<CraftBoat> BOAT = new GenerateEntityType<>("Boat", "BOAT", CraftBoat.class
            , "i", EntityBoat.class);
    public static final GenerateEntityType<CraftCat> CAT = new GenerateEntityType<>("Cat", "CAT", CraftCat.class, "j"
            , EntityCat.class);
    public static final GenerateEntityType<CraftCaveSpider> CAVE_SPIDER = new GenerateEntityType<>("CaveSpider",
            "CAVE_SPIDER", CraftCaveSpider.class, "k", EntityCaveSpider.class);
    public static final GenerateEntityType<CraftChicken> CHICKEN = new GenerateEntityType<>("Chicken", "CHICKEN",
            CraftChicken.class, "l", EntityChicken.class);
    public static final GenerateEntityType<CraftCod> COD = new GenerateEntityType<>("Cod", "COD", CraftCod.class, "m"
            , EntityCod.class);
    public static final GenerateEntityType<CraftCow> COW = new GenerateEntityType<>("Cow", "COW", CraftCow.class, "n"
            , EntityCow.class);
    public static final GenerateEntityType<CraftCreeper> CREEPER = new GenerateEntityType<>("Creeper", "CREEPER",
            CraftCreeper.class, "o", EntityCreeper.class);
    public static final GenerateEntityType<CraftDolphin> DOLPHIN = new GenerateEntityType<>("Dolphin", "DOLPHIN",
            CraftDolphin.class, "p", EntityDolphin.class);
    public static final GenerateEntityType<CraftDonkey> DONKEY = new GenerateEntityType<>("Donkey", "DONKEY",
            CraftDonkey.class, "q", EntityHorseDonkey.class);
    public static final GenerateEntityType<CraftDragonFireball> DRAGON_FIREBALL = new GenerateEntityType<>(
            "DragonFireball", "DRAGON_FIREBALL", CraftDragonFireball.class, "r", EntityDragonFireball.class);
    public static final GenerateEntityType<CraftDrowned> DROWNED = new GenerateEntityType<>("Drowned", "DROWNED",
            CraftDrowned.class, "s", EntityDrowned.class);
    public static final GenerateEntityType<CraftElderGuardian> ELDER_GUARDIAN = new GenerateEntityType<>(
            "ElderGuardian", "ELDER_GUARDIAN", CraftElderGuardian.class, "t", EntityGuardianElder.class);
    public static final GenerateEntityType<CraftEnderCrystal> ENDER_CRYSTAL = new GenerateEntityType<>("EnderCrystal"
            , "ENDER_CRYSTAL", CraftEnderCrystal.class, "u", EntityEnderCrystal.class);
    public static final GenerateEntityType<CraftEnderDragon> ENDER_DRAGON = new GenerateEntityType<>("EnderDragon",
            "ENDER_DRAGON", CraftEnderDragon.class, "v", EntityEnderDragon.class);
    public static final GenerateEntityType<CraftEnderman> ENDERMAN = new GenerateEntityType<>("Enderman", "ENDERMAN",
            CraftEnderman.class, "w", EntityEnderman.class);
    public static final GenerateEntityType<CraftEndermite> ENDERMITE = new GenerateEntityType<>("Endermite",
            "ENDERMITE", CraftEndermite.class, "x", EntityEndermite.class);
    public static final GenerateEntityType<CraftEvoker> EVOKER = new GenerateEntityType<>("Evoker", "EVOKER",
            CraftEvoker.class, "y", EntityEvoker.class);
    public static final GenerateEntityType<CraftEvokerFangs> EVOKER_FANGS = new GenerateEntityType<>("EvokerFangs",
            "EVOKER_FANGS", CraftEvokerFangs.class, "z", EntityEvokerFangs.class);
    public static final GenerateEntityType<CraftExperienceOrb> EXPERIENCE_ORB = new GenerateEntityType<>(
            "ExperienceOrb", "EXPERIENCE_ORB", CraftExperienceOrb.class, "A", EntityExperienceOrb.class);
    public static final GenerateEntityType<CraftEnderSignal> ENDER_SIGNAL = new GenerateEntityType<>("EnderSignal",
            "ENDER_SIGNAL", CraftEnderSignal.class, "B", EntityEnderSignal.class);
    public static final GenerateEntityType<CraftFallingBlock> FALLING_BLOCK = new GenerateEntityType<>("FallingBlock"
            , "FALLING_BLOCK", CraftFallingBlock.class, "C", EntityFallingBlock.class);
    public static final GenerateEntityType<CraftFirework> FIREWORK = new GenerateEntityType<>("Firework", "FIREWORK",
            CraftFirework.class, "D", EntityFireworks.class);
    public static final GenerateEntityType<CraftFox> FOX = new GenerateEntityType<>("Fox", "FOX", CraftFox.class, "E"
            , EntityFox.class);
    public static final GenerateEntityType<CraftGhast> GHAST = new GenerateEntityType<>("Ghast", "GHAST",
            CraftGhast.class, "F", EntityGhast.class);
    public static final GenerateEntityType<CraftGiant> GIANT = new GenerateEntityType<>("Giant", "GIANT",
            CraftGiant.class, "G", EntityGiantZombie.class);
    public static final GenerateEntityType<CraftGlowItemFrame> GLOW_ITEM_FRAME = new GenerateEntityType<>(
            "GlowItemFrame", "GLOW_ITEM_FRAME", CraftGlowItemFrame.class, "H", GlowItemFrame.class);
    public static final GenerateEntityType<CraftGlowSquid> GLOW_SQUID = new GenerateEntityType<>("GlowSquid",
            "GLOW_SQUID", CraftGlowSquid.class, "I", GlowSquid.class);
    public static final GenerateEntityType<CraftGoat> GOAT = new GenerateEntityType<>("Goat", "GOAT", CraftGoat.class
            , "J", Goat.class);
    public static final GenerateEntityType<CraftGuardian> GUARDIAN = new GenerateEntityType<>("Guardian", "GUARDIAN",
            CraftGuardian.class, "K", EntityGuardian.class);
    public static final GenerateEntityType<CraftHoglin> HOGLIN = new GenerateEntityType<>("Hoglin", "HOGLIN",
            CraftHoglin.class, "L", EntityHoglin.class);
    public static final GenerateEntityType<CraftHorse> HORSE = new GenerateEntityType<>("Horse", "HORSE",
            CraftHorse.class, "M", EntityHorse.class);
    public static final GenerateEntityType<CraftHusk> HUSK = new GenerateEntityType<>("Husk", "HUSK", CraftHusk.class
            , "N", EntityZombieHusk.class);
    public static final GenerateEntityType<CraftIllusioner> ILLUSIONER = new GenerateEntityType<>("Illusioner",
            "ILLUSIONER", CraftIllusioner.class, "O", EntityIllagerIllusioner.class);
    public static final GenerateEntityType<CraftIronGolem> IRON_GOLEM = new GenerateEntityType<>("IronGolem",
            "IRON_GOLEM", CraftIronGolem.class, "P", EntityIronGolem.class);
    public static final GenerateEntityType<CraftItem> ITEM = new GenerateEntityType<>("Item", "ITEM", CraftItem.class
            , "Q", EntityItem.class);
    public static final GenerateEntityType<CraftItemFrame> ITEM_FRAME = new GenerateEntityType<>("ItemFrame",
            "ITEM_FRAME", CraftItemFrame.class, "R", EntityItemFrame.class);
    public static final GenerateEntityType<CraftLargeFireball> LARGE_FIREBALL = new GenerateEntityType<>(
            "LargeFireball", "LARGE_FIREBALL", CraftLargeFireball.class, "S", EntityLargeFireball.class);
    public static final GenerateEntityType<CraftLeash> LEASH = new GenerateEntityType<>("Leash", "LEASH",
            CraftLeash.class, "T", EntityLeash.class);
    public static final GenerateEntityType<CraftLightningStrike> LIGHTNING_STRIKE = new GenerateEntityType<>(
            "LightningStrike", "LIGHTNING_STRIKE", CraftLightningStrike.class, "U", EntityLightning.class);
    public static final GenerateEntityType<CraftLlama> LLAMA = new GenerateEntityType<>("Llama", "LLAMA",
            CraftLlama.class, "V", EntityLlama.class);
    public static final GenerateEntityType<CraftLlamaSpit> LLAMA_SPIT = new GenerateEntityType<>("LlamaSpit",
            "LLAMA_SPIT", CraftLlamaSpit.class, "W", EntityLlamaSpit.class);
    public static final GenerateEntityType<CraftMagmaCube> MAGMA_CUBE = new GenerateEntityType<>("MagmaCube",
            "MAGMA_CUBE", CraftMagmaCube.class, "X", EntityMagmaCube.class);
    public static final GenerateEntityType<CraftMarker> MARKER = new GenerateEntityType<>("Marker", "MARKER",
            CraftMarker.class, "Y", Marker.class);
    public static final GenerateEntityType<CraftMinecartRideable> MINECART_RIDEABLE = new GenerateEntityType<>(
            "MinecartRideable", "MINECART_RIDEABLE", CraftMinecartRideable.class, "Z", EntityMinecartRideable.class);
    public static final GenerateEntityType<CraftMinecartChest> MINECART_CHEST = new GenerateEntityType<>(
            "MinecartChest", "MINECART_CHEST", CraftMinecartChest.class, "aa", EntityMinecartChest.class);
    public static final GenerateEntityType<CraftMinecartCommand> MINECART_COMMAND = new GenerateEntityType<>(
            "MinecartCommand", "MINECART_COMMAND", CraftMinecartCommand.class, "ab", EntityMinecartCommandBlock.class);
    public static final GenerateEntityType<CraftMinecartFurnace> MINECART_FURNACE = new GenerateEntityType<>(
            "MinecartFurnace", "MINECART_FURNACE", CraftMinecartFurnace.class, "ac", EntityMinecartFurnace.class);
    public static final GenerateEntityType<CraftMinecartHopper> MINECART_HOPPER = new GenerateEntityType<>(
            "MinecartHopper", "MINECART_HOPPER", CraftMinecartHopper.class, "ad", EntityMinecartHopper.class);
    //  public static final GenerateEntityType<CraftMinecartContainer> MINECART_CONTAINER = new GenerateEntityType<>
    //  ("MinecartContainer", "MINECART_CONTAINER", CraftMinecartContainer.class, "ae", EntityMinecartMobSpawner.class);
    //  public static final GenerateEntityType<CraftMinecartContainer> MINECART_CONTAINER = new GenerateEntityType<>
    //  ("MinecartContainer", "MINECART_CONTAINER", CraftMinecartContainer.class, "af", EntityMinecartTNT.class);
    public static final GenerateEntityType<CraftMule> MULE = new GenerateEntityType<>("Mule", "MULE", CraftMule.class
            , "ag", EntityHorseMule.class);
    public static final GenerateEntityType<CraftMushroomCow> MUSHROOM_COW = new GenerateEntityType<>("MushroomCow",
            "MUSHROOM_COW", CraftMushroomCow.class, "ah", EntityMushroomCow.class);
    public static final GenerateEntityType<CraftOcelot> OCELOT = new GenerateEntityType<>("Ocelot", "OCELOT",
            CraftOcelot.class, "ai", EntityOcelot.class);
    public static final GenerateEntityType<CraftPainting> PAINTING = new GenerateEntityType<>("Painting", "PAINTING",
            CraftPainting.class, "aj", EntityPainting.class);
    public static final GenerateEntityType<CraftPanda> PANDA = new GenerateEntityType<>("Panda", "PANDA",
            CraftPanda.class, "ak", EntityPanda.class);
    public static final GenerateEntityType<CraftParrot> PARROT = new GenerateEntityType<>("Parrot", "PARROT",
            CraftParrot.class, "al", EntityParrot.class);
    public static final GenerateEntityType<CraftPhantom> PHANTOM = new GenerateEntityType<>("Phantom", "PHANTOM",
            CraftPhantom.class, "am", EntityPhantom.class);
    public static final GenerateEntityType<CraftPig> PIG = new GenerateEntityType<>("Pig", "PIG", CraftPig.class, "an"
            , EntityPig.class);
    public static final GenerateEntityType<CraftPiglin> PIGLIN = new GenerateEntityType<>("Piglin", "PIGLIN",
            CraftPiglin.class, "ao", EntityPiglin.class);
    public static final GenerateEntityType<CraftPiglinBrute> PIGLIN_BRUTE = new GenerateEntityType<>("PiglinBrute",
            "PIGLIN_BRUTE", CraftPiglinBrute.class, "ap", EntityPiglinBrute.class);
    public static final GenerateEntityType<CraftPillager> PILLAGER = new GenerateEntityType<>("Pillager", "PILLAGER",
            CraftPillager.class, "aq", EntityPillager.class);
    public static final GenerateEntityType<CraftPolarBear> POLAR_BEAR = new GenerateEntityType<>("PolarBear",
            "POLAR_BEAR", CraftPolarBear.class, "ar", EntityPolarBear.class);
    public static final GenerateEntityType<CraftTNTPrimed> TNT_PRIMED = new GenerateEntityType<>("TNTPrimed",
            "TNT_PRIMED", CraftTNTPrimed.class, "as", EntityTNTPrimed.class);
    public static final GenerateEntityType<CraftPufferFish> PUFFER_FISH = new GenerateEntityType<>("PufferFish",
            "PUFFER_FISH", CraftPufferFish.class, "at", EntityPufferFish.class);
    public static final GenerateEntityType<CraftRabbit> RABBIT = new GenerateEntityType<>("Rabbit", "RABBIT",
            CraftRabbit.class, "au", EntityRabbit.class);
    public static final GenerateEntityType<CraftRavager> RAVAGER = new GenerateEntityType<>("Ravager", "RAVAGER",
            CraftRavager.class, "av", EntityRavager.class);
    public static final GenerateEntityType<CraftSalmon> SALMON = new GenerateEntityType<>("Salmon", "SALMON",
            CraftSalmon.class, "aw", EntitySalmon.class);
    public static final GenerateEntityType<CraftSheep> SHEEP = new GenerateEntityType<>("Sheep", "SHEEP",
            CraftSheep.class, "ax", EntitySheep.class);
    public static final GenerateEntityType<CraftShulker> SHULKER = new GenerateEntityType<>("Shulker", "SHULKER",
            CraftShulker.class, "ay", EntityShulker.class);
    public static final GenerateEntityType<CraftShulkerBullet> SHULKER_BULLET = new GenerateEntityType<>(
            "ShulkerBullet", "SHULKER_BULLET", CraftShulkerBullet.class, "az", EntityShulkerBullet.class);
    public static final GenerateEntityType<CraftSilverfish> SILVERFISH = new GenerateEntityType<>("Silverfish",
            "SILVERFISH", CraftSilverfish.class, "aA", EntitySilverfish.class);
    public static final GenerateEntityType<CraftSkeleton> SKELETON = new GenerateEntityType<>("Skeleton", "SKELETON",
            CraftSkeleton.class, "aB", EntitySkeleton.class);
    public static final GenerateEntityType<CraftSkeletonHorse> SKELETON_HORSE = new GenerateEntityType<>(
            "SkeletonHorse", "SKELETON_HORSE", CraftSkeletonHorse.class, "aC", EntityHorseSkeleton.class);
    public static final GenerateEntityType<CraftSlime> SLIME = new GenerateEntityType<>("Slime", "SLIME",
            CraftSlime.class, "aD", EntitySlime.class);
    public static final GenerateEntityType<CraftSmallFireball> SMALL_FIREBALL = new GenerateEntityType<>(
            "SmallFireball", "SMALL_FIREBALL", CraftSmallFireball.class, "aE", EntitySmallFireball.class);
    public static final GenerateEntityType<CraftSnowman> SNOWMAN = new GenerateEntityType<>("Snowman", "SNOWMAN",
            CraftSnowman.class, "aF", EntitySnowman.class);
    public static final GenerateEntityType<CraftSnowball> SNOWBALL = new GenerateEntityType<>("Snowball", "SNOWBALL",
            CraftSnowball.class, "aG", EntitySnowball.class);
    public static final GenerateEntityType<CraftSpectralArrow> SPECTRAL_ARROW = new GenerateEntityType<>(
            "SpectralArrow", "SPECTRAL_ARROW", CraftSpectralArrow.class, "aH", EntitySpectralArrow.class);
    public static final GenerateEntityType<CraftSpider> SPIDER = new GenerateEntityType<>("Spider", "SPIDER",
            CraftSpider.class, "aI", EntitySpider.class);
    public static final GenerateEntityType<CraftSquid> SQUID = new GenerateEntityType<>("Squid", "SQUID",
            CraftSquid.class, "aJ", EntitySquid.class);
    public static final GenerateEntityType<CraftStray> STRAY = new GenerateEntityType<>("Stray", "STRAY",
            CraftStray.class, "aK", EntitySkeletonStray.class);
    public static final GenerateEntityType<CraftStrider> STRIDER = new GenerateEntityType<>("Strider", "STRIDER",
            CraftStrider.class, "aL", EntityStrider.class);
    public static final GenerateEntityType<CraftEgg> EGG = new GenerateEntityType<>("Egg", "EGG", CraftEgg.class, "aM"
            , EntityEgg.class);
    public static final GenerateEntityType<CraftEnderPearl> ENDER_PEARL = new GenerateEntityType<>("EnderPearl",
            "ENDER_PEARL", CraftEnderPearl.class, "aN", EntityEnderPearl.class);
    public static final GenerateEntityType<CraftThrownExpBottle> THROWN_EXP_BOTTLE = new GenerateEntityType<>(
            "ThrownExpBottle", "THROWN_EXP_BOTTLE", CraftThrownExpBottle.class, "aO", EntityThrownExpBottle.class);
    public static final GenerateEntityType<CraftThrownPotion> THROWN_POTION = new GenerateEntityType<>("ThrownPotion"
            , "THROWN_POTION", CraftThrownPotion.class, "aP", EntityPotion.class);
    public static final GenerateEntityType<CraftTrident> TRIDENT = new GenerateEntityType<>("Trident", "TRIDENT",
            CraftTrident.class, "aQ", EntityThrownTrident.class);
    public static final GenerateEntityType<CraftTraderLlama> TRADER_LLAMA = new GenerateEntityType<>("TraderLlama",
            "TRADER_LLAMA", CraftTraderLlama.class, "aR", EntityLlamaTrader.class);
    public static final GenerateEntityType<CraftTropicalFish> TROPICAL_FISH = new GenerateEntityType<>("TropicalFish"
            , "TROPICAL_FISH", CraftTropicalFish.class, "aS", EntityTropicalFish.class);
    public static final GenerateEntityType<CraftTurtle> TURTLE = new GenerateEntityType<>("Turtle", "TURTLE",
            CraftTurtle.class, "aT", EntityTurtle.class);
    public static final GenerateEntityType<CraftVex> VEX = new GenerateEntityType<>("Vex", "VEX", CraftVex.class, "aU"
            , EntityVex.class);
    public static final GenerateEntityType<CraftVillager> VILLAGER = new GenerateEntityType<>("Villager", "VILLAGER",
            CraftVillager.class, "aV", EntityVillager.class);
    public static final GenerateEntityType<CraftVindicator> VINDICATOR = new GenerateEntityType<>("Vindicator",
            "VINDICATOR", CraftVindicator.class, "aW", EntityVindicator.class);
    public static final GenerateEntityType<CraftWanderingTrader> WANDERING_TRADER = new GenerateEntityType<>(
            "WanderingTrader", "WANDERING_TRADER", CraftWanderingTrader.class, "aX", EntityVillagerTrader.class);
    public static final GenerateEntityType<CraftWitch> WITCH = new GenerateEntityType<>("Witch", "WITCH",
            CraftWitch.class, "aY", EntityWitch.class);
    public static final GenerateEntityType<CraftWither> WITHER = new GenerateEntityType<>("Wither", "WITHER",
            CraftWither.class, "aZ", EntityWither.class);
    public static final GenerateEntityType<CraftWitherSkeleton> WITHER_SKELETON = new GenerateEntityType<>(
            "WitherSkeleton", "WITHER_SKELETON", CraftWitherSkeleton.class, "ba", EntitySkeletonWither.class);
    public static final GenerateEntityType<CraftWitherSkull> WITHER_SKULL = new GenerateEntityType<>("WitherSkull",
            "WITHER_SKULL", CraftWitherSkull.class, "bb", EntityWitherSkull.class);
    public static final GenerateEntityType<CraftWolf> WOLF = new GenerateEntityType<>("Wolf", "WOLF", CraftWolf.class
            , "bc", EntityWolf.class);
    public static final GenerateEntityType<CraftZoglin> ZOGLIN = new GenerateEntityType<>("Zoglin", "ZOGLIN",
            CraftZoglin.class, "bd", EntityZoglin.class);
    public static final GenerateEntityType<CraftZombie> ZOMBIE = new GenerateEntityType<>("Zombie", "ZOMBIE",
            CraftZombie.class, "be", EntityZombie.class);
    public static final GenerateEntityType<CraftZombieHorse> ZOMBIE_HORSE = new GenerateEntityType<>("ZombieHorse",
            "ZOMBIE_HORSE", CraftZombieHorse.class, "bf", EntityHorseZombie.class);
    public static final GenerateEntityType<CraftVillagerZombie> VILLAGER_ZOMBIE = new GenerateEntityType<>(
            "VillagerZombie", "VILLAGER_ZOMBIE", CraftVillagerZombie.class, "bg", EntityZombieVillager.class);
    public static final GenerateEntityType<CraftPigZombie> PIG_ZOMBIE = new GenerateEntityType<>("PigZombie",
            "PIG_ZOMBIE", CraftPigZombie.class, "bh", EntityPigZombie.class);
    public static final GenerateEntityType<CraftHumanEntity> HUMAN_ENTITY = new GenerateEntityType<>("HumanEntity",
            "HUMAN_ENTITY", CraftHumanEntity.class, "bi", EntityHuman.class);
    public static final GenerateEntityType<CraftFishHook> FISH_HOOK = new GenerateEntityType<>("FishHook", "FISH_HOOK"
            , CraftFishHook.class, "bj", EntityFishingHook.class);

    public static final List<GenerateEntityType<?>> TYPES = new ArrayList<>();

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
        TYPES.add(MINECART_CHEST);
        TYPES.add(MINECART_COMMAND);
        TYPES.add(MINECART_FURNACE);
        TYPES.add(MINECART_HOPPER);
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
