package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityBlaze;

import java.util.Arrays;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalBlazeFireball extends ExCustomPathfinderGoal {

    private static final Class<?> NMS_CLASS =
            Arrays.stream(EntityBlaze.class.getDeclaredClasses()).filter((c) -> c.getSimpleName().equals(
                    "PathfinderGoalBlazeFireball")).findFirst().get();

    public ExCustomPathfinderGoalBlazeFireball() {
        super.pathfinderGoal = ((PathfinderGoal) RefUtil.instantiate(NMS_CLASS, new Class[]{EntityBlaze.class},
                (EntityBlaze) null));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("a", entity.getNMS());
    }

}