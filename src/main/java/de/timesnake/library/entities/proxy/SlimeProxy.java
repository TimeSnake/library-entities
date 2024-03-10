/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.world.entity.monster.Slime;
import xyz.jpenilla.reflectionremapper.proxy.annotation.MethodName;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(Slime.class)
public interface SlimeProxy {

  @MethodName("isDealsDamage")
  boolean isDealsDamage(Slime instance);
}
