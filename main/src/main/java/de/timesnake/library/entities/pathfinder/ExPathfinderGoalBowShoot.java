/*
    Generated by entity generator. Should only be edited in generator files.
*/

package de.timesnake.library.entities.pathfinder;


import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBowShoot;

public class ExPathfinderGoalBowShoot extends ExPathfinderGoal {

    private final double speed;
    private final int delay;
    private final float radius;

    public ExPathfinderGoalBowShoot(double speed, int delay, float radius) {
        this.speed = speed;
        this.delay = delay;
        this.radius = radius;
    }

    public ExPathfinderGoalBowShoot(int delay, float radius) {
        this.speed = 1.0D;
        this.delay = delay;
        this.radius = radius;
    }

    public ExPathfinderGoalBowShoot(double speed, float radius) {
        this.speed = speed;
        this.delay = 20;
        this.radius = radius;
    }

    public ExPathfinderGoalBowShoot(float radius) {
        this.speed = 1.0D;
        this.delay = 20;
        this.radius = radius;
    }


    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.pathfinderGoal = new PathfinderGoalBowShoot((net.minecraft.world.entity.monster.EntityMonster) entity.getNMS(), speed, delay, radius);
    }

}
