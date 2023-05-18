/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.generator;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.entity.extension.ExEntityAgeable;
import de.timesnake.library.entities.entity.extension.ExEntityAmbient;
import de.timesnake.library.entities.entity.extension.ExEntityAnimal;
import de.timesnake.library.entities.entity.extension.ExEntityArrow;
import de.timesnake.library.entities.entity.extension.ExEntityCreature;
import de.timesnake.library.entities.entity.extension.ExEntityCreeper;
import de.timesnake.library.entities.entity.extension.ExEntityFireball;
import de.timesnake.library.entities.entity.extension.ExEntityFish;
import de.timesnake.library.entities.entity.extension.ExEntityFlying;
import de.timesnake.library.entities.entity.extension.ExEntityGolem;
import de.timesnake.library.entities.entity.extension.ExEntityHanging;
import de.timesnake.library.entities.entity.extension.ExEntityHuman;
import de.timesnake.library.entities.entity.extension.ExEntityIllagerAbstract;
import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.entities.entity.extension.ExEntityMonster;
import de.timesnake.library.entities.entity.extension.ExEntityPlayer;
import de.timesnake.library.entities.entity.extension.ExEntityRaider;
import de.timesnake.library.entities.entity.extension.ExEntitySkeletonAbstract;
import de.timesnake.library.entities.entity.extension.ExEntitySpider;
import de.timesnake.library.entities.entity.extension.ExEntityTameableAnimal;
import de.timesnake.library.entities.entity.extension.ExEntityVillagerAbstract;
import de.timesnake.library.entities.entity.extension.ExEntityWaterAnimal;
import de.timesnake.library.entities.entity.extension.ExIProjectile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityAgeable;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityFlying;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTameableAnimal;
import net.minecraft.world.entity.ambient.EntityAmbient;
import net.minecraft.world.entity.animal.EntityAnimal;
import net.minecraft.world.entity.animal.EntityFish;
import net.minecraft.world.entity.animal.EntityGolem;
import net.minecraft.world.entity.animal.EntityWaterAnimal;
import net.minecraft.world.entity.decoration.EntityHanging;
import net.minecraft.world.entity.monster.EntityCreeper;
import net.minecraft.world.entity.monster.EntityIllagerAbstract;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.entity.monster.EntityMonster;
import net.minecraft.world.entity.monster.EntitySkeletonAbstract;
import net.minecraft.world.entity.monster.EntitySpider;
import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.entity.projectile.EntityArrow;
import net.minecraft.world.entity.projectile.EntityFireball;
import net.minecraft.world.entity.projectile.IProjectile;
import net.minecraft.world.entity.raid.EntityRaider;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.AbstractSkeleton;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Flying;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Illager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Spellcaster;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.WaterMob;

public class Generator_ExAbstractEntityType<NmsType extends net.minecraft.world.entity.Entity> {

