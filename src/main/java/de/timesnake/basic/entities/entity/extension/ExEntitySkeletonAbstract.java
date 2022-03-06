package de.timesnake.basic.entities.entity.extension;

import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoalBowShoot;
import net.minecraft.world.entity.monster.EntitySkeletonAbstract;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftAbstractSkeleton;

public class ExEntitySkeletonAbstract extends ExEntityInsentient {

    public ExEntitySkeletonAbstract(CraftAbstractSkeleton entity) {
        super(entity);
    }

    public ExEntitySkeletonAbstract(EntitySkeletonAbstract entity) {
        super(entity);
    }

    @Override
    public EntitySkeletonAbstract getNMS() {
        return (EntitySkeletonAbstract) super.getNMS();
    }

    @Override
    public void addPathfinderGoal(int priority, ExPathfinderGoal pathfinderGoal) {
        if (pathfinderGoal instanceof ExPathfinderGoalBowShoot) {
            if (pathfinderGoal == null) {
                return;
            }

            pathfinderGoal.injectEntity(this);

            super.setNMSField(EntitySkeletonAbstract.class, "b", pathfinderGoal.getNMS());
            this.getNMS().t();
        } else {
            super.addPathfinderGoal(priority, pathfinderGoal);
        }
    }

    @Override
    public void addPathfinderGoal(ExPathfinderGoal pathfinderGoal) {
        if (pathfinderGoal instanceof ExPathfinderGoalBowShoot) {
            if (pathfinderGoal == null) {
                return;
            }

            pathfinderGoal.injectEntity(this);

            super.setNMSField(EntitySkeletonAbstract.class, "b", pathfinderGoal.getNMS());
            this.getNMS().t();
        } else {
            super.addPathfinderGoal(pathfinderGoal);
        }
    }

}
