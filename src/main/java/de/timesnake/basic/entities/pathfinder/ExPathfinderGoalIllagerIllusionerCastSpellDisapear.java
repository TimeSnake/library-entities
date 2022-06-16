package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.EntityIllagerIllusioner;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.event.entity.EntityPotionEffectEvent;

import javax.annotation.Nullable;

@NmsReflection
public class ExPathfinderGoalIllagerIllusionerCastSpellDisapear extends ExPathfinderGoalIllagerWizardCastSpell {

    public ExPathfinderGoalIllagerIllusionerCastSpellDisapear() {
        super(new PathfinderGoalIllagerIllusionerCastSpellDisapear(null));
    }

    static class PathfinderGoalIllagerIllusionerCastSpellDisapear extends ExPathfinderGoalIllagerWizardCastSpell.PathfinderGoalIllagerWizardCastSpell {

        public PathfinderGoalIllagerIllusionerCastSpellDisapear(EntityIllagerIllusioner entity) {
            super(entity);
        }

        public boolean a() {
            return super.a() && !this.entity.a(MobEffects.n);
        }

        protected int g() {
            return 20;
        }

        protected int i() {
            return 340;
        }

        protected void k() {
            this.entity.addEffect(new MobEffect(MobEffects.n, 1200), EntityPotionEffectEvent.Cause.ILLUSION);
        }

        @Nullable
        protected SoundEffect l() {
            return SoundEffects.jd;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.e;
        }
    }
}
