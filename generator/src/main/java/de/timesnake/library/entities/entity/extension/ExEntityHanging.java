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

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.decoration.EntityHanging;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHanging;

public class ExEntityHanging extends ExEntity {

    public ExEntityHanging(CraftHanging entity) {
        super(entity);
    }

    public ExEntityHanging(EntityHanging entity) {
        super(entity);
    }

    @Override
    public EntityHanging getNMS() {
        return (EntityHanging) super.getNMS();
    }

    @Override
    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
        this.getNMS().c = new BlockPosition(x, y, z);
    }

    @Override
    public void setPosition(double x, double y, double z, boolean fixSpawnInBlock) {
        super.setPosition(x, y, z, fixSpawnInBlock);
        this.getNMS().c = new BlockPosition(x, y, z);
    }
}
