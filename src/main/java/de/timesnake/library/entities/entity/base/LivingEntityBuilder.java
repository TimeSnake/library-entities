/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.world.entity.item.ItemEntity;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public abstract class LivingEntityBuilder<E extends net.minecraft.world.entity.LivingEntity,
    B extends LivingEntityBuilder<E, B>> extends EntityBuilder<E, B> {

  public LivingEntityBuilder() {
    super();
  }


  public B setMaxHealth(float maxHealth) {
    return this.applyOnEntity(e -> {
      ((LivingEntity) e.getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    });
  }

  public B setMaxHealthAndHealth(float health) {
    return this.applyOnEntity(e -> {
      ((LivingEntity) e.getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
      e.setHealth(health);
    });
  }

  public B addDeathLoot(Collection<ItemStack> items) {
    this.applyOnEntity(e -> e.drops.addAll(items.stream()
        .map(i -> new net.minecraft.world.entity.Entity.DefaultDrop(CraftItemStack.asNMSCopy(i), itemStack -> {
          ItemEntity itemEntity = new ItemEntity(e.level(), e.getX(), e.getY() + (double) 0, e.getZ(), itemStack);
          itemEntity.setDefaultPickUpDelay();
          e.level().addFreshEntity(itemEntity);
        })).toList()));
    return this.self;
  }

  public B clearDeathLoot(Collection<ItemStack> items) {
    return this.applyOnEntity(e -> {
      e.drops.clear();
    });
  }
}
