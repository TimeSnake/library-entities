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

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BlockPosition;
import net.minecraft.world.phys.AxisAlignedBB;

public class ExAxisAlignedBB {

    private final AxisAlignedBB axis;

    public ExAxisAlignedBB(AxisAlignedBB axis) {
        this.axis = axis;
    }

    public AxisAlignedBB getNMS() {
        return this.axis;
    }

    public ExAxisAlignedBB grow(double x, double y, double z) {
        return new ExAxisAlignedBB(this.axis.a(x, y, z));
    }

    public ExAxisAlignedBB grow(double size) {
        return this.grow(size, size, size);
    }

    public AxisAlignedBB a(BlockPosition position) {
        return this.axis.a(position);
    }

    public ExAxisAlignedBB a(ExBlockPosition position) {
        return new ExAxisAlignedBB(this.a(position.getNMS()));
    }
}
