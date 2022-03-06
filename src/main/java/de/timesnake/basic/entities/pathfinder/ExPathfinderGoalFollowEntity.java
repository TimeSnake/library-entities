package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.wrapper.EntityClass;
import de.timesnake.basic.entities.wrapper.ExControllerLook;
import de.timesnake.basic.entities.wrapper.ExNavigationAbstract;
import de.timesnake.basic.entities.wrapper.ExPathType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

import java.util.EnumSet;
import java.util.List;

public class ExPathfinderGoalFollowEntity extends ExPathfinderGoal {

    public ExPathfinderGoalFollowEntity(EntityExtension<? extends ExEntityInsentient> leader, float speed, float maxDistance, float leaderSearchRadius) {
        super(new PathfinderGoalFollowEntity(null, leader.getExtension(), speed, maxDistance, leaderSearchRadius));
    }

    public ExPathfinderGoalFollowEntity(EntityClass<? extends EntityInsentient> leader, float speed, float maxDistance, float leaderSearchRadius) {
        super(new PathfinderGoalFollowEntity(null, leader.getNMSClass(), speed, maxDistance, leaderSearchRadius));
    }


    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
        ((PathfinderGoalFollowEntity) super.getNMS()).navigationAbstract = entity.getNavigation();
    }

    public static class PathfinderGoalFollowEntity extends PathfinderGoal {

        private final ExEntityInsentient entity;
        private ExEntityInsentient leaderEntity;
        private final double speed;
        private ExNavigationAbstract navigationAbstract;
        private int f;
        private final float maxDistance;
        private float h;
        private final float leaderSearchRadius;

        private final Class<? extends Entity> leaderClass;
        private ExEntityInsentient leader;

        public PathfinderGoalFollowEntity(ExEntityInsentient entity, Class<? extends EntityInsentient> leaderClass, double speed, float maxDistance, float leaderSearchRadius) {
            this.entity = entity;
            this.speed = speed;
            this.maxDistance = maxDistance;
            this.leaderSearchRadius = leaderSearchRadius;
            this.leaderClass = leaderClass;
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS(), ExPathfinderGoal.Type.LOOK.getNMS()));
        }

        public PathfinderGoalFollowEntity(ExEntityInsentient entity, ExEntityInsentient leader, double speed, float maxDistance, float leaderSearchRadius) {
            this(entity, leader.getNMS().getClass(), speed, maxDistance, leaderSearchRadius);
            this.leader = leader;
            this.leaderEntity = leader;
        }

        public boolean a() {
            if (this.leader != null) {
                return this.entity.distanceSquared(this.leader) > this.maxDistance * this.maxDistance;
            } else {
                List<? extends Entity> entities = this.entity.getExWorld().getNMS().a(this.leaderClass, this.entity.getExBoundingBox().grow(this.leaderSearchRadius).getNMS());
                if (!entities.isEmpty()) {

                    for (Entity entity : entities) {
                        if (entity instanceof EntityInsentient && !new ExEntityInsentient((EntityInsentient) entity).isInvisible()) {
                            this.leaderEntity = new ExEntityInsentient((EntityInsentient) entity);
                            return true;
                        }
                    }
                }

            }
            return false;
        }

        public boolean b() {
            return this.leaderEntity != null && !this.navigationAbstract.m() && this.entity.distanceSquared(this.leaderEntity) > (double) (this.maxDistance * this.maxDistance);
        }

        public void c() {
            this.f = 0;
            this.h = this.entity.a(ExPathType.WATER);
            this.entity.a(ExPathType.WATER, 0.0F);
        }

        public void d() {
            if (this.leader == null) {
                this.leaderEntity = null;
            }
            this.navigationAbstract.o();
            this.entity.a(ExPathType.WATER, this.h);
        }

        public void e() {
            if (this.leaderEntity != null && !this.entity.isNmsLeashed()) {
                this.entity.getControllerLook().a(this.leaderEntity, 10.0F, (float) this.entity.O());
                if (--this.f <= 0) {
                    this.f = 10;
                    double deltaX = this.entity.getX() - this.leaderEntity.getX();
                    double deltaY = this.entity.getY() - this.leaderEntity.getY();
                    double deltaZ = this.entity.getZ() - this.leaderEntity.getZ();
                    double distanceSquared = deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
                    if (!(distanceSquared <= (double) (this.maxDistance * this.maxDistance))) {
                        this.navigationAbstract.walkTo(this.leaderEntity, this.speed);
                    } else {
                        this.navigationAbstract.o();
                        ExControllerLook controllerLook = this.leaderEntity.getControllerLook();
                        if (distanceSquared <= (double) this.maxDistance || controllerLook.d() == this.entity.getX() && controllerLook.e() == this.entity.getY() && controllerLook.f() == this.entity.getZ()) {

                            double var9 = this.leaderEntity.getX() - this.entity.getX();
                            double var11 = this.leaderEntity.getZ() - this.entity.getZ();

                            this.navigationAbstract.walkTo(this.entity.getX() - var9, this.entity.getY(), this.entity.getZ() - var11, this.speed);
                        }

                    }
                }
            }
        }
    }
}
