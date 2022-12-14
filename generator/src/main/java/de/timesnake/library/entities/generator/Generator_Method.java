/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.generator;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Generator_Method {

    private final String name;
    private final Parameter[] parameters;
    private final Type returnType;
    private final Method method;

    public Generator_Method(Method method) {
        this.name = method.getName();
        this.parameters = method.getParameters();
        this.returnType = method.getGenericReturnType();
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public String getName() {
        return name;
    }

    public String getParameterNameList() {
        StringBuilder sb = new StringBuilder();

        if (this.parameters.length > 0) {
            for (Parameter parameter : this.parameters) {
                sb.append(parameter.getName());
                sb.append(", ");
            }

            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();
    }

    public String getParameterList() {
        StringBuilder sb = new StringBuilder();

        if (this.parameters.length > 0) {
            for (Parameter parameter : this.parameters) {
                sb.append(parameter.getParameterizedType().getTypeName().replace("$", "."));
                sb.append(" ").append(parameter.getName());
                sb.append(", ");
            }

            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();
    }

    public List<Class<?>> getParameterTypeList() {
        return Arrays.stream(this.parameters).map(Parameter::getType).collect(Collectors.toList());
    }

    public String getReturnType() {
        return returnType.getTypeName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Generator_Method)) return false;
        return ((Generator_Method) obj).name.equals(this.name) && ((Generator_Method) obj).getParameterTypeList().equals(this.getParameterTypeList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.getParameterTypeList());
    }
}
