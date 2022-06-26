<#include "Header.ftl">

package ${moduleName};

import ${extensionModuleName}.ExEntity;
import ${entityModuleName}.ExtendedEntity;
import ${entityModuleName}.ExtendedCraftEntity;
import de.timesnake.library.entities.entity.bukkit.*;
import org.bukkit.entity.EntityType;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExEntityType<NmsType extends Entity> {

<#list entities as entity>
    public static final ExEntityType<${entity.getNmsClass().getName()}> ${entity.getBukkitTypeName()} = new ExEntityType<>(EntityTypes.${entity.getNmsTypeName()}, ${entity.getNmsClass().getName()}.class, Ex${entity.getName()}.class);
</#list>

    public static final List<ExEntityType<? extends Entity>> TYPES = List.of(
<#list entities as entity>
            ${entity.getBukkitTypeName()}<#if entity_has_next>,</#if>
</#list>
    );

    public static final Map<Class<? extends ExtendedCraftEntity<?>>, ExEntityType<? extends Entity>> EX_TYPES_BY_EX_CLASS = new HashMap<>();
    public static final Map<EntityTypes<?>, ExEntityType<? extends Entity>> EX_TYPES_BY_NMS_TYPE = new HashMap<>();
    public static final Map<Class<? extends ExtendedCraftEntity<?>>, Class<? extends Entity>> NMS_CLASS_BY_EX_CLASS = new HashMap<>();
    public static final Map<Class<? extends Entity>, Class<? extends ExtendedCraftEntity<?>>> EX_CLASS_BY_NMS_CLASS = new HashMap<>();


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

    public static Class<? extends Entity> getNmsClassByExClass(Class<? extends ExEntity> clazz) {
        Class<? extends Entity> nmsClazz = NMS_CLASS_BY_EX_CLASS.get(clazz);
        if (nmsClazz != null) return nmsClazz;
        return ExAbstractEntityType.getAbstractNmsClassByExClass(clazz);
    }

    public static Class<? extends Entity>[] getNmsClassesByExClasses(Class<? extends ExEntity>... exClasses) {
        Class<? extends Entity>[] nmsClasses = new Class[exClasses.length];
        for (int i = 0; i < exClasses.length; i++) {
            nmsClasses[i] = getNmsClassByExClass(exClasses[i]);
            if (nmsClasses[i] == null) {
                nmsClasses[i] = ExAbstractEntityType.getAbstractNmsClassByExClass(exClasses[i]);
            }
        }
        return nmsClasses;
    }

    public static Class<? extends ExtendedEntity> getExClassByNmsClass(Class<? extends Entity> clazz) {
        Class<? extends ExtendedEntity> nmsClazz = EX_CLASS_BY_NMS_CLASS.get(clazz);
        if (nmsClazz != null) return nmsClazz;
        return ExAbstractEntityType.getAbstractExClassByNmsClass(clazz);
    }

    public static Class<? extends ExtendedEntity>[] getExClassesByNmsClasses(Class<? extends Entity>... nmsClasses) {
        Class<? extends ExtendedEntity>[] exClasses = new Class[nmsClasses.length];
        for (int i = 0; i < nmsClasses.length; i++) {
            exClasses[i] = getExClassByNmsClass(nmsClasses[i]);
            if (exClasses[i] == null) {
                exClasses[i] = ExAbstractEntityType.getAbstractExClassByNmsClass(nmsClasses[i]);
            }
        }
        return exClasses;
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