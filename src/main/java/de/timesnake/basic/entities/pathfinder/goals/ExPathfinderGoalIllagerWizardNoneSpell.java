package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityIllagerWizard;

import java.util.EnumSet;

public class ExPathfinderGoalIllagerWizardNoneSpell extends ExPathfinderGoal {

    public ExPathfinderGoalIllagerWizardNoneSpell() {
        super(new PathfinderGoalIllagerWizardNoneSpell(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity.getNMS());
    }

    public static class PathfinderGoalIllagerWizardNoneSpell extends PathfinderGoal {

        private final EntityIllagerWizard entity;

        public PathfinderGoalIllagerWizardNoneSpell(EntityIllagerWizard entity) {
            this.entity = entity;
            this.a(EnumSet.of(Type.a, Type.b));
        }

        public boolean a() {
            return ((int) RefUtil.invokeMethod(this.entity, "fK")) > 0;
        }

        public void c() {
            super.c();
            this.entity.D().n();
        }

        public void d() {
            super.d();
            this.entity.a(EntityIllagerWizard.Spell.a);
        }

        public void e() {
            if (this.entity.G() != null) {
                this.entity.z().a(this.entity.G(), (float) this.entity.U(), (float) this.entity.T());
            }

        }
    }
}
