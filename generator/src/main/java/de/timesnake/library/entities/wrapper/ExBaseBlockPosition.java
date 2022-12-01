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

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.BlockPosition;

public class ExBaseBlockPosition {

    protected final BaseBlockPosition block;

    public ExBaseBlockPosition(BaseBlockPosition block) {
        this.block = block;
    }

    public ExBaseBlockPosition(int x, int y, int z) {
        this.block = new BlockPosition(x, y, z);
    }

    public ExBaseBlockPosition(double x, double y, double z) {
        this.block = new BlockPosition(x, y, z);
    }

    public BaseBlockPosition getNMS() {
        return this.block;
    }

    public int getX() {
        return this.block.u();
    }

    public int getY() {
        return this.block.v();
    }

    public int getZ() {
        return this.block.w();
    }

    public boolean inRange(BaseBlockPosition position, double range) {
        return this.block.a(position, range);
    }

    public boolean inRange(ExBaseBlockPosition position, double range) {
        return this.inRange(position, range);
    }
}
