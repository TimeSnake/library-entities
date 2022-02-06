package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.util.MathHelper;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.IRangedEntity;

import java.util.EnumSet;

public class ExPathfinderGoalArrowAttack extends ExPathfinderGoal {

    public ExPathfinderGoalArrowAttack(double speed, int ticksPerAttack, float maxRange) {
        super(new PathfinderGoalArrowAttack(null, speed, ticksPerAttack, maxRange));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        ((PathfinderGoalArrowAttack) super.pathfinderGoal).init(entity);
    }

    public static class PathfinderGoalArrowAttack extends PathfinderGoal {
        private ExEntityInsentient entity;
        private IRangedEntity entityRanged;
        private ExEntityLiving target;
        private int delay;
        private final double speed;
        private int f;
        private final int minimumTicksPerAttack;
        private final int ticksPerAttackAtMaxRange;
        private final float maxRange;
        private final float maxRangeSquared;

        public PathfinderGoalArrowAttack(ExEntityInsentient entity, double speed, int ticksPerAttack, float maxRange) {
            this(entity, speed, ticksPerAttack, ticksPerAttack, maxRange);
        }

        public PathfinderGoalArrowAttack(ExEntityInsentient entity, double speed, int minimumTicksPerAttack, int ticksPerAttackAtMaxRange, float maxRange) {
            this.delay = -1;
            this.entity = entity;
            this.speed = speed;
            this.minimumTicksPerAttack = minimumTicksPerAttack;
            this.ticksPerAttackAtMaxRange = ticksPerAttackAtMaxRange;
            this.maxRange = maxRange;
            this.maxRangeSquared = maxRange * maxRange;
            this.a(EnumSet.of(Type.a, Type.b));
        }

        public void init(ExEntityInsentient entity) {
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
            double distanceSquared = this.entity.distanceSquared(this.target.getX(), this.target.getY(), this.target.getZ());
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
                this.delay = MathHelper.d(distanceMaxRangeRatio * (float) (this.ticksPerAttackAtMaxRange - this.minimumTicksPerAttack) + (float) this.minimumTicksPerAttack);
            } else if (this.delay < 0) {
                distanceMaxRangeRatio = (float) (Math.sqrt(distanceSquared) / this.maxRange);
                this.delay = MathHelper.d(distanceMaxRangeRatio * (float) (this.ticksPerAttackAtMaxRange - this.minimumTicksPerAttack) + (float) this.minimumTicksPerAttack);
            }

        }

    }
}
