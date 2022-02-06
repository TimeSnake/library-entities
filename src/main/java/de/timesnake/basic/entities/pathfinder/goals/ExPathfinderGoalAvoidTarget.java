package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.entities.entity.extension.ExEntityCreature;
import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.basic.entities.wrapper.EntityClass;
import de.timesnake.basic.entities.wrapper.ExNavigationAbstract;
import de.timesnake.basic.entities.wrapper.ExPathEntity;
import de.timesnake.basic.entities.wrapper.ExVec3D;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.IEntitySelector;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;

import java.util.EnumSet;
import java.util.function.Predicate;

public class ExPathfinderGoalAvoidTarget extends ExPathfinderGoal {

    public ExPathfinderGoalAvoidTarget(EntityClass<? extends EntityLiving> clazz, float innerRadius, double innerSpeed, float outerRadius, double outerSpeed) {
        super(new PathfinderGoalAvoidTarget<>(null, clazz.getNMSClass(), innerRadius, outerRadius, innerSpeed, outerSpeed));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity);
        ((PathfinderGoalAvoidTarget<?>) this.pathfinderGoal).navigation = entity.getNavigation();
    }


    public static class PathfinderGoalAvoidTarget<T extends EntityLiving> extends PathfinderGoal {

        protected final ExEntityCreature entity;
        private final double outerSpeed;
        private final double innerSpeed;
        protected T entityAvoid;
        protected final float innerRadius;
        protected ExPathEntity pathEntity;
        protected ExNavigationAbstract navigation;
        protected final Class<T> entityAvoidClass;
        protected final Predicate<EntityLiving> predicate;
        protected final Predicate<EntityLiving> targetConditionPredicate;
        private final PathfinderTargetCondition targetCondition;

        private final float outerRadius;

        public PathfinderGoalAvoidTarget(ExEntityCreature entity, Class<T> entityAvoidClass, float innerRadius, float outerRadius, double outerSpeed, double innerSpeed) {

            this(entity, entityAvoidClass, (var0x) -> true, innerRadius, outerRadius, outerSpeed, innerSpeed, IEntitySelector.e::test);
        }

        public PathfinderGoalAvoidTarget(ExEntityCreature entity, Class<T> entityAvoidClass, Predicate<EntityLiving> predicate, float innerRadius, float outerRadius, double outerSpeed, double innerSpeed, Predicate<EntityLiving> targetConditionPredicate) {
            this.entity = entity;
            this.entityAvoidClass = entityAvoidClass;
            this.predicate = predicate;
            this.innerRadius = innerRadius;
            this.outerSpeed = outerSpeed;
            this.innerSpeed = innerSpeed;
            this.targetConditionPredicate = targetConditionPredicate;
            this.outerRadius = outerRadius;
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
            this.targetCondition = PathfinderTargetCondition.a().a(innerRadius).a(targetConditionPredicate.and(predicate));
        }

        public PathfinderGoalAvoidTarget(ExEntityCreature entity, Class<T> entityAvoidClass, float innerRadius, float outerRadius, double outerSpeed, double innerSpeed, Predicate<EntityLiving> targetConditionPredicate) {

            this(entity, entityAvoidClass, (var0x) -> true, innerRadius, outerRadius, outerSpeed, innerSpeed, targetConditionPredicate);
        }

        public boolean a() {
            this.entityAvoid = this.entity.getNMSWorld().a(this.entity.getNMSWorld().a(this.entityAvoidClass, this.entity.getExBoundingBox().grow(this.innerRadius, 3.0D, this.innerRadius).getNMS(), (v) -> true), this.targetCondition, this.entity.getNMS(), this.entity.getX(), this.entity.getY(), this.entity.getZ());
            if (this.entityAvoid == null) {
                return false;
            } else {
                ExVec3D vec = new ExVec3D(DefaultRandomPos.a(this.entity.getNMS(), 16, 7, new ExEntity(this.entityAvoid).getPositionVector().getNMS()));
                ExEntity entityAvoid = new ExEntity(this.entityAvoid);
                if (vec == null) {
                    return false;
                } else if (entityAvoid.distanceSquared(vec.getX(), vec.getY(), vec.getZ()) < entityAvoid.distanceSquared(this.entity)) {
                    return false;
                } else {
                    this.pathEntity = this.navigation.calcExPathTo(vec.getX(), vec.getY(), vec.getZ(), 0);
                    return this.pathEntity != null;
                }
            }
        }

        public boolean b() {
            return !this.navigation.m();
        }

        public void c() {
            this.navigation.walkTo(this.pathEntity, this.outerSpeed);
        }

        public void d() {
            this.entityAvoid = null;
        }

        @Override
        public void e() {
            if (this.entity.distanceSquared(new ExEntityCreature((EntityCreature) this.entityAvoid)) < (outerRadius * outerRadius)) {
                this.entity.getNavigation().setSpeed(this.innerSpeed);
            } else {
                this.entity.getNavigation().setSpeed(this.outerSpeed);
            }
        }
    }
}
