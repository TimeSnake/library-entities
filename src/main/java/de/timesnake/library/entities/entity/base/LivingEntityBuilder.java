/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public abstract class LivingEntityBuilder<E extends net.minecraft.world.entity.LivingEntity, B extends LivingEntityBuilder<E, B>> extends EntityBuilder<E, B> {

  public LivingEntityBuilder() {
    super();
  }


  public B setMaxHealth(float maxHealth) {
    return this.applyOnEntity(e -> {
      ((LivingEntity) e.getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    });
  }

  public B setMaxHealthAndHealth(float health) {
    return this.applyOnEntity(e -> ((LivingEntity) e.getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health));
  }

  public B addDeathLoot(Collection<ItemStack> items) {
    this.applyOnEntity(e -> e.drops.addAll(items));
    return this.self;
  }

  public B setDeathLoot(Collection<ItemStack> items) {
    return this.applyOnEntity(e -> {
      e.drops.clear();
      e.drops.addAll(items);
    });
  }
}
