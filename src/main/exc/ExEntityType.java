package de.timesnake.basic.entities.entity;

import de.timesnake.basic.entities.utils.RefUtil;

import java.util.List;

public class ExEntityType<Type extends ExEntity> {


    // area cloud effect
    public static final ExEntityType<ExEntityArmorStand> ARMOR_STAND;
    public static final ExEntityType<ExEntityBat> BAT;
    public static final ExEntityType<ExEntityBee> BEE;
    public static final ExEntityType<ExEntityBlaze> BLAZE;
    public static final ExEntityType<ExEntityCat> CAT;
    public static final ExEntityType<ExEntityCaveSpider> CAVE_SPIDER;
    public static final ExEntityType<ExEntityChicken> CHICKEN;
    public static final ExEntityType<ExEntityCod> COD;
    public static final ExEntityType<ExEntityCow> COW;
    public static final ExEntityType<ExEntityCreeper> CREEPER;
    public static final ExEntityType<ExEntityDolphin> DOLPHIN;
    public static final ExEntityType<ExEntityHorseDonkey> DONKEY;
    public static final ExEntityType<ExEntityDragonFireball> DRAGON_FIREBALL;
    public static final ExEntityType<ExEntityDrowned> DROWNED;
    public static final ExEntityType<ExEntityGuardianElder> ELDER_GUARDIAN;
    public static final ExEntityType<ExEntityEnderCrystal> END_CRYSTAL;
    public static final ExEntityType<ExEntityEnderDragon> ENDER_DRAGON;
    public static final ExEntityType<ExEntityEnderman> ENDERMAN;
    public static final ExEntityType<ExEntityEndermite> ENDERMITE;
    public static final ExEntityType<ExEntityEvoker> EVOKER;
    public static final ExEntityType<ExEntityEvokerFangs> EVOKER_FANGS;
    public static final ExEntityType<ExEntityExperienceOrb> EXPERIENCE_ORB;
    public static final ExEntityType<ExEntityEnderSignal> EYE_OF_ENDER;
    public static final ExEntityType<ExEntityFallingBlock> FALLING_BLOCK;
    public static final ExEntityType<ExEntityFireworks> FIREWORK_ROCKET;
    public static final ExEntityType<ExEntityFox> FOX;
    public static final ExEntityType<ExEntityGhast> GHAST;
    public static final ExEntityType<ExEntityGiantZombie> GIANT;
    public static final ExEntityType<ExEntityGuardian> GUARDIAN;
    public static final ExEntityType<ExEntityHoglin> HOGLIN;
    public static final ExEntityType<ExEntityHorse> HORSE;
    public static final ExEntityType<ExEntityZombieHusk> HUSK;
    public static final ExEntityType<ExEntityIllagerIllusioner> ILLUSIONER;
    public static final ExEntityType<ExEntityIronGolem> IRON_GOLEM;
    public static final ExEntityType<ExEntityItem> ITEM;
    public static final ExEntityType<ExEntityItemFrame> ITEM_FRAME;
    public static final ExEntityType<ExEntityLargeFireball> FIREBALL;
    public static final ExEntityType<ExEntityLeash> LEASH_KNOT;
    public static final ExEntityType<ExEntityLightning> LIGHTNING_BOLT;
    public static final ExEntityType<ExEntityLlama> LLAMA;
    public static final ExEntityType<ExEntityLlamaSpit> LLAMA_SPIT;
    public static final ExEntityType<ExEntityMagmaCube> MAGMA_CUBE;
    public static final ExEntityType<ExEntityMinecartRideable> MINECART;
    public static final ExEntityType<ExEntityMinecartChest> CHEST_MINECART;
    public static final ExEntityType<ExEntityMinecartCommandBlock> COMMAND_BLOCK_MINECART;
    public static final ExEntityType<ExEntityMinecartFurnace> FURNACE_MINECART;
    public static final ExEntityType<ExEntityMinecartHopper> HOPPER_MINECART;
    public static final ExEntityType<ExEntityMinecartMobSpawner> SPAWNER_MINECART;
    public static final ExEntityType<ExEntityMinecartTNT> TNT_MINECART;
    public static final ExEntityType<ExEntityHorseMule> MULE;
    public static final ExEntityType<ExEntityMushroomCow> MOOSHROOM;
    public static final ExEntityType<ExEntityOcelot> OCELOT;
    public static final ExEntityType<ExEntityPainting> PAINTING;
    public static final ExEntityType<ExEntityPanda> PANDA;
    public static final ExEntityType<ExEntityParrot> PARROT;
    public static final ExEntityType<ExEntityPhantom> PHANTOM;
    public static final ExEntityType<ExEntityPig> PIG;
    public static final ExEntityType<ExEntityPiglin> PIGLIN;
    public static final ExEntityType<ExEntityPiglinBrute> PIGLIN_BRUTE;
    public static final ExEntityType<ExEntityPillager> PILLAGER;
    public static final ExEntityType<ExEntityPolarBear> POLAR_BEAR;
    public static final ExEntityType<ExEntityTNTPrimed> TNT;
    public static final ExEntityType<ExEntityPufferFish> PUFFERFISH;
    //public static final ExEntityType<ExEntityRabbit> RABBIT = new ExEntityType<>(EntityTypes.RABBIT, EntityRabbit.class);
    //public static final ExEntityType<ExEntityRavager> RAVAGER = new ExEntityType<>(EntityTypes.RAVAGER, EntityRavager.class);
    //public static final ExEntityType<ExEntitySalmon> SALMON = new ExEntityType<>(EntityTypes.SALMON, EntitySalmon.class);
    //public static final ExEntityType<ExEntitySheep> SHEEP = new ExEntityType<>(EntityTypes.SHEEP, EntitySheep.class);
    //public static final ExEntityType<ExEntityShulker> SHULKER = new ExEntityType<>(EntityTypes.SHULKER, EntityShulker.class);
    //public static final ExEntityType<ExEntityShulkerBullet> SHULKER_BULLET = new ExEntityType<>(EntityTypes.SHULKER_BULLET, EntityShulkerBullet.class);
    public static final ExEntityType<ExEntitySilverfish> SILVERFISH;
    public static final ExEntityType<ExEntitySkeleton> SKELETON;
    public static final ExEntityType<ExEntityHorseSkeleton> SKELETON_HORSE;
    public static final ExEntityType<ExEntitySlime> SLIME;
    public static final ExEntityType<ExEntitySmallFireball> SMALL_FIREBALL;
    public static final ExEntityType<ExEntitySnowman> SNOW_GOLEM;
    //public static final ExEntityType<ExEntitySnowball> SNOWBALL = new ExEntityType<>(EntityTypes.SNOWBALL, EntitySnowball.class);
    //public static final ExEntityType<ExEntitySpectralArrow> SPECTRAL_ARROW = new ExEntityType<>(EntityTypes.SPECTRAL_ARROW, EntitySpectralArrow.class);
    public static final ExEntityType<ExEntitySpider> SPIDER;
    //public static final ExEntityType<ExEntitySquid> SQUID = new ExEntityType<>(EntityTypes.SQUID, EntitySquid.class);
    public static final ExEntityType<ExEntitySkeletonStray> STRAY;
    public static final ExEntityType<ExEntityStrider> STRIDER;
    //public static final ExEntityType<ExEntityEgg> EGG = new ExEntityType<>(EntityTypes.EGG, EntityEgg.class);
    //public static final ExEntityType<ExEntityEnderPearl> ENDER_PEARL = new ExEntityType<>(EntityTypes.ENDER_PEARL, EntityEnderPearl.class);
    //public static final ExEntityType<ExEntityThrownExpBottle> EXPERIENCE_BOTTLE = new ExEntityType<>(EntityTypes.EXPERIENCE_BOTTLE, EntityThrownExpBottle.class);
    //public static final ExEntityType<ExEntityPotion> POTION = new ExEntityType<>(EntityTypes.POTION, EntityPotion.class);
    //public static final ExEntityType<ExEntityThrownTrident> TRIDENT = new ExEntityType<>(EntityTypes.TRIDENT, EntityThrownTrident.class);
    //public static final ExEntityType<ExEntityLlamaTrader> TRADER_LLAMA = new ExEntityType<>(EntityTypes.TRADER_LLAMA, EntityLlamaTrader.class);
    //public static final ExEntityType<ExEntityTropicalFish> TROPICAL_FISH = new ExEntityType<>(EntityTypes.TROPICAL_FISH, EntityTropicalFish.class);
    //public static final ExEntityType<ExEntityTurtle> TURTLE = new ExEntityType<>(EntityTypes.TURTLE, EntityTurtle.class);
    //public static final ExEntityType<ExEntityVex> VEX = new ExEntityType<>(EntityTypes.VEX, EntityVex.class);
    public static final ExEntityType<ExEntityVillager> VILLAGER;
    public static final ExEntityType<ExEntityVindicator> VINDICATOR;
    //public static final ExEntityType<ExEntityVillagerTrader> WANDERING_TRADER = new ExEntityType<>(EntityTypes.WANDERING_TRADER, EntityVillagerTrader.class);
    public static final ExEntityType<ExEntityWitch> WITCH;
    //public static final ExEntityType<ExEntityWither> WITHER = new ExEntityType<>(EntityTypes.WITHER, EntityWither.class);
    public static final ExEntityType<ExEntitySkeletonWither> WITHER_SKELETON;
    //public static final ExEntityType<ExEntityWitherSkull> WITHER_SKULL = new ExEntityType<>(EntityTypes.WITHER_SKULL, EntityWitherSkull.class);
    public static final ExEntityType<ExEntityWolf> WOLF;
    //public static final ExEntityType<ExEntityZoglin> ZOGLIN = new ExEntityType<>(EntityTypes.ZOGLIN, EntityZoglin.class);
    public static final ExEntityType<ExEntityZombie> ZOMBIE;
    //public static final ExEntityType<ExEntityHorseZombie> ZOMBIE_HORSE = new ExEntityType<>(EntityTypes.ZOMBIE_HORSE, EntityHorseZombie.class);
    public static final ExEntityType<ExEntityZombieVillager> ZOMBIE_VILLAGER;
    //public static final ExEntityType<ExEntityPigZombie> ZOMBIFIED_PIGLIN = new ExEntityType<>(EntityTypes.ZOMBIFIED_PIGLIN, EntityPigZombie.class);
    public static final ExEntityType<ExEntityHuman> PLAYER;
    //public static final ExEntityType<ExEntityFishingHook> FISHING_BOBBER = new ExEntityType<>(EntityTypes.FISHING_BOBBER, EntityFishingHook.class);

