/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.reflection.Util;
import java.util.Arrays;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityBlaze;

public class ExCustomPathfinderGoalBlazeFireball extends ExPathfinderGoal {

    private static final Class<?> NMS_CLASS =
            Arrays.stream(EntityBlaze.class.getDeclaredClasses()).filter((c) -> c.getSimpleName().equals(
                    "PathfinderGoalBlazeFireball")).findFirst().get();

    public ExCustomPathfinderGoalBlazeFireball() {
        super.pathfinderGoal = ((PathfinderGoal) Util.instantiate(NMS_CLASS, new Class[]{EntityBlaze.class},
                (EntityBlaze) null));
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("a", entity.getNMS());
    }

}
