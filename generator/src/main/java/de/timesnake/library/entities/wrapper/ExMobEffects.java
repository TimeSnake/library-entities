package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.effect.MobEffectList;
import net.minecraft.world.effect.MobEffects;

@NmsReflection
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
