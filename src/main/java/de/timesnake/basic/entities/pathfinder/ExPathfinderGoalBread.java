package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityAnimal;
import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.animal.EntityAnimal;
import net.minecraft.world.level.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

@NmsReflection
public class ExPathfinderGoalBread extends ExPathfinderGoal {

    public ExPathfinderGoalBread(double speed) {
        super(new PathfinderGoalBreed(null, speed));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("animal", entity);
    }

    public static class PathfinderGoalBreed extends PathfinderGoal {

        private static final PathfinderTargetCondition d = PathfinderTargetCondition.b().c();

        protected final ExEntityAnimal animal;
        private final Class<? extends EntityAnimal> entityClass;
        protected final World world;
        protected ExEntityAnimal partner;
        private int f;
        private final double speed;

        public PathfinderGoalBreed(ExEntityAnimal entity, double speed) {
            this(entity, speed, entity.getNMS().getClass());
        }

        public PathfinderGoalBreed(ExEntityAnimal entity, double speed, Class<? extends EntityAnimal> entityClass) {
            this.animal = entity;
            this.world = entity.getNMSWorld();
            this.entityClass = entityClass;
            this.speed = speed;
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS(), ExPathfinderGoal.Type.LOOK.getNMS()));
        }

        public boolean a() {
            if (!this.animal.isInLove()) {
                return false;
            } else {
                EntityAnimal partner = this.getPartner();
                this.partner = this.partner == null ? null : new ExEntityAnimal(partner);
                return this.partner != null;
            }
        }

        public boolean b() {
            return this.partner.isAlive() && this.partner.isInLove() && this.f < 60;
        }

        public void d() {
            this.partner = null;
            this.f = 0;
        }

        public void e() {
            this.animal.getControllerLook().a(this.partner, 10.0F, (float) this.animal.O());
            this.animal.getNavigation().walkTo(this.partner, this.speed);
            ++this.f;
            if (this.f >= 60 && this.animal.distanceSquared(this.partner) < 9.0D) {
                this.g();
            }

        }

        @Nullable
        private EntityAnimal getPartner() {
            List<? extends EntityAnimal> entities = this.world.a(this.entityClass, d, this.animal.getNMS(),
                    this.animal.getExBoundingBox().grow(8.0D).getNMS());
            double var1 = 1.7976931348623157E308D;
            EntityAnimal partner = null;

            for (EntityAnimal entity : entities) {
                if (this.animal.mate(new ExEntityAnimal(entity)) && this.animal.distanceSquared(entity) < var1) {
                    partner = entity;
                    var1 = this.animal.distanceSquared(entity);
                }
            }

            return partner;
        }

        protected void g() {
            this.animal.makeLove((WorldServer) this.world, this.partner);
        }
    }
}
