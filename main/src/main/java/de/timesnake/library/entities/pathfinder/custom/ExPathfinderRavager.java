/*
 * library-entities.library-entities.main
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

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.wrapper.ExPathType;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfinderNormal;

@NmsReflection
public class ExPathfinderRavager extends ExPathfinderNormal {

    public ExPathfinderRavager() {
        super(new PathfinderRavager());
    }

    protected static class PathfinderRavager extends PathfinderNormal {
        private PathfinderRavager() {
        }

        protected PathType a(IBlockAccess iblockaccess, boolean flag, boolean flag1, BlockPosition blockposition,
                             PathType pathtype) {
            return pathtype == ExPathType.LEAVES.getNMS() ? ExPathType.OPEN.getNMS() : super.a(iblockaccess, flag,
                    flag1, blockposition, pathtype);
        }
    }
}
