/*
 * de.timesnake.workspace.library-entities.main
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
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import org.bukkit.Location;

public abstract class CustomPathfinderGoalUpdatedLocation extends PathfinderGoal {

    protected final Mob entity;
    protected final double trackingDistance;
    protected final double minDistance;
    protected double speed;
    protected double x;
    protected double y;
    protected double z;

    public CustomPathfinderGoalUpdatedLocation(Mob entity, double speed, double trackingDistance,
                                               double minDistance) {
        this.entity = entity;
        this.speed = speed;
        this.trackingDistance = trackingDistance;
        this.minDistance = minDistance;
    }

    @Override
    public boolean a() {
        Location loc = this.getNextLocation(new Location(this.entity.getNMSWorld().getWorld(), this.entity.getX(),
                this.entity.getY(), this.entity.getZ()));

        if (loc == null) {
            return false;
        }

        this.x = loc.getX();
        this.y = loc.getY();
        this.z = loc.getZ();

        if (this.entity.distanceSquared(x, y, z) < (this.minDistance * this.minDistance)) { // entity distance <
            // minDistance
            return false;
        } else {
            return !(this.entity.distanceSquared(x, y, z) > (this.trackingDistance * this.trackingDistance));
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

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public abstract Location getNextLocation(Location entityLoc);
}