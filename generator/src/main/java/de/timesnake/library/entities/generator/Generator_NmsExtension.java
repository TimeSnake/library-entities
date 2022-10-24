/*
 * library-entities.generator.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.entities.generator;

import de.timesnake.library.entities.entity.extension.ExEntity;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Generator_NmsExtension {

    public static final List<Method> EXCLUDED_METHODS;

    public static boolean canMethodOverride(List<Method> methods, Method overrider) {
        Class<?>[] overriderParameterTypes = overrider.getParameterTypes();

        if (EXCLUDED_METHODS.contains(overrider)) {
            return false;
        }

        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();

            if (method.getName().equals(overrider.getName()) && Arrays.equals(overriderParameterTypes,
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

    public Generator_NmsExtension(Class<?> extensionClass, String extensionInterface, Class<?> bukkitClass) {
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
                        if (existingMethod.getMethod().getReturnType().isAssignableFrom(method.getReturnType())) {
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
        return Arrays.toString(Arrays.stream(bukkitClass.getMethods()).map(Method::getName).toList().toArray());
    }

    public Collection<Generator_Method> getMethods() {
        return methodsByHash.values();
    }
}
