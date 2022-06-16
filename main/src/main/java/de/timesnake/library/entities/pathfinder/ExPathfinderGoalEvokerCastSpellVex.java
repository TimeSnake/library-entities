package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EnumMobSpawn;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.monster.EntityEvoker;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.entity.monster.EntityVex;

import java.util.Random;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalEvokerCastSpellVex extends ExPathfinderGoalIllagerWizardCastSpell {

    public ExPathfinderGoalEvokerCastSpellVex() {
        super(new PathfinderGoalEvokerCastSpellVex(null));
    }

    protected static class PathfinderGoalEvokerCastSpellVex extends PathfinderGoalIllagerWizardCastSpell {

        private final PathfinderTargetCondition e = PathfinderTargetCondition.b().a(16.0D).d().e();

        private PathfinderGoalEvokerCastSpellVex(EntityEvoker entity) {
            super(entity);
        }

        public boolean a() {
            if (!super.a()) {
                return false;
            } else {
                int var0 = this.entity.s.a(EntityVex.class, this.e, this.entity, this.entity.cw().g(16.0D)).size();
                return ((Random) RefUtil.getInstanceField(this.entity, "R")).nextInt(8) + 1 > var0;
            }
        }

        protected int g() {
            return 100;
        }

        protected int i() {
            return 340;
        }

        protected void k() {
            WorldServer var0 = (WorldServer) this.entity.s;

            for (int var1 = 0; var1 < 3; ++var1) {
                BlockPosition var2 =
                        this.entity.cW().b(-2 + ((Random) RefUtil.getInstanceField(this.entity, "R")).nextInt(5), 1,
                                -2 + ((Random) RefUtil.getInstanceField(this.entity, "R")).nextInt(5));
                EntityVex var3 = EntityTypes.aU.a(this.entity.s);
                var3.a(var2, 0.0F, 0.0F);
                var3.a(var0, this.entity.s.d_(var2), EnumMobSpawn.f, null, null);
                var3.a(this.entity);
                var3.g(var2);
                var3.a(20 * (30 + ((Random) RefUtil.getInstanceField(this.entity, "R")).nextInt(90)));
                var0.a_(var3);
            }

        }

        protected SoundEffect l() {
            return SoundEffects.fP;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.b;
        }
    }
}
