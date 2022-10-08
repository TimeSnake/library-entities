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

@NmsReflection
public class ExCustomPathfinderGoalLocation extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalLocation(double x, double y, double z, double speed, double trackingDistance,
                                          double minDistance) {
        super(new CustomPathfinderGoalLocation(null, x, y, z, speed, trackingDistance, minDistance));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity);
    }

}
