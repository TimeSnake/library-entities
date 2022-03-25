package de.timesnake.basic.entities.wrapper;

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
