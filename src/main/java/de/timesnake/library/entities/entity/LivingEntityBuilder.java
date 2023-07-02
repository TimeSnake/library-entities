/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;

public class LivingEntityBuilder<E extends net.minecraft.world.entity.LivingEntity, B extends LivingEntityBuilder<E, B>> extends EntityBuilder<E, B> {

  public LivingEntityBuilder(E entity) {
    super(entity);
  }


  public B setMaxHealth(float maxHealth) {
    ((LivingEntity) this.getNMS().getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    return this.self;
  }

  public B setMaxHealthAndHealth(float health) {
    ((LivingEntity) this.getNMS().getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
    this.entity.setHealth(health);
    return this.self;
  }

  public AttributeInstance getBukkitAttribute(Attribute attribute) {
    return ((LivingEntity) this.getNMS().getBukkitEntity()).getAttribute(attribute);
  }

  public B addDeathLoot(Collection<ItemStack> items) {
    this.getNMS().drops.addAll(items);
    return this.self;
  }

  public List<ItemStack> getDeathLoot() {
    return this.getNMS().drops;
  }

  public B setDeathLoot(Collection<ItemStack> items) {
    this.getNMS().drops.clear();
    this.getNMS().drops.addAll(items);
    return this.self;
  }
}
