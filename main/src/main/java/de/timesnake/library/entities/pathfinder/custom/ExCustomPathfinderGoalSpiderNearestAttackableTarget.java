package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.monster.EntitySpider;

@NmsReflection
public class ExCustomPathfinderGoalSpiderNearestAttackableTarget extends ExCustomPathfinderGoalNearestAttackableTarget {

    public ExCustomPathfinderGoalSpiderNearestAttackableTarget(EntityClass<EntityLiving> target) {
        super(new PathfinderGoalSpiderNearestAttackableTarget(null, target.getNMSClass()));
    }

    static class PathfinderGoalSpiderNearestAttackableTarget<T extends EntityLiving> extends PathfinderGoalNearestAttackableTarget<T> {

        public PathfinderGoalSpiderNearestAttackableTarget(EntitySpider entityspider, Class<T> oclass) {
            super(entityspider, oclass, true);
        }

        public boolean a() {
            float f = this.e.bh();
            return !(f >= 0.5F) && super.a();
        }
    }
}
