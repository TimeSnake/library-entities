/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.world.entity.ai.control.MoveControl;
import xyz.jpenilla.reflectionremapper.proxy.annotation.MethodName;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(className = "net.minecraft.world.entity.monster.Slime$SlimeMoveControl")
public interface SlimeMoveControlProxy {

  @MethodName("setWantedMovement")
  void setWantedMovement(MoveControl instance, double speed);

  @MethodName("setDirection")
  void setDirection(MoveControl instance, float targetYaw, boolean jumpOften);
}
