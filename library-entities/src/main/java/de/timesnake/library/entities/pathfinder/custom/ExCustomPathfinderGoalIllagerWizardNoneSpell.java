/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityIllagerWizard;


public class ExCustomPathfinderGoalIllagerWizardNoneSpell extends ExPathfinderGoal {

    public ExCustomPathfinderGoalIllagerWizardNoneSpell() {
        super(new PathfinderGoalIllagerWizardNoneSpell(null));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity.getNMS());
    }

    public static class PathfinderGoalIllagerWizardNoneSpell extends PathfinderGoal {

        private final ExEntityIllagerWizard entity;

        public PathfinderGoalIllagerWizardNoneSpell(ExEntityIllagerWizard entity) {
            this.entity = entity;
            this.a(EnumSet.of(Type.a, Type.b));
        }

        public boolean a() {
            int fW;
            try {
                Method fWMethod = this.entity.getNMS().getClass().getMethod("fW");
                fWMethod.setAccessible(true);
                fW = (int) fWMethod.invoke(this.entity.getNMS());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return fW > 0;
        }

        public void c() {
            super.c();
            this.entity.getNavigation().getNMS().n();
        }

        public void d() {
            super.d();
            this.entity.getNMS().a(EntityIllagerWizard.Spell.a);
        }

        public void e() {
            if (this.entity.getNMS().G() != null) {
                this.entity.getNMS().z().a(this.entity.getNMS().G(), (float) this.entity.getNMS().V(),
                        (float) this.entity.getNMS().U());
            }

        }
    }
}
