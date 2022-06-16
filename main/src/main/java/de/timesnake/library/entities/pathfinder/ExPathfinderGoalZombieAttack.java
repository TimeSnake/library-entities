package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalZombieAttack;

@NmsReflection(usesReflection = true)
public class ExPathfinderGoalZombieAttack extends ExPathfinderGoal {

    public ExPathfinderGoalZombieAttack(double speed) {
        super(new PathfinderGoalZombieAttack(null, speed, false));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("a", entity.getNMS());
        this.setNMSField("b", entity.getNMS());
    }

}
