/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoalBowShoot;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalBowShoot;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.monster.EntitySkeletonAbstract;
import net.minecraft.world.entity.projectile.ProjectileHelper;
import net.minecraft.world.item.Items;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAbstractSkeleton;

import java.lang.reflect.Field;

@NmsReflection(usesReflection = true)
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
            this.updateBowShootMeele(priority);
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
            this.updateBowShootMeele(pathfinderGoal.getPriority());
        } else {
            super.addPathfinderGoal(pathfinderGoal);
        }
    }

    private void updateBowShootMeele(int priority) {

        PathfinderGoalBowShoot<?> b;
        try {
            Field bField = EntitySkeletonAbstract.class.getDeclaredField("b");
            bField.setAccessible(true);
            b = (PathfinderGoalBowShoot<?>) bField.get(this.getNMS());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        PathfinderGoalMeleeAttack c;
        try {
            Field cField = EntitySkeletonAbstract.class.getDeclaredField("c");
            cField.setAccessible(true);
            c = (PathfinderGoalMeleeAttack) cField.get(this.getNMS());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (this.getNMSWorld() != null && !this.getNMSWorld().y) {
            this.getGoalSelector().a(c);
            this.getGoalSelector().a(b);

            net.minecraft.world.item.ItemStack itemStack = this.getNMS().b(ProjectileHelper.a(this.getNMS(), Items.mg));
            if (itemStack.a(Items.mg)) {
                this.getGoalSelector().a(priority, b);
            } else {
                this.getGoalSelector().a(priority, c);
            }
        }
    }

}
