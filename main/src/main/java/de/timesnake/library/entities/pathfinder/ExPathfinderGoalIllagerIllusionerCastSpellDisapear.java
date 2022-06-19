package de.timesnake.library.entities.pathfinder;

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
public class ExPathfinderGoalIllagerIllusionerCastSpellDisapear extends ExPathfinderGoalIllagerWizardCastSpell {

    public ExPathfinderGoalIllagerIllusionerCastSpellDisapear() {
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
