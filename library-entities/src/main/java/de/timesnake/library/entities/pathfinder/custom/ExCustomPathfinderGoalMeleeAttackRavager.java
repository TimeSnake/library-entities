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

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntityVindicator;

@NmsReflection
public class ExCustomPathfinderGoalMeleeAttackRavager extends ExCustomPathfinderGoalMeleeAttack {

    public ExCustomPathfinderGoalMeleeAttackRavager(double speed) {
        super(new PathfinderGoalMeleeAttackRavager(null, speed));
    }

    protected static class PathfinderGoalMeleeAttackRavager extends PathfinderGoalMeleeAttack {

        public PathfinderGoalMeleeAttackRavager(EntityVindicator entity, double speed) {
            super(entity, speed, true);
        }

        @Override
        protected double a(EntityLiving entityliving) {
            float f = this.a.cX() - 0.1F;
            return f * 2.0F * f * 2.0F + entityliving.cX();
        }
    }
}
