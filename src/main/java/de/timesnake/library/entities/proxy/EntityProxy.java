/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.Entity;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldGetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Static;

import java.util.Optional;

@Proxies(Entity.class)
public interface EntityProxy {

  @Static
  @FieldGetter("DATA_SHARED_FLAGS_ID")
  EntityDataAccessor<Byte> getDataSharedFlagsIdDataAccessor();

  @Static
  @FieldGetter("DATA_POSE")
  EntityDataAccessor<net.minecraft.world.entity.Pose> getDataPoseDataAccessor();

  @Static
  @FieldGetter("DATA_CUSTOM_NAME")
  EntityDataAccessor<Optional<Component>> getCustomNameDataAccessor();

  @Static
  @FieldGetter("DATA_CUSTOM_NAME_VISIBLE")
  EntityDataAccessor<Boolean> getCustomNameVisibleDataAccessor();

}
