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

import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.event.entity.EntityPotionEffectEvent;

public class ExCustomPathfinderGoalIllagerIllusionerCastSpellBlindness extends ExCustomPathfinderGoalIllagerWizardCastSpell {

    public ExCustomPathfinderGoalIllagerIllusionerCastSpellBlindness() {
        super(new PathfinderGoalIllagerIllusionerCastSpellBlindness(null));
    }

    static class PathfinderGoalIllagerIllusionerCastSpellBlindness extends PathfinderGoalIllagerWizardCastSpell {

        private int e;

        private PathfinderGoalIllagerIllusionerCastSpellBlindness(ExEntityIllagerWizard entity) {
            super(entity);
        }

        public boolean a() {
            return super.a() && (this.entity.getNMS().G() != null
                    && (this.entity.getNMS().G().ae() != this.e
                    && this.entity.getNMS().s.d_(this.entity.getNMS().db()).a((float) EnumDifficulty.c.ordinal())));
        }

        public void c() {
            super.c();
            EntityLiving entityliving = this.entity.getNMS().G();
            if (entityliving != null) {
                this.e = entityliving.ae();
            }

        }

        protected int h() {
            return 20;
        }

        protected int i() {
            return 180;
        }

        protected void k() {
            this.entity.getNMS().G().addEffect(new MobEffect(MobEffects.o, 400), this.entity.getNMS(),
                    EntityPotionEffectEvent.Cause.ATTACK);
        }

        protected SoundEffect l() {
            return SoundEffects.jJ;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.f;
        }
    }
}
