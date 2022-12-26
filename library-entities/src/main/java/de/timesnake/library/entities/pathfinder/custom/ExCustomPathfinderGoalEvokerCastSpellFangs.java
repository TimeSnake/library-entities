/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.entity.projectile.EntityEvokerFangs;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ExCustomPathfinderGoalEvokerCastSpellFangs extends ExCustomPathfinderGoalIllagerWizardCastSpell {

    public ExCustomPathfinderGoalEvokerCastSpellFangs() {
        super(new PathfinderGoalEvokerCastSpellFangs(null));
    }

    protected static class PathfinderGoalEvokerCastSpellFangs extends PathfinderGoalIllagerWizardCastSpell {
        public PathfinderGoalEvokerCastSpellFangs(ExEntityIllagerWizard entity) {
            super(entity);
        }

        protected int h() {
            return 40;
        }

        protected int i() {
            return 100;
        }

        protected void k() {
            EntityLiving entityliving = this.entity.getNMS().G();
            double d0 = Math.min(entityliving.di(), this.entity.getNMS().di());
            double d1 = Math.max(entityliving.di(), this.entity.getNMS().di()) + 1.0;
            float f = (float) MathHelper.d(entityliving.dm() - this.entity.getNMS().dm(),
                    entityliving.dg() - this.entity.getNMS().dg());
            int i;
            if (this.entity.getNMS().f(entityliving) < 9.0) {
                float f1;
                for (i = 0; i < 5; ++i) {
                    f1 = f + (float) i * 3.1415927F * 0.4F;
                    this.a(this.entity.getNMS().dg() + (double) MathHelper.b(f1) * 1.5,
                            this.entity.getNMS().dm() + (double) MathHelper.a(f1) * 1.5, d0, d1, f1, 0);
                }

                for (i = 0; i < 8; ++i) {
                    f1 = f + (float) i * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
                    this.a(this.entity.getNMS().dg() + (double) MathHelper.b(f1) * 2.5,
                            this.entity.getNMS().dm() + (double) MathHelper.a(f1) * 2.5, d0, d1, f1, 3);
                }
            } else {
                for (i = 0; i < 16; ++i) {
                    double d2 = 1.25 * (double) (i + 1);
                    int j = 1 * i;
                    this.a(this.entity.getNMS().dg() + (double) MathHelper.b(f) * d2,
                            this.entity.getNMS().dm() + (double) MathHelper.a(f) * d2, d0, d1, f, j);
                }
            }
        }

        private void a(double d0, double d1, double d2, double d3, float f, int i) {
            BlockPosition blockposition = new BlockPosition(d0, d3, d1);
            boolean flag = false;
            double d4 = 0.0;

            do {
                BlockPosition blockposition1 = blockposition.c();
                IBlockData iblockdata = this.entity.getNMS().s.a_(blockposition1);
                if (iblockdata.d(this.entity.getNMS().s, blockposition1, EnumDirection.b)) {
                    if (!this.entity.getNMS().s.x(blockposition)) {
                        IBlockData iblockdata1 = this.entity.getNMS().s.a_(blockposition);
                        VoxelShape voxelshape = iblockdata1.k(this.entity.getNMS().s, blockposition);
                        if (!voxelshape.b()) {
                            d4 = voxelshape.c(EnumDirection.EnumAxis.b);
                        }
                    }

                    flag = true;
                    break;
                }

                blockposition = blockposition.c();
            } while (blockposition.v() >= MathHelper.b(d2) - 1);

            if (flag) {
                this.entity.getNMS().s.b(new EntityEvokerFangs(this.entity.getNMS().s, d0,
                        (double) blockposition.v() + d4, d1, f, i, this.entity.getNMS()));
            }

        }

        protected SoundEffect l() {
            return SoundEffects.fX;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.c;
        }
    }
}
