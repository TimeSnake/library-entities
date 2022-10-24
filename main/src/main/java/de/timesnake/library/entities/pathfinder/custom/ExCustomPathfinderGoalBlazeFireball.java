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

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityBlaze;

import java.util.Arrays;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalBlazeFireball extends ExCustomPathfinderGoal {

    private static final Class<?> NMS_CLASS =
            Arrays.stream(EntityBlaze.class.getDeclaredClasses()).filter((c) -> c.getSimpleName().equals(
                    "PathfinderGoalBlazeFireball")).findFirst().get();

    public ExCustomPathfinderGoalBlazeFireball() {
        super.pathfinderGoal = ((PathfinderGoal) RefUtil.instantiate(NMS_CLASS, new Class[]{EntityBlaze.class},
                (EntityBlaze) null));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
