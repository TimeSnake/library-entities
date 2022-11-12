/*
 * workspace.library-entities.library-entities.main
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
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityVindicator;

@NmsReflection
public class ExCustomPathfinderGoalMeleeAttackVindicator extends ExCustomPathfinderGoalMeleeAttack {

    public ExCustomPathfinderGoalMeleeAttackVindicator(double speed) {
        super(new PathfinderGoalMeleeAttackVindicator(null, speed));
    }

    protected static class PathfinderGoalMeleeAttackVindicator extends PathfinderGoalMeleeAttack {

        public PathfinderGoalMeleeAttackVindicator(EntityVindicator entity, double speed) {
            super(entity, speed, false);
        }

        protected double a(EntityLiving var0) {
            if (this.a.cR() instanceof EntityRavager) {
                float var1 = this.a.cR().cX() - 0.1F;
                return var1 * 2.0F * var1 * 2.0F + var0.cX();
            } else {
                return super.a(var0);
            }
        }
    }
}
