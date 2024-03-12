/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.ProjectileBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;

public class FireworkRocketBuilder extends ProjectileBuilder<FireworkRocketEntity, FireworkRocketBuilder> {

  @Override
  protected FireworkRocketEntity create(ServerLevel serverLevel) {
    return new FireworkRocketEntity(EntityType.FIREWORK_ROCKET, serverLevel) {

    };
  }
}
