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
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.event.entity.EntityPotionEffectEvent;

import javax.annotation.Nullable;

@NmsReflection
public class ExCustomPathfinderGoalIllagerIllusionerCastSpellDisapear extends ExCustomPathfinderGoalIllagerWizardCastSpell {

    public ExCustomPathfinderGoalIllagerIllusionerCastSpellDisapear() {
        super(new PathfinderGoalIllagerIllusionerCastSpellDisapear(null));
    }

    static class PathfinderGoalIllagerIllusionerCastSpellDisapear extends PathfinderGoalIllagerWizardCastSpell {

        public PathfinderGoalIllagerIllusionerCastSpellDisapear(ExEntityIllagerWizard entity) {
            super(entity);
        }

        public boolean a() {
            return super.a() && !this.entity.getNMS().a(MobEffects.n);
        }

        protected int h() {
            return 20;
        }

        protected int i() {
            return 340;
        }

        protected void k() {
            this.entity.getNMS().addEffect(new MobEffect(MobEffects.n, 1200), EntityPotionEffectEvent.Cause.ILLUSION);
        }

        protected @Nullable SoundEffect l() {
            return SoundEffects.jK;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.e;
        }
    }
}
