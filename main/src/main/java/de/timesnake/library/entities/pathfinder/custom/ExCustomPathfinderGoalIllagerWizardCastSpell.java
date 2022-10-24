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
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.craftbukkit.v1_19_R1.event.CraftEventFactory;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@NmsReflection(usesReflection = true)
public abstract class ExCustomPathfinderGoalIllagerWizardCastSpell extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalIllagerWizardCastSpell(PathfinderGoalIllagerWizardCastSpell pathfinder) {
        super(pathfinder);
    }

    public ExCustomPathfinderGoalIllagerWizardCastSpell() {

    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity);
    }

    public static abstract class PathfinderGoalIllagerWizardCastSpell extends PathfinderGoal {

        protected ExEntityIllagerWizard entity;

        protected int b;
        protected int c;

        public PathfinderGoalIllagerWizardCastSpell(ExEntityIllagerWizard entity) {
            this.entity = entity;
        }

        public boolean a() {
            EntityLiving entityliving = this.entity.getNMS().G();
            return entityliving != null && entityliving.bp() && (!this.entity.getNMS().fU() &&
                    this.entity.getNMS().S >= this.c);
        }

        public boolean b() {
            EntityLiving entityliving = this.entity.getNMS().G();
            return entityliving != null && entityliving.bp() && this.b > 0;
        }

        public void c() {
            this.b = this.a(this.n());
            try {
                Field b = this.entity.getClass().getField("b");
                b.setAccessible(true);
                b.set(this.entity, this.h());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            this.c = this.entity.getNMS().S + this.i();
            SoundEffect soundeffect = this.l();
            if (soundeffect != null) {
                this.entity.getNMS().a(soundeffect, 1.0F, 1.0F);
            }

            this.entity.getNMS().a(this.m());
        }

        public void e() {
            --this.b;
            if (this.b == 0) {
                if (!CraftEventFactory.handleEntitySpellCastEvent(this.entity.getNMS(), this.m())) {
                    return;
                }

                this.k();

                try {
                    Method fK = this.entity.getClass().getMethod("fk");
                    fK.setAccessible(true);
                    this.entity.getNMS().a((SoundEffect) fK.invoke(this.entity), 1.0F, 1.0F);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        protected abstract void k();

        protected int n() {
            return 20;
        }

        protected abstract int h();

        protected abstract int i();

        protected abstract @Nullable SoundEffect l();

        protected abstract EntityIllagerWizard.Spell m();
    }
}
