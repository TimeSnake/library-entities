/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalMeleeAttack;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntityVindicator;

public class ExCustomPathfinderGoalMeleeAttackRavager extends ExPathfinderGoalMeleeAttack {

    public ExCustomPathfinderGoalMeleeAttackRavager(double speed) {
        super(speed);
    }

    @Override
    public void injectEntity(Mob entity) {
        super.pathfinderGoal = new PathfinderGoalMeleeAttackRavager(((EntityVindicator) entity.getNMS()), this.speed);
    }

    protected static class PathfinderGoalMeleeAttackRavager extends PathfinderGoalMeleeAttack {

        public PathfinderGoalMeleeAttackRavager(EntityVindicator entity, double speed) {
            super(entity, speed, true);
        }

        @Override
        protected double a(EntityLiving entityliving) {
            float f = this.a.cX() - 0.1F;
            return f * 2.0F * f * 2.0F + entityliving.cX();
        }
    }
}
