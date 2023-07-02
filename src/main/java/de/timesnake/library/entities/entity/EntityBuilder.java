/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;

import java.lang.reflect.Field;
import java.util.function.Consumer;

public class EntityBuilder<E extends Entity, B extends EntityBuilder<E, B>> {

  protected final E entity;
  protected final B self;

  public EntityBuilder(E entity) {
    this.entity = entity;
    this.self = (B) this;
  }

  public E getNMS() {
    return this.getHandle();
  }

  public E getHandle() {
    return this.entity;
  }

  public E build() {
    return this.entity;
  }

  public CraftEntity getBukkitEntity() {
    return this.entity.getBukkitEntity();
  }

  public RandomSource getRandomSource() {
    RandomSource rs;
    try {
      Field rsField = Entity.class.getDeclaredField("random");
      rsField.setAccessible(true);
      rs = (RandomSource) rsField.get(this.getNMS());
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return rs;
  }

  public B apply(Consumer<B> consumer) {
    consumer.accept(this.self);
    return this.self;
  }

  public B applyOnEntity(Consumer<E> consumer) {
    consumer.accept(this.entity);
    return this.self;
  }

  public B applyOnEntityIf(boolean condition, Consumer<E> consumer) {
    if (condition) {
      this.applyOnEntity(consumer);
    }
    return this.self;
  }
}
