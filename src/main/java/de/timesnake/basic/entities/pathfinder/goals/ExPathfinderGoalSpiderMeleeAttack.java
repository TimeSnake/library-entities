package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntitySpider;
import org.bukkit.event.entity.EntityTargetEvent;

public class ExPathfinderGoalSpiderMeleeAttack extends ExPathfinderGoalMeleeAttack {

    public ExPathfinderGoalSpiderMeleeAttack(float speed) {
        super(new PathfinderGoalSpiderMeleeAttack(null, speed));
    }

    static class PathfinderGoalSpiderMeleeAttack extends PathfinderGoalMeleeAttack {
        public PathfinderGoalSpiderMeleeAttack(EntitySpider entityspider, float speed) {
            super(entityspider, speed, true);
        }

        public boolean a() {
            return super.a() && !EntityExtension.isVehicle(this.a);
        }

        public boolean b() {
            float f = EntityExtension.aR(this.a);
            if (f >= 0.5F && EntityExtension.getRandom(this.a).nextInt(100) == 0) {
                this.a.setTarget(null, EntityTargetEvent.TargetReason.CUSTOM, true);
                return false;
            } else {
                return super.b();
            }
        }

        protected double a(EntityLiving entityliving) {
            return 4.0F + EntityExtension.getWidth(entityliving);
        }
    }
}
