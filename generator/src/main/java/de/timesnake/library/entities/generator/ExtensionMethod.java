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

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtensionMethod {

    private final String name;
    private final Parameter[] parameters;
    private final Type returnType;


    public ExtensionMethod(Method method) {
        this.name = method.getName();
        this.parameters = method.getParameters();
        this.returnType = method.getGenericReturnType();
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
        if (!(obj instanceof ExtensionMethod)) return false;
        return ((ExtensionMethod) obj).name.equals(this.name) && ((ExtensionMethod) obj).getParameterTypeList().equals(this.getParameterTypeList());
    }
}
