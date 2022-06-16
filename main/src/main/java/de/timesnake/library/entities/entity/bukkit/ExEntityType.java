package de.timesnake.library.entities.entity.bukkit;

import de.timesnake.library.entities.entity.extension.ExEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExEntityType<NmsType extends Entity> {

    public static final ExEntityType<net.minecraft.world.entity.EntityAreaEffectCloud> AREA_EFFECT_CLOUD = new ExEntityType<>(EntityTypes.b, net.minecraft.world.entity.EntityAreaEffectCloud.class, ExAreaEffectCloud.class);
    public static final ExEntityType<net.minecraft.world.entity.decoration.EntityArmorStand> ARMOR_STAND = new ExEntityType<>(EntityTypes.c, net.minecraft.world.entity.decoration.EntityArmorStand.class, ExArmorStand.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityTippedArrow> TIPPED_ARROW = new ExEntityType<>(EntityTypes.d, net.minecraft.world.entity.projectile.EntityTippedArrow.class, ExTippedArrow.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.axolotl.Axolotl> AXOLOTL = new ExEntityType<>(EntityTypes.e, net.minecraft.world.entity.animal.axolotl.Axolotl.class, ExAxolotl.class);
    public static final ExEntityType<net.minecraft.world.entity.ambient.EntityBat> BAT = new ExEntityType<>(EntityTypes.f, net.minecraft.world.entity.ambient.EntityBat.class, ExBat.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityBee> BEE = new ExEntityType<>(EntityTypes.g, net.minecraft.world.entity.animal.EntityBee.class, ExBee.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityBlaze> BLAZE = new ExEntityType<>(EntityTypes.h, net.minecraft.world.entity.monster.EntityBlaze.class, ExBlaze.class);
    public static final ExEntityType<net.minecraft.world.entity.vehicle.EntityBoat> BOAT = new ExEntityType<>(EntityTypes.i, net.minecraft.world.entity.vehicle.EntityBoat.class, ExBoat.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityCat> CAT = new ExEntityType<>(EntityTypes.j, net.minecraft.world.entity.animal.EntityCat.class, ExCat.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityCaveSpider> CAVE_SPIDER = new ExEntityType<>(EntityTypes.k, net.minecraft.world.entity.monster.EntityCaveSpider.class, ExCaveSpider.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityChicken> CHICKEN = new ExEntityType<>(EntityTypes.l, net.minecraft.world.entity.animal.EntityChicken.class, ExChicken.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityCod> COD = new ExEntityType<>(EntityTypes.m, net.minecraft.world.entity.animal.EntityCod.class, ExCod.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityCow> COW = new ExEntityType<>(EntityTypes.n, net.minecraft.world.entity.animal.EntityCow.class, ExCow.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityCreeper> CREEPER = new ExEntityType<>(EntityTypes.o, net.minecraft.world.entity.monster.EntityCreeper.class, ExCreeper.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityDolphin> DOLPHIN = new ExEntityType<>(EntityTypes.p, net.minecraft.world.entity.animal.EntityDolphin.class, ExDolphin.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityHorseDonkey> DONKEY = new ExEntityType<>(EntityTypes.q, net.minecraft.world.entity.animal.horse.EntityHorseDonkey.class, ExDonkey.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityDragonFireball> DRAGON_FIREBALL = new ExEntityType<>(EntityTypes.r, net.minecraft.world.entity.projectile.EntityDragonFireball.class, ExDragonFireball.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityDrowned> DROWNED = new ExEntityType<>(EntityTypes.s, net.minecraft.world.entity.monster.EntityDrowned.class, ExDrowned.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityGuardianElder> ELDER_GUARDIAN = new ExEntityType<>(EntityTypes.t, net.minecraft.world.entity.monster.EntityGuardianElder.class, ExElderGuardian.class);
    public static final ExEntityType<net.minecraft.world.entity.boss.enderdragon.EntityEnderCrystal> ENDER_CRYSTAL = new ExEntityType<>(EntityTypes.u, net.minecraft.world.entity.boss.enderdragon.EntityEnderCrystal.class, ExEnderCrystal.class);
    public static final ExEntityType<net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon> ENDER_DRAGON = new ExEntityType<>(EntityTypes.v, net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon.class, ExEnderDragon.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityEnderman> ENDERMAN = new ExEntityType<>(EntityTypes.w, net.minecraft.world.entity.monster.EntityEnderman.class, ExEnderman.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityEndermite> ENDERMITE = new ExEntityType<>(EntityTypes.x, net.minecraft.world.entity.monster.EntityEndermite.class, ExEndermite.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityEvoker> EVOKER = new ExEntityType<>(EntityTypes.y, net.minecraft.world.entity.monster.EntityEvoker.class, ExEvoker.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityEvokerFangs> EVOKER_FANGS = new ExEntityType<>(EntityTypes.z, net.minecraft.world.entity.projectile.EntityEvokerFangs.class, ExEvokerFangs.class);
    public static final ExEntityType<net.minecraft.world.entity.EntityExperienceOrb> EXPERIENCE_ORB = new ExEntityType<>(EntityTypes.A, net.minecraft.world.entity.EntityExperienceOrb.class, ExExperienceOrb.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityEnderSignal> ENDER_SIGNAL = new ExEntityType<>(EntityTypes.B, net.minecraft.world.entity.projectile.EntityEnderSignal.class, ExEnderSignal.class);
    public static final ExEntityType<net.minecraft.world.entity.item.EntityFallingBlock> FALLING_BLOCK = new ExEntityType<>(EntityTypes.C, net.minecraft.world.entity.item.EntityFallingBlock.class, ExFallingBlock.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityFireworks> FIREWORK = new ExEntityType<>(EntityTypes.D, net.minecraft.world.entity.projectile.EntityFireworks.class, ExFirework.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityFox> FOX = new ExEntityType<>(EntityTypes.E, net.minecraft.world.entity.animal.EntityFox.class, ExFox.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityGhast> GHAST = new ExEntityType<>(EntityTypes.F, net.minecraft.world.entity.monster.EntityGhast.class, ExGhast.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityGiantZombie> GIANT = new ExEntityType<>(EntityTypes.G, net.minecraft.world.entity.monster.EntityGiantZombie.class, ExGiant.class);
    public static final ExEntityType<net.minecraft.world.entity.decoration.GlowItemFrame> GLOW_ITEM_FRAME = new ExEntityType<>(EntityTypes.H, net.minecraft.world.entity.decoration.GlowItemFrame.class, ExGlowItemFrame.class);
    public static final ExEntityType<net.minecraft.world.entity.GlowSquid> GLOW_SQUID = new ExEntityType<>(EntityTypes.I, net.minecraft.world.entity.GlowSquid.class, ExGlowSquid.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.goat.Goat> GOAT = new ExEntityType<>(EntityTypes.J, net.minecraft.world.entity.animal.goat.Goat.class, ExGoat.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityGuardian> GUARDIAN = new ExEntityType<>(EntityTypes.K, net.minecraft.world.entity.monster.EntityGuardian.class, ExGuardian.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.hoglin.EntityHoglin> HOGLIN = new ExEntityType<>(EntityTypes.L, net.minecraft.world.entity.monster.hoglin.EntityHoglin.class, ExHoglin.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityHorse> HORSE = new ExEntityType<>(EntityTypes.M, net.minecraft.world.entity.animal.horse.EntityHorse.class, ExHorse.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityZombieHusk> HUSK = new ExEntityType<>(EntityTypes.N, net.minecraft.world.entity.monster.EntityZombieHusk.class, ExHusk.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityIllagerIllusioner> ILLUSIONER = new ExEntityType<>(EntityTypes.O, net.minecraft.world.entity.monster.EntityIllagerIllusioner.class, ExIllusioner.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityIronGolem> IRON_GOLEM = new ExEntityType<>(EntityTypes.P, net.minecraft.world.entity.animal.EntityIronGolem.class, ExIronGolem.class);
    public static final ExEntityType<net.minecraft.world.entity.item.EntityItem> ITEM = new ExEntityType<>(EntityTypes.Q, net.minecraft.world.entity.item.EntityItem.class, ExItem.class);
    public static final ExEntityType<net.minecraft.world.entity.decoration.EntityItemFrame> ITEM_FRAME = new ExEntityType<>(EntityTypes.R, net.minecraft.world.entity.decoration.EntityItemFrame.class, ExItemFrame.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityLargeFireball> LARGE_FIREBALL = new ExEntityType<>(EntityTypes.S, net.minecraft.world.entity.projectile.EntityLargeFireball.class, ExLargeFireball.class);
    public static final ExEntityType<net.minecraft.world.entity.decoration.EntityLeash> LEASH = new ExEntityType<>(EntityTypes.T, net.minecraft.world.entity.decoration.EntityLeash.class, ExLeash.class);
    public static final ExEntityType<net.minecraft.world.entity.EntityLightning> LIGHTNING_STRIKE = new ExEntityType<>(EntityTypes.U, net.minecraft.world.entity.EntityLightning.class, ExLightningStrike.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityLlama> LLAMA = new ExEntityType<>(EntityTypes.V, net.minecraft.world.entity.animal.horse.EntityLlama.class, ExLlama.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityLlamaSpit> LLAMA_SPIT = new ExEntityType<>(EntityTypes.W, net.minecraft.world.entity.projectile.EntityLlamaSpit.class, ExLlamaSpit.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityMagmaCube> MAGMA_CUBE = new ExEntityType<>(EntityTypes.X, net.minecraft.world.entity.monster.EntityMagmaCube.class, ExMagmaCube.class);
    public static final ExEntityType<net.minecraft.world.entity.Marker> MARKER = new ExEntityType<>(EntityTypes.Y, net.minecraft.world.entity.Marker.class, ExMarker.class);
    public static final ExEntityType<net.minecraft.world.entity.vehicle.EntityMinecartRideable> MINECART_RIDEABLE = new ExEntityType<>(EntityTypes.Z, net.minecraft.world.entity.vehicle.EntityMinecartRideable.class, ExMinecartRideable.class);
    public static final ExEntityType<net.minecraft.world.entity.vehicle.EntityMinecartChest> MINECART_CHEST = new ExEntityType<>(EntityTypes.aa, net.minecraft.world.entity.vehicle.EntityMinecartChest.class, ExMinecartChest.class);
    public static final ExEntityType<net.minecraft.world.entity.vehicle.EntityMinecartCommandBlock> MINECART_COMMAND = new ExEntityType<>(EntityTypes.ab, net.minecraft.world.entity.vehicle.EntityMinecartCommandBlock.class, ExMinecartCommand.class);
    public static final ExEntityType<net.minecraft.world.entity.vehicle.EntityMinecartFurnace> MINECART_FURNACE = new ExEntityType<>(EntityTypes.ac, net.minecraft.world.entity.vehicle.EntityMinecartFurnace.class, ExMinecartFurnace.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityHorseMule> MULE = new ExEntityType<>(EntityTypes.ag, net.minecraft.world.entity.animal.horse.EntityHorseMule.class, ExMule.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityMushroomCow> MUSHROOM_COW = new ExEntityType<>(EntityTypes.ah, net.minecraft.world.entity.animal.EntityMushroomCow.class, ExMushroomCow.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityOcelot> OCELOT = new ExEntityType<>(EntityTypes.ai, net.minecraft.world.entity.animal.EntityOcelot.class, ExOcelot.class);
    public static final ExEntityType<net.minecraft.world.entity.decoration.EntityPainting> PAINTING = new ExEntityType<>(EntityTypes.aj, net.minecraft.world.entity.decoration.EntityPainting.class, ExPainting.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityPanda> PANDA = new ExEntityType<>(EntityTypes.ak, net.minecraft.world.entity.animal.EntityPanda.class, ExPanda.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityParrot> PARROT = new ExEntityType<>(EntityTypes.al, net.minecraft.world.entity.animal.EntityParrot.class, ExParrot.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityPhantom> PHANTOM = new ExEntityType<>(EntityTypes.am, net.minecraft.world.entity.monster.EntityPhantom.class, ExPhantom.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityPig> PIG = new ExEntityType<>(EntityTypes.an, net.minecraft.world.entity.animal.EntityPig.class, ExPig.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.piglin.EntityPiglin> PIGLIN = new ExEntityType<>(EntityTypes.ao, net.minecraft.world.entity.monster.piglin.EntityPiglin.class, ExPiglin.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.piglin.EntityPiglinBrute> PIGLIN_BRUTE = new ExEntityType<>(EntityTypes.ap, net.minecraft.world.entity.monster.piglin.EntityPiglinBrute.class, ExPiglinBrute.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityPillager> PILLAGER = new ExEntityType<>(EntityTypes.aq, net.minecraft.world.entity.monster.EntityPillager.class, ExPillager.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityPolarBear> POLAR_BEAR = new ExEntityType<>(EntityTypes.ar, net.minecraft.world.entity.animal.EntityPolarBear.class, ExPolarBear.class);
    public static final ExEntityType<net.minecraft.world.entity.item.EntityTNTPrimed> TNT_PRIMED = new ExEntityType<>(EntityTypes.as, net.minecraft.world.entity.item.EntityTNTPrimed.class, ExTNTPrimed.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityPufferFish> PUFFER_FISH = new ExEntityType<>(EntityTypes.at, net.minecraft.world.entity.animal.EntityPufferFish.class, ExPufferFish.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityRabbit> RABBIT = new ExEntityType<>(EntityTypes.au, net.minecraft.world.entity.animal.EntityRabbit.class, ExRabbit.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityRavager> RAVAGER = new ExEntityType<>(EntityTypes.av, net.minecraft.world.entity.monster.EntityRavager.class, ExRavager.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntitySalmon> SALMON = new ExEntityType<>(EntityTypes.aw, net.minecraft.world.entity.animal.EntitySalmon.class, ExSalmon.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntitySheep> SHEEP = new ExEntityType<>(EntityTypes.ax, net.minecraft.world.entity.animal.EntitySheep.class, ExSheep.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityShulker> SHULKER = new ExEntityType<>(EntityTypes.ay, net.minecraft.world.entity.monster.EntityShulker.class, ExShulker.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityShulkerBullet> SHULKER_BULLET = new ExEntityType<>(EntityTypes.az, net.minecraft.world.entity.projectile.EntityShulkerBullet.class, ExShulkerBullet.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntitySilverfish> SILVERFISH = new ExEntityType<>(EntityTypes.aA, net.minecraft.world.entity.monster.EntitySilverfish.class, ExSilverfish.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntitySkeleton> SKELETON = new ExEntityType<>(EntityTypes.aB, net.minecraft.world.entity.monster.EntitySkeleton.class, ExSkeleton.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityHorseSkeleton> SKELETON_HORSE = new ExEntityType<>(EntityTypes.aC, net.minecraft.world.entity.animal.horse.EntityHorseSkeleton.class, ExSkeletonHorse.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntitySlime> SLIME = new ExEntityType<>(EntityTypes.aD, net.minecraft.world.entity.monster.EntitySlime.class, ExSlime.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntitySmallFireball> SMALL_FIREBALL = new ExEntityType<>(EntityTypes.aE, net.minecraft.world.entity.projectile.EntitySmallFireball.class, ExSmallFireball.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntitySnowman> SNOWMAN = new ExEntityType<>(EntityTypes.aF, net.minecraft.world.entity.animal.EntitySnowman.class, ExSnowman.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntitySnowball> SNOWBALL = new ExEntityType<>(EntityTypes.aG, net.minecraft.world.entity.projectile.EntitySnowball.class, ExSnowball.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntitySpectralArrow> SPECTRAL_ARROW = new ExEntityType<>(EntityTypes.aH, net.minecraft.world.entity.projectile.EntitySpectralArrow.class, ExSpectralArrow.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntitySpider> SPIDER = new ExEntityType<>(EntityTypes.aI, net.minecraft.world.entity.monster.EntitySpider.class, ExSpider.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntitySquid> SQUID = new ExEntityType<>(EntityTypes.aJ, net.minecraft.world.entity.animal.EntitySquid.class, ExSquid.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntitySkeletonStray> STRAY = new ExEntityType<>(EntityTypes.aK, net.minecraft.world.entity.monster.EntitySkeletonStray.class, ExStray.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityStrider> STRIDER = new ExEntityType<>(EntityTypes.aL, net.minecraft.world.entity.monster.EntityStrider.class, ExStrider.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityEgg> EGG = new ExEntityType<>(EntityTypes.aM, net.minecraft.world.entity.projectile.EntityEgg.class, ExEgg.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityEnderPearl> ENDER_PEARL = new ExEntityType<>(EntityTypes.aN, net.minecraft.world.entity.projectile.EntityEnderPearl.class, ExEnderPearl.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityThrownExpBottle> THROWN_EXP_BOTTLE = new ExEntityType<>(EntityTypes.aO, net.minecraft.world.entity.projectile.EntityThrownExpBottle.class, ExThrownExpBottle.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityPotion> THROWN_POTION = new ExEntityType<>(EntityTypes.aP, net.minecraft.world.entity.projectile.EntityPotion.class, ExThrownPotion.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityThrownTrident> TRIDENT = new ExEntityType<>(EntityTypes.aQ, net.minecraft.world.entity.projectile.EntityThrownTrident.class, ExTrident.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityLlamaTrader> TRADER_LLAMA = new ExEntityType<>(EntityTypes.aR, net.minecraft.world.entity.animal.horse.EntityLlamaTrader.class, ExTraderLlama.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityTropicalFish> TROPICAL_FISH = new ExEntityType<>(EntityTypes.aS, net.minecraft.world.entity.animal.EntityTropicalFish.class, ExTropicalFish.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityTurtle> TURTLE = new ExEntityType<>(EntityTypes.aT, net.minecraft.world.entity.animal.EntityTurtle.class, ExTurtle.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityVex> VEX = new ExEntityType<>(EntityTypes.aU, net.minecraft.world.entity.monster.EntityVex.class, ExVex.class);
    public static final ExEntityType<net.minecraft.world.entity.npc.EntityVillager> VILLAGER = new ExEntityType<>(EntityTypes.aV, net.minecraft.world.entity.npc.EntityVillager.class, ExVillager.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityVindicator> VINDICATOR = new ExEntityType<>(EntityTypes.aW, net.minecraft.world.entity.monster.EntityVindicator.class, ExVindicator.class);
    public static final ExEntityType<net.minecraft.world.entity.npc.EntityVillagerTrader> WANDERING_TRADER = new ExEntityType<>(EntityTypes.aX, net.minecraft.world.entity.npc.EntityVillagerTrader.class, ExWanderingTrader.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityWitch> WITCH = new ExEntityType<>(EntityTypes.aY, net.minecraft.world.entity.monster.EntityWitch.class, ExWitch.class);
    public static final ExEntityType<net.minecraft.world.entity.boss.wither.EntityWither> WITHER = new ExEntityType<>(EntityTypes.aZ, net.minecraft.world.entity.boss.wither.EntityWither.class, ExWither.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntitySkeletonWither> WITHER_SKELETON = new ExEntityType<>(EntityTypes.ba, net.minecraft.world.entity.monster.EntitySkeletonWither.class, ExWitherSkeleton.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityWitherSkull> WITHER_SKULL = new ExEntityType<>(EntityTypes.bb, net.minecraft.world.entity.projectile.EntityWitherSkull.class, ExWitherSkull.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.EntityWolf> WOLF = new ExEntityType<>(EntityTypes.bc, net.minecraft.world.entity.animal.EntityWolf.class, ExWolf.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityZoglin> ZOGLIN = new ExEntityType<>(EntityTypes.bd, net.minecraft.world.entity.monster.EntityZoglin.class, ExZoglin.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityZombie> ZOMBIE = new ExEntityType<>(EntityTypes.be, net.minecraft.world.entity.monster.EntityZombie.class, ExZombie.class);
    public static final ExEntityType<net.minecraft.world.entity.animal.horse.EntityHorseZombie> ZOMBIE_HORSE = new ExEntityType<>(EntityTypes.bf, net.minecraft.world.entity.animal.horse.EntityHorseZombie.class, ExZombieHorse.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityZombieVillager> VILLAGER_ZOMBIE = new ExEntityType<>(EntityTypes.bg, net.minecraft.world.entity.monster.EntityZombieVillager.class, ExVillagerZombie.class);
    public static final ExEntityType<net.minecraft.world.entity.monster.EntityPigZombie> PIG_ZOMBIE = new ExEntityType<>(EntityTypes.bh, net.minecraft.world.entity.monster.EntityPigZombie.class, ExPigZombie.class);
    public static final ExEntityType<net.minecraft.world.entity.player.EntityHuman> HUMAN_ENTITY = new ExEntityType<>(EntityTypes.bi, net.minecraft.world.entity.player.EntityHuman.class, ExHumanEntity.class);
    public static final ExEntityType<net.minecraft.world.entity.projectile.EntityFishingHook> FISH_HOOK = new ExEntityType<>(EntityTypes.bj, net.minecraft.world.entity.projectile.EntityFishingHook.class, ExFishHook.class);

    public static final List<ExEntityType<? extends Entity>> TYPES = List.of(
            AREA_EFFECT_CLOUD,
            ARMOR_STAND,
            TIPPED_ARROW,
            AXOLOTL,
            BAT,
            BEE,
            BLAZE,
            BOAT,
            CAT,
            CAVE_SPIDER,
            CHICKEN,
            COD,
            COW,
            CREEPER,
            DOLPHIN,
            DONKEY,
            DRAGON_FIREBALL,
            DROWNED,
            ELDER_GUARDIAN,
            ENDER_CRYSTAL,
            ENDER_DRAGON,
            ENDERMAN,
            ENDERMITE,
            EVOKER,
            EVOKER_FANGS,
            EXPERIENCE_ORB,
            ENDER_SIGNAL,
            FALLING_BLOCK,
            FIREWORK,
            FOX,
            GHAST,
            GIANT,
            GLOW_ITEM_FRAME,
            GLOW_SQUID,
            GOAT,
            GUARDIAN,
            HOGLIN,
            HORSE,
            HUSK,
            ILLUSIONER,
            IRON_GOLEM,
            ITEM,
            ITEM_FRAME,
            LARGE_FIREBALL,
            LEASH,
            LIGHTNING_STRIKE,
            LLAMA,
            LLAMA_SPIT,
            MAGMA_CUBE,
            MARKER,
            MINECART_RIDEABLE,
            MINECART_CHEST,
            MINECART_COMMAND,
            MINECART_FURNACE,
            MULE,
            MUSHROOM_COW,
            OCELOT,
            PAINTING,
            PANDA,
            PARROT,
            PHANTOM,
            PIG,
            PIGLIN,
            PIGLIN_BRUTE,
            PILLAGER,
            POLAR_BEAR,
            TNT_PRIMED,
            PUFFER_FISH,
            RABBIT,
            RAVAGER,
            SALMON,
            SHEEP,
            SHULKER,
            SHULKER_BULLET,
            SILVERFISH,
            SKELETON,
            SKELETON_HORSE,
            SLIME,
            SMALL_FIREBALL,
            SNOWMAN,
            SNOWBALL,
            SPECTRAL_ARROW,
            SPIDER,
            SQUID,
            STRAY,
            STRIDER,
            EGG,
            ENDER_PEARL,
            THROWN_EXP_BOTTLE,
            THROWN_POTION,
            TRIDENT,
            TRADER_LLAMA,
            TROPICAL_FISH,
            TURTLE,
            VEX,
            VILLAGER,
            VINDICATOR,
            WANDERING_TRADER,
            WITCH,
            WITHER,
            WITHER_SKELETON,
            WITHER_SKULL,
            WOLF,
            ZOGLIN,
            ZOMBIE,
            ZOMBIE_HORSE,
            VILLAGER_ZOMBIE,
            PIG_ZOMBIE,
            HUMAN_ENTITY,
            FISH_HOOK
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