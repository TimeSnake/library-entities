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

import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.animal.EntitySheep;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.item.EnumColor;
import net.minecraft.world.level.GameRules;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalEvokerCastSpellWololo extends ExCustomPathfinderGoalIllagerWizardCastSpell {

    public ExCustomPathfinderGoalEvokerCastSpellWololo() {
        super(new PathfinderGoalEvokerCastSpellWololo(null));
    }

    protected static class PathfinderGoalEvokerCastSpellWololo extends PathfinderGoalIllagerWizardCastSpell {

        private final PathfinderTargetCondition e = PathfinderTargetCondition.b().a(16.0).a((entityliving) ->
                ((EntitySheep) entityliving).t() == EnumColor.l);

        public PathfinderGoalEvokerCastSpellWololo(ExEntityIllagerWizard entity) {
            super(entity);
        }

        public boolean a() {
            if (this.entity.getNMS().G() != null) {
                return false;
            } else if (this.entity.getNMS().fU()) {
                return false;
            } else if (this.entity.getNMS().S < this.c) {
                return false;
            } else if (!this.entity.getNMS().s.W().b(GameRules.c)) {
                return false;
            } else {
                List<EntitySheep> list = this.entity.getNMS().s.a(EntitySheep.class, this.e, this.entity.getNMS(),
                        this.entity.getNMS().cz().c(16.0, 4.0, 16.0));
                if (list.isEmpty()) {
                    return false;
                } else {
                    this.entity.getNMS().a(list.get(this.entity.getRandomSource().a(list.size())));
                    return true;
                }
            }
        }

        public boolean b() {
            try {
                Method gd = this.entity.getNMS().getClass().getMethod("gd");
                gd.setAccessible(true);
                return gd.invoke(this.entity.getNMS().getClass()) != null && this.b > 0;
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public void d() {
            super.d();
            this.entity.getNMS().a((EntitySheep) null);
        }

        protected void k() {
            try {
                Method gd = this.entity.getNMS().getClass().getMethod("gd");
                gd.setAccessible(true);
                EntitySheep entitysheep = (EntitySheep) gd.invoke(this.entity.getNMS().getClass());
                if (entitysheep != null && entitysheep.bp()) {
                    entitysheep.b(EnumColor.o);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        protected int n() {
            return 40;
        }

        protected int h() {
            return 60;
        }

        protected int i() {
            return 140;
        }

        protected SoundEffect l() {
            return SoundEffects.fZ;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.d;
        }
    }
}
