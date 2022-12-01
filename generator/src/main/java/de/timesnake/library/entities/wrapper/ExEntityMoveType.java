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

import net.minecraft.world.entity.EnumMoveType;

public enum ExEntityMoveType {

    SELF(EnumMoveType.a),
    PLAYER(EnumMoveType.b),
    PISTON(EnumMoveType.c),
    SHULKER_BOX(EnumMoveType.d),
    SHULKER(EnumMoveType.e);

    private final EnumMoveType type;

    ExEntityMoveType(EnumMoveType type) {
        this.type = type;
    }

    public EnumMoveType getNMSType() {
        return type;
    }
}
