package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityVindicator;

public class ExPathfinderGoalMeleeAttackVindicator extends ExPathfinderGoalMeleeAttack {

    public ExPathfinderGoalMeleeAttackVindicator(double speed) {
        super(new PathfinderGoalMeleeAttackVindicator(null, speed));
    }

    protected static class PathfinderGoalMeleeAttackVindicator extends PathfinderGoalMeleeAttack {

        public PathfinderGoalMeleeAttackVindicator(EntityVindicator entity, double speed) {
            super(entity, speed, false);
        }

        protected double a(EntityLiving var0) {
            if (new ExEntity(this.a).getVehicle() instanceof EntityRavager) {
                float var1 = new ExEntity(new ExEntity(this.a).getVehicle()).getWidth() - 0.1F;
                return var1 * 2.0F * var1 * 2.0F + new ExEntity(var0).getWidth();
            } else {
                return super.a(var0);
            }
        }
    }
}
