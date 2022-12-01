/*
 * de.timesnake.workspace.library-entities.main
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

import de.timesnake.library.entities.entity.extension.LivingEntity;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.entity.type.EntityMapper;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalTarget;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.phys.AxisAlignedBB;
import org.bukkit.event.entity.EntityTargetEvent;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.function.Predicate;

public class ExCustomPathfinderGoalNearestAttackableTarget extends ExPathfinderGoalTarget {

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target) {
        this(target, true);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target,
                                                         Double maxDistance) {
        this(target, true, false, maxDistance);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target,
                                                         boolean checkIfCanSee) {
        this(target, checkIfCanSee, false);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target,
                                                         boolean checkIfCanSee,
                                                         boolean onlyIfPathExists) {
        this(target, 10, checkIfCanSee, onlyIfPathExists);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target,
                                                         boolean checkIfCanSee,
                                                         boolean onlyIfPathExists, Double maxDistance) {
        super(new PathfinderGoalNearestAttackableTarget(null,
                EntityMapper.mapExClassToNmsClass(target), checkIfCanSee, onlyIfPathExists, maxDistance));
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target, int chance,
                                                         boolean checkIfCanSee, boolean onlyIfPathExists) {
        this(target, chance, checkIfCanSee, onlyIfPathExists, null);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(Class<? extends LivingEntity> target, int chance,
                                                         boolean checkIfCanSee, boolean onlyIfPathExists,
                                                         @Nullable Predicate<EntityLiving> condition) {
        super(new PathfinderGoalNearestAttackableTarget(null,
                EntityMapper.mapExClassToNmsClass(target), chance, checkIfCanSee, onlyIfPathExists, condition));
    }

    protected ExCustomPathfinderGoalNearestAttackableTarget(PathfinderGoalNearestAttackableTarget<?
            extends EntityLiving> pathfinderGoal) {
        super(pathfinderGoal);
    }

    protected ExCustomPathfinderGoalNearestAttackableTarget(net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget<? extends EntityLiving> pathfinderGoal) {
        super(pathfinderGoal);
    }

    @Override
    public void injectEntity(Mob entity) {
        try {
            Field e = PathfinderGoalTarget.class.getDeclaredField("e");
            e.setAccessible(true);
            e.set(this.pathfinderGoal, entity.getNMS());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ((PathfinderGoalNearestAttackableTarget<?>) super.pathfinderGoal).init();
    }

    public static class PathfinderGoalNearestAttackableTarget<T extends EntityLiving> extends PathfinderGoalTarget {
        protected final Class<T> a;
        protected final int b;
        protected EntityLiving c;
        protected PathfinderTargetCondition d;

        protected Predicate<EntityLiving> predicate;

        protected Double maxDistance;

        public PathfinderGoalNearestAttackableTarget(EntityInsentient entityinsentient, Class<T> oclass, boolean flag) {
            this(entityinsentient, oclass, flag, false);
        }

        public PathfinderGoalNearestAttackableTarget(EntityInsentient entityinsentient, Class<T> oclass, boolean flag
                , boolean flag1) {
            this(entityinsentient, oclass, 10, flag, flag1, null);
        }

        public PathfinderGoalNearestAttackableTarget(EntityInsentient entityinsentient, Class<T> oclass, boolean flag
                , boolean flag1, Double maxDistance) {
            this(entityinsentient, oclass, 10, flag, flag1, null);
            this.maxDistance = maxDistance;
        }

        public PathfinderGoalNearestAttackableTarget(EntityInsentient entityinsentient, Class<T> oclass, int i,
                                                     boolean flag, boolean flag1,
                                                     @Nullable Predicate<EntityLiving> predicate) {
            super(entityinsentient, flag, flag1);
            this.a = oclass;
            this.b = i;
            this.predicate = predicate;
            this.a(EnumSet.of(ExPathfinderGoal.Type.TARGET.getNMS()));
        }

        protected void init() {
            this.d = PathfinderTargetCondition.a().a(this.l()).a(predicate);
        }

        public boolean a() {
            if (this.b > 0 && this.e.dR().a(this.b) != 0) {
                return false;
            } else {
                this.h();
                return this.c != null;
            }
        }

        protected AxisAlignedBB a(double d0) {
            return this.e.cz().c(d0, 4.0, d0);
        }

        protected void h() {
            if (this.a != EntityHuman.class && this.a != EntityPlayer.class) {
                this.c = this.e.s.a(this.e.s.a(this.a, this.a(this.l()), (entityliving) -> {
                    return true;
                }), this.d, this.e, this.e.dg(), this.e.dk(), this.e.dm());
            } else {
                this.c = this.e.s.a(this.d, this.e, this.e.dg(), this.e.dk(), this.e.dm());
            }

        }

        public void c() {
            this.e.setTarget(this.c, this.c instanceof EntityPlayer ? EntityTargetEvent.TargetReason.CLOSEST_PLAYER :
                    EntityTargetEvent.TargetReason.CLOSEST_ENTITY, true);
            super.c();
        }

        public void a(@Nullable EntityLiving entityliving) {
            this.c = entityliving;
        }
    }

}
