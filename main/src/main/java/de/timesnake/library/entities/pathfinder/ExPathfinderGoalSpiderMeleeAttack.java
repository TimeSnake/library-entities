package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntitySpider;

@NmsReflection
public class ExPathfinderGoalSpiderMeleeAttack extends ExPathfinderGoalMeleeAttack {

    public ExPathfinderGoalSpiderMeleeAttack(float speed) {
        super(new PathfinderGoalSpiderMeleeAttack(null, speed));
    }

    static class PathfinderGoalSpiderMeleeAttack extends PathfinderGoalMeleeAttack {
        public PathfinderGoalSpiderMeleeAttack(EntitySpider entityspider, float speed) {
            super(entityspider, speed, true);
        }

        public boolean a() {
            return super.a() && !this.a.bK();
        }

        public boolean b() {
            float f = this.a.bh();
            if (f >= 0.5F && this.a.dR().a(100) == 0) {
                this.a.h((EntityLiving) null);
                return false;
            } else {
                return super.b();
            }
        }

        protected double a(EntityLiving entityliving) {
            return (double) (4.0F + entityliving.cX());
        }
    }
}
