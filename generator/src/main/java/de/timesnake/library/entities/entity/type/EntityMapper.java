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
