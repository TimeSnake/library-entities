/*
 * workspace.library-entities.library-entities.main
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

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.level.pathfinder.PathfinderAbstract;

@NmsReflection
public class ExPathfinderAbstract {

    protected int priority = 1;
    protected PathfinderAbstract pathfinder;

    public ExPathfinderAbstract(PathfinderAbstract pathfinder) {
        this.pathfinder = pathfinder;
    }

    public PathfinderAbstract getNMS() {
        return this.pathfinder;
    }

    public void setNMSField(String name, Object value) {
        RefUtil.setInstanceField(this.getNMS(), name, value);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
