package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

import java.util.EnumSet;

@NmsReflection
public class PathfinderGoalLocation extends PathfinderGoal {


    private final ExEntityInsentient entity;

    private final double speed;
    private final double trackingDistance;
    private final double minDistance;

    private final double x;
    private final double y;
    private final double z;

    public PathfinderGoalLocation(ExEntityInsentient entity, double x, double y, double z, double speed,
                                  double trackingDistance, double minDistance) {
        this.entity = entity;
        this.speed = speed;
        this.trackingDistance = trackingDistance;
        this.minDistance = minDistance;
        this.x = x;
        this.y = y;
        this.z = z;
        this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
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
