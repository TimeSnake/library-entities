package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.craftbukkit.v1_18_R2.event.CraftEventFactory;

import javax.annotation.Nullable;

@NmsReflection(usesReflection = true)
public abstract class ExPathfinderGoalIllagerWizardCastSpell extends ExPathfinderGoal {

    public ExPathfinderGoalIllagerWizardCastSpell(PathfinderGoalIllagerWizardCastSpell pathfinder) {
        super(pathfinder);
    }

    public ExPathfinderGoalIllagerWizardCastSpell() {

    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }

    public static abstract class PathfinderGoalIllagerWizardCastSpell extends PathfinderGoal {

        protected EntityIllagerWizard entity;

        protected int b;
        protected int c;

        public PathfinderGoalIllagerWizardCastSpell(EntityIllagerWizard entity) {
            this.entity = entity;
        }

        public boolean a() {
            EntityLiving entityliving = this.entity.G();
            return entityliving != null && entityliving.bl() && (!this.entity.fJ() && this.entity.S >= this.c);
        }

        public boolean b() {
            EntityLiving entityliving = this.entity.G();
            return entityliving != null && entityliving.bl() && this.b > 0;
        }

        public void c() {
            this.b = this.a(this.n());
            RefUtil.setInstanceField(this.entity, "b", this.g());
            this.c = this.entity.S + this.i();
            SoundEffect soundeffect = this.l();
            if (soundeffect != null) {
                this.entity.a(soundeffect, 1.0F, 1.0F);
            }

            this.entity.a(this.m());
        }

        public void e() {
            --this.b;
            if (this.b == 0) {
                if (!CraftEventFactory.handleEntitySpellCastEvent(this.entity, this.m())) {
                    return;
                }

                this.k();
                this.entity.a((SoundEffect) RefUtil.invokeMethod(this.entity, "fy"), 1.0F, 1.0F);
            }

        }

        protected abstract void k();

        protected int n() {
            return 20;
        }

        protected abstract int g();

        protected abstract int i();

        @Nullable
        protected abstract SoundEffect l();

        protected abstract EntityIllagerWizard.Spell m();
    }
}
