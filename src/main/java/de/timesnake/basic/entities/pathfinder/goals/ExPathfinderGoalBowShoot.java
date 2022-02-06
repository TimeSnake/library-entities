package de.timesnake.basic.entities.pathfinder.goals;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.pathfinder.ExPathfinderGoal;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBowShoot;

public class ExPathfinderGoalBowShoot extends ExPathfinderGoal {

    public ExPathfinderGoalBowShoot(float radius) {
        super(new PathfinderGoalBowShoot<>(null, 1.0D, 20, radius));
    }

    public ExPathfinderGoalBowShoot(double d, int i, float radius) {
        super(new PathfinderGoalBowShoot<>(null, d, i, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
    }

}
