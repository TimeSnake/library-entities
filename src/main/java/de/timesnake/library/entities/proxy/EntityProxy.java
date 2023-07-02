/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Entity;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldGetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Static;

@Proxies(Entity.class)
public interface EntityProxy {

  @Static
  @FieldGetter("DATA_SHARED_FLAGS_ID")
  EntityDataAccessor<Byte> getDataSharedFlagsId();
}