    static {
        ARMOR_STAND = new ExEntityType<>("ARMOR_STAND", "EntityArmorStand", ExEntityArmorStand.class);
        BAT = new ExEntityType<>("BAT", "EntityBat", ExEntityBat.class);
        BEE = new ExEntityType<>("BEE", "EntityBee", ExEntityBee.class);
        BLAZE = new ExEntityType<>("BLAZE", "EntityBlaze", ExEntityBlaze.class);
        CAT = new ExEntityType<>("CAT", "EntityCat", ExEntityCat.class);
        CAVE_SPIDER = new ExEntityType<>("CAVE_SPIDER", "EntityCaveSpider", ExEntityCaveSpider.class);
        CHICKEN = new ExEntityType<>("CHICKEN", "EntityChicken", ExEntityChicken.class);
        COD = new ExEntityType<>("COD", "EntityCod", ExEntityCod.class);
        COW = new ExEntityType<>("COW", "EntityCow", ExEntityCow.class);
        CREEPER = new ExEntityType<>("CREEPER", "EntityCreeper", ExEntityCreeper.class);
        DOLPHIN = new ExEntityType<>("DOLPHIN", "EntityDolphin", ExEntityDolphin.class);
        DONKEY = new ExEntityType<>("DONKEY", "EntityDonkey", ExEntityHorseDonkey.class);
        DRAGON_FIREBALL = new ExEntityType<>("DRAGON_FIREBALL", "EntityDragonFireball", ExEntityDragonFireball.class);
        DROWNED = new ExEntityType<>("DROWNED", "EntityDrowned", ExEntityDrowned.class);
        ELDER_GUARDIAN = new ExEntityType<>("ELDER_GUARDIAN", "EntityGuardianElder", ExEntityGuardianElder.class);
        END_CRYSTAL = new ExEntityType<>("END_CRYSTAL", "EntityEnderCrystal", ExEntityEnderCrystal.class);
        ENDER_DRAGON = new ExEntityType<>("ENDER_DRAGON", "EntityEnderDragon", ExEntityEnderDragon.class);
        ENDERMAN = new ExEntityType<>("ENDERMAN", "EntityEnderman", ExEntityEnderman.class);
        ENDERMITE = new ExEntityType<>("ENDERMITE", "EntityEndermite", ExEntityEndermite.class);
        EVOKER = new ExEntityType<>("EVOKER", "EntityEvoker", ExEntityEvoker.class);
        EVOKER_FANGS = new ExEntityType<>("EVOKER_FANGS", "EntityEvokerFangs", ExEntityEvokerFangs.class);
        EXPERIENCE_ORB = new ExEntityType<>("EXPERIENCE_ORB", "EntityExperienceOrb", ExEntityExperienceOrb.class);
        EYE_OF_ENDER = new ExEntityType<>("EYE_OF_ENDER", "EntityEnderSignal", ExEntityEnderSignal.class);
        FALLING_BLOCK = new ExEntityType<>("FALLING_BLOCK", "EntityFallingBlock", ExEntityFallingBlock.class);
        FIREWORK_ROCKET = new ExEntityType<>("FIREWORK_ROCKET", "EntityFireworks", ExEntityFireworks.class);
        FOX = new ExEntityType<>("FOX", "EntityFox", ExEntityFox.class);
        GHAST = new ExEntityType<>("GHAST", "EntityGhast", ExEntityGhast.class);
        GIANT = new ExEntityType<>("GIANT", "EntityGiantZombie", ExEntityGiantZombie.class);
        GUARDIAN = new ExEntityType<>("GUARDIAN", "EntityGuardian", ExEntityGuardian.class);
        HOGLIN = new ExEntityType<>("HOGLIN", "EntityHoglin", ExEntityHoglin.class);
        HORSE = new ExEntityType<>("HORSE", "EntityHorse", ExEntityHorse.class);
        HUSK = new ExEntityType<>("HUSK", "EntityZombieHusk", ExEntityZombieHusk.class);
        ILLUSIONER = new ExEntityType<>("ILLUSIONER", "EntityIllagerIllusioner", ExEntityIllagerIllusioner.class);
        IRON_GOLEM = new ExEntityType<>("IRON_GOLEM", "EntityIronGolem", ExEntityIronGolem.class);
        ITEM = new ExEntityType<>("ITEM", "EntityItem", ExEntityItem.class);
        ITEM_FRAME = new ExEntityType<>("ITEM_FRAME", "EntityItemFrame", ExEntityItemFrame.class);
        FIREBALL = new ExEntityType<>("FIREBALL", "EntityLargeFireball", ExEntityLargeFireball.class);
        LEASH_KNOT = new ExEntityType<>("LEASH_KNOT", "EntityLeash", ExEntityLeash.class);
        LIGHTNING_BOLT = new ExEntityType<>("LIGHTNING_BOLT", "EntityLightning", ExEntityLightning.class);
        LLAMA = new ExEntityType<>("LLAMA", "EntityLlama", ExEntityLlama.class);
        LLAMA_SPIT = new ExEntityType<>("LLAMA_SPIT", "EntityLlamaSpit", ExEntityLlamaSpit.class);
        MAGMA_CUBE = new ExEntityType<>("MAGMA_CUBE", "EntityMagmaCube", ExEntityMagmaCube.class);
        MINECART = new ExEntityType<>("MINECART", "EntityMinecartRideable", ExEntityMinecartRideable.class);
        CHEST_MINECART = new ExEntityType<>("CHEST_MINECART", "EntityMinecartChest", ExEntityMinecartChest.class);
        COMMAND_BLOCK_MINECART = new ExEntityType<>("COMMAND_BLOCK_MINECART", "EntityMinecartCommandBlock", ExEntityMinecartCommandBlock.class);
        FURNACE_MINECART = new ExEntityType<>("FURNACE_MINECART", "EntityMinecartFurnace", ExEntityMinecartFurnace.class);
        HOPPER_MINECART = new ExEntityType<>("HOPPER_MINECART", "EntityMinecartHopper", ExEntityMinecartHopper.class);
        SPAWNER_MINECART = new ExEntityType<>("SPAWNER_MINECART", "EntityMinecartMobSpawner", ExEntityMinecartMobSpawner.class);
        TNT_MINECART = new ExEntityType<>("TNT_MINECART", "EntityMinecartTNT", ExEntityMinecartTNT.class);
        MULE = new ExEntityType<>("MULE", "EntityHorseMule", ExEntityHorseMule.class);
        MOOSHROOM = new ExEntityType<>("MOOSHROOM", "EntityMushroomCow", ExEntityMushroomCow.class);
        OCELOT = new ExEntityType<>("OCELOT", "EntityOcelot", ExEntityOcelot.class);
        PAINTING = new ExEntityType<>("PAINTING", "EntityPainting", ExEntityPainting.class);
        PANDA = new ExEntityType<>("PANDA", "EntityPanda", ExEntityPanda.class);
        PARROT = new ExEntityType<>("PARROT", "EntityParrot", ExEntityParrot.class);
        PHANTOM = new ExEntityType<>("PHANTOM", "EntityPhantom", ExEntityPhantom.class);
        PIG = new ExEntityType<>("PIG", "EntityPig", ExEntityPig.class);
        PIGLIN = new ExEntityType<>("PIGLIN", "EntityPiglin", ExEntityPiglin.class);
        PIGLIN_BRUTE = new ExEntityType<>("PIGLIN_BRUTE", "EntityPiglinBrute", ExEntityPiglinBrute.class);
        PILLAGER = new ExEntityType<>("PILLAGER", "EntityPillager", ExEntityPillager.class);
        POLAR_BEAR = new ExEntityType<>("POLAR_BEAR", "EntityPolarBear", ExEntityPolarBear.class);
        TNT = new ExEntityType<>("TNT", "EntityTNTPrimed", ExEntityTNTPrimed.class);
        PUFFERFISH = new ExEntityType<>("PUFFERFISH", "EntityPufferFish", ExEntityPufferFish.class);
        SILVERFISH = new ExEntityType<>("SILVERFISH", "EntitySilverfish", ExEntitySilverfish.class);
        SKELETON = new ExEntityType<>("SKELETON", "EntitySkeleton", ExEntitySkeleton.class);
        SKELETON_HORSE = new ExEntityType<>("SKELETON_HORSE", "EntityHorseSkeleton", ExEntityHorseSkeleton.class);
        SLIME = new ExEntityType<>("SLIME", "EntitySlime", ExEntitySlime.class);
        SMALL_FIREBALL = new ExEntityType<>("SMALL_FIREBALL", "EntitySmallFireball", ExEntitySmallFireball.class);
        SNOW_GOLEM = new ExEntityType<>("SNOW_GOLEM", "EntitySnowman", ExEntitySnowman.class);
        SPIDER = new ExEntityType<>("SPIDER", "EntitySpider", ExEntitySpider.class);
        STRAY = new ExEntityType<>("STRAY", "EntitySkeletonStray", ExEntitySkeletonStray.class);
        STRIDER = new ExEntityType<>("STRIDER", "EntityStrider", ExEntityStrider.class);
        VILLAGER = new ExEntityType<>("VILLAGER", "EntityVillager", ExEntityVillager.class);
        VINDICATOR = new ExEntityType<>("VINDICATOR", "EntityVindicator", ExEntityVindicator.class);
        WITCH = new ExEntityType<>("WITCH", "EntityWitch", ExEntityWitch.class);
        WITHER_SKELETON = new ExEntityType<>("WITHER_SKELETON", "EntitySkeletonWither", ExEntitySkeletonWither.class);
        WOLF = new ExEntityType<>("WOLF", "EntityWolf", ExEntityWolf.class);
        ZOMBIE = new ExEntityType<>("ZOMBIE", "EntityZombie", ExEntityZombie.class);
        ZOMBIE_VILLAGER = new ExEntityType<>("ZOMBIE_VILLAGER", "EntityZombieVillager", ExEntityZombieVillager.class);
        PLAYER = new ExEntityType<>("PLAYER", "EntityHuman", ExPlayer.class);
    }

