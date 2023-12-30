/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.base;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public abstract class EntityBuilder<E extends Entity, B extends EntityBuilder<E, B>> {

  protected final B self;

  protected LinkedList<Consumer<E>> entityConsumer = new LinkedList<>();

  protected boolean loadDefaultPathfinderGoals = false;
  protected boolean randomizeDataOnSpawn = false;
  protected boolean preventDespawning = true;
  protected boolean neverVehicle = true;

  public EntityBuilder() {
    this.self = (B) this;
  }

  protected abstract E create(ServerLevel serverLevel);

  public E build(ServerLevel serverLevel) {
    E entity = this.create(serverLevel);

    List<Consumer<E>> consumers;
    while (!(consumers = this.entityConsumer).isEmpty()) {
      this.entityConsumer = new LinkedList<>();
      consumers.forEach(c -> c.accept(entity));
    }

    if (this.preventDespawning) {
      entity.persist = true;
    }
    return entity;
  }

  public B apply(Consumer<B> consumer) {
    consumer.accept(this.self);
    return this.self;
  }

  public B applyOnEntity(Consumer<E> consumer) {
    this.entityConsumer.add(consumer);
    return this.self;
  }

  public B applyOnEntityIf(boolean condition, Consumer<E> consumer) {
    if (condition) {
      this.applyOnEntity(consumer);
    }
    return this.self;
  }

  public B loadDefaultPathfinderGoals() {
    this.loadDefaultPathfinderGoals = true;
    return this.self;
  }

  public B randomizeDataOnSpawn() {
    this.randomizeDataOnSpawn = true;
    return this.self;
  }

  public B allowDespawning() {
    this.preventDespawning = false;
    return this.self;
  }

  public B allowVehicle() {
    this.neverVehicle = false;
    return this.self;
  }
}
