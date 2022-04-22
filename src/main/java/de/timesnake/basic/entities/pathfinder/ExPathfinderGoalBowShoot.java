package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBowShoot;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalBowShoot extends ExPathfinderGoal {

    public ExPathfinderGoalBowShoot(float radius) {
        super(new PathfinderGoalBowShoot<>(null, 1.0D, 20, radius));
    }

    public ExPathfinderGoalBowShoot(double speed, float radius) {
        super(new PathfinderGoalBowShoot<>(null, speed, 20, radius));
    }

    public ExPathfinderGoalBowShoot(double speed, int delay, float radius) {
        super(new PathfinderGoalBowShoot<>(null, speed, delay, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
    }

}
