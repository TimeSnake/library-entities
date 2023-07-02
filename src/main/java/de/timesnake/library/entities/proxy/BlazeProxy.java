/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.world.entity.monster.Blaze;
import xyz.jpenilla.reflectionremapper.proxy.annotation.MethodName;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(Blaze.class)
public interface BlazeProxy {

  @MethodName("setCharged")
  void setCharged(Blaze instance, boolean charged);
}
