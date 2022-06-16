package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.animal.EntitySheep;
import net.minecraft.world.entity.monster.EntityEvoker;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.item.EnumColor;
import net.minecraft.world.level.GameRules;

import java.util.List;
import java.util.Random;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalEvokerCastSpellWololo extends ExPathfinderGoalIllagerWizardCastSpell {

    public ExPathfinderGoalEvokerCastSpellWololo() {
        super(new PathfinderGoalEvokerCastSpellWololo(null));
    }

    protected static class PathfinderGoalEvokerCastSpellWololo extends PathfinderGoalIllagerWizardCastSpell {

        private final PathfinderTargetCondition e =
                PathfinderTargetCondition.b().a(16.0D).a((var0x) -> ((EntitySheep) var0x).t() == EnumColor.l);


        public PathfinderGoalEvokerCastSpellWololo(EntityEvoker entity) {
            super(entity);
        }

        public boolean a() {
            if (this.entity.G() != null) {
                return false;
            } else if (this.entity.fJ()) {
                return false;
            } else if (this.entity.S < this.c) {
                return false;
            } else if (!this.entity.s.W().b(GameRules.c)) {
                return false;
            } else {
                List<EntitySheep> var0 = this.entity.s.a(EntitySheep.class, this.e, this.entity,
                        this.entity.cw().c(16.0D, 4.0D, 16.0D));
                if (var0.isEmpty()) {
                    return false;
                } else {
                    this.entity.a(var0.get(((Random) RefUtil.getInstanceField(this.entity, "R")).nextInt(var0.size())));
                    return true;
                }
            }
        }

        public boolean b() {
            return RefUtil.invokeMethod(this.entity, "fR") != null && this.b > 0;
        }

        public void d() {
            super.d();
            this.entity.a((EntitySheep) null);
        }

        protected void k() {
            EntitySheep var0 = (EntitySheep) RefUtil.invokeMethod(this.entity, "fR");
            if (var0 != null && var0.bl()) {
                var0.b(EnumColor.o);
            }

        }

        protected int n() {
            return 40;
        }

        protected int g() {
            return 60;
        }

        protected int i() {
            return 140;
        }

        protected SoundEffect l() {
            return SoundEffects.fQ;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.d;
        }
    }
}
