/*
 * library-entities.library-entities.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.entity.extension.ExEntityCreature;
import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.entity.type.EntityMapper;
import de.timesnake.library.entities.wrapper.ExNavigationAbstract;
import de.timesnake.library.entities.wrapper.ExPathEntity;
import de.timesnake.library.entities.wrapper.ExVec3D;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityCreature;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.IEntitySelector;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;

import java.util.EnumSet;
import java.util.function.Predicate;

@NmsReflection
public class ExCustomPathfinderGoalAvoidTarget extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalAvoidTarget(Class<? extends LivingEntity> clazz, float innerRadius,
                                             double innerSpeed, float outerRadius, double outerSpeed) {
        super(new PathfinderGoalAvoidTarget<>(null, EntityMapper.mapExClassToNmsClass(clazz), innerRadius, outerRadius, innerSpeed,
                outerSpeed));
    }

    @Override
    public void injectEntity(Mob entity) {
        this.setNMSField("entity", entity);
        ((PathfinderGoalAvoidTarget<?>) this.pathfinderGoal).navigation = entity.getNavigation();
    }


    public static class PathfinderGoalAvoidTarget<T extends EntityLiving> extends PathfinderGoal {

        protected final float innerRadius;
        protected final Class<T> entityAvoidClass;
        protected final Predicate<EntityLiving> predicate;
        protected final Predicate<EntityLiving> targetConditionPredicate;
        private final double outerSpeed;
        private final double innerSpeed;
        private final PathfinderTargetCondition targetCondition;
        private final float outerRadius;
        protected ExEntityCreature entity;
        protected T entityAvoid;
        protected ExPathEntity pathEntity;
        protected ExNavigationAbstract navigation;

        public PathfinderGoalAvoidTarget(ExEntityCreature entity, Class<T> entityAvoidClass, float innerRadius,
                                         float outerRadius, double outerSpeed, double innerSpeed) {

            this(entity, entityAvoidClass, (var0x) -> true, innerRadius, outerRadius, outerSpeed, innerSpeed,
                    IEntitySelector.e::test);
        }

        public PathfinderGoalAvoidTarget(ExEntityCreature entity, Class<T> entityAvoidClass,
                                         Predicate<EntityLiving> predicate, float innerRadius, float outerRadius,
                                         double outerSpeed, double innerSpeed,
                                         Predicate<EntityLiving> targetConditionPredicate) {
            this.entity = entity;
            this.entityAvoidClass = entityAvoidClass;
            this.predicate = predicate;
            this.innerRadius = innerRadius;
            this.outerSpeed = outerSpeed;
            this.innerSpeed = innerSpeed;
            this.targetConditionPredicate = targetConditionPredicate;
            this.outerRadius = outerRadius;
            this.a(EnumSet.of(ExCustomPathfinderGoal.Type.MOVE.getNMS()));
            this.targetCondition =
                    PathfinderTargetCondition.a().a(innerRadius).a(targetConditionPredicate.and(predicate));
        }

        public PathfinderGoalAvoidTarget(ExEntityCreature entity, Class<T> entityAvoidClass, float innerRadius,
                                         float outerRadius, double outerSpeed, double innerSpeed,
                                         Predicate<EntityLiving> targetConditionPredicate) {

            this(entity, entityAvoidClass, (var0x) -> true, innerRadius, outerRadius, outerSpeed, innerSpeed,
                    targetConditionPredicate);
        }

        public boolean a() {
            this.entityAvoid = this.entity.getNMSWorld().a(this.entity.getNMSWorld().a(this.entityAvoidClass,
                            this.entity.getExBoundingBox().grow(this.innerRadius, 3.0D, this.innerRadius).getNMS(),
                            (v) -> true), this.targetCondition, this.entity.getNMS(), this.entity.getX(),
                    this.entity.getY(),
                    this.entity.getZ());
            if (this.entityAvoid == null) {
                return false;
            } else {
                ExVec3D vec = new ExVec3D(DefaultRandomPos.a(this.entity.getNMS(), 16, 7,
                        new ExEntity(this.entityAvoid).getPositionVector().getNMS()));
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
