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
import net.minecraft.core.EnumDirection;

public enum ExEnumDirection {

    DOWN(EnumDirection.a),
    UP(EnumDirection.b),
    NORTH(EnumDirection.c),
    SOUTH(EnumDirection.d),
    WEST(EnumDirection.e),
    EAST(EnumDirection.f);

    private final EnumDirection direction;

    ExEnumDirection(EnumDirection direction) {
        this.direction = direction;
    }

    public EnumDirection getNMS() {
        return this.direction;
    }

    public BaseBlockPosition getBaseBlockPosition() {
        return this.direction.q();
    }

    public ExBaseBlockPosition getExBaseBlockPosition() {
        return new ExBaseBlockPosition(this.getBaseBlockPosition());
    }

    public int getAdjacentX() {
        return this.getExBaseBlockPosition().getX();
    }

    public int getAdjacentY() {
        return this.getExBaseBlockPosition().getY();
    }

    public int getAdjacentZ() {
        return this.getExBaseBlockPosition().getZ();
    }
}
