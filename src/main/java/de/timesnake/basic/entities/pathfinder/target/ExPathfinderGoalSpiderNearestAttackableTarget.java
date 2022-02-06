package de.timesnake.basic.entities.pathfinder.target;

import de.timesnake.basic.entities.wrapper.EntityClass;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntitySpider;

public class ExPathfinderGoalSpiderNearestAttackableTarget extends ExPathfinderGoalNearestAttackableTarget {

    public ExPathfinderGoalSpiderNearestAttackableTarget(EntityClass<EntityLiving> target) {
        super(new PathfinderGoalSpiderNearestAttackableTarget(null, target.getNMSClass()));
    }

    static class PathfinderGoalSpiderNearestAttackableTarget<T extends EntityLiving> extends PathfinderGoalNearestAttackableTarget<T> {

        public PathfinderGoalSpiderNearestAttackableTarget(EntitySpider entityspider, Class<T> oclass) {
            super(entityspider, oclass, true);
        }

        public boolean a() {
            float f = this.e.bd();
            return !(f >= 0.5F) && super.a();
        }
    }
}
