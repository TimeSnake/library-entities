/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.generator;

import de.timesnake.library.entities.entity.extension.ExEntity;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Generator_NmsExtension {

  public static final List<Method> EXCLUDED_METHODS;

  public static boolean canMethodOverride(List<Method> methods, Method overrider) {
    Class<?>[] overriderParameterTypes = overrider.getParameterTypes();

    if (EXCLUDED_METHODS.contains(overrider)) {
      return false;
    }

    for (Method method : methods) {
      Class<?>[] parameterTypes = method.getParameterTypes();

      if (method.getName().equals(overrider.getName()) && Arrays.equals(
          overriderParameterTypes,
          parameterTypes)) {
        return false;
      }
    }
    return true;
  }

  static {
    try {
      EXCLUDED_METHODS = List.of(ExEntity.class.getMethod("getExtension"));
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  private final Class<?> exClass;
  private final String exInterface;
  private final Map<Integer, Generator_Method> methodsByHash;
  private final Class<?> bukkitClass;

  public Generator_NmsExtension(Class<?> extensionClass, String extensionInterface,
      Class<?> bukkitClass) {
    this.exClass = extensionClass;
    this.exInterface = extensionInterface;
    this.bukkitClass = bukkitClass;
    this.methodsByHash = new LinkedHashMap<>();

    List<Method> bukkitMethods = Arrays.stream(bukkitClass.getMethods()).toList();

    // read methods from extension class and its super classes
    do {
      for (Method method : extensionClass.getDeclaredMethods()) {
        if (!Modifier.isPublic(method.getModifiers())) {
          continue;
        }

        // check if method already exists in bukkit, then skip
        if (canMethodOverride(bukkitMethods, method)) {
          Generator_Method extensionMethod = new Generator_Method(method);
          int hashCode = extensionMethod.hashCode();
          // if method is already parsed, check for return type, else skip
          if (!this.methodsByHash.containsKey(hashCode)) {
            this.methodsByHash.put(hashCode, extensionMethod);
          } else {
            Generator_Method existingMethod = this.methodsByHash.get(hashCode);
            // check if return type is more specific
            if (existingMethod.getMethod().getReturnType()
                .isAssignableFrom(method.getReturnType())) {
              this.methodsByHash.put(hashCode, extensionMethod);
            }
          }
        }
      }

      extensionClass = extensionClass.getSuperclass();
    } while (extensionClass != null && !extensionClass.equals(Object.class));
  }

  public Class<?> getExClass() {
    return exClass;
  }

  public String getExInterfaceName() {
    return exInterface;
  }

  public Class<?> getBukkitClass() {
    return bukkitClass;
  }

  public String getBukkitMethods() {
    return Arrays.toString(
        Arrays.stream(bukkitClass.getMethods()).map(Method::getName).toList().toArray());
  }

  public Collection<Generator_Method> getMethods() {
    return methodsByHash.values();
  }
}
