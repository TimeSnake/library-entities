/*
 * library-entities.library-entities.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityLiving;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.IRangedEntity;

import java.util.EnumSet;

@NmsReflection
public class ExCustomPathfinderGoalArrowAttack extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalArrowAttack(double speed, int ticksPerAttack, float maxRange) {
        super(new PathfinderGoalArrowAttack(null, speed, ticksPerAttack, maxRange));
    }

    @Override
    public void injectEntity(Mob entity) {
        ((PathfinderGoalArrowAttack) super.pathfinderGoal).init(entity);
    }

    public static class PathfinderGoalArrowAttack extends PathfinderGoal {
        private final double speed;
        private final int minimumTicksPerAttack;
        private final int ticksPerAttackAtMaxRange;
        private final float maxRange;
        private final float maxRangeSquared;
        private Mob entity;
        private IRangedEntity entityRanged;
        private ExEntityLiving target;
        private int delay;
        private int f;

        public PathfinderGoalArrowAttack(Mob entity, double speed, int ticksPerAttack, float maxRange) {
            this(entity, speed, ticksPerAttack, ticksPerAttack, maxRange);
        }

        public PathfinderGoalArrowAttack(Mob entity, double speed, int minimumTicksPerAttack,
                                         int ticksPerAttackAtMaxRange, float maxRange) {
            this.delay = -1;
            this.entity = entity;
            this.speed = speed;
            this.minimumTicksPerAttack = minimumTicksPerAttack;
            this.ticksPerAttackAtMaxRange = ticksPerAttackAtMaxRange;
            this.maxRange = maxRange;
            this.maxRangeSquared = maxRange * maxRange;
            this.a(EnumSet.of(Type.a, Type.b));
        }

        public void init(Mob entity) {
            this.entity = entity;
            this.entityRanged = ((IRangedEntity) entity.getNMS());
        }

        public boolean a() {
            ExEntityLiving entity = this.entity.getExTarget();
            if (entity != null && entity.isAlive()) {
                this.target = entity;
                return true;
            } else {
                return false;
            }
        }

        public boolean b() {
            return this.a() || !this.entity.getNavigation().m();
        }

        public void d() {
            this.target = null;
            this.f = 0;
            this.delay = -1;
        }

        public void e() {
            double distanceSquared = this.entity.distanceSquared(this.target.getX(), this.target.getY(),
                    this.target.getZ());
            boolean var2 = this.entity.getEntitySenses().a(this.target);
            if (var2) {
                ++this.f;
            } else {
                this.f = 0;
            }

            if (!(distanceSquared > (double) this.maxRangeSquared) && this.f >= 5) {
                this.entity.getNavigation().o();
            } else {
                this.entity.getNavigation().walkTo(this.target, this.speed);
            }

            this.entity.getControllerLook().a(this.target, 30.0F, 30.0F);
            float distanceMaxRangeRatio;
            if (--this.delay == 0) {
                if (!var2) {
                    return;
                }

                distanceMaxRangeRatio = (float) (Math.sqrt(distanceSquared) / this.maxRange);
                float var4 = MathHelper.a(distanceMaxRangeRatio, 0.1F, 1.0F);
                this.entityRanged.a(this.target.getNMS(), var4);
                this.delay =
                        MathHelper.d(distanceMaxRangeRatio * (float) (this.ticksPerAttackAtMaxRange - this.minimumTicksPerAttack) + (float) this.minimumTicksPerAttack);
            } else if (this.delay < 0) {
                distanceMaxRangeRatio = (float) (Math.sqrt(distanceSquared) / this.maxRange);
                this.delay =
                        MathHelper.d(distanceMaxRangeRatio * (float) (this.ticksPerAttackAtMaxRange - this.minimumTicksPerAttack) + (float) this.minimumTicksPerAttack);
            }

        }

    }
}
