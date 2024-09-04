/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.lang.reflect.Field;
import java.util.function.Function;


public abstract class AbstractSkeletonBuilder<E extends AbstractSkeleton, B extends AbstractSkeletonBuilder<E, B>> extends MonsterBuilder<E, B> {

  public AbstractSkeletonBuilder() {
    super();
  }


  @Override
  public B addPathfinderGoal(int priority, Function<E, ? extends Goal> pathfinderGoal) {
    super.addPathfinderGoal(priority, pathfinderGoal);
    return this.applyOnEntity(e -> {
      Goal goal = pathfinderGoal.apply(e);
      if (goal instanceof RangedBowAttackGoal<?>) {
        try {
          Field bowGoal = AbstractSkeleton.class.getDeclaredField("bowGoal");
          bowGoal.setAccessible(true);
          bowGoal.set(this, goal);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
          throw new RuntimeException(ex);
        }
        this.reassessWeaponGoal(priority);
      } else if (goal instanceof MeleeAttackGoal) {
        try {
          Field meleeGoal = AbstractSkeleton.class.getDeclaredField("meleeGoal");
          meleeGoal.setAccessible(true);
          meleeGoal.set(this, goal);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
          throw new RuntimeException(ex);
        }
        this.reassessWeaponGoal(priority);
      }
    });
  }

  public B reassessWeaponGoal(int priority) {
    return this.applyOnEntity(e -> {
      RangedBowAttackGoal<?> bowGoal;
      try {
        Field bowGoalField = AbstractSkeleton.class.getDeclaredField("bowGoal");
        bowGoalField.setAccessible(true);
        bowGoal = (RangedBowAttackGoal<?>) bowGoalField.get(e);
      } catch (NoSuchFieldException | IllegalAccessException ex) {
        throw new RuntimeException(ex);
      }

      MeleeAttackGoal meleeGoal;
      try {
        Field meleeGoalField = AbstractSkeleton.class.getDeclaredField("meleeGoal");
        meleeGoalField.setAccessible(true);
        meleeGoal = (MeleeAttackGoal) meleeGoalField.get(e);
      } catch (NoSuchFieldException | IllegalAccessException ex) {
        throw new RuntimeException(ex);
      }

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
