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

import net.minecraft.world.damagesource.DamageSource;

public enum ExDamageSource {

    FIRE(DamageSource.a),
    LIGHTNING(DamageSource.b),
    BURN(DamageSource.c),
    LAVA(DamageSource.d),
    HOT_FLOOR(DamageSource.e),
    STUCK(DamageSource.f),
    CRAMMING(DamageSource.g),
    DROWN(DamageSource.h),
    STARVE(DamageSource.i),
    CACTUS(DamageSource.j),
    FALL(DamageSource.k),
    FLY_INTO_WALL(DamageSource.l),
    OUT_OF_WORLD(DamageSource.m),
    GENERIC(DamageSource.n),
    MAGIC(DamageSource.o),
    WITHER(DamageSource.p),
    ANVIL(DamageSource.q),
    FALLING_BLOCK(DamageSource.r),
    DRAGON_BREATH(DamageSource.s),
    DRYOUT(DamageSource.t),
    SWEET_BERRY_BUSH(DamageSource.u),
    FREEZE(DamageSource.v),
    FALLING_STALACTITE(DamageSource.w),
    STALAGMITE(DamageSource.x);

    private final DamageSource damageSource;

    ExDamageSource(DamageSource damageSource) {
        this.damageSource = damageSource;
    }

    public DamageSource getNMS() {
        return damageSource;
    }
}
