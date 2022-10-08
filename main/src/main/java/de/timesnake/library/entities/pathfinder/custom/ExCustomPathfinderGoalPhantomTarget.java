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

import de.timesnake.library.entities.entity.bukkit.ExPhantom;
import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.player.EntityHuman;

import java.util.Comparator;
import java.util.List;

@NmsReflection
public class ExCustomPathfinderGoalPhantomTarget extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalPhantomTarget() {
        super(new PathfinderGoalPhantomTargetEntity(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity.getNMS());
    }

    protected static class PathfinderGoalPhantomTargetEntity extends PathfinderGoal {

        private final ExPhantom entity;
        private final PathfinderTargetCondition b;
        private int c;

        private PathfinderGoalPhantomTargetEntity(ExPhantom entity) {
            this.entity = entity;
            this.b = PathfinderTargetCondition.a().a(64.0D);
            this.c = 20;
        }

        public boolean a() {
            if (this.c > 0) {
                --this.c;
            } else {
                this.c = 60;
                List<EntityHuman> list = this.entity.getExtension().getNMSWorld().a(this.b, this.entity.getHandle(),
                        this.entity.getExtension().getExBoundingBox().grow(16.0D, 64.0D, 16.0D).getNMS());
                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing((e) -> new ExEntity(((Entity) e)).getY()).reversed());

                    for (EntityHuman entityhuman : list) {
                        this.entity.getExtension().setTarget(entityhuman);
                        return true;
                    }
                }

            }
            return false;
        }

        public boolean b() {
            EntityLiving entityliving = this.entity.getExtension().getNMSTarget();
            return entityliving != null && this.entity.getExtension().a(entityliving, PathfinderTargetCondition.a);
        }
    }
}
