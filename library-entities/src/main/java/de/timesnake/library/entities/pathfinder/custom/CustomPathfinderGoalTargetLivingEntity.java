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

import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;

public class CustomPathfinderGoalTargetLivingEntity extends PathfinderGoalNearestAttackableTarget {

    private final EntityLiving target;

    public CustomPathfinderGoalTargetLivingEntity(EntityInsentient entity, EntityLiving target) {
        super(entity, target.getClass(), true);
        this.target = target;
    }

    @Override
    public void h() {
        super.c = target;
    }
}
