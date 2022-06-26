package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.phys.AxisAlignedBB;
import org.bukkit.event.entity.EntityTargetEvent;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

@NmsReflection
public class ExCustomPathfinderGoalNearestAttackableTarget extends ExCustomPathfinderGoalTarget {

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target) {
        this(target, true);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target,
                                                         Double maxDistance) {
        this(target, true, false, maxDistance);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target,
                                                         boolean checkIfCanSee) {
        this(target, checkIfCanSee, false);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target,
                                                         boolean checkIfCanSee,
                                                         boolean onlyIfPathExists) {
        this(target, 10, checkIfCanSee, onlyIfPathExists);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target,
                                                         boolean checkIfCanSee,
                                                         boolean onlyIfPathExists, Double maxDistance) {
        super(new PathfinderGoalNearestAttackableTarget(null, target.getNMSClass(), checkIfCanSee, onlyIfPathExists,
                maxDistance));
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target, int chance,
                                                         boolean checkIfCanSee, boolean onlyIfPathExists) {
        this(target, chance, checkIfCanSee, onlyIfPathExists, null);
    }

    public ExCustomPathfinderGoalNearestAttackableTarget(EntityClass<? extends EntityLiving> target, int chance,
                                                         boolean checkIfCanSee, boolean onlyIfPathExists,
                                                         @Nullable Predicate<EntityLiving> condition) {
        super(new PathfinderGoalNearestAttackableTarget(null, target.getNMSClass(), chance, checkIfCanSee,
                onlyIfPathExists, condition));
    }

    protected ExCustomPathfinderGoalNearestAttackableTarget(PathfinderGoalNearestAttackableTarget<?
            extends EntityLiving> pathfinderGoal) {
        super(pathfinderGoal);
    }

    protected ExCustomPathfinderGoalNearestAttackableTarget(net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget<? extends EntityLiving> pathfinderGoal) {
        super(pathfinderGoal);
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.injectEntity(entity);
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
            this.a(EnumSet.of(ExCustomPathfinderGoal.Type.TARGET.getNMS()));
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
