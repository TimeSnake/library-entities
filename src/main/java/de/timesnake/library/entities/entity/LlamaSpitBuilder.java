/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.base.ProjectileBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.LlamaSpit;

public class LlamaSpitBuilder extends ProjectileBuilder<LlamaSpit, LlamaSpitBuilder> {

  public LlamaSpitBuilder() {
    super();
  }

  @Override
  protected LlamaSpit create(ServerLevel serverLevel) {
    return new LlamaSpit(EntityType.LLAMA_SPIT, serverLevel);
  }
}
