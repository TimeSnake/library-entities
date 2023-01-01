/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.entity.type;


import de.timesnake.library.entities.entity.extension.Entity;
import java.util.Arrays;
import java.util.Objects;

public class EntityMapper {

    public static <T extends net.minecraft.world.entity.Entity> Class<T> mapExClassToNmsClass(Class<? extends Entity> clazz) {
        try {
            return (Class<T>) clazz.getField("NMS_CLASS").get(null);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return null;
    }

    public static <T extends net.minecraft.world.entity.Entity> Class<T>[] mapExClassesToNmsClasses(Class<? extends Entity>[] classes) {
        return Arrays.stream(classes).map(EntityMapper::mapExClassToNmsClass).filter(Objects::nonNull).toArray(Class[]::new);
    }
}
