/*
 * workspace.library-entities-generator.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.entities.generator;

import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityTameableAnimal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.EntityHorseAbstract;
import net.minecraft.world.entity.animal.horse.EntityLlama;
import net.minecraft.world.entity.monster.EntityCreeper;
import net.minecraft.world.entity.monster.EntityMonster;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.entity.monster.IRangedEntity;
import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import net.minecraft.world.entity.raid.EntityRaider;
import net.minecraft.world.item.ItemStack;
import org.bukkit.World;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public class Generator_PathfinderGoal<Clazz> {

    public static final Generator_PathfinderGoal<ClimbOnTopOfPowderSnowGoal> CLIMB_ON_TOP_OF_POWDER_SNOW_GOAL =
            new Generator_PathfinderGoal<>(ClimbOnTopOfPowderSnowGoal.class, EntityInsentient.class,
                    List.of(new PathfinderField("world", net.minecraft.world.level.World.class)),
                    List.of(new WorldWrapperParameter("world")));
    public static final Generator_PathfinderGoal<PathfinderGoalArrowAttack> ARROW_ATTACK =
            new Generator_PathfinderGoal<>(PathfinderGoalArrowAttack.class, IRangedEntity.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("minTicksPerAttack", int.class),
                            new PathfinderField("maxTicksPerAttack", int.class),
                            new PathfinderField("maxRange", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("ticksPerAttack", List.of("minTicksPerAttack",
                                    "maxTicksPerAttack"), int.class),
                            new PathfinderParameter<>("maxRange", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("minTicksPerAttack", int.class),
                            new PathfinderParameter<>("maxTicksPerAttack", int.class),
                            new PathfinderParameter<>("maxRange", float.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalAvoidTarget> AVOID_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalAvoidTarget.class, EntityCreature.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("radius", float.class),
                            new PathfinderField("outerSpeed", double.class),
                            new PathfinderField("innerSpeed", double.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new PathfinderParameter<>("clazz", Class.class),
                            new PathfinderParameter<>("radius", float.class),
                            new PathfinderParameter<>("outerSpeed", double.class),
                            new PathfinderParameter<>("innerSpeed", double.class),
                            new PathfinderParameter<>("predicate", Predicate.class, "p -> true")));
    public static final Generator_PathfinderGoal<PathfinderGoalBeg> BEG =
            new Generator_PathfinderGoal<>(PathfinderGoalBeg.class, EntityWolf.class,
                    List.of(new PathfinderField("radius", float.class)),
                    List.of(new PathfinderParameter<>("radius", float.class)));
    //  public static final GeneratePathfinderGoal<PathfinderGoalBoat> BOAT = new GeneratePathfinderGoal<>
    //  (PathfinderGoalBoat.class, PathfinderGoalBoat.class, "a");
    public static final Generator_PathfinderGoal<PathfinderGoalBowShoot> BOW_SHOOT =
            new Generator_PathfinderGoal<>(PathfinderGoalBowShoot.class, EntityMonster.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("delay", int.class),
                            new PathfinderField("radius", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class, "1.0D"),
                            new PathfinderParameter<>("delay", int.class, "20"),
                            new PathfinderParameter<>("radius", float.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalBreakDoor> BREAK_DOOR =
            new Generator_PathfinderGoal<>(PathfinderGoalBreakDoor.class, EntityInsentient.class,
                    List.of(new PathfinderField("var0", int.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new PathfinderParameter<>("var0", int.class, "-1"),
                            new PathfinderParameter<>("predicate", Predicate.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalBreath> BREATH =
            new Generator_PathfinderGoal<>(PathfinderGoalBreath.class, EntityCreature.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalBreed> BREED =
            new Generator_PathfinderGoal<>(PathfinderGoalBreed.class, EntityAnimal.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalCatSitOnBed> CAT_SIT_ON_BED =
            new Generator_PathfinderGoal<>(PathfinderGoalCatSitOnBed.class, EntityCat.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", int.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", int.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalCrossbowAttack> CROSSBOW_ATTACK =
            new Generator_PathfinderGoal<>(PathfinderGoalCrossbowAttack.class, EntityMonster.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("radius", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("radius", float.class)));
    //public static final GeneratePathfinderGoal<PathfinderGoalDoorInteract> DOOR_INTERACT =
    //        new GeneratePathfinderGoal<>(PathfinderGoalDoorInteract.class, EntityInsentient.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalDoorOpen> DOOR_OPEN =
            new Generator_PathfinderGoal<>(PathfinderGoalDoorOpen.class, EntityInsentient.class,
                    List.of(new PathfinderField("var0", boolean.class)),
                    List.of(new PathfinderParameter<>("var0", boolean.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalEatTile> EAT_TILE =
            new Generator_PathfinderGoal<>(PathfinderGoalEatTile.class, EntityInsentient.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalFishSchool> FISH_SCHOOL =
            new Generator_PathfinderGoal<>(PathfinderGoalFishSchool.class, EntityFishSchool.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalFleeSun> FLEE_SUN =
            new Generator_PathfinderGoal<>(PathfinderGoalFleeSun.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalFloat> FLOAT =
            new Generator_PathfinderGoal<>(PathfinderGoalFloat.class, EntityInsentient.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalFollowBoat> FOLLOW_BOAT =
            new Generator_PathfinderGoal<>(PathfinderGoalFollowBoat.class, EntityCreature.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalFollowEntity> FOLLOW_ENTITY =
            new Generator_PathfinderGoal<>(PathfinderGoalFollowEntity.class, EntityInsentient.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("maxDistance", float.class),
                            new PathfinderField("searchRadius", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("maxDistance", float.class),
                            new PathfinderParameter<>("searchRadius", float.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalFollowOwner> FOLLOW_OWNER =
            new Generator_PathfinderGoal<>(PathfinderGoalFollowOwner.class, EntityTameableAnimal.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("maxDistance", float.class),
                            new PathfinderField("searchRadius", float.class),
                            new PathfinderField("var0", boolean.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("maxDistance", float.class),
                            new PathfinderParameter<>("searchRadius", float.class),
                            new PathfinderParameter<>("var0", boolean.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalFollowParent> FOLLOW_PARENT =
            new Generator_PathfinderGoal<>(PathfinderGoalFollowParent.class, EntityAnimal.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    //public static final GeneratePathfinderGoal<PathfinderGoalGotoTarget> GOTO_TARGET =
    //        new GeneratePathfinderGoal<>(PathfinderGoalGotoTarget.class, EntityCreature.class,
    //                List.of(new PathfinderField("speed", double.class),
    //                        new PathfinderField("var0", int.class),
    //                        new PathfinderField("var1", int.class)),
    //                List.of(new PathfinderParameter<>("speed", double.class),
    //                        new PathfinderParameter<>("var0", int.class),
    //                        new PathfinderParameter<>("var1", int.class, "1")));
    public static final Generator_PathfinderGoal<PathfinderGoalInteract> INTERACT =
            new Generator_PathfinderGoal<>(PathfinderGoalInteract.class, EntityInsentient.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("var0", float.class),
                            new PathfinderField("var1", float.class)),
                    List.of(new EntityClassWrapperParameter("clazz"),
                            new PathfinderParameter<>("var0", float.class),
                            new PathfinderParameter<>("var1", float.class, "0.02F")));
    public static final Generator_PathfinderGoal<PathfinderGoalJumpOnBlock> JUMP_ON_BLOCK =
            new Generator_PathfinderGoal<>(PathfinderGoalJumpOnBlock.class, EntityCat.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalLeapAtTarget> LEAP_AT_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalLeapAtTarget.class, EntityInsentient.class,
                    List.of(new PathfinderField("height", float.class)),
                    List.of(new PathfinderParameter<>("height", float.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalLlamaFollow> LLAMA_FOLLOW =
            new Generator_PathfinderGoal<>(PathfinderGoalLlamaFollow.class, EntityLlama.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalLookAtPlayer> LOOK_AT_PLAYER =
            new Generator_PathfinderGoal<>(PathfinderGoalLookAtPlayer.class, EntityInsentient.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("var0", float.class),
                            new PathfinderField("var1", float.class),
                            new PathfinderField("var2", boolean.class)),
                    List.of(new EntityClassWrapperParameter("clazz"),
                            new PathfinderParameter<>("var0", float.class),
                            new PathfinderParameter<>("var1", float.class, "0.02F"),
                            new PathfinderParameter<>("var2", boolean.class, "false")));
    public static final Generator_PathfinderGoal<PathfinderGoalLookAtTradingPlayer> LOOK_AT_TRADING_PLAYER =
            new Generator_PathfinderGoal<>(PathfinderGoalLookAtTradingPlayer.class,
                    EntityVillagerAbstract.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalMeleeAttack> MELEE_ATTACK =
            new Generator_PathfinderGoal<>(PathfinderGoalMeleeAttack.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("flag", boolean.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("flag", boolean.class, "false")));
    public static final Generator_PathfinderGoal<PathfinderGoalMoveTowardsRestriction> MOVE_TOWARDS_RESTRICTION =
            new Generator_PathfinderGoal<>(PathfinderGoalMoveTowardsRestriction.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalMoveTowardsTarget> MOVE_TOWARDS_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalMoveTowardsTarget.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("trackingDistance", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("trackingDistance", float.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalNearestVillage> NEAREST_VILLAGE =
            new Generator_PathfinderGoal<>(PathfinderGoalNearestVillage.class, EntityCreature.class,
                    List.of(new PathfinderField("var0", int.class)),
                    List.of(new PathfinderParameter<>("var0", int.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalOcelotAttack> OCELOT_ATTACK =
            new Generator_PathfinderGoal<>(PathfinderGoalOcelotAttack.class, EntityInsentient.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalOfferFlower> OFFER_FLOWER =
            new Generator_PathfinderGoal<>(PathfinderGoalOfferFlower.class, EntityIronGolem.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalPanic> PANIC =
            new Generator_PathfinderGoal<>(PathfinderGoalPanic.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalPerch> PERCH =
            new Generator_PathfinderGoal<>(PathfinderGoalPerch.class, EntityPerchable.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalRaid> RAID =
            new Generator_PathfinderGoal<>(PathfinderGoalRaid.class, EntityRaider.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalRandomFly> RANDOM_FLY =
            new Generator_PathfinderGoal<>(PathfinderGoalRandomFly.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalRandomLookaround> RANDOM_LOOKAROUND =
            new Generator_PathfinderGoal<>(PathfinderGoalRandomLookaround.class, EntityInsentient.class,
                    List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalRandomStroll> RANDOM_STROLL =
            new Generator_PathfinderGoal<>(PathfinderGoalRandomStroll.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", int.class),
                            new PathfinderField("var1", boolean.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", int.class),
                            new PathfinderParameter<>("var1", boolean.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalRandomStrollLand> RANDOM_STROLL_LAND =
            new Generator_PathfinderGoal<>(PathfinderGoalRandomStrollLand.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", float.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", float.class, "0.001F")));
    public static final Generator_PathfinderGoal<PathfinderGoalRandomSwim> RANDOM_SWIM =
            new Generator_PathfinderGoal<>(PathfinderGoalRandomSwim.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", int.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", int.class)));
    // TODO parameter order
    //public static final GeneratePathfinderGoal<PathfinderGoalRemoveBlock> REMOVE_BLOCK =
    //        new GeneratePathfinderGoal<>(PathfinderGoalRemoveBlock.class, EntityInsentient.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalRestrictSun> RESTRICT_SUN =
            new Generator_PathfinderGoal<>(PathfinderGoalRestrictSun.class, EntityCreature.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalSit> SIT =
            new Generator_PathfinderGoal<>(PathfinderGoalSit.class, EntityTameableAnimal.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalStrollVillage> STROLL_VILLAGE =
            new Generator_PathfinderGoal<>(PathfinderGoalStrollVillage.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", boolean.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", boolean.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalStrollVillageGolem> STROLL_VILLAGE_GOLEM =
            new Generator_PathfinderGoal<>(PathfinderGoalStrollVillageGolem.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalSwell> SWELL =
            new Generator_PathfinderGoal<>(PathfinderGoalSwell.class, EntityCreeper.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalTame> TAME =
            new Generator_PathfinderGoal<>(PathfinderGoalTame.class, EntityHorseAbstract.class,
                    List.of(new PathfinderField("speed", double.class)),
                    List.of(new PathfinderParameter<>("speed", double.class)));
    // TODO unknown goal
    //public static final GeneratePathfinderGoal<PathfinderGoalTempt> TEMPT =
    //        new GeneratePathfinderGoal<>(PathfinderGoalTempt.class, EntityCreature.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalTradeWithPlayer> TRADE_WITH_PLAYER =
            new Generator_PathfinderGoal<>(PathfinderGoalTradeWithPlayer.class, EntityVillagerAbstract.class,
                    List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalUseItem> USE_ITEM =
            new Generator_PathfinderGoal<>(PathfinderGoalUseItem.class, EntityInsentient.class,
                    List.of(new PathfinderField("item", ItemStack.class),
                            new PathfinderField("soundEffect", SoundEffect.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new ItemStackWrapperParameter("item"),
                            new PathfinderParameter<>("soundEffect", SoundEffect.class),
                            new PathfinderParameter<>("predicate", Predicate.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalMoveThroughVillage> MOVE_THROUGH_VILLAGE =
            new Generator_PathfinderGoal<>(PathfinderGoalMoveThroughVillage.class, EntityCreature.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", boolean.class),
                            new PathfinderField("var1", int.class),
                            new PathfinderField("supplier", BooleanSupplier.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", boolean.class),
                            new PathfinderParameter<>("var1", int.class),
                            new PathfinderParameter<>("supplier", BooleanSupplier.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalWater> WATER =
            new Generator_PathfinderGoal<>(PathfinderGoalWater.class, EntityCreature.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalWaterJump> WATER_JUMP =
            new Generator_PathfinderGoal<>(PathfinderGoalWaterJump.class, EntityDolphin.class,
                    List.of(new PathfinderField("var0", int.class)),
                    List.of(new PathfinderParameter<>("var0", int.class)));
    //  public static final GeneratePathfinderGoal<PathfinderGoalWaterJumpAbstract> WATER_JUMP_ABSTRACT = new
    //  GeneratePathfinderGoal<>(PathfinderGoalWaterJumpAbstract.class, PathfinderGoalWaterJumpAbstract.class, "a");
    //public static final GeneratePathfinderGoal<PathfinderGoalWrapped> WRAPPED =
    //        new GeneratePathfinderGoal<>(PathfinderGoalWrapped.class, PathfinderGoalWrapped.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalZombieAttack> ZOMBIE_ATTACK =
            new Generator_PathfinderGoal<>(PathfinderGoalZombieAttack.class, EntityZombie.class,
                    List.of(new PathfinderField("speed", double.class),
                            new PathfinderField("var0", boolean.class)),
                    List.of(new PathfinderParameter<>("speed", double.class),
                            new PathfinderParameter<>("var0", boolean.class)));

    // TARGET PATHFINDERS
    public static final Generator_PathfinderGoal<PathfinderGoalDefendVillage> DEFEND_VILLAGE =
            new Generator_PathfinderGoal<>(PathfinderGoalDefendVillage.class, EntityIronGolem.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalHurtByTarget> HURT_BY_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalHurtByTarget.class, EntityCreature.class,
                    List.of(new PathfinderField("classes", Class[].class)),
                    List.of(new EntityClassesWrapperParameter("classes")));
    public static final Generator_PathfinderGoal<PathfinderGoalNearestAttackableTarget> NEAREST_ATTACKABLE_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalNearestAttackableTarget.class, EntityInsentient.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("chance", int.class),
                            new PathfinderField("checkOfCanSee", boolean.class),
                            new PathfinderField("onlyIfPathExists", boolean.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new PathfinderParameter<>("clazz", Class.class),
                            new PathfinderParameter<>("chance", int.class, "10"),
                            new PathfinderParameter<>("checkOfCanSee", boolean.class),
                            new PathfinderParameter<>("onlyIfPathExists", boolean.class, "false"),
                            new PathfinderParameter<>("predicate", Predicate.class, "null")));

    public static final Generator_PathfinderGoal<PathfinderGoalNearestAttackableTargetWitch> NEAREST_ATTACKABLE_TARGET_WITCH =
            new Generator_PathfinderGoal<>(PathfinderGoalNearestAttackableTargetWitch.class, EntityRaider.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("var0", int.class),
                            new PathfinderField("var1", boolean.class),
                            new PathfinderField("var2", boolean.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new PathfinderParameter<>("clazz", Class.class),
                            new PathfinderParameter<>("var0", int.class),
                            new PathfinderParameter<>("var1", boolean.class),
                            new PathfinderParameter<>("var2", boolean.class),
                            new PathfinderParameter<>("predicate", Predicate.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalNearestHealableRaider> NEAREST_HEALABLE_RAIDER =
            new Generator_PathfinderGoal<>(PathfinderGoalNearestHealableRaider.class, EntityRaider.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("var0", boolean.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new PathfinderParameter<>("clazz", Class.class),
                            new PathfinderParameter<>("var0", boolean.class),
                            new PathfinderParameter<>("predicate", Predicate.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalOwnerHurtByTarget> OWNER_HURT_BY_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalOwnerHurtByTarget.class, EntityTameableAnimal.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalOwnerHurtTarget> OWNER_HURT_TARGET =
            new Generator_PathfinderGoal<>(PathfinderGoalOwnerHurtTarget.class, EntityTameableAnimal.class, List.of());
    public static final Generator_PathfinderGoal<PathfinderGoalRandomTargetNonTamed> RANDOM_TARGET_NON_TAMED =
            new Generator_PathfinderGoal<>(PathfinderGoalRandomTargetNonTamed.class, EntityTameableAnimal.class,
                    List.of(new PathfinderField("clazz", Class.class),
                            new PathfinderField("var0", boolean.class),
                            new PathfinderField("predicate", Predicate.class)),
                    List.of(new PathfinderParameter<>("clazz", Class.class),
                            new PathfinderParameter<>("var0", boolean.class),
                            new PathfinderParameter<>("predicate", Predicate.class)));
    //public static final GeneratePathfinderGoal<PathfinderGoalTarget> TARGET =
    //        new GeneratePathfinderGoal<>(PathfinderGoalTarget.class, EntityInsentient.class,
    //                List.of(new PathfinderField("var0", boolean.class)),
    //                List.of(new PathfinderParameter<>("var0", boolean.class)));
    public static final Generator_PathfinderGoal<PathfinderGoalUniversalAngerReset> UNIVERSAL_ANGER_RESET =
            new Generator_PathfinderGoal<>(PathfinderGoalUniversalAngerReset.class, EntityInsentient.class,
                    List.of(new PathfinderField("var0", boolean.class)),
                    List.of(new PathfinderParameter<>("var0", boolean.class)));


    public static final List<Generator_PathfinderGoal<?>> TYPES = new LinkedList<>();

    public static final List<Generator_PathfinderGoal<?>> TARGET_TYPES = new LinkedList<>();


    static {
        TYPES.add(CLIMB_ON_TOP_OF_POWDER_SNOW_GOAL);
        TYPES.add(ARROW_ATTACK);
        TYPES.add(AVOID_TARGET);
        TYPES.add(BEG);
        //      TYPES.add(BOAT);
        TYPES.add(BOW_SHOOT);
        TYPES.add(BREAK_DOOR);
        TYPES.add(BREATH);
        TYPES.add(BREED);
        TYPES.add(CAT_SIT_ON_BED);
        TYPES.add(CROSSBOW_ATTACK);
        //      TYPES.add(DOOR_INTERACT);
        TYPES.add(DOOR_OPEN);
        TYPES.add(EAT_TILE);
        TYPES.add(FISH_SCHOOL);
        TYPES.add(FLEE_SUN);
        TYPES.add(FLOAT);
        TYPES.add(FOLLOW_BOAT);
        TYPES.add(FOLLOW_ENTITY);
        TYPES.add(FOLLOW_OWNER);
        TYPES.add(FOLLOW_PARENT);
        //      TYPES.add(GOTO_TARGET);
        TYPES.add(INTERACT);
        TYPES.add(JUMP_ON_BLOCK);
        TYPES.add(LEAP_AT_TARGET);
        TYPES.add(LLAMA_FOLLOW);
        TYPES.add(LOOK_AT_PLAYER);
        TYPES.add(LOOK_AT_TRADING_PLAYER);
        TYPES.add(MELEE_ATTACK);
        TYPES.add(MOVE_TOWARDS_RESTRICTION);
        TYPES.add(MOVE_TOWARDS_TARGET);
        TYPES.add(NEAREST_VILLAGE);
        TYPES.add(OCELOT_ATTACK);
        TYPES.add(OFFER_FLOWER);
        TYPES.add(PANIC);
        TYPES.add(PERCH);
        TYPES.add(RAID);
        TYPES.add(RANDOM_FLY);
        TYPES.add(RANDOM_LOOKAROUND);
        TYPES.add(RANDOM_STROLL);
        TYPES.add(RANDOM_STROLL_LAND);
        TYPES.add(RANDOM_SWIM);
        //      TYPES.add(REMOVE_BLOCK);
        TYPES.add(RESTRICT_SUN);
        TYPES.add(SIT);
        TYPES.add(STROLL_VILLAGE);
        TYPES.add(STROLL_VILLAGE_GOLEM);
        TYPES.add(SWELL);
        TYPES.add(TAME);
        //      TYPES.add(TEMPT);
        TYPES.add(TRADE_WITH_PLAYER);
        TYPES.add(USE_ITEM);
        TYPES.add(MOVE_THROUGH_VILLAGE);
        TYPES.add(WATER);
        TYPES.add(WATER_JUMP);
        //      TYPES.add(WATER_JUMP_ABSTRACT);
        //      TYPES.add(WRAPPED);
        TYPES.add(ZOMBIE_ATTACK);


        TARGET_TYPES.add(DEFEND_VILLAGE);
        TARGET_TYPES.add(HURT_BY_TARGET);
        TARGET_TYPES.add(NEAREST_ATTACKABLE_TARGET);
        TARGET_TYPES.add(NEAREST_ATTACKABLE_TARGET_WITCH);
        TARGET_TYPES.add(NEAREST_HEALABLE_RAIDER);
        TARGET_TYPES.add(OWNER_HURT_BY_TARGET);
        TARGET_TYPES.add(OWNER_HURT_TARGET);
        TARGET_TYPES.add(RANDOM_TARGET_NON_TAMED);
        //      TARGET_TYPES.add(TARGET);
        TARGET_TYPES.add(UNIVERSAL_ANGER_RESET);
    }


    private final Class<Clazz> clazz;
    private final Class<?> entityFieldClass;
    private final List<PathfinderField> pathfinderFields;
    private final List<PathfinderParameter<?>>[] parametersList;
    private final LinkedList<LinkedList<PathfinderParameter<?>>> constructorsParameters;

    public Generator_PathfinderGoal(Class<Clazz> clazz, Class<?> entityFieldClass,
                                    List<PathfinderField> fields,
                                    List<PathfinderParameter<?>>... parametersList) {
        this.clazz = clazz;
        this.entityFieldClass = entityFieldClass;
        this.pathfinderFields = fields;
        this.parametersList = parametersList;
        this.constructorsParameters = new LinkedList<>();

        for (List<PathfinderParameter<?>> parameters : this.parametersList) {
            LinkedList<LinkedList<PathfinderParameter<?>>> derivateConstructorParameters = new LinkedList<>();

            derivateConstructorParameters.add(new LinkedList<>());

            for (PathfinderParameter<?> parameter : parameters) {
                if (!parameter.hasDefaultValue()) {
                    derivateConstructorParameters.forEach(l -> l.addLast(parameter));
                } else {
                    LinkedList<LinkedList<PathfinderParameter<?>>> constructorParametersWithDefaultValue =
                            new LinkedList<>();

                    PathfinderParameter<?> parameterWithoutDefault =
                            new PathfinderParameter<>(parameter.getName(), parameter.getFieldNames(),
                                    parameter.getTypeClass());

                    for (LinkedList<PathfinderParameter<?>> list : derivateConstructorParameters) {
                        LinkedList<PathfinderParameter<?>> copy = new LinkedList<>(list);
                        copy.addLast(parameter);
                        constructorParametersWithDefaultValue.add(copy);
                    }

                    for (LinkedList<PathfinderParameter<?>> list : derivateConstructorParameters) {
                        list.addLast(parameterWithoutDefault);
                    }

                    derivateConstructorParameters.addAll(constructorParametersWithDefaultValue);
                }
            }

            constructorsParameters.addAll(derivateConstructorParameters);
        }
    }

    public String getExName() {
        return "Ex" + this.getName();
    }

    public String getName() {
        return this.clazz.getSimpleName();
    }

    public Class<Clazz> getNmsClass() {
        return clazz;
    }

    public Class<?> getEntityFieldClass() {
        return entityFieldClass;
    }

    public List<PathfinderField> getPathfinderFields() {
        return pathfinderFields;
    }

    public List<PathfinderParameter<?>>[] getParametersList() {
        return parametersList;
    }

    public LinkedList<LinkedList<PathfinderParameter<?>>> getConstructorsParameters() {
        return this.constructorsParameters;
    }

    public int getConstructorsParametersSize() {
        return this.constructorsParameters.size();
    }

    public static class PathfinderField {

        protected final String name;
        protected final Class<?> typeClass;
        protected final Optional<String> defaultValue;

        public PathfinderField(String name, Class<?> typeClass) {
            this.name = name;
            this.typeClass = typeClass;
            this.defaultValue = Optional.empty();
        }

        public PathfinderField(String name, Class<?> typeClass, String defaultValue) {
            this.name = name;
            this.typeClass = typeClass;
            this.defaultValue = Optional.of(defaultValue);
        }

        public String getName() {
            return name;
        }

        public String getTypeClassName() {
            return typeClass.getTypeName();
        }

        public boolean hasDefaultValue() {
            return this.defaultValue.isPresent();
        }

        public String getDefaultValue() {
            return defaultValue.get();
        }
    }

    public static class PathfinderParameter<Type> {

        protected final String name;
        protected final List<String> fieldNames;
        protected final Class<Type> typeClass;
        protected final Optional<String> defaultValue;

        public PathfinderParameter(String name, List<String> fieldNames, Class<Type> typeClass) {
            this.name = name;
            this.fieldNames = fieldNames;
            this.typeClass = typeClass;
            this.defaultValue = Optional.empty();
        }

        public PathfinderParameter(String name, String fieldName, Class<Type> typeClass) {
            this(name, List.of(fieldName), typeClass);
        }

        public PathfinderParameter(String name, Class<Type> typeClass) {
            this(name, name, typeClass);
        }

        public PathfinderParameter(String name, List<String> fieldNames, Class<Type> typeClass, String defaultValue) {
            this.name = name;
            this.fieldNames = fieldNames;
            this.typeClass = typeClass;
            this.defaultValue = Optional.of(defaultValue);
        }

        public PathfinderParameter(String name, String fieldName, Class<Type> typeClass, String defaultValue) {
            this(name, List.of(fieldName), typeClass, defaultValue);
        }

        public PathfinderParameter(String name, Class<Type> typeClass, String defaultValue) {
            this(name, name, typeClass, defaultValue);
        }

        public String getName() {
            return name;
        }

        public List<String> getFieldNames() {
            return this.fieldNames;
        }

        public String getValue() {
            return this.defaultValue.isPresent() ? defaultValue.get() : name;
        }

        public String getTypeClassName() {
            return typeClass.getTypeName();
        }

        public Class<Type> getTypeClass() {
            return typeClass;
        }

        public boolean hasDefaultValue() {
            return this.defaultValue.isPresent();
        }

        public Optional<String> getDefaultValue() {
            return defaultValue;
        }
    }

    public static class WrapperPathfinderParameter<Type> extends PathfinderParameter<Type> {

        protected final String extractor;

        public WrapperPathfinderParameter(String name, List<String> fieldNames, Class<Type> typeClass,
                                          String extractor) {
            super(name, fieldNames, typeClass);
            this.extractor = extractor;
        }

        public WrapperPathfinderParameter(String name, Class<Type> typeClass, String extractor) {
            super(name, typeClass);
            this.extractor = extractor;
        }

        public WrapperPathfinderParameter(String name, Class<Type> typeClass, String extractor, String defaultValue) {
            super(name, typeClass, defaultValue);
            this.extractor = extractor;
        }

        @Override
        public String getValue() {
            return extractor;
        }
    }

    public static class EntityWrapperParameter<Type> extends WrapperPathfinderParameter<Type> {

        public EntityWrapperParameter(String name, Class<Type> typeClass) {
            super(name, typeClass, name + ".getNMS()");
        }

        public EntityWrapperParameter(String name, Class<Type> typeClass, String defaultValue) {
            super(name, typeClass, name + ".getNMS()", defaultValue);
        }
    }

    public static class EntityClassWrapperParameter extends WrapperPathfinderParameter<Class> {

        public EntityClassWrapperParameter(String name) {
            super(name, Class.class, "de.timesnake.library.entities.entity.type.EntityMapper.mapExClassToNmsClass(" + name + ")");
        }

        public EntityClassWrapperParameter(String name, String defaultValue) {
            super(name, Class.class, "de.timesnake.library.entities.entity.type.EntityMapper.mapExClassToNmsClass(" + name + ")", defaultValue);
        }

        @Override
        public String getValue() {
            return name;
        }

        @Override
        public String getTypeClassName() {
            return typeClass.getName();
        }
    }

    public static class EntityClassesWrapperParameter extends WrapperPathfinderParameter<Class[]> {

        public EntityClassesWrapperParameter(String name) {
            super(name, Class[].class, "de.timesnake.library.entities.entity.type.EntityMapper.mapExClassesToNmsClasses" +
                    "(" + name + ")");
        }

        public EntityClassesWrapperParameter(String name, String defaultValue) {
            super(name, Class[].class, "de.timesnake.library.entities.entity.type.EntityMapper.mapExClassesToNmsClasses" +
                    "(" + name + ")", defaultValue);
        }

        @Override
        public String getTypeClassName() {
            return typeClass.getTypeName();
        }
    }

    public static class WorldWrapperParameter extends WrapperPathfinderParameter<World> {

        public WorldWrapperParameter(String name) {
            super(name, World.class,
                    "((org.bukkit.craftbukkit." + LibraryEntityGenerator.VERSION + ".CraftWorld) " + name + ")" +
                            ".getHandle()");
        }

        public WorldWrapperParameter(String name, String defaultValue) {
            super(name, World.class,
                    "((org.bukkit.craftbukkit." + LibraryEntityGenerator.VERSION + ".CraftWorld) " + name + ")" +
                            ".getHandle()", defaultValue);
        }
    }

    public static class ItemStackWrapperParameter extends WrapperPathfinderParameter<org.bukkit.inventory.ItemStack> {

        public ItemStackWrapperParameter(String name) {
            super(name, org.bukkit.inventory.ItemStack.class,
                    "org.bukkit.craftbukkit." + LibraryEntityGenerator.VERSION + ".inventory.CraftItemStack.asNMSCopy" +
                            "(" + name + ");");
        }

        public ItemStackWrapperParameter(String name, String defaultValue) {
            super(name, org.bukkit.inventory.ItemStack.class,
                    "org.bukkit.craftbukkit." + LibraryEntityGenerator.VERSION + ".inventory.CraftItemStack.asNMSCopy" +
                            "(" + name + ");",
                    defaultValue);
        }
    }

}
