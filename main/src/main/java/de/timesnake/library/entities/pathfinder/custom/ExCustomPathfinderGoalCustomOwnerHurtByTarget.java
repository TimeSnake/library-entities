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

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

@NmsReflection
public class ExCustomPathfinderGoalCustomOwnerHurtByTarget extends ExCustomPathfinderGoalTarget {

    public ExCustomPathfinderGoalCustomOwnerHurtByTarget(ExEntityInsentient owner) {
        super(new PathfinderGoalCustomOwnerHurtByTarget(null, owner));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.injectEntity(entity);
    }

    public static class PathfinderGoalCustomOwnerHurtByTarget extends PathfinderGoalTarget {

        private final ExEntityInsentient owner;
        private ExEntityLiving damager;
        private int c;

        public PathfinderGoalCustomOwnerHurtByTarget(ExEntityInsentient entity, ExEntityInsentient owner) {
            super(entity.getNMS(), false);
            this.owner = owner;
            this.a(EnumSet.of(ExCustomPathfinderGoal.Type.TARGET.getNMS()));
        }

        public boolean a() {
            if (this.owner == null) {
                return false;
            } else {
                this.damager = this.owner.getExLastDamager();
                int i = this.owner.getHurtTimestamp();
                return i != this.c && this.a(this.damager.getNMS(), PathfinderTargetCondition.a);
            }
        }

        public void c() {
            new ExEntityInsentient(this.e).setTarget(this.damager.getNMS(),
                    EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER, true);
            if (this.owner != null) {
                this.c = this.owner.getHurtTimestamp();
            }

            super.c();
        }
    }
}
