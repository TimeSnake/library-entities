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

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.Material;

@NmsReflection
public class ExCustomPathfinderGoalBreakBlockToLocation extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalBreakBlockToLocation(double x, double y, double z, double speedModifier,
                                                      Material... materials) {
        super(new CustomPathfinderGoalBreakBlockToLocation(null, x, y, z, speedModifier, materials));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }

}
