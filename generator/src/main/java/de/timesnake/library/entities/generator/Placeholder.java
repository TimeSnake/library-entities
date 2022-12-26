/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.generator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Code marked with this annotation is only used for compile reasons. It provides no functionality.
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Placeholder {
}
