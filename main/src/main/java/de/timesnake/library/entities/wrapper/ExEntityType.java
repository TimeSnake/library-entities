package de.timesnake.library.entities.wrapper;

import de.timesnake.library.entities.entity.bukkit.*;
import de.timesnake.library.entities.entity.bukkit.extension.ExCreeper;
import de.timesnake.library.entities.entity.bukkit.extension.ExPlayer;
import de.timesnake.library.entities.entity.extension.ExEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.animal.EntitySheep;
import net.minecraft.world.entity.animal.EntitySnowman;
import net.minecraft.world.entity.animal.EntityWolf;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.player.EntityHuman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExEntityType<NmsType extends Entity> {

    //public static final ExEntityType<EntityAreaEffectCloud> AREA_EFFECT_CLOUD = new ExEntityType<>(EntityTypes.b,
    //        EntityAreaEffectCloud.class, ExEntityAreaEffectCloud.class);
    //public static final ExEntityType<EntityArmorStand> ARMOR_STAND = new ExEntityType<>(EntityTypes.c,
    //        EntityArmorStand.class, ExArmorStand.class);
    //public static final ExEntityType<EntityTippedArrow> ARROW = new ExEntityType<>(EntityTypes.d, EntityTippedArrow
    // .class, ExEntityTippedArrow.class);
    //public static final ExEntityType<Axolotl> AXOLOTL = new ExEntityType<>(EntityTypes.e, Axolotl.class, ExAxolotl
    // .class);
    // public static final ExEntityType<EntityBat> BAT = new ExEntityType<>(EntityTypes.f, EntityBat.class, ExBat
    // .class);
    // public static final ExEntityType<EntityBee> BEE = new ExEntityType<>(EntityTypes.g, EntityBee.class, ExBee
    // .class);
    // public static final ExEntityType<EntityBlaze> BLAZE = new ExEntityType<>(EntityTypes.h, EntityBlaze.class,
    // ExBlaze.class);
    //public static final ExEntityType<EntityBoat> BOAT = new ExEntityType<>(EntityTypes.i, EntityBoat.class,
    // ExEntityBoat.class);
    //public static final ExEntityType<EntityCat> CAT = new ExEntityType<>(EntityTypes.j, EntityCat.class,
    // ExEntityCat.class);
    // public static final ExEntityType<EntityCaveSpider> CAVE_SPIDER = new ExEntityType<>(EntityTypes.k,
    // EntityCaveSpider.class, ExCaveSpider.class);
    //public static final ExEntityType<EntityChicken> CHICKEN = new ExEntityType<>(EntityTypes.l, EntityChicken
    // .class, ExEntityChicken.class);
    //public static final ExEntityType<EntityCod> COD = new ExEntityType<>(EntityTypes.m, EntityCod.class,
    // ExEntityCod.class);
    //public static final ExEntityType<EntityCow> COW = new ExEntityType<>(EntityTypes.n, EntityCow.class,
    // ExEntityCow.class);
    public static final ExEntityType<EntityCreeper> CREEPER = new ExEntityType<>(EntityTypes.o, EntityCreeper.class,
            ExCreeper.class);
    //public static final ExEntityType<EntityDolphin> DOLPHIN = new ExEntityType<>(EntityTypes.p, EntityDolphin
    // .class, ExEntityDolphin.class);
    //public static final ExEntityType<EntityHorseDonkey> DONKEY = new ExEntityType<>(EntityTypes.q,
    // EntityHorseDonkey.class, ExEntityHorseDonkey.class);
    //public static final ExEntityType<EntityDragonFireball> DRAGON_FIREBALL = new ExEntityType<>(EntityTypes.r,
    // EntityDragonFireball.class, ExEntityDragonFireball.class);
    //public static final ExEntityType<EntityDrowned> DROWNED = new ExEntityType<>(EntityTypes.s, EntityDrowned
    // .class, ExEntityDrowned.class);
    //public static final ExEntityType<EntityGuardianElder> ELDER_GUARDIAN = new ExEntityType<>(EntityTypes.t,
    // EntityGuardianElder.class, ExEntityGuardianElder.class);
    //public static final ExEntityType<EntityEnderCrystal> END_CRYSTAL = new ExEntityType<>(EntityTypes.u,
    // EntityEnderCrystal.class, ExEntityEnderCrystal.class);
    //public static final ExEntityType<EntityEnderDragon> ENDER_DRAGON = new ExEntityType<>(EntityTypes.v,
    // EntityEnderDragon.class, ExEntityEnderDragon.class);
    //public static final ExEntityType<EntityEnderman> ENDERMAN = new ExEntityType<>(EntityTypes.w, EntityEnderman
    // .class, ExEntityEnderman.class);
    public static final ExEntityType<EntityEndermite> ENDERMITE = new ExEntityType<>(EntityTypes.x,
            EntityEndermite.class, ExEndermite.class);
    public static final ExEntityType<EntityEvoker> EVOKER = new ExEntityType<>(EntityTypes.y, EntityEvoker.class,
            ExEvoker.class);
    //public static final ExEntityType<EntityEvokerFangs> EVOKER_FANGS = new ExEntityType<>(EntityTypes.z,
    // EntityEvokerFangs.class, ExEntityEvokerFangs.class);
    //public static final ExEntityType<EntityExperienceOrb> EXPERIENCE_ORB = new ExEntityType<>(EntityTypes.A,
    // EntityExperienceOrb.class, ExEntityExperienceOrb.class);
    //public static final ExEntityType<EntityEnderSignal> EYE_OF_ENDER = new ExEntityType<>(EntityTypes.B,
    // EntityEnderSignal.class, ExEntityEnderSignal.class);
    //public static final ExEntityType<EntityFallingBlock> FALLING_BLOCK = new ExEntityType<>(EntityTypes.C,
    // EntityFallingBlock.class, ExEntityFallingBlock.class);
    //public static final ExEntityType<EntityFireworks> FIREWORK_ROCKET = new ExEntityType<>(EntityTypes.D,
    // EntityFireworks.class, ExEntityFireworks.class);
    //public static final ExEntityType<EntityFox> FOX = new ExEntityType<>(EntityTypes.E, EntityFox.class,
    // ExEntityFox.class);
    //public static final ExEntityType<EntityGhast> GHAST = new ExEntityType<>(EntityTypes.F, EntityGhast.class,
    // ExEntityGhast.class);
    //public static final ExEntityType<EntityGiantZombie> GIANT = new ExEntityType<>(EntityTypes.G, EntityGiantZombie
    // .class, ExEntityGiantZombie.class);
    //public static final ExEntityType<GlowItemFrame> GLOW_ITEM_FRAME = new ExEntityType<>(EntityTypes.H,
    // GlowItemFrame.class, ExGlowItemFrame.class);
    //public static final ExEntityType<GlowSquid> GLOW_SQUID = new ExEntityType<>(EntityTypes.I, );
    //public static final ExEntityType<Goat> J;
    //public static final ExEntityType<EntityGuardian> GUARDIAN = new ExEntityType<>(EntityTypes.K, EntityGuardian
    // .class, ExEntityGuardian.class);
    //public static final ExEntityType<EntityHoglin> HOGLIN = new ExEntityType<>(EntityTypes.L, EntityHoglin.class,
    // ExEntityHoglin.class);
    //public static final ExEntityType<EntityHorse> HORSE = new ExEntityType<>(EntityTypes.M, EntityHorse.class,
    // ExEntityHorse.class);
    //public static final ExEntityType<EntityZombieHusk> HUSK = new ExEntityType<>(EntityTypes.N, EntityZombieHusk
    // .class, ExEntityZombieHusk.class);
    // public static final ExEntityType<EntityIllagerIllusioner> ILLUSIONER = new ExEntityType<>(EntityTypes.O,
    // EntityIllagerIllusioner.class, ExIllagerIllusioner.class);
    // public static final ExEntityType<EntityIronGolem> IRON_GOLEM = new ExEntityType<>(EntityTypes.P,
    //        EntityIronGolem.class, ExEntityIronGolem.class);
    //public static final ExEntityType<EntityItem> ITEM = new ExEntityType<>(EntityTypes.Q, EntityItem.class,
    //        ExItem.class);
    //public static final ExEntityType<EntityItemFrame> ITEM_FRAME = new ExEntityType<>(EntityTypes.R,
    //        EntityItemFrame.class, ExItemFrame.class);
    //public static final ExEntityType<EntityLargeFireball> FIREBALL = new ExEntityType<>(EntityTypes.S,
    // EntityLargeFireball.class, ExEntityLargeFireball.class);
    //public static final ExEntityType<EntityLeash> LEASH_KNOT = new ExEntityType<>(EntityTypes.T, EntityLeash.class,
    // ExEntityLeash.class);
    //public static final ExEntityType<EntityLightning> LIGHTNING_BOLT = new ExEntityType<>(EntityTypes.U,
    // EntityLightning.class, ExEntityLightning.class);
    //public static final ExEntityType<EntityLlama> LLAMA = new ExEntityType<>(EntityTypes.V, EntityLlama.class,
    // ExEntityLlama.class);
    //public static final ExEntityType<EntityLlamaSpit> LLAMA_SPIT = new ExEntityType<>(EntityTypes.W,
    // EntityLlamaSpit.class, ExEntityLlamaSpit.class);
    //public static final ExEntityType<EntityMagmaCube> MAGMA_CUBE = new ExEntityType<>(EntityTypes.X,
    // EntityMagmaCube.class, ExEntityMagmaCube.class);
    //public static final ExEntityType<EntityMinecartRideable> MINECART = new ExEntityType<>(EntityTypes.Z,
    // EntityMinecartRideable.class, ExEntityMinecartRideable.class);
    //public static final ExEntityType<EntityMinecartChest> CHEST_MINECART = new ExEntityType<>(EntityTypes.aa,
    // EntityMinecartChest.class, ExEntityMinecartChest.class);
    //public static final ExEntityType<EntityMinecartCommandBlock> COMMAND_BLOCK_MINECART = new ExEntityType<>
    // (EntityTypes.ab, EntityMinecartCommandBlock.class, ExEntityMinecartCommandBlock.class);
    //public static final ExEntityType<EntityMinecartFurnace> FURNACE_MINECART = new ExEntityType<>(EntityTypes.ac,
    // EntityMinecartFurnace.class, ExEntityMinecartFurnace.class);
    //public static final ExEntityType<EntityMinecartHopper> HOPPER_MINECART = new ExEntityType<>(EntityTypes.ad,
    // EntityMinecartHopper.class, ExEntityMinecartHopper.class);
    //public static final ExEntityType<EntityMinecartMobSpawner> SPAWNER_MINECART = new ExEntityType<>(EntityTypes
    // .ae, EntityMinecartMobSpawner.class, ExEntityMinecartMobSpawner.class);
    //public static final ExEntityType<EntityMinecartTNT> TNT_MINECART = new ExEntityType<>(EntityTypes.af,
    // EntityMinecartTNT.class, ExEntityMinecartTNT.class);
    //public static final ExEntityType<EntityHorseMule> MULE = new ExEntityType<>(EntityTypes.ag, EntityHorseMule
    // .class, ExEntityHorseMule.class);
    //public static final ExEntityType<EntityMushroomCow> MOOSHROOM = new ExEntityType<>(EntityTypes.ah,
    // EntityMushroomCow.class, ExEntityMushroomCow.class);
    //public static final ExEntityType<EntityOcelot> OCELOT = new ExEntityType<>(EntityTypes.ai, EntityOcelot.class,
    // ExEntityOcelot.class);
    //public static final ExEntityType<EntityPainting> PAINTING = new ExEntityType<>(EntityTypes.aj, EntityPainting
    // .class, ExEntityPainting.class);
    //public static final ExEntityType<EntityPanda> PANDA = new ExEntityType<>(EntityTypes.ak, EntityPanda.class,
    // ExEntityPanda.class);
    //public static final ExEntityType<EntityParrot> PARROT = new ExEntityType<>(EntityTypes.al, EntityParrot.class,
    // ExEntityParrot.class);
    public static final ExEntityType<EntityPhantom> PHANTOM = new ExEntityType<>(EntityTypes.am, EntityPhantom.class,
            ExPhantom.class);
    //public static final ExEntityType<EntityPig> PIG = new ExEntityType<>(EntityTypes.an, EntityPig.class,
    // ExEntityPig.class);
    //public static final ExEntityType<EntityPiglin> PIGLIN = new ExEntityType<>(EntityTypes.ao, EntityPiglin.class,
    // ExEntityPiglin.class);
    //public static final ExEntityType<EntityPiglinBrute> PIGLIN_BRUTE = new ExEntityType<>(EntityTypes.ap,
    // EntityPiglinBrute.class, ExEntityPiglinBrute.class);
    public static final ExEntityType<EntityPillager> PILLAGER = new ExEntityType<>(EntityTypes.aq,
            EntityPillager.class, ExPillager.class);
    //public static final ExEntityType<EntityPolarBear> POLAR_BEAR = new ExEntityType<>(EntityTypes.ar,
    // EntityPolarBear.class, ExEntityPolarBear.class);
    //public static final ExEntityType<EntityTNTPrimed> TNT = new ExEntityType<>(EntityTypes.as, EntityTNTPrimed
    // .class, ExEntityTNTPrimed.class);
    //public static final ExEntityType<EntityPufferFish> PUFFERFISH = new ExEntityType<>(EntityTypes.at,
    // EntityPufferFish.class, ExEntityPufferFish.class);
    //public static final ExEntityType<EntityRabbit> RABBIT = new ExEntityType<>(EntityTypes.au, EntityRabbit.class,
    // ExEntityRabbit.class);
    public static final ExEntityType<EntityRavager> RAVAGER = new ExEntityType<>(EntityTypes.av, EntityRavager.class,
            ExRavager.class);
    //public static final ExEntityType<EntitySalmon> SALMON = new ExEntityType<>(EntityTypes.aw, EntitySalmon.class,
    // ExEntitySalmon.class);
    public static final ExEntityType<EntitySheep> SHEEP = new ExEntityType<>(EntityTypes.ax, EntitySheep.class,
            ExSheep.class);
    //public static final ExEntityType<EntityShulker> SHULKER = new ExEntityType<>(EntityTypes.ay, EntityShulker
    // .class, ExEntityShulker.class);
    //public static final ExEntityType<EntityShulkerBullet> SHULKER_BULLET = new ExEntityType<>(EntityTypes.az,
    // EntityShulkerBullet.class, ExEntityShulkerBullet.class);
    public static final ExEntityType<EntitySilverfish> SILVERFISH = new ExEntityType<>(EntityTypes.aA,
            EntitySilverfish.class, ExSilverfish.class);
    public static final ExEntityType<EntitySkeleton> SKELETON = new ExEntityType<>(EntityTypes.aB,
            EntitySkeleton.class, ExSkeleton.class);
    //public static final ExEntityType<EntityHorseSkeleton> SKELETON_HORSE = new ExEntityType<>(EntityTypes.aC,
    // EntityHorseSkeleton.class, ExEntityHorseSkeleton.class);
    //public static final ExEntityType<EntitySlime> SLIME = new ExEntityType<>(EntityTypes.aD, EntitySlime.class,
    // ExEntitySlime.class);
    //public static final ExEntityType<EntitySmallFireball> SMALL_FIREBALL = new ExEntityType<>(EntityTypes.aE,
    // EntitySmallFireball.class, ExEntitySmallFireball.class);
    public static final ExEntityType<EntitySnowman> SNOW_GOLEM = new ExEntityType<>(EntityTypes.aF,
            EntitySnowman.class, ExSnowman.class);
    //public static final ExEntityType<EntitySnowball> SNOWBALL = new ExEntityType<>(EntityTypes.aG, EntitySnowball
    // .class, ExEntitySnowball.class);
    //public static final ExEntityType<EntitySpectralArrow> SPECTRAL_ARROW = new ExEntityType<>(EntityTypes.aH,
    // EntitySpectralArrow.class, ExEntitySpectralArrow.class);
    public static final ExEntityType<EntitySpider> SPIDER = new ExEntityType<>(EntityTypes.aI, EntitySpider.class,
            ExSpider.class);
    //public static final ExEntityType<EntitySquid> SQUID = new ExEntityType<>(EntityTypes.aJ, EntitySquid.class,
    // ExEntitySquid.class);
    public static final ExEntityType<EntitySkeletonStray> STRAY = new ExEntityType<>(EntityTypes.aK,
            EntitySkeletonStray.class, ExStray.class);
    //public static final ExEntityType<EntityStrider> STRIDER = new ExEntityType<>(EntityTypes.aL, EntityStrider
    // .class, ExEntityStrider.class);
    //public static final ExEntityType<EntityEgg> EGG = new ExEntityType<>(EntityTypes.aM, EntityEgg.class,
    // ExEntityEgg.class);
    //public static final ExEntityType<EntityEnderPearl> ENDER_PEARL = new ExEntityType<>(EntityTypes.aN,
    // EntityEnderPearl.class, ExEntityEnderPearl.class);
    //public static final ExEntityType<EntityThrownExpBottle> EXPERIENCE_BOTTLE = new ExEntityType<>(EntityTypes.aO,
    // EntityThrownExpBottle.class, ExEntityThrownExpBottle.class);
    //public static final ExEntityType<EntityPotion> POTION = new ExEntityType<>(EntityTypes.aP, EntityPotion.class,
    // ExEntityPotion.class);
    //public static final ExEntityType<EntityThrownTrident> TRIDENT = new ExEntityType<>(EntityTypes.aQ,
    // EntityThrownTrident.class, ExEntityThrownTrident.class);
    //public static final ExEntityType<EntityLlamaTrader> TRADER_LLAMA = new ExEntityType<>(EntityTypes.aR,
    // EntityLlamaTrader.class, ExEntityLlamaTrader.class);
    //public static final ExEntityType<EntityTropicalFish> TROPICAL_FISH = new ExEntityType<>(EntityTypes.aS,
    // EntityTropicalFish.class, ExEntityTropicalFish.class);
    //public static final ExEntityType<EntityTurtle> TURTLE = new ExEntityType<>(EntityTypes.aT, EntityTurtle.class,
    // ExEntityTurtle.class);
    public static final ExEntityType<EntityVex> VEX = new ExEntityType<>(EntityTypes.aU, EntityVex.class, ExVex.class);
    public static final ExEntityType<EntityVillager> VILLAGER = new ExEntityType<>(EntityTypes.aV,
            EntityVillager.class, ExVillager.class);
    public static final ExEntityType<EntityVindicator> VINDICATOR = new ExEntityType<>(EntityTypes.aW,
            EntityVindicator.class, ExVindicator.class);
    //public static final ExEntityType<EntityVillagerTrader> WANDERING_TRADER = new ExEntityType<>(EntityTypes.aX,
    // EntityVillagerTrader.class, ExEntityVillagerTrader.class);
    public static final ExEntityType<EntityWitch> WITCH = new ExEntityType<>(EntityTypes.aY, EntityWitch.class,
            ExWitch.class);
    //public static final ExEntityType<EntityWither> WITHER = new ExEntityType<>(EntityTypes.aZ, EntityWither.class,
    // ExEntityWither.class);
    //public static final ExEntityType<EntitySkeletonWither> WITHER_SKELETON = new ExEntityType<>(EntityTypes.ba,
    // EntitySkeletonWither.class, ExEntitySkeletonWither.class);
    //public static final ExEntityType<EntityWitherSkull> WITHER_SKULL = new ExEntityType<>(EntityTypes.bb,
    // EntityWitherSkull.class, ExEntityWitherSkull.class);
    public static final ExEntityType<EntityWolf> WOLF = new ExEntityType<>(EntityTypes.bc, EntityWolf.class,
            ExWolf.class);
    //public static final ExEntityType<EntityZoglin> ZOGLIN = new ExEntityType<>(EntityTypes.bd, EntityZoglin.class,
    // ExEntityZoglin.class);
    public static final ExEntityType<EntityZombie> ZOMBIE = new ExEntityType<>(EntityTypes.be, EntityZombie.class,
            ExZombie.class);
    //public static final ExEntityType<EntityHorseZombie> ZOMBIE_HORSE = new ExEntityType<>(EntityTypes.bf,
    // EntityHorseZombie.class, ExEntityHorseZombie.class);
    //public static final ExEntityType<EntityZombieVillager> ZOMBIE_VILLAGER = new ExEntityType<>(EntityTypes.bg,
    // EntityZombieVillager.class, ExEntityZombieVillager.class);
    //public static final ExEntityType<EntityPigZombie> ZOMBIFIED_PIGLIN = new ExEntityType<>(EntityTypes.bh,
    // EntityPigZombie.class, ExEntityPigZombie.class);
    public static final ExEntityType<EntityHuman> PLAYER = new ExEntityType<>(EntityTypes.bi, EntityHuman.class,
            ExPlayer.class);
    //public static final ExEntityType<EntityFishingHook> FISHING_BOBBER = new ExEntityType<>(EntityTypes.bj,
    // EntityFishingHook.class, ExEntityFishingHook.class);


    public static final List<ExEntityType<? extends Entity>> TYPES = List.of(
            ZOMBIE
    );

    public static final Map<Class<? extends org.bukkit.entity.Entity>, ExEntityType<? extends Entity>> EX_TYPES_BY_EX_CLASS = new HashMap<>();
    public static final Map<EntityTypes<?>, ExEntityType<? extends Entity>> EX_TYPES_BY_NMS_TYPE = new HashMap<>();

    public static ExEntityType<? extends Entity> getTypeByString(String type) {
        if (type == null) {
            return null;
        }

        Optional<EntityTypes<?>> opt = EntityTypes.a(type);
        return opt.map(ExEntityType::getTypeByNMSType).orElse(null);

    }

    public static ExEntityType<? extends Entity> getTypeByNMSType(EntityTypes<?> nmsType) {
        return EX_TYPES_BY_NMS_TYPE.get(nmsType);
    }

    public static ExEntityType<? extends Entity> getTypeByExClass(Class<? extends ExEntity> clazz) {
        return EX_TYPES_BY_EX_CLASS.get(clazz);
    }

    static {
        for (ExEntityType<? extends Entity> entityType : TYPES) {
            EX_TYPES_BY_EX_CLASS.put(entityType.getExClass(), entityType);
            EX_TYPES_BY_NMS_TYPE.put(entityType.getNMSType(), entityType);
        }
    }

    private final EntityTypes<NmsType> nmsType;
    private final Class<NmsType> nmsClass;
    private final Class<? extends org.bukkit.entity.Entity> exClass;

    public ExEntityType(EntityTypes<NmsType> nmsType, Class<NmsType> nmsClass, Class<?
            extends org.bukkit.entity.Entity> exClass) {
        this.nmsType = nmsType;
        this.nmsClass = nmsClass;
        this.exClass = exClass;
    }

    public EntityTypes<NmsType> getNMSType() {
        return nmsType;
    }

    public Class<NmsType> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends org.bukkit.entity.Entity> getExClass() {
        return exClass;
    }
}
