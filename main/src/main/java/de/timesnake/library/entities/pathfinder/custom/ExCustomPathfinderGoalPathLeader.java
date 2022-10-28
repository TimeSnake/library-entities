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

import de.timesnake.library.entities.entity.extension.Entity;
import de.timesnake.library.entities.entity.extension.HumanEntity;
import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.Location;

import java.util.LinkedList;

@NmsReflection
public class ExCustomPathfinderGoalPathLeader extends ExCustomPathfinderGoalPath {

    public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance, LivingEntity follower,
                                            double maxfollowerDistance, Location... pathPoints) {
        super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance, HumanEntity follower,
                                            double maxfollowerDistance, Location... pathPoints) {
        super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance, LivingEntity follower,
                                            double maxfollowerDistance, LinkedList<Location> pathPoints) {
        super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public ExCustomPathfinderGoalPathLeader(Location target, double speed, double minDistance, HumanEntity follower,
                                            double maxfollowerDistance, LinkedList<Location> pathPoints) {
        super(new CustomPathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public static class CustomPathfinderGoalPathLeader extends CustomPathfinderGoalPath {

        private final Entity follower;
        private final double maxFollowerDistance;

        public CustomPathfinderGoalPathLeader(Mob entity, Location target, double speed,
                                              double minDistance,
                                              Entity follower, double maxfollowerDistance, Location... pathPoints) {
            super(entity, target, speed, minDistance, pathPoints);
            this.follower = follower;
            this.maxFollowerDistance = maxfollowerDistance;
        }

        public CustomPathfinderGoalPathLeader(Mob entity, Location target, double speed,
                                              double minDistance,
                                              Entity follower, double maxfollowerDistance,
                                              LinkedList<Location> pathPoints) {
            super(entity, target, speed, minDistance, pathPoints);
            this.follower = follower;
            this.maxFollowerDistance = maxfollowerDistance;
        }

        @Override
        public boolean a() {

            boolean run = super.a();

            if (!run) {
                return false;
            }

            // folower is
            if (this.follower.distanceSquared(this.currentPosition) < this.entity.distanceSquared(this.currentPosition)) {
                return true;
            }

            if (this.follower.distanceSquared(this.entity.getNMS()) < this.maxFollowerDistance) {
                return true;
            }

            return false;
        }

        @Override
        public boolean b() {
            return !this.entity.getNavigation().isPathFinished()
                    && this.entity.distanceSquared(this.currentPosition.getX(), this.currentPosition.getY(),
                    this.currentPosition.getZ()) < (this.minDistance * this.minDistance)
                    && this.follower.distanceSquared(this.entity.getNMS()) < this.maxFollowerDistance;
        }


    }
}
