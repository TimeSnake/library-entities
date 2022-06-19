package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntityRavager;
import net.minecraft.world.entity.monster.EntityVindicator;

@NmsReflection
public class ExPathfinderGoalMeleeAttackVindicator extends ExPathfinderGoalMeleeAttack {

    public ExPathfinderGoalMeleeAttackVindicator(double speed) {
        super(new PathfinderGoalMeleeAttackVindicator(null, speed));
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
