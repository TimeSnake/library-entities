/*
 * Copyright (C) 2022 timesnake
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