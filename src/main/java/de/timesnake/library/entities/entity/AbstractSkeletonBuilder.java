/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

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


public class AbstractSkeletonBuilder<E extends AbstractSkeleton, B extends AbstractSkeletonBuilder<E, B>> extends MonsterBuilder<E, B> {

  protected static final AbstractSkeletonProxy PROXY = ProxyManager.getInstance().getAbstractSkeletonProxy();

  public AbstractSkeletonBuilder(E entity) {
    super(entity);
  }


  @Override
  public B addPathfinderGoal(int priority, Function<E, Goal> pathfinderGoal) {
    Goal goal = pathfinderGoal.apply(this.entity);
    if (goal instanceof RangedBowAttackGoal<?>) {
      PROXY.setBowGoal(this.entity, (RangedBowAttackGoal<AbstractSkeleton>) goal);
      this.reassessWeaponGoal(priority);
    } else if (goal instanceof MeleeAttackGoal) {
      PROXY.setMeleeGoal(this.entity, (MeleeAttackGoal) goal);
      this.reassessWeaponGoal(priority);
    } else {
      super.addPathfinderGoal(priority, pathfinderGoal);
    }
    return this.self;
  }

  public B reassessWeaponGoal(int priority) {
    RangedBowAttackGoal<?> bowGoal = PROXY.getBowGoal(this.entity);
    MeleeAttackGoal meleeGoal = PROXY.getMeleeGoal(this.entity);

    if (!this.getNMS().level().isClientSide) {
      this.getNMS().goalSelector.removeGoal(bowGoal);
      this.getNMS().goalSelector.removeGoal(meleeGoal);
      ItemStack itemstack = this.getNMS().getItemInHand(ProjectileUtil.getWeaponHoldingHand(this.getNMS(), Items.BOW));

      if (itemstack.is(Items.BOW)) {
        this.getGoalSelector().addGoal(priority, bowGoal);
      } else {
        this.getGoalSelector().addGoal(priority, meleeGoal);
      }

    }
    return this.self;
  }

}
