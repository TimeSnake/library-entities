/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import de.timesnake.library.entities.proxy.AbstractSkeletonProxy;
import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Function;


public abstract class AbstractSkeletonBuilder<E extends AbstractSkeleton, B extends AbstractSkeletonBuilder<E, B>> extends MonsterBuilder<E, B> {

  protected static final AbstractSkeletonProxy PROXY = ProxyManager.getInstance().getAbstractSkeletonProxy();

  public AbstractSkeletonBuilder() {
    super();
  }


  @Override
  public B addPathfinderGoal(int priority, Function<E, ? extends Goal> pathfinderGoal) {
    super.addPathfinderGoal(priority, pathfinderGoal);
    return this.applyOnEntity(e -> {
      Goal goal = pathfinderGoal.apply(e);
      if (goal instanceof RangedBowAttackGoal<?>) {
        PROXY.setBowGoal(e, (RangedBowAttackGoal<AbstractSkeleton>) goal);
        this.reassessWeaponGoal(priority);
      } else if (goal instanceof MeleeAttackGoal) {
        PROXY.setMeleeGoal(e, (MeleeAttackGoal) goal);
        this.reassessWeaponGoal(priority);
      }
    });
  }

  public B reassessWeaponGoal(int priority) {
    return this.applyOnEntity(e -> {
      RangedBowAttackGoal<?> bowGoal = PROXY.getBowGoal(e);
      MeleeAttackGoal meleeGoal = PROXY.getMeleeGoal(e);

      if (!e.level().isClientSide) {
        e.goalSelector.removeGoal(bowGoal);
        e.goalSelector.removeGoal(meleeGoal);
        ItemStack itemstack = e.getItemInHand(ProjectileUtil.getWeaponHoldingHand(e, Items.BOW));

        if (itemstack.is(Items.BOW)) {
          e.goalSelector.addGoal(priority, bowGoal);
        } else {
          e.goalSelector.addGoal(priority, meleeGoal);
        }
      }
    });
  }

}
