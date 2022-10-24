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

package de.timesnake.library.entities.entity.type;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.generator.Placeholder;
import de.timesnake.library.entities.generator.PlaceholderException;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;

@Placeholder
public interface ExEntityType<NmsType extends Entity, ExClass extends Entity & org.bukkit.entity.Entity> {

    static ExEntityType<?, ?> getByExClass(Class<? extends ExEntity> clazz) {
        throw new PlaceholderException();
    }

    static ExEntityType<?, ?>[] getByExClasses(Class<? extends ExEntity>... exClasses) {
        throw new PlaceholderException();
    }

    static ExEntityType<?, ?> getByNmsClass(Class<? extends net.minecraft.world.entity.Entity> clazz) {
        throw new PlaceholderException();
    }

    static ExEntityType<?, ?>[] getByNmsClasses(Class<? extends net.minecraft.world.entity.Entity>... nmsClasses) {
        throw new PlaceholderException();
    }

    EntityTypes<NmsType> getNMSType();

    Class<NmsType> getNMSClass();

    Class<ExClass> getExClass();

}
