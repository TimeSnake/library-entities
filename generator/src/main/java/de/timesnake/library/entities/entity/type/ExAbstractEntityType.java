/*
 * library-entities.generator.main
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

/*
    Copied from entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.entity.type;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.entity.extension.HumanEntity;
import org.bukkit.entity.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExAbstractEntityType<NmsType extends net.minecraft.world.entity.Entity> {

    public static final ExAbstractEntityType<net.minecraft.world.entity.Entity> ENTITY = new ExAbstractEntityType<>(net.minecraft.world.entity.Entity.class, de.timesnake.library.entities.entity.extension.ExEntity.class, org.bukkit.entity.Entity.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.EntityAgeable> ENTITY_AGEABLE = new ExAbstractEntityType<>(net.minecraft.world.entity.EntityAgeable.class, de.timesnake.library.entities.entity.extension.ExEntityAgeable.class, Ageable.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.ambient.EntityAmbient> ENTITY_AMBIENT = new ExAbstractEntityType<>(net.minecraft.world.entity.ambient.EntityAmbient.class, de.timesnake.library.entities.entity.extension.ExEntityAmbient.class, Ambient.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.animal.EntityAnimal> ENTITY_ANIMAL = new ExAbstractEntityType<>(net.minecraft.world.entity.animal.EntityAnimal.class, de.timesnake.library.entities.entity.extension.ExEntityAnimal.class, Animals.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.projectile.EntityArrow> ENTITY_ARROW = new ExAbstractEntityType<>(net.minecraft.world.entity.projectile.EntityArrow.class, de.timesnake.library.entities.entity.extension.ExEntityArrow.class, AbstractArrow.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.EntityCreature> ENTITY_CREATURE = new ExAbstractEntityType<>(net.minecraft.world.entity.EntityCreature.class, de.timesnake.library.entities.entity.extension.ExEntityCreature.class, Creature.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntityCreeper> ENTITY_CREEPER = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntityCreeper.class, de.timesnake.library.entities.entity.extension.ExEntityCreeper.class, Creeper.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.animal.EntityFish> ENTITY_FISH = new ExAbstractEntityType<>(net.minecraft.world.entity.animal.EntityFish.class, de.timesnake.library.entities.entity.extension.ExEntityFish.class, Fish.class);
    //public static final ExAbstractEntityType<net.minecraft.world.entity.animal.EntityFishSchool> ENTITY_FISH_SCHOOL = new ExAbstractEntityType<>(net.minecraft.world.entity.animal.EntityFishSchool.class, de.timesnake.library.entities.entity.extension.ExEntityFishSchool.class, Fish.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.EntityFlying> ENTITY_FLYING = new ExAbstractEntityType<>(net.minecraft.world.entity.EntityFlying.class, de.timesnake.library.entities.entity.extension.ExEntityFlying.class, Flying.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.animal.EntityGolem> ENTITY_GOLEM = new ExAbstractEntityType<>(net.minecraft.world.entity.animal.EntityGolem.class, de.timesnake.library.entities.entity.extension.ExEntityGolem.class, Golem.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.decoration.EntityHanging> ENTITY_HANGING = new ExAbstractEntityType<>(net.minecraft.world.entity.decoration.EntityHanging.class, de.timesnake.library.entities.entity.extension.ExEntityHanging.class, Hanging.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.player.EntityHuman> ENTITY_HUMAN = new ExAbstractEntityType<>(net.minecraft.world.entity.player.EntityHuman.class, de.timesnake.library.entities.entity.extension.ExEntityHuman.class, HumanEntity.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntityIllagerAbstract> ENTITY_ILLAGER_ABSTRACT = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntityIllagerAbstract.class, de.timesnake.library.entities.entity.extension.ExEntityIllagerAbstract.class, Illager.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntityIllagerWizard> ENTITY_ILLAGER_WIZARD = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntityIllagerWizard.class, de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard.class, Spellcaster.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.EntityInsentient> ENTITY_INSENTIENT = new ExAbstractEntityType<>(net.minecraft.world.entity.EntityInsentient.class, de.timesnake.library.entities.entity.extension.ExEntityInsentient.class, Mob.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.EntityLiving> ENTITY_LIVING = new ExAbstractEntityType<>(net.minecraft.world.entity.EntityLiving.class, de.timesnake.library.entities.entity.extension.ExEntityLiving.class, LivingEntity.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntityMonster> ENTITY_MONSTER = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntityMonster.class, de.timesnake.library.entities.entity.extension.ExEntityMonster.class, Monster.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntityMonsterPatrolling> ENTITY_MONSTER_PATROLLING = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntityMonsterPatrolling.class, de.timesnake.library.entities.entity.extension.ExEntityMonsterPatrolling.class, Monster.class);
    public static final ExAbstractEntityType<net.minecraft.server.level.EntityPlayer> ENTITY_PLAYER = new ExAbstractEntityType<>(net.minecraft.server.level.EntityPlayer.class, de.timesnake.library.entities.entity.extension.ExEntityPlayer.class, Player.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.raid.EntityRaider> ENTITY_RAIDER = new ExAbstractEntityType<>(net.minecraft.world.entity.raid.EntityRaider.class, de.timesnake.library.entities.entity.extension.ExEntityRaider.class, Raider.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntitySkeletonAbstract> ENTITY_SKELETON_ABSTRACT = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntitySkeletonAbstract.class, de.timesnake.library.entities.entity.extension.ExEntitySkeletonAbstract.class, AbstractSkeleton.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.monster.EntitySpider> ENTITY_SPIDER = new ExAbstractEntityType<>(net.minecraft.world.entity.monster.EntitySpider.class, de.timesnake.library.entities.entity.extension.ExEntitySpider.class, Spider.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.EntityTameableAnimal> ENTITY_TAMEABLE_ANIMAL = new ExAbstractEntityType<>(net.minecraft.world.entity.EntityTameableAnimal.class, de.timesnake.library.entities.entity.extension.ExEntityTameableAnimal.class, Tameable.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.npc.EntityVillagerAbstract> ENTITY_VILLAGER_ABSTRACT = new ExAbstractEntityType<>(net.minecraft.world.entity.npc.EntityVillagerAbstract.class, de.timesnake.library.entities.entity.extension.ExEntityVillagerAbstract.class, AbstractVillager.class);
    public static final ExAbstractEntityType<net.minecraft.world.entity.animal.EntityWaterAnimal> ENTITY_WATER_ANIMAL = new ExAbstractEntityType<>(net.minecraft.world.entity.animal.EntityWaterAnimal.class, de.timesnake.library.entities.entity.extension.ExEntityWaterAnimal.class, WaterMob.class);

    public static final List<ExAbstractEntityType<?>> ABSTRACT_TYPES = List.of(
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
            ENTITY_MONSTER_PATROLLING,
            ENTITY_PLAYER,
            ENTITY_RAIDER,
            ENTITY_SKELETON_ABSTRACT,
            ENTITY_SPIDER,
            ENTITY_TAMEABLE_ANIMAL,
            ENTITY_VILLAGER_ABSTRACT,
            ENTITY_WATER_ANIMAL
    );

    public static final Map<Class<? extends ExEntity>, ExAbstractEntityType<?>> TYPE_BY_EX_CLASS =
            ABSTRACT_TYPES.stream().collect(Collectors.toMap(ExAbstractEntityType::getExClass, t -> t));
    public static final Map<Class<? extends net.minecraft.world.entity.Entity>, ExAbstractEntityType<?>> TYPE_BY_NMS_CLASS =
            ABSTRACT_TYPES.stream().collect(Collectors.toMap(ExAbstractEntityType::getNMSClass, t -> t));

    public static ExAbstractEntityType<?> getByExClass(Class<? extends ExEntity> clazz) {
        return TYPE_BY_EX_CLASS.get(clazz);
    }

    public static ExAbstractEntityType<?>[] getByExClasses(Class<? extends ExEntity>... exClasses) {
        ExAbstractEntityType<?>[] nmsClasses = new ExAbstractEntityType[exClasses.length];
        for (int i = 0; i < exClasses.length; i++) {
            nmsClasses[i] = getByExClass(exClasses[i]);

        }
        return nmsClasses;
    }

    public static ExAbstractEntityType<?> getByNmsClass(Class<? extends net.minecraft.world.entity.Entity> clazz) {
        return TYPE_BY_NMS_CLASS.get(clazz);
    }

    public static ExAbstractEntityType<?>[] getByNmsClasses(Class<? extends net.minecraft.world.entity.Entity>... nmsClasses) {
        ExAbstractEntityType<?>[] exClasses = new ExAbstractEntityType[nmsClasses.length];
        for (int i = 0; i < nmsClasses.length; i++) {
            exClasses[i] = getByNmsClass(nmsClasses[i]);

        }
        return exClasses;
    }

    private final Class<NmsType> nmsClass;
    private final Class<? extends ExEntity> exClass;
    private final Class<? extends org.bukkit.entity.Entity> bukkitInterface;

    public ExAbstractEntityType(Class<NmsType> nmsClass, Class<? extends ExEntity> exClass,
                                Class<? extends org.bukkit.entity.Entity> bukkitInterface) {
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

    public Class<? extends org.bukkit.entity.Entity> getBukkitInterface() {
        return bukkitInterface;
    }
}
