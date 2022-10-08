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

package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.level.pathfinder.PathType;

@NmsReflection
public enum ExPathType {

    BLOCKED(PathType.a),
    OPEN(PathType.b),
    WALKABLE(PathType.c),
    WALKABLE_DOOR(PathType.d),
    TRAPDOOR(PathType.e),
    FENCE(PathType.f),
    LAVA(PathType.g),
    WATER(PathType.h),
    WATER_BORDER(PathType.i),
    RAIL(PathType.j),
    UNPASSABLE_RAIL(PathType.k),
    DANGER_FIRE(PathType.l),
    DAMAGE_FIRE(PathType.m),
    DANGER_CACTUS(PathType.n),
    DAMAGE_CACTUS(PathType.o),
    DANGER_OTHER(PathType.p),
    DAMAGE_OTHER(PathType.q),
    DOOR_OPEN(PathType.r),
    DOOR_WOOD_CLOSED(PathType.s),
    DOOR_IRON_CLOSED(PathType.t),
    BREACH(PathType.u),
    LEAVES(PathType.v),
    STICKY_HONEY(PathType.w),
    COCOA(PathType.x);

    private final PathType type;

    ExPathType(PathType type) {
        this.type = type;
    }

    public PathType getNMS() {
        return this.type;
    }
}
