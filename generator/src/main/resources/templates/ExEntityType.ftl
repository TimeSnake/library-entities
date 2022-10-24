<#include "Header.ftl">

package ${moduleName};

import ${extensionModuleName}.ExEntity;
import de.timesnake.library.entities.entity.bukkit.*;
import org.bukkit.entity.EntityType;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExEntityType<NmsType extends Entity, ExClass extends ${extensionModuleName}.Entity & org.bukkit.entity.Entity> {

<#list entities as entity>
    public static final ExEntityType<${entity.getNmsClass().getName()}, Ex${entity.getName()}> ${entity.getBukkitTypeName()} = new ExEntityType<>(EntityTypes.${entity.getNmsTypeName()}, ${entity.getNmsClass().getName()}.class, Ex${entity.getName()}.class);
</#list>

    public static final List<ExEntityType<?, ?>> TYPES = List.of(
<#list entities as entity>
            ${entity.getBukkitTypeName()}<#if entity_has_next>,</#if>
</#list>
    );

public static final Map<Class<? extends de.timesnake.library.entities.entity.extension.Entity>, ExEntityType<?, ?>> TYPE_BY_EX_CLASS =
            TYPES.stream().collect(Collectors.toMap(ExEntityType::getExClass, t -> t));
    public static final Map<Class<? extends net.minecraft.world.entity.Entity>, ExEntityType<?, ?>> TYPE_BY_NMS_CLASS =
            TYPES.stream().collect(Collectors.toMap(ExEntityType::getNMSClass, t -> t));

    @Deprecated
    public static ExEntityType<?, ?> getByExClass(Class<? extends de.timesnake.library.entities.entity.extension.Entity> clazz) {
        return TYPE_BY_EX_CLASS.get(clazz);
    }

    @Deprecated
    public static ExEntityType<?, ?>[] getByExClasses(Class<? extends de.timesnake.library.entities.entity.extension.Entity>... exClasses) {
        ExEntityType<?, ?>[] nmsClasses = new ExEntityType[exClasses.length];
        for (int i = 0; i < exClasses.length; i++) {
            nmsClasses[i] = getByExClass(exClasses[i]);

        }
        return nmsClasses;
    }

    @Deprecated
    public static ExEntityType<?, ?> getByNmsClass(Class<? extends net.minecraft.world.entity.Entity> clazz) {
        return TYPE_BY_NMS_CLASS.get(clazz);
    }

    @Deprecated
    public static ExEntityType<?, ?>[] getByNmsClasses(Class<? extends net.minecraft.world.entity.Entity>... nmsClasses) {
        ExEntityType<?, ?>[] exClasses = new ExEntityType[nmsClasses.length];
        for (int i = 0; i < nmsClasses.length; i++) {
            exClasses[i] = getByNmsClass(nmsClasses[i]);

        }
        return exClasses;
    }

    private final EntityTypes<NmsType> nmsType;
    private final Class<NmsType> nmsClass;
    private final Class<ExClass> exClass;

    public ExEntityType(EntityTypes<NmsType> nmsType, Class<NmsType> nmsClass, Class<ExClass> exClass) {
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

    public Class<ExClass> getExClass() {
        return exClass;
    }
}