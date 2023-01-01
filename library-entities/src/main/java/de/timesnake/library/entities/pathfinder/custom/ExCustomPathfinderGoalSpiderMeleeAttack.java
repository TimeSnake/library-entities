/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalMeleeAttack;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntitySpider;

public class ExCustomPathfinderGoalSpiderMeleeAttack extends ExPathfinderGoalMeleeAttack {

    public ExCustomPathfinderGoalSpiderMeleeAttack(float speed) {
        super(speed);
    }

    @Override
    public void injectEntity(Mob entity) {
        super.pathfinderGoal = new PathfinderGoalSpiderMeleeAttack(((EntitySpider) entity.getNMS()), this.speed);
    }

    static class PathfinderGoalSpiderMeleeAttack extends PathfinderGoalMeleeAttack {
        public PathfinderGoalSpiderMeleeAttack(EntitySpider entityspider, double speed) {
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
