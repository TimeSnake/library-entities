package de.timesnake.basic.entities.pathfinder.target;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;

public class ExPathfinderGoalCustomOwnerHurtByTarget extends ExPathfinderGoalTarget {

    public ExPathfinderGoalCustomOwnerHurtByTarget(ExEntityInsentient owner) {
        super(new ExPathfinderGoalCustomOwnerHurtByTarget.PathfinderGoalCustomOwnerHurtByTarget(null, owner));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.injectEntity(entity);
    }

    public static class PathfinderGoalCustomOwnerHurtByTarget extends PathfinderGoalTarget {

        private final ExEntityInsentient owner;
        private ExEntityLiving damager;
        private int c;

        public PathfinderGoalCustomOwnerHurtByTarget(ExEntityInsentient entity, ExEntityInsentient owner) {
            super(entity.getNMS(), false);
            this.owner = owner;
            this.a(EnumSet.of(ExPathfinderGoal.Type.TARGET.getNMS()));
        }

        public boolean a() {
            if (this.owner == null) {
                return false;
            } else {
                this.damager = this.owner.getExLastDamager();
                int i = this.owner.getHurtTimestamp();
                return i != this.c && this.a(this.damager.getNMS(), PathfinderTargetCondition.a);
            }
        }

        public void c() {
            new ExEntityInsentient(this.e).setTarget(this.damager.getNMS(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER, true);
            if (this.owner != null) {
                this.c = this.owner.getHurtTimestamp();
            }

            super.c();
        }
    }
}
