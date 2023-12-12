/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.network.syncher.SynchedEntityData;
import xyz.jpenilla.reflectionremapper.proxy.annotation.FieldGetter;
import xyz.jpenilla.reflectionremapper.proxy.annotation.Proxies;

@Proxies(SynchedEntityData.class)
public interface SynchedEntityDataProxy {

  @FieldGetter("itemsById")
  Int2ObjectMap<SynchedEntityData.DataItem<?>> getItemsById(SynchedEntityData instance);
}
