package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.raid.EntityRaider;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@NmsReflection
public class ExCustomPathfinderGoalNearestAttackableTargetWitch extends ExCustomPathfinderGoalNearestAttackableTarget {

    public ExCustomPathfinderGoalNearestAttackableTargetWitch(EntityClass<? extends EntityLiving> target, int chance,
                                                              boolean checkIfCanSee, boolean onlyIfPathExists) {
        super(new PathfinderGoalNearestAttackableTargetWitch<>(null, target.getNMSClass(), chance, checkIfCanSee,
                onlyIfPathExists, null));
    }

    public ExCustomPathfinderGoalNearestAttackableTargetWitch(PathfinderGoalNearestAttackableTargetWitch<?> pathfinderGoal) {
        super(pathfinderGoal);
    }

    public ExCustomPathfinderGoalNearestAttackableTargetWitch(net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTargetWitch<?> pathfinderGoal) {
        super(pathfinderGoal);
    }

    public static class PathfinderGoalNearestAttackableTargetWitch<T extends EntityLiving> extends PathfinderGoalNearestAttackableTarget<T> {

        private boolean i = true;

        public PathfinderGoalNearestAttackableTargetWitch(EntityRaider var0, Class<T> var1, int var2, boolean var3,
                                                          boolean var4, @Nullable Predicate<EntityLiving> var5) {
            super(var0, var1, var2, var3, var4, var5);
        }

        public void a(boolean var0) {
            this.i = var0;
        }

        public boolean a() {
            return this.i && super.a();
        }
    }

}