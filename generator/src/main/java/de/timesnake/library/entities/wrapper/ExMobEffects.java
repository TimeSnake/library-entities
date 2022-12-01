/*
 * workspace.library-entities-generator.main
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

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.effect.MobEffectList;
import net.minecraft.world.effect.MobEffects;

public enum ExMobEffects {

    SPEED(MobEffects.a),
    SLOWNESS(MobEffects.b),
    HASTE(MobEffects.c),
    MINING_FATIGUE(MobEffects.d),
    STRENGTH(MobEffects.e),
    INSTANT_HEALTH(MobEffects.f),
    INSTANT_DAMAGE(MobEffects.g),
    JUMP_BOOST(MobEffects.h),
    NAUSEA(MobEffects.i),
    REGENERATION(MobEffects.j),
    RESISTANCE(MobEffects.k),
    FIRE_RESISTANC(MobEffects.l),
    WATER_BREATHIN(MobEffects.m),
    INVISIBILITY(MobEffects.n),
    BLINDNESS(MobEffects.o),
    NIGHT_VISION(MobEffects.p),
    HUNGER(MobEffects.q),
    WEAKNESS(MobEffects.r),
    POISON(MobEffects.s),
    WITHER(MobEffects.t),
    HEALTH_BOOST(MobEffects.u),
    ABSORPTION(MobEffects.v),
    SATURATION(MobEffects.w),
    GLOWING(MobEffects.x),
    LEVITATION(MobEffects.y),
    LUCK(MobEffects.z),
    UNLUCK(MobEffects.A),
    SLOW_FALLING(MobEffects.B),
    CONDUIT_POWER(MobEffects.C),
    DOLPHINS_GRACE(MobEffects.D),
    BAD_OMEN(MobEffects.E),
    HERO_OF_THE_VILLAGE(MobEffects.F);


    private final MobEffectList mobEffectList;

    ExMobEffects(MobEffectList mobEffectList) {
        this.mobEffectList = mobEffectList;
    }

    public MobEffectList getMobEffectList() {
        return mobEffectList;
    }
}
