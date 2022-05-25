package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.entities.entity.extension.ExEntityHuman;
import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.Location;

import java.util.LinkedList;

@NmsReflection
public class ExPathfinderGoalPathLeader extends ExPathfinderGoalPath {

    public ExPathfinderGoalPathLeader(Location target, double speed, double minDistance, ExEntityLiving follower,
                                      double maxfollowerDistance, Location... pathPoints) {
        super(new PathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public ExPathfinderGoalPathLeader(Location target, double speed, double minDistance, ExEntityHuman follower,
                                      double maxfollowerDistance, Location... pathPoints) {
        super(new PathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public ExPathfinderGoalPathLeader(Location target, double speed, double minDistance, ExEntityLiving follower,
                                      double maxfollowerDistance, LinkedList<Location> pathPoints) {
        super(new PathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public ExPathfinderGoalPathLeader(Location target, double speed, double minDistance, ExEntityHuman follower,
                                      double maxfollowerDistance, LinkedList<Location> pathPoints) {
        super(new PathfinderGoalPathLeader(null, target, speed, minDistance, follower, maxfollowerDistance,
                pathPoints));
    }

    public static class PathfinderGoalPathLeader extends PathfinderGoalPath {

        private final ExEntity follower;
        private final double maxFollowerDistance;

        public PathfinderGoalPathLeader(ExEntityInsentient entity, Location target, double speed, double minDistance,
                                        ExEntity follower, double maxfollowerDistance, Location... pathPoints) {
            super(entity, target, speed, minDistance, pathPoints);
            this.follower = follower;
            this.maxFollowerDistance = maxfollowerDistance;
        }

        public PathfinderGoalPathLeader(ExEntityInsentient entity, Location target, double speed, double minDistance,
                                        ExEntity follower, double maxfollowerDistance,
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

            if (this.follower.distanceSquared(this.entity) < this.maxFollowerDistance) {
                return true;
            }

            return false;
        }

        @Override
        public boolean b() {
            return !this.entity.getNavigation().isPathFinished() && this.entity.distanceSquared(this.currentPosition.getX(), this.currentPosition.getY(), this.currentPosition.getZ()) < (this.minDistance * this.minDistance) && this.follower.distanceSquared(this.entity) < this.maxFollowerDistance;
        }


    }
}
