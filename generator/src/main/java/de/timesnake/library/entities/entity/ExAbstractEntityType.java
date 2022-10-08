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

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.extension.*;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ambient.EntityAmbient;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.decoration.EntityHanging;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.entity.projectile.EntityArrow;
import net.minecraft.world.entity.raid.EntityRaider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExAbstractEntityType<NmsType extends Entity> {

    public static final ExAbstractEntityType<Entity> ENTITY = new ExAbstractEntityType<>(Entity.class,
            ExEntity.class);
    public static final ExAbstractEntityType<EntityAgeable> ENTITY_AGEABLE =
            new ExAbstractEntityType<>(EntityAgeable.class, ExEntityAgeable.class);
    public static final ExAbstractEntityType<EntityAmbient> ENTITY_AMBIENT =
            new ExAbstractEntityType<>(EntityAmbient.class, ExEntityAmbient.class);
    public static final ExAbstractEntityType<EntityAnimal> ENTITY_ANIMAL =
            new ExAbstractEntityType<>(EntityAnimal.class, ExEntityAnimal.class);
    public static final ExAbstractEntityType<EntityArrow> ENTITY_ARROW = new ExAbstractEntityType<>(EntityArrow.class
            , ExEntityArrow.class);
    public static final ExAbstractEntityType<EntityCreature> ENTITY_CREATURE =
            new ExAbstractEntityType<>(EntityCreature.class, ExEntityCreature.class);
    public static final ExAbstractEntityType<EntityCreeper> ENTITY_CREEPER =
            new ExAbstractEntityType<>(EntityCreeper.class, ExEntityCreeper.class);
    public static final ExAbstractEntityType<EntityFish> ENTITY_FISH = new ExAbstractEntityType<>(EntityFish.class,
            ExEntityFish.class);
    public static final ExAbstractEntityType<EntityFishSchool> ENTITY_FISH_SCHOOL =
            new ExAbstractEntityType<>(EntityFishSchool.class, ExEntityFishSchool.class);
    public static final ExAbstractEntityType<EntityFlying> ENTITY_FLYING =
            new ExAbstractEntityType<>(EntityFlying.class, ExEntityFlying.class);
    public static final ExAbstractEntityType<EntityGolem> ENTITY_GOLEM = new ExAbstractEntityType<>(EntityGolem.class
            , ExEntityGolem.class);
    public static final ExAbstractEntityType<EntityHanging> ENTITY_HANGING =
            new ExAbstractEntityType<>(EntityHanging.class, ExEntityHanging.class);
    public static final ExAbstractEntityType<EntityHuman> ENTITY_HUMAN = new ExAbstractEntityType<>(EntityHuman.class
            , ExEntityHuman.class);
    public static final ExAbstractEntityType<EntityIllagerAbstract> ENTITY_ILLAGER_ABSTRACT =
            new ExAbstractEntityType<>(EntityIllagerAbstract.class, ExEntityIllagerAbstract.class);
    public static final ExAbstractEntityType<EntityIllagerWizard> ENTITY_ILLAGER_WIZARD =
            new ExAbstractEntityType<>(EntityIllagerWizard.class, ExEntityIllagerWizard.class);
    public static final ExAbstractEntityType<EntityInsentient> ENTITY_INSENTIENT =
            new ExAbstractEntityType<>(EntityInsentient.class, ExEntityInsentient.class);
    public static final ExAbstractEntityType<EntityLiving> ENTITY_LIVING =
            new ExAbstractEntityType<>(EntityLiving.class, ExEntityLiving.class);
    public static final ExAbstractEntityType<EntityMonster> ENTITY_MONSTER =
            new ExAbstractEntityType<>(EntityMonster.class, ExEntityMonster.class);
    public static final ExAbstractEntityType<EntityMonsterPatrolling> ENTITY_MONSTER_PATROLLING =
            new ExAbstractEntityType<>(EntityMonsterPatrolling.class, ExEntityMonsterPatrolling.class);
    public static final ExAbstractEntityType<EntityPlayer> ENTITY_PLAYER =
            new ExAbstractEntityType<>(EntityPlayer.class, ExEntityPlayer.class);
    public static final ExAbstractEntityType<EntityRaider> ENTITY_RAIDER =
            new ExAbstractEntityType<>(EntityRaider.class, ExEntityRaider.class);
    public static final ExAbstractEntityType<EntitySkeletonAbstract> ENTITY_SKELETON_ABSTRACT =
            new ExAbstractEntityType<>(EntitySkeletonAbstract.class, ExEntitySkeletonAbstract.class);
    public static final ExAbstractEntityType<EntitySpider> ENTITY_SPIDER =
            new ExAbstractEntityType<>(EntitySpider.class, ExEntitySpider.class);
    public static final ExAbstractEntityType<EntityTameableAnimal> ENTITY_TAMEABLE_ANIMAL =
            new ExAbstractEntityType<>(EntityTameableAnimal.class, ExEntityTameableAnimal.class);
    public static final ExAbstractEntityType<EntityVillagerAbstract> ENTITY_VILLAGER_ABSTRACT =
            new ExAbstractEntityType<>(EntityVillagerAbstract.class, ExEntityVillagerAbstract.class);
    public static final ExAbstractEntityType<EntityWaterAnimal> ENTITY_WATER_ANIMAL =
            new ExAbstractEntityType<>(EntityWaterAnimal.class, ExEntityWaterAnimal.class);

    public static final List<ExAbstractEntityType<?>> ABSTRACT_TYPES = List.of(
            ENTITY,
            ENTITY_AGEABLE,
            ENTITY_AMBIENT,
            ENTITY_ANIMAL,
            ENTITY_ARROW,
            ENTITY_CREATURE,
            ENTITY_CREEPER,
            ENTITY_FISH,
            ENTITY_FISH_SCHOOL,
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

    public static final Map<Class<? extends ExEntity>, Class<? extends Entity>> ABSTRACT_NMS_CLASS_BY_EX_CLASS =
            new HashMap<>();
    public static final Map<Class<? extends Entity>, Class<? extends ExEntity>> ABSTRACT_EX_CLASS_BY_NMS_CLASS =
            new HashMap<>();

    public static Class<? extends Entity> getAbstractNmsClassByExClass(Class<? extends ExEntity> clazz) {
        return ABSTRACT_NMS_CLASS_BY_EX_CLASS.get(clazz);
    }

    public static Class<? extends Entity>[] getAbstractNmsClassesByExClasses(Class<? extends ExEntity>... exClasses) {
        Class<? extends Entity>[] nmsClasses = new Class[exClasses.length];
        for (int i = 0; i < exClasses.length; i++) {
            nmsClasses[i] = getAbstractNmsClassByExClass(exClasses[i]);

        }
        return nmsClasses;
    }

    public static Class<? extends ExEntity> getAbstractExClassByNmsClass(Class<? extends Entity> clazz) {
        return ABSTRACT_EX_CLASS_BY_NMS_CLASS.get(clazz);
    }

    public static Class<? extends ExEntity>[] getAbstractExClassesByNmsClasses(Class<? extends Entity>... nmsClasses) {
        Class<? extends ExEntity>[] exClasses = new Class[nmsClasses.length];
        for (int i = 0; i < nmsClasses.length; i++) {
            exClasses[i] = getAbstractExClassByNmsClass(nmsClasses[i]);

        }
        return exClasses;
    }

    static {
        for (ExAbstractEntityType<?> entityType : ABSTRACT_TYPES) {
            ABSTRACT_NMS_CLASS_BY_EX_CLASS.put(entityType.getExClass(), entityType.getNMSClass());
            ABSTRACT_EX_CLASS_BY_NMS_CLASS.put(entityType.getNMSClass(), entityType.getExClass());
        }
    }

    private final Class<NmsType> nmsClass;
    private final Class<? extends ExEntity> exClass;

    public ExAbstractEntityType(Class<NmsType> nmsClass, Class<? extends ExEntity> exClass) {
        this.nmsClass = nmsClass;
        this.exClass = exClass;
    }

    public Class<NmsType> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends ExEntity> getExClass() {
        return exClass;
    }


}
