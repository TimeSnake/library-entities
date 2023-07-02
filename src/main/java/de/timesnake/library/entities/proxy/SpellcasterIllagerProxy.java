/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldSetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.MethodName;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(SpellcasterIllager.class)
public interface SpellcasterIllagerProxy {

  @FieldSetter("spellCastingTickCount")
  void setSpellCastingTickCount(SpellcasterIllager instance, int count);

  @MethodName("getCastingSoundEvent")
  SoundEvent getCastingSoundEvent(SpellcasterIllager instance);

}
