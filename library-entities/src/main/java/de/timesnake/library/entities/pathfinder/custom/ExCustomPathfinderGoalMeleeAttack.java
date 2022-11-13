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

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalMeleeAttack extends ExCustomPathfinderGoal {

    protected ExCustomPathfinderGoalMeleeAttack(PathfinderGoalMeleeAttack pathfinderGoal) {
        super(pathfinderGoal);
    }

    public ExCustomPathfinderGoalMeleeAttack(double speed) {
        super(new PathfinderGoalMeleeAttack(null, speed, false));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("a", entity.getNMS());
    }

}