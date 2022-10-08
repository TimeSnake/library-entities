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
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityWaterAnimal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftWaterMob;

public class ExEntityWaterAnimal extends ExEntityCreature {

    public ExEntityWaterAnimal(CraftWaterMob entity) {
        super(entity);
    }

    public ExEntityWaterAnimal(EntityWaterAnimal entity) {
        super(entity);
    }
}