    private static Object getEntityType(String name) {
        return RefUtil.getEnumConstant(RefUtil.getNMSClass("EntityTypes"), name);
    }

    private static Class<?> getEntityClass(String name) {
        return RefUtil.getNMSClass(name);
    }


    public static final List<ExEntityType<? extends ExEntity>> TYPES = List.of(ARMOR_STAND, BAT, BEE, BLAZE, CAT, CAVE_SPIDER, CHICKEN, COD, COW, CREEPER, DOLPHIN, DONKEY, DRAGON_FIREBALL, DROWNED, ELDER_GUARDIAN, END_CRYSTAL, ENDER_DRAGON, ENDERMAN, ENDERMITE, EVOKER, EVOKER_FANGS, EXPERIENCE_ORB, EYE_OF_ENDER, FALLING_BLOCK, FIREWORK_ROCKET, FOX, GHAST, GIANT, GUARDIAN, HOGLIN, HORSE, HUSK, ILLUSIONER, IRON_GOLEM, ITEM, ITEM_FRAME, FIREBALL, LEASH_KNOT, LIGHTNING_BOLT, LLAMA, LLAMA_SPIT, MAGMA_CUBE, MINECART, CHEST_MINECART, COMMAND_BLOCK_MINECART, FURNACE_MINECART, HOPPER_MINECART, SPAWNER_MINECART, TNT_MINECART, MULE, MOOSHROOM, OCELOT, PAINTING, PANDA, PARROT, PHANTOM, PIG, PIGLIN, PIGLIN_BRUTE, PILLAGER, POLAR_BEAR, TNT, PUFFERFISH,
            // RABBIT, RAVAGER, SALMON,SHEEP, SHULKER, SHULKER_BULLET,
            // SILVERFISH, SKELETON, SKELETON_HORSE, SLIME, SMALL_FIREBALL, SNOW_GOLEM,
            // SNOWBALL, SPECTRAL_ARROW,
            SPIDER,
            // SQUID,
            STRAY, STRIDER,
            // EGG, ENDER_PEARL, EXPERIENCE_BOTTLE, POTION,
            // TRIDENT, TRADER_LLAMA, TROPICAL_FISH, TURTLE, VEX,
            VILLAGER, VINDICATOR,
            // WANDERING_TRADER,
            WITCH,
            // WITHER,
            WITHER_SKELETON,
            // WITHER_SKULL,
            WOLF,
            // ZOGLIN,
            ZOMBIE,
            // ZOMBIE_HORSE,
            ZOMBIE_VILLAGER,
            // ZOMBIFIED_PIGLIN,
            PLAYER//,
            //FISHING_BOBBER
    );

    protected final Object nmsType;
    protected final Class<?> nmsClass;
    protected Class<? extends ExEntity> exClass;

    public ExEntityType(Object nmsType, Class<?> nmsClass, Class<? extends ExEntity> exClass) {
        this.nmsType = nmsType;
        this.nmsClass = nmsClass;
        this.exClass = exClass;
    }

    public ExEntityType(String typeName, String className, Class<? extends ExEntity> exClass) {
        this.nmsType = getEntityType(typeName);
        this.nmsClass = getEntityClass(className);
        this.exClass = exClass;
    }

    public Object getNmsType() {
        return nmsType;
    }

    public Class<?> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends ExEntity> getExClass() {
        return this.exClass;
    }
}
