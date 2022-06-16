package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntitySpider;

@NmsReflection
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
