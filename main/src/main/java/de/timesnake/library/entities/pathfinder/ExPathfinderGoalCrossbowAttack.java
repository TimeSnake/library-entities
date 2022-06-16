package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalCrossbowAttack;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalCrossbowAttack extends ExPathfinderGoal {

    public ExPathfinderGoalCrossbowAttack(double speed, float radius) {
        super(new PathfinderGoalCrossbowAttack<>(null, speed, radius));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("b", entity.getNMS());
    }

}
