/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;

public class ExWorldServer extends ExWorld {

  public ExWorldServer(WorldServer world) {
    super(world);
  }

  @Override
  public WorldServer getNMS() {
    return (WorldServer) super.getNMS();
  }

  public boolean isEmpty(BlockPosition position) {
    return this.getNMS().x(position);
  }

  public boolean addEntity(Entity entity) {
    return this.getNMS().b(entity);
  }
}
