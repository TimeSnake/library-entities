package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.bukkit.ExPhantom;
import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.player.EntityHuman;

import java.util.Comparator;
import java.util.List;

public class ExPathfinderGoalPhantomTarget extends ExPathfinderGoal {

    public ExPathfinderGoalPhantomTarget() {
        super(new PathfinderGoalPhantomTargetEntity(null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("entity", entity.getNMS());
    }

    protected static class PathfinderGoalPhantomTargetEntity extends PathfinderGoal {

        private final ExPhantom entity;
        private final PathfinderTargetCondition b;
        private int c;

        private PathfinderGoalPhantomTargetEntity(ExPhantom entity) {
            this.entity = entity;
            this.b = PathfinderTargetCondition.a().a(64.0D);
            this.c = 20;
        }

        public boolean a() {
            if (this.c > 0) {
                --this.c;
            } else {
                this.c = 60;
                List<EntityHuman> list = this.entity.getExtension().getNMSWorld().a(this.b, this.entity.getHandle(), this.entity.getExtension().getExBoundingBox().grow(16.0D, 64.0D, 16.0D).getNMS());
                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing((e) -> new ExEntity(((Entity) e)).getY()).reversed());

                    for (EntityHuman entityhuman : list) {
                        this.entity.getExtension().setTarget(entityhuman);
                        return true;
                    }
                }

            }
            return false;
        }

        public boolean b() {
            EntityLiving entityliving = this.entity.getExtension().getNMSTarget();
            return entityliving != null && this.entity.getExtension().a(entityliving, PathfinderTargetCondition.a);
        }
    }
}