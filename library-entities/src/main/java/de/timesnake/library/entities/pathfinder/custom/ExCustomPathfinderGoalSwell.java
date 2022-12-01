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

import de.timesnake.library.entities.entity.bukkit.ExCreeper;
import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

import java.util.EnumSet;

public class ExCustomPathfinderGoalSwell extends ExPathfinderGoal {

    public ExCustomPathfinderGoalSwell(double swellRadius, double keepSwellingRadius) {
        super(new PathfinderGoalSwell(null, swellRadius, keepSwellingRadius));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity.getBukkitEntity());
    }

    public static class PathfinderGoalSwell extends PathfinderGoal {

        private final ExCreeper entity;
        private final double radius;
        private final double keepSwellingRadius;
        private ExEntityLiving target;

        public PathfinderGoalSwell(ExCreeper entity, double radius, double keepSwellingRadius) {
            this.entity = entity;
            this.radius = radius;
            this.keepSwellingRadius = keepSwellingRadius;
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
        }

        public boolean a() {
            ExEntityLiving target = this.entity.getExtension().getExTarget();
            return this.entity.eK() > 0 || target != null && this.entity.getExtension().distanceSquared(target) < this.radius * this.radius;
        }

        public void c() {
            this.entity.getExtension().getNavigation().o();
            this.target = this.entity.getExtension().getExTarget();
        }

        public void d() {
            this.target = null;
        }

        public void e() {
            if (this.target == null) {
                this.entity.a(-1);
            } else if (this.entity.getExtension().distanceSquared(this.target) > this.keepSwellingRadius * this.keepSwellingRadius) {
                this.entity.a(-1);
            } else if (!this.entity.getExtension().getEntitySenses().a(this.target)) {
                this.entity.a(-1);
            } else {
                this.entity.a(1);
            }
        }
    }

}
