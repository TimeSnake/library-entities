/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalMeleeAttack;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityVindicator;

public class ExCustomPathfinderGoalMeleeAttackVindicator extends ExPathfinderGoalMeleeAttack {

    public ExCustomPathfinderGoalMeleeAttackVindicator(double speed) {
        super(speed);
    }

    @Override
    public void injectEntity(Mob entity) {
        super.pathfinderGoal = new PathfinderGoalMeleeAttackVindicator(((EntityVindicator) entity.getNMS()), this.speed);
    }

    protected static class PathfinderGoalMeleeAttackVindicator extends PathfinderGoalMeleeAttack {

        public PathfinderGoalMeleeAttackVindicator(EntityVindicator entity, double speed) {
            super(entity, speed, false);
        }

        protected double a(EntityLiving var0) {
            if (this.a.cR() instanceof EntityRavager) {
                float var1 = this.a.cR().cX() - 0.1F;
                return var1 * 2.0F * var1 * 2.0F + var0.cX();
            } else {
                return super.a(var0);
            }
        }
    }
}
