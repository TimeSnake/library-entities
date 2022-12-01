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
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalMeleeAttack;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntitySpider;

public class ExCustomPathfinderGoalSpiderMeleeAttack extends ExPathfinderGoalMeleeAttack {

    public ExCustomPathfinderGoalSpiderMeleeAttack(float speed) {
        super(speed);
    }

    @Override
    public void injectEntity(Mob entity) {
        super.pathfinderGoal = new PathfinderGoalSpiderMeleeAttack(((EntitySpider) entity.getNMS()), this.speed);
    }

    static class PathfinderGoalSpiderMeleeAttack extends PathfinderGoalMeleeAttack {
        public PathfinderGoalSpiderMeleeAttack(EntitySpider entityspider, double speed) {
            super(entityspider, speed, true);
        }

        public boolean a() {
            return super.a() && !this.a.bK();
        }

        public boolean b() {
            float f = this.a.bh();
            if (f >= 0.5F && this.a.dR().a(100) == 0) {
                this.a.h((EntityLiving) null);
                return false;
            } else {
                return super.b();
            }
        }

        protected double a(EntityLiving entityliving) {
            return (double) (4.0F + entityliving.cX());
        }
    }
}
