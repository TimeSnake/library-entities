package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import org.bukkit.Location;

public abstract class PathfinderGoalUpdatedLocation extends PathfinderGoal {

    protected final ExEntityInsentient entity;

    protected final double speed;
    protected final double trackingDistance;
    protected final double minDistance;

    protected double x;
    protected double y;
    protected double z;

    public PathfinderGoalUpdatedLocation(ExEntityInsentient entity, double speed, double trackingDistance, double minDistance) {
        this.entity = entity;
        this.speed = speed;
        this.trackingDistance = trackingDistance;
        this.minDistance = minDistance;
    }

    @Override
    public boolean a() {
        Location loc = this.getNextLocation(new Location(this.entity.getNMSWorld().getWorld(), this.entity.getX(), this.entity.getY(), this.entity.getZ()));

        if (loc == null) {
            return false;
        }

        this.x = loc.getX();
        this.y = loc.getY();
        this.z = loc.getZ();

        if (this.entity.distanceSquared(x, y, z) < (this.minDistance * this.minDistance)) { // entity distance < minDistance
            return false;
        } else if (this.entity.distanceSquared(x, y, z) > (this.trackingDistance * this.trackingDistance)) { // entity not in tracking distance
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

    public abstract Location getNextLocation(Location entityLoc);
}