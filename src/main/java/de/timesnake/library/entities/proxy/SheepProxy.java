/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.animal.Sheep;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldSetter;

public interface SheepProxy {

  @FieldSetter("eatBlockGoal")
  EntityDataAccessor<Byte> setEatBlockGoal(Sheep instance, EatBlockGoal eatBlockGoal);
}
