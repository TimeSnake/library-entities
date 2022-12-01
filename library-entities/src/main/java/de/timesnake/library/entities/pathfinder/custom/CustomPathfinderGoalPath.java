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
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.entities.wrapper.ExPathEntity;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import org.bukkit.Location;

import java.util.*;

public class CustomPathfinderGoalPath extends PathfinderGoal {


    protected final Mob entity;

    protected final double speed;
    protected final double minDistance;
    protected final Map<Integer, Location> pathPointsById = new HashMap<>();
    protected ExBlockPosition currentPosition;

    public CustomPathfinderGoalPath(Mob entity, Location target, double speed, double minDistance,
                                    Location... pathPoints) {
        this.entity = entity;
        this.speed = speed;
        this.minDistance = minDistance;

        int i = 0;
        for (; i < pathPoints.length; i++) {
            this.pathPointsById.put(i, pathPoints[i]);
        }
        this.pathPointsById.put(i, target);

        this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
    }

    public CustomPathfinderGoalPath(Mob entity, Location target, double speed, double minDistance,
                                    LinkedList<Location> pathPoints) {
        this.entity = entity;
        this.speed = speed;
        this.minDistance = minDistance;

        int i = 0;
        Iterator<Location> iterator = pathPoints.iterator();
        for (; i < pathPoints.size() && iterator.hasNext(); i++) {
            this.pathPointsById.put(i, iterator.next());
        }
        this.pathPointsById.put(i, target);

        this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
    }

    @Override
    public boolean a() {

        for (int i = this.pathPointsById.size() - 1; i >= 0; i--) {
            Location target = this.pathPointsById.get(i);
            ExBlockPosition position = new ExBlockPosition(target.getX(), target.getY(), target.getZ());

            if (this.entity.distanceSquared(target.getX(), target.getY(), target.getZ()) > (32 * 32)) {
                continue;
            }

            ExPathEntity pathEntity = this.entity.getNavigation().calcExPathTo(position);

            if (pathEntity != null) {
                if (pathEntity.getLastExPathPoint().getExPosition().inRange(position, this.minDistance)) {
                    do {
                        position = new ExBlockPosition(position.getX() + this.calcRandom(), position.getY(),
                                position.getZ() + this.calcRandom());
                        pathEntity = this.entity.getNavigation().calcExPathTo(position);
                    } while (pathEntity == null);
                    this.currentPosition = position;
                    return true;
                }
            }
        }

        return false;
    }

    private int calcRandom() {
        return (int) (Math.round(Math.random() * this.minDistance * 2) - this.minDistance);
    }

    @Override
    public void c() {
        this.entity.getNavigation().walkTo(this.currentPosition.getX(), this.currentPosition.getY(),
                this.currentPosition.getZ(), this.speed);
    }

    @Override
    public boolean b() {
        return !this.entity.getNavigation().isPathFinished() && this.entity.distanceSquared(this.currentPosition.getX(), this.currentPosition.getY(), this.currentPosition.getZ()) < (this.minDistance * this.minDistance);
    }

}
