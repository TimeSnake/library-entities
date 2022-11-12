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

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

import java.util.EnumSet;

@NmsReflection
public class CustomPathfinderGoalLocation extends PathfinderGoal {


    private final Mob entity;

    private final double speed;
    private final double trackingDistance;
    private final double minDistance;

    private final double x;
    private final double y;
    private final double z;

    public CustomPathfinderGoalLocation(Mob entity, double x, double y, double z, double speed,
                                        double trackingDistance, double minDistance) {
        this.entity = entity;
        this.speed = speed;
        this.trackingDistance = trackingDistance;
        this.minDistance = minDistance;
        this.x = x;
        this.y = y;
        this.z = z;
        this.a(EnumSet.of(ExCustomPathfinderGoal.Type.MOVE.getNMS()));
    }

    @Override
    public boolean a() {

        if (this.entity.distanceSquared(x, y, z) < (this.minDistance * this.minDistance)) { // entity distance <
            // minDistance
            return false;
        } else if (this.entity.distanceSquared(x, y, z) > (this.trackingDistance * this.trackingDistance)) { //
            // entity not in tracking distance
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void c() {
        this.entity.getNavigation().walkTo(this.x, this.y, this.z, this.speed);
    }

    @Override
    public boolean b() {
        return !this.entity.getNavigation().m() && this.entity.distanceSquared(x, y, z) < (this.minDistance * this.minDistance);
    }

    @Override
    public void d() {

    }
}
