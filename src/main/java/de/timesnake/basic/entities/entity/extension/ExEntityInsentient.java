package de.timesnake.basic.entities.entity.extension;

import com.google.common.collect.Sets;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoalTarget;
import de.timesnake.basic.entities.wrapper.*;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoalSelector;
import net.minecraft.world.level.pathfinder.PathType;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftMob;
import org.bukkit.event.entity.EntityTargetEvent;

public class ExEntityInsentient extends ExEntityLiving {

    public ExEntityInsentient(CraftMob entity) {
        super(entity);
    }

    public ExEntityInsentient(EntityInsentient entity) {
        super(entity);
    }

    static void setTarget(EntityInsentient entity, EntityLiving target) {
        entity.setTarget(target, EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    public EntityInsentient getNMS() {
        return (EntityInsentient) super.getNMS();
    }

    public PathfinderGoalSelector getGoalSelector() {
        return this.getNMS().bR;
    }

    public PathfinderGoalSelector getTargetSelector() {
        return this.getNMS().bS;
    }

    public void addPathfinderGoal(ExPathfinderGoal pathfinderGoal) {
        if (pathfinderGoal == null) {
            return;
        }

        pathfinderGoal.injectEntity(this);

        if (pathfinderGoal.getNMS() == null) {
            return;
        }

        this.getGoalSelector().a(pathfinderGoal.getPriority(), pathfinderGoal.getNMS());
    }

    public void addPathfinderGoal(int priority, ExPathfinderGoal pathfinderGoal) {
        if (pathfinderGoal == null) {
            return;
        }

        pathfinderGoal.injectEntity(this);

        if (pathfinderGoal instanceof ExPathfinderGoalTarget) {
            this.getNMS().bS.a(priority, pathfinderGoal.getNMS());
        } else {
            this.getNMS().bR.a(priority, pathfinderGoal.getNMS());
        }
    }

    public void removePathfinderGoal(ExPathfinderGoal pathfinderGoal) {
        if (pathfinderGoal instanceof ExPathfinderGoalTarget) {
            this.getTargetSelector().a(pathfinderGoal.getNMS());
        } else {
            this.getGoalSelector().a(pathfinderGoal.getNMS());
        }
    }

    public void clearPathfinderGoals() {
        RefUtil.setInstanceField(this.getGoalSelector(), "d", Sets.newLinkedHashSet());
        RefUtil.setInstanceField(this.getTargetSelector(), "d", Sets.newLinkedHashSet());
    }

    public void setTarget(ExEntityLiving target) {
        if (target != null) {
            this.getNMS().setTarget(target.getNMS(), EntityTargetEvent.TargetReason.CUSTOM, true);
        } else {
            this.getNMS().setTarget(null, EntityTargetEvent.TargetReason.CUSTOM, true);
        }
    }

    public void setTarget(EntityLiving target) {
        this.getNMS().setTarget(target, EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    public void setTarget(EntityLiving entityliving, EntityTargetEvent.TargetReason reason, boolean fireEvent) {
        this.getNMS().setTarget(entityliving, reason, fireEvent);
    }

    public ExEntityLiving getExTarget() {
        if (this.getNMSTarget() == null) {
            return null;
        }
        return new ExEntityLiving(this.getNMSTarget());
    }

    public EntityLiving getNMSTarget() {
        if (this.getNMS().G() == null) {
            return null;
        }
        return this.getNMS().G();
    }

    public void clearGoalTargets() {
        this.getNMS().bS = new PathfinderGoalSelector(this.getNMS().t.ac());
    }

    public ExPathEntity calcPath(double x, double y, double z, int minDistance) {
        return ExWrapper.wrapPathEntity(this.getNMS().D().a(x, y, z, minDistance));
    }

    public ExNavigationAbstract getNavigation() {
        return new ExNavigationAbstract(this.getNMS().D());
    }

    public ExControllerLook getControllerLook() {
        return new ExControllerLook(this.getNMS().z());
    }

    public ExControllerJump getControllerJump() {
        return new ExControllerJump(this.getNMS().C());
    }

    public ExControllerMove getControllerMove() {
        return new ExControllerMove(this.getNMS().A());
    }

    public ExEntitySenses getEntitySenses() {
        return new ExEntitySenses(this.getNMS().E());
    }

    public void setNoAI(boolean flag) {
        this.getNMS().s(flag);
    }

    public void setLeftHanded(boolean flag) {
        this.getNMS().t(flag);
    }

    public void setAggressive(boolean flag) {
        this.getNMS().u(flag);
    }

    public boolean isNoAI() {
        return this.getNMS().fr();
    }

    public boolean isLeftHanded() {
        return this.getNMS().fs();
    }

    public boolean isAggressive() {
        return this.getNMS().ft();
    }

    public boolean isNmsLeashed() {
        return this.getNMS().fp();
    }

    public boolean isLeashed() {
        return this.getNMS().fq() != null;
    }

    public int O() {
        return this.getNMS().T();
    }

    public int Q() {
        return this.getNMS().U();
    }

    public int ep() {
        return this.getNMS().V();
    }

    public float a(PathType pathType) {
        return this.getNMS().a(pathType);
    }

    public void a(PathType pathType, float f) {
        this.getNMS().a(pathType, f);
    }

    public float a(ExPathType pathType) {
        return this.a(pathType.getNMS());
    }

    public void a(ExPathType pathType, float f) {
        this.a(pathType.getNMS(), f);
    }

    public boolean c(EntityLiving entity) {
        return this.getNMS().c(entity);
    }
}
