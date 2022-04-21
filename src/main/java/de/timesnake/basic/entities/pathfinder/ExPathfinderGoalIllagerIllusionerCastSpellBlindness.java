package de.timesnake.basic.entities.pathfinder;

import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntityIllagerIllusioner;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.event.entity.EntityPotionEffectEvent;

public class ExPathfinderGoalIllagerIllusionerCastSpellBlindness extends ExPathfinderGoalIllagerWizardCastSpell {

    public ExPathfinderGoalIllagerIllusionerCastSpellBlindness() {
        super(new PathfinderGoalIllagerIllusionerCastSpellBlindness(null));
    }

    static class PathfinderGoalIllagerIllusionerCastSpellBlindness extends ExPathfinderGoalIllagerWizardCastSpell.PathfinderGoalIllagerWizardCastSpell {

        private int e;

        private PathfinderGoalIllagerIllusionerCastSpellBlindness(EntityIllagerIllusioner entity) {
            super(entity);
        }

        public boolean a() {
            return super.a() && (this.entity.G() != null && (this.entity.G().ae() != this.e && this.entity.s.d_(this.entity.cW()).a((float) EnumDifficulty.c.ordinal())));
        }

        public void c() {
            super.c();
            EntityLiving entityliving = this.entity.G();
            if (entityliving != null) {
                this.e = entityliving.ae();
            }

        }

        protected int g() {
            return 20;
        }

        protected int i() {
            return 180;
        }

        protected void k() {
            this.entity.G().addEffect(new MobEffect(MobEffects.o, 400), this.entity, EntityPotionEffectEvent.Cause.ATTACK);
        }

        protected SoundEffect l() {
            return SoundEffects.jc;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.f;
        }
    }
}
