package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntityEvoker;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.entity.projectile.EntityEvokerFangs;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.phys.shapes.VoxelShape;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalEvokerCastSpellFangs extends ExPathfinderGoalIllagerWizardCastSpell {

    public ExPathfinderGoalEvokerCastSpellFangs() {
        super(new PathfinderGoalEvokerCastSpellFangs(null));
    }

    protected static class PathfinderGoalEvokerCastSpellFangs extends PathfinderGoalIllagerWizardCastSpell {
        private PathfinderGoalEvokerCastSpellFangs(EntityEvoker entity) {
            super(entity);
        }

        protected int g() {
            return 40;
        }

        protected int i() {
            return 100;
        }

        protected void k() {
            EntityLiving var0 = this.entity.G();
            double var1 = Math.min(var0.de(), this.entity.de());
            double var3 = Math.max(var0.de(), this.entity.de()) + 1.0D;
            float var5 = (float) MathHelper.d(var0.di() - this.entity.di(), var0.dc() - this.entity.dc());
            int var6;
            if (this.entity.f(var0) < 9.0D) {
                float var7x;
                for (var6 = 0; var6 < 5; ++var6) {
                    var7x = var5 + (float) var6 * 3.1415927F * 0.4F;
                    this.a(this.entity.dc() + (double) MathHelper.b(var7x) * 1.5D,
                            this.entity.di() + (double) MathHelper.a(var7x) * 1.5D, var1, var3, var7x, 0);
                }

                for (var6 = 0; var6 < 8; ++var6) {
                    var7x = var5 + (float) var6 * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
                    this.a(this.entity.dc() + (double) MathHelper.b(var7x) * 2.5D,
                            this.entity.di() + (double) MathHelper.a(var7x) * 2.5D, var1, var3, var7x, 3);
                }
            } else {
                for (var6 = 0; var6 < 16; ++var6) {
                    double var7 = 1.25D * (double) (var6 + 1);
                    this.a(this.entity.dc() + (double) MathHelper.b(var5) * var7,
                            this.entity.di() + (double) MathHelper.a(var5) * var7, var1, var3, var5, var6);
                }
            }

        }

        private void a(double var0, double var2, double var4, double var6, float var8, int var9) {
            BlockPosition var10 = new BlockPosition(var0, var6, var2);
            boolean var11 = false;
            double var12 = 0.0D;

            do {
                BlockPosition var14 = var10.c();
                IBlockData var15 = this.entity.s.a_(var14);
                if (var15.d(this.entity.s, var14, EnumDirection.b)) {
                    if (!this.entity.s.w(var10)) {
                        IBlockData var16 = this.entity.s.a_(var10);
                        VoxelShape var17 = var16.k(this.entity.s, var10);
                        if (!var17.b()) {
                            var12 = var17.c(EnumDirection.EnumAxis.b);
                        }
                    }

                    var11 = true;
                    break;
                }

                var10 = var10.c();
            } while (var10.v() >= MathHelper.b(var4) - 1);

            if (var11) {
                this.entity.s.b(new EntityEvokerFangs(this.entity.s, var0, (double) var10.v() + var12, var2, var8,
                        var9, this.entity));
            }

        }

        protected SoundEffect l() {
            return SoundEffects.fO;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.c;
        }
    }
}
