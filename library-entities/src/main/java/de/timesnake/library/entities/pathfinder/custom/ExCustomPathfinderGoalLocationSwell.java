/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.bukkit.ExCreeper;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

import java.util.EnumSet;

public class ExCustomPathfinderGoalLocationSwell extends ExPathfinderGoal {

    public ExCustomPathfinderGoalLocationSwell(double swellRadius, double keepSwellingRadius) {
        super(new PathfinderGoalCustomSwell(null, swellRadius, keepSwellingRadius));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity);
    }

    public static class PathfinderGoalCustomSwell extends PathfinderGoal implements LocationTargetable {

        private final ExCreeper entity;
        private final double radius;
        private final double keepSwellingRadius;
        private Double x;
        private Double y;
        private Double z;

        public PathfinderGoalCustomSwell(ExCreeper entity, double radius, double keepSwellingRadius) {
            this.entity = entity;
            this.radius = radius;
            this.keepSwellingRadius = keepSwellingRadius;

            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
        }

        public boolean a() {
            if (this.x == null || this.y == null || this.z == null) {
                return false;
            }
            return this.entity.q() > 0 || this.entity.getExtension().distanceSquared(x, y, z) <= this.radius * this.radius;
        }

        public void c() {
            this.entity.getExtension().getNavigation().o();
            this.entity.getExtension().getNavigation().walkTo(this.x, this.y, this.z, 1d);
        }

        public void d() {
            this.x = null;
            this.y = null;
            this.z = null;
        }

        public void e() {
            if (this.x == null || this.y == null || this.z == null) {
                this.entity.a(-1);
            } else if (this.entity.getExtension().distanceSquared(x, y, z) > this.keepSwellingRadius * this.keepSwellingRadius) {
                this.entity.a(-1);
            } else {
                this.entity.a(1);
            }
        }

        public void setTarget(Double x, Double y, Double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
