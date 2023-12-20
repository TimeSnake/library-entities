/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class FoxSearchForItemsGoal extends Goal {

  static final Predicate<ItemEntity> ALLOWED_ITEMS =
      (entityitem) -> !entityitem.hasPickUpDelay() && entityitem.isAlive();

  private final Fox fox;

  public FoxSearchForItemsGoal(Fox fox) {
    this.fox = fox;
    this.setFlags(EnumSet.of(Goal.Flag.MOVE));
  }

  @Override
  public boolean canUse() {
    if (!this.fox.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
      return false;
    } else if (this.fox.getTarget() == null && this.fox.getLastHurtByMob() == null) {
      if (!(!this.fox.isSleeping() && !this.fox.isSitting() && !this.fox.isFaceplanted())) {
        return false;
      } else if (this.fox.getRandom().nextInt(reducedTickDelay(10)) != 0) {
        return false;
      } else {
        List<ItemEntity> list = this.fox.level().getEntitiesOfClass(ItemEntity.class,
            this.fox.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), ALLOWED_ITEMS);

        return !list.isEmpty() && this.fox.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
      }
    } else {
      return false;
    }
  }

  @Override
  public void tick() {
    List<ItemEntity> list = this.fox.level().getEntitiesOfClass(ItemEntity.class,
        this.fox.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), ALLOWED_ITEMS);
    ItemStack itemstack = this.fox.getItemBySlot(EquipmentSlot.MAINHAND);

    if (itemstack.isEmpty() && !list.isEmpty()) {
      this.fox.getNavigation().moveTo(list.get(0), 1.2000000476837158D);
    }

  }

  @Override
  public void start() {
    List<ItemEntity> list = this.fox.level().getEntitiesOfClass(ItemEntity.class,
        this.fox.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), ALLOWED_ITEMS);

    if (!list.isEmpty()) {
      this.fox.getNavigation().moveTo(list.get(0), 1.2000000476837158D);
    }

  }
}
