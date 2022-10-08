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

import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;

import java.util.List;

@NmsReflection
public class ExCustomPathfinderGoalHurtByTarget extends ExCustomPathfinderGoalTarget {

    @SafeVarargs
    public ExCustomPathfinderGoalHurtByTarget(EntityClass<? extends EntityLiving>... excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.length];
        for (int i = 0; i < excludedClasses.length; i++) {
            nmsClasses[i] = excludedClasses[i].getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExCustomPathfinderGoalHurtByTarget(List<EntityClass<? extends EntityLiving>> excludedClasses) {
        Class<?>[] nmsClasses = new Class[excludedClasses.size()];
        for (int i = 0; i < excludedClasses.size(); i++) {
            nmsClasses[i] = excludedClasses.get(i).getNMSClass();
        }
        super.pathfinderGoal = new PathfinderGoalHurtByTarget(null, nmsClasses);
    }

    public ExCustomPathfinderGoalHurtByTarget a(Class<?>... aclass) {
        ((PathfinderGoalHurtByTarget) super.getNMS()).a(aclass);
        return this;
    }
}
