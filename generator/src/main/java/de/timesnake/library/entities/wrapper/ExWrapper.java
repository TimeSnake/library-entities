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
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.Position;
import net.minecraft.world.entity.ai.navigation.NavigationAbstract;
import net.minecraft.world.level.pathfinder.PathEntity;
import net.minecraft.world.level.pathfinder.PathPoint;

@NmsReflection
public class ExWrapper {

    public static ExNavigationAbstract wrapNavigationAbstract(NavigationAbstract navigationAbstract) {
        if (navigationAbstract == null) {
            return null;
        }
        return new ExNavigationAbstract(navigationAbstract);
    }

    public static ExPathEntity wrapPathEntity(PathEntity pathEntity) {
        if (pathEntity == null) {
            return null;
        }
        return new ExPathEntity(pathEntity);
    }

    public static ExPathPoint wrapPathPoint(PathPoint pathPoint) {
        if (pathPoint == null) {
            return null;
        }
        return new ExPathPoint(pathPoint);
    }

    public static Position getPosition(double x, double y, double z) {
        return new Position(x, y, z);
    }

    public static ExBlockPosition wrapBlockPosition(BlockPosition position) {
        if (position == null) {
            return null;
        }
        return new ExBlockPosition(position);
    }
}
