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

import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityIllagerWizard;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalIllagerWizardNoneSpell extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalIllagerWizardNoneSpell() {
        super(new PathfinderGoalIllagerWizardNoneSpell(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }

    public static class PathfinderGoalIllagerWizardNoneSpell extends PathfinderGoal {

        private final ExEntityIllagerWizard entity;

        public PathfinderGoalIllagerWizardNoneSpell(ExEntityIllagerWizard entity) {
            this.entity = entity;
            this.a(EnumSet.of(Type.a, Type.b));
        }

        public boolean a() {
            int fW;
            try {
                Method fWMethod = this.entity.getNMS().getClass().getMethod("fW");
                fWMethod.setAccessible(true);
                fW = (int) fWMethod.invoke(this.entity.getNMS());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return fW > 0;
        }

        public void c() {
            super.c();
            this.entity.getNavigation().getNMS().n();
        }

        public void d() {
            super.d();
            this.entity.getNMS().a(EntityIllagerWizard.Spell.a);
        }

        public void e() {
            if (this.entity.getNMS().G() != null) {
                this.entity.getNMS().z().a(this.entity.getNMS().G(), (float) this.entity.getNMS().V(),
                        (float) this.entity.getNMS().U());
            }

        }
    }
}
