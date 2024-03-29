/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.proxy;

import xyz.jpenilla.reflectionremapper.ReflectionRemapper;
import xyz.jpenilla.reflectionremapper.proxy.ReflectionProxyFactory;

public class ProxyManager {

  private static final ProxyManager INSTANCE = new ProxyManager();

  public static ProxyManager getInstance() {
    return INSTANCE;
  }

  private final SpellcasterIllagerProxy spellcasterIllagerProxy;
  private final AbstractSkeletonProxy abstractSkeletonProxy;
  private final BlazeProxy blazeProxy;
  private final SheepProxy sheepProxy;
  private final EntityProxy entityProxy;
  private final SynchedEntityDataProxy synchedEntityDataProxy;
  private final WitchProxy witchProxy;
  private final SlimeProxy slimeProxy;
  private final SlimeMoveControlProxy slimeMoveControlProxy;

  public ProxyManager() {
    final ReflectionRemapper reflectionRemapper = ReflectionRemapper.forReobfMappingsInPaperJar();
    final ClassLoader classLoader = ProxyManager.class.getModule().getClassLoader();
    final ReflectionProxyFactory reflectionProxyFactory = ReflectionProxyFactory.create(reflectionRemapper, classLoader);

    this.spellcasterIllagerProxy = reflectionProxyFactory.reflectionProxy(SpellcasterIllagerProxy.class);
    this.abstractSkeletonProxy = reflectionProxyFactory.reflectionProxy(AbstractSkeletonProxy.class);
    this.blazeProxy = reflectionProxyFactory.reflectionProxy(BlazeProxy.class);
    this.sheepProxy = reflectionProxyFactory.reflectionProxy(SheepProxy.class);
    this.entityProxy = reflectionProxyFactory.reflectionProxy(EntityProxy.class);
    this.witchProxy = reflectionProxyFactory.reflectionProxy(WitchProxy.class);
    this.slimeProxy = reflectionProxyFactory.reflectionProxy(SlimeProxy.class);
    this.slimeMoveControlProxy = reflectionProxyFactory.reflectionProxy(SlimeMoveControlProxy.class);

    this.synchedEntityDataProxy = reflectionProxyFactory.reflectionProxy(SynchedEntityDataProxy.class);
  }

  public SpellcasterIllagerProxy getSpellcasterIllagerProxy() {
    return spellcasterIllagerProxy;
  }

  public AbstractSkeletonProxy getAbstractSkeletonProxy() {
    return abstractSkeletonProxy;
  }

  public BlazeProxy getBlazeProxy() {
    return blazeProxy;
  }

  public SheepProxy getSheepProxy() {
    return sheepProxy;
  }

  public EntityProxy getEntityProxy() {
    return entityProxy;
  }

  public WitchProxy getWitchProxy() {
    return witchProxy;
  }

  public SlimeProxy getSlimeProxy() {
    return slimeProxy;
  }

  public SlimeMoveControlProxy getSlimeMoveControlProxy() {
    return slimeMoveControlProxy;
  }

  public SynchedEntityDataProxy getSynchedEntityDataProxy() {
    return synchedEntityDataProxy;
  }
}
