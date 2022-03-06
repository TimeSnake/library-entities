package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBowShoot;

public class ExPathfinderGoalBowShoot extends ExPathfinderGoal {

    public ExPathfinderGoalBowShoot(float radius) {
        super(new PathfinderGoalBowShoot<>(null, 1.0D, 20, radius));
    }

    public ExPathfinderGoalBowShoot(double speed, float radius) {
        super(new PathfinderGoalBowShoot<>(null, speed, 20, radius));
    }

    public ExPathfinderGoalBowShoot(double speed, int i, float radius) {
        super(new PathfinderGoalBowShoot<>(null, speed, i, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
    }

}
