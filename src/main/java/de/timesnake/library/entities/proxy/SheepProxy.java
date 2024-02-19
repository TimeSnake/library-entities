/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.animal.Sheep;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldSetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(Sheep.class)
public interface SheepProxy {

  @FieldSetter("eatBlockGoal")
  void setEatBlockGoal(Sheep instance, EatBlockGoal eatBlockGoal);
}
