/*
 * library-entities.library-entities.main
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

import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.type.EntityMapper;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;

import java.util.List;

@NmsReflection
public class ExCustomPathfinderGoalHurtByTarget extends ExCustomPathfinderGoalTarget {

    @SafeVarargs
    public ExCustomPathfinderGoalHurtByTarget(Class<? extends LivingEntity>... excludedClasses) {
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null,
                EntityMapper.mapExClassesToNmsClasses(excludedClasses));
    }

    public ExCustomPathfinderGoalHurtByTarget(List<Class<? extends LivingEntity>> excludedClasses) {
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null,
                EntityMapper.mapExClassesToNmsClasses(excludedClasses.toArray(Class[]::new)));
    }

    public ExCustomPathfinderGoalHurtByTarget a(Class<?>... aclass) {
        ((PathfinderGoalHurtByTarget) super.getNMS()).a(aclass);
        return this;
    }
}
