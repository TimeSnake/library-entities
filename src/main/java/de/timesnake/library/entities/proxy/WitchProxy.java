/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.world.entity.ai.goal.target.NearestAttackableWitchTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestHealableRaiderTargetGoal;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldSetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(Witch.class)
public interface WitchProxy {

  @FieldSetter("healRaidersGoal")
  void setHealRaidersGoal(Witch instance, NearestHealableRaiderTargetGoal<Raider> goal);

  @FieldSetter("attackPlayersGoal")
  void setAttackPlayersGoal(Witch instance, NearestAttackableWitchTargetGoal<Player> goal);
}
