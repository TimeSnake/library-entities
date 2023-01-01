/*
 * Copyright (C) 2023 timesnake
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
