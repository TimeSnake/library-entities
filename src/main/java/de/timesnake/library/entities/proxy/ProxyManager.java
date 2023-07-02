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
  private final EntityProxy entityProxy;

  public ProxyManager() {
    final ReflectionRemapper reflectionRemapper = ReflectionRemapper.forReobfMappingsInPaperJar();
    final ClassLoader classLoader = ProxyManager.class.getModule().getClassLoader();
    final ReflectionProxyFactory reflectionProxyFactory = ReflectionProxyFactory.create(reflectionRemapper, classLoader);

    this.spellcasterIllagerProxy = reflectionProxyFactory.reflectionProxy(SpellcasterIllagerProxy.class);
    this.abstractSkeletonProxy = reflectionProxyFactory.reflectionProxy(AbstractSkeletonProxy.class);
    this.blazeProxy = reflectionProxyFactory.reflectionProxy(BlazeProxy.class);
    this.entityProxy = reflectionProxyFactory.reflectionProxy(EntityProxy.class);

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

  public EntityProxy getEntityProxy() {
    return entityProxy;
  }
}
