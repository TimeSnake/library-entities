package de.timesnake.library.entities_generator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NmsExtensionBasis {

    public static final List<Method> EXCLUDED_METHODS = Arrays.asList(Object.class.getMethods());

    public static boolean canMethodOverride(List<Method> methods, Method overrider) {
        Class<?>[] overriderParameterTypes = overrider.getParameterTypes();

        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();

            if (method.getName().equals(overrider.getName()) && Arrays.equals(overriderParameterTypes,
                    parameterTypes)) {
                return false;
            }
        }
        return true;
    }

    private final String name;
    private final List<ExtensionMethod> methods;
    private final Class<?> bukkitClass;

    public NmsExtensionBasis(Class<?> extensionClass, Class<?> bukkitClass) {
        this.name = extensionClass.getSimpleName();
        this.bukkitClass = bukkitClass;
        this.methods = new LinkedList<>();

        List<Method> bukkitMethods = Arrays.stream(bukkitClass.getMethods()).toList();

        do {
            for (Method method : extensionClass.getMethods()) {
                if (canMethodOverride(bukkitMethods, method)) {
                    ExtensionMethod extensionMethod = new ExtensionMethod(method);
                    if (!this.methods.contains(extensionMethod)) {
                        this.methods.add(extensionMethod);
                    }
                }
            }

            extensionClass = extensionClass.getSuperclass();
        } while (extensionClass != null && !extensionClass.getSimpleName().equals("Object"));
    }

    public String getName() {
        return name;
    }

    public String getBukkitMethods() {
        return Arrays.toString(Arrays.stream(bukkitClass.getMethods()).map(Method::getName).toList().toArray());
    }

    public List<ExtensionMethod> getMethods() {
        return methods;
    }
}
