package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.tags.TagsFluid;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

import java.util.EnumSet;

@NmsReflection
public class ExPathfinderGoalFloat extends ExPathfinderGoal {

    public ExPathfinderGoalFloat() {
        super(new PathfinderGoalFloat(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        ((PathfinderGoalFloat) this.getNMS()).setEntity(entity);
    }

    private static class PathfinderGoalFloat extends PathfinderGoal {
        private ExEntityInsentient entity;

        public PathfinderGoalFloat(ExEntityInsentient var0) {
            this.entity = var0;
            this.a(EnumSet.of(ExPathfinderGoal.Type.JUMP.getNMS()));
        }

        public void setEntity(ExEntityInsentient entity) {
            this.entity = entity;
            this.entity.getNavigation().d(true);
        }

        public boolean a() {
            return this.entity.isInWater() && this.entity.b(TagsFluid.b) > this.entity.cx() || this.entity.aQ();
        }

        public void e() {
            if (this.entity.getRandom().nextFloat() < 0.8F) {
                this.entity.getControllerJump().jump();
            }

        }
    }
}