  public static final Generator_ExAbstractEntityType<net.minecraft.world.entity.Entity> ENTITY = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.Entity.class, ExEntity.class, Entity.class);
  public static final Generator_ExAbstractEntityType<EntityAgeable> ENTITY_AGEABLE = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.EntityAgeable.class, ExEntityAgeable.class, Ageable.class);
  public static final Generator_ExAbstractEntityType<EntityAmbient> ENTITY_AMBIENT = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.ambient.EntityAmbient.class, ExEntityAmbient.class,
      Ambient.class);
  public static final Generator_ExAbstractEntityType<EntityAnimal> ENTITY_ANIMAL = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.animal.EntityAnimal.class, ExEntityAnimal.class,
      Animals.class);
  public static final Generator_ExAbstractEntityType<EntityArrow> ENTITY_ARROW = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.projectile.EntityArrow.class, ExEntityArrow.class,
      AbstractArrow.class);
  public static final Generator_ExAbstractEntityType<EntityCreature> ENTITY_CREATURE = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.EntityCreature.class, ExEntityCreature.class,
      Creature.class);
  public static final Generator_ExAbstractEntityType<EntityCreeper> ENTITY_CREEPER = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.monster.EntityCreeper.class, ExEntityCreeper.class,
      Creeper.class);
  public static final Generator_ExAbstractEntityType<EntityFish> ENTITY_FISH = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.animal.EntityFish.class, ExEntityFish.class, Fish.class);
  //public static final Generator_ExAbstractEntityType<EntityFishSchool> ENTITY_FISH_SCHOOL = new Generator_ExAbstractEntityType<>(net.minecraft.world.entity.animal.EntityFishSchool.class, ExEntityFishSchool.class, Fish.class);
  public static final Generator_ExAbstractEntityType<EntityFlying> ENTITY_FLYING = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.EntityFlying.class, ExEntityFlying.class, Flying.class);
  public static final Generator_ExAbstractEntityType<EntityGolem> ENTITY_GOLEM = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.animal.EntityGolem.class, ExEntityGolem.class, Golem.class);
  public static final Generator_ExAbstractEntityType<EntityHanging> ENTITY_HANGING = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.decoration.EntityHanging.class, ExEntityHanging.class,
      Hanging.class);
  public static final Generator_ExAbstractEntityType<EntityHuman> ENTITY_HUMAN = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.player.EntityHuman.class, ExEntityHuman.class,
      HumanEntity.class);
  public static final Generator_ExAbstractEntityType<EntityIllagerAbstract> ENTITY_ILLAGER_ABSTRACT = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.monster.EntityIllagerAbstract.class,
      ExEntityIllagerAbstract.class, Illager.class);
  public static final Generator_ExAbstractEntityType<EntityIllagerWizard> ENTITY_ILLAGER_WIZARD = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.monster.EntityIllagerWizard.class,
      ExEntityIllagerWizard.class, Spellcaster.class);
  public static final Generator_ExAbstractEntityType<EntityInsentient> ENTITY_INSENTIENT = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.EntityInsentient.class, ExEntityInsentient.class, Mob.class);
  public static final Generator_ExAbstractEntityType<EntityLiving> ENTITY_LIVING = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.EntityLiving.class, ExEntityLiving.class,
      LivingEntity.class);
  public static final Generator_ExAbstractEntityType<EntityMonster> ENTITY_MONSTER = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.monster.EntityMonster.class, ExEntityMonster.class,
      Monster.class);
  //public static final Generator_ExAbstractEntityType<EntityMonsterPatrolling> ENTITY_MONSTER_PATROLLING = new Generator_ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntityMonsterPatrolling.class, ExEntityMonsterPatrolling.class, Monster.class);
  public static final Generator_ExAbstractEntityType<EntityPlayer> ENTITY_PLAYER = new Generator_ExAbstractEntityType<>(
      net.minecraft.server.level.EntityPlayer.class, ExEntityPlayer.class, Player.class);
  public static final Generator_ExAbstractEntityType<EntityRaider> ENTITY_RAIDER = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.raid.EntityRaider.class, ExEntityRaider.class, Raider.class);
  public static final Generator_ExAbstractEntityType<EntitySkeletonAbstract> ENTITY_SKELETON_ABSTRACT = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.monster.EntitySkeletonAbstract.class,
      ExEntitySkeletonAbstract.class, AbstractSkeleton.class);
  public static final Generator_ExAbstractEntityType<EntitySpider> ENTITY_SPIDER = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.monster.EntitySpider.class, ExEntitySpider.class,
      Spider.class);
  public static final Generator_ExAbstractEntityType<EntityTameableAnimal> ENTITY_TAMEABLE_ANIMAL = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.EntityTameableAnimal.class, ExEntityTameableAnimal.class,
      Tameable.class);
  public static final Generator_ExAbstractEntityType<EntityVillagerAbstract> ENTITY_VILLAGER_ABSTRACT = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.npc.EntityVillagerAbstract.class,
      ExEntityVillagerAbstract.class, AbstractVillager.class);
  public static final Generator_ExAbstractEntityType<EntityWaterAnimal> ENTITY_WATER_ANIMAL = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.animal.EntityWaterAnimal.class, ExEntityWaterAnimal.class,
      WaterMob.class);
  public static final Generator_ExAbstractEntityType<EntityFireball> ENTITY_FIREBALL = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.projectile.EntityFireball.class, ExEntityFireball.class,
      Fireball.class);
  public static final Generator_ExAbstractEntityType<IProjectile> ENTITY_PROJECTILE = new Generator_ExAbstractEntityType<>(
      net.minecraft.world.entity.projectile.IProjectile.class, ExIProjectile.class,
      Projectile.class);

  public static final List<Generator_ExAbstractEntityType<?>> ABSTRACT_TYPES = List.of(
      ENTITY,
      ENTITY_AGEABLE,
      ENTITY_AMBIENT,
      ENTITY_ANIMAL,
      ENTITY_ARROW,
      ENTITY_CREATURE,
      ENTITY_CREEPER,
      ENTITY_FISH,
      //ENTITY_FISH_SCHOOL,
      ENTITY_FLYING,
      ENTITY_GOLEM,
      ENTITY_HANGING,
      ENTITY_HUMAN,
      ENTITY_ILLAGER_ABSTRACT,
      ENTITY_ILLAGER_WIZARD,
      ENTITY_INSENTIENT,
      ENTITY_LIVING,
      ENTITY_MONSTER,
      //ENTITY_MONSTER_PATROLLING,
      ENTITY_PLAYER,
      ENTITY_RAIDER,
      ENTITY_SKELETON_ABSTRACT,
      ENTITY_SPIDER,
      ENTITY_TAMEABLE_ANIMAL,
      ENTITY_VILLAGER_ABSTRACT,
      ENTITY_WATER_ANIMAL,
      ENTITY_FIREBALL,
      ENTITY_PROJECTILE
  );

  public static final Map<Class<? extends ExEntity>, Generator_ExAbstractEntityType<?>> TYPE_BY_EX_CLASS =
      new HashMap<>();
  public static final Map<Class<? extends net.minecraft.world.entity.Entity>, Generator_ExAbstractEntityType<?>> TYPE_BY_NMS_CLASS =
      new HashMap<>();

  public static Generator_ExAbstractEntityType<?> getByExClass(Class<? extends ExEntity> clazz) {
    return TYPE_BY_EX_CLASS.get(clazz);
  }

  public static Generator_ExAbstractEntityType<?>[] getByExClasses(
      Class<? extends ExEntity>... exClasses) {
    Generator_ExAbstractEntityType<?>[] nmsClasses = new Generator_ExAbstractEntityType[exClasses.length];
    for (int i = 0; i < exClasses.length; i++) {
      nmsClasses[i] = getByExClass(exClasses[i]);

    }
    return nmsClasses;
  }

  public static Generator_ExAbstractEntityType<?> getByNmsClass(
      Class<? extends net.minecraft.world.entity.Entity> clazz) {
    return TYPE_BY_NMS_CLASS.get(clazz);
  }

  public static Generator_ExAbstractEntityType<?>[] getByNmsClasses(
      Class<? extends net.minecraft.world.entity.Entity>... nmsClasses) {
    Generator_ExAbstractEntityType<?>[] exClasses = new Generator_ExAbstractEntityType[nmsClasses.length];
    for (int i = 0; i < nmsClasses.length; i++) {
      exClasses[i] = getByNmsClass(nmsClasses[i]);

    }
    return exClasses;
  }

  static {
    for (Generator_ExAbstractEntityType<?> entityType : ABSTRACT_TYPES) {
      TYPE_BY_EX_CLASS.put(entityType.getExClass(), entityType);
      TYPE_BY_NMS_CLASS.put(entityType.getNMSClass(), entityType);
    }
  }

  private final Class<NmsType> nmsClass;
  private final Class<? extends ExEntity> exClass;
  private final Class<? extends Entity> bukkitInterface;

  public Generator_ExAbstractEntityType(Class<NmsType> nmsClass,
      Class<? extends ExEntity> exClass,
      Class<? extends Entity> bukkitInterface) {
    this.nmsClass = nmsClass;
    this.exClass = exClass;
    this.bukkitInterface = bukkitInterface;
  }

  public Class<NmsType> getNMSClass() {
    return nmsClass;
  }

  public Class<? extends ExEntity> getExClass() {
    return exClass;
  }

  public Class<? extends Entity> getBukkitInterface() {
    return bukkitInterface;
  }
}
