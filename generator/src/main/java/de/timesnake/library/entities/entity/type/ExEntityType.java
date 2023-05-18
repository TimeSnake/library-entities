/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.entity.type;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.generator.Placeholder;
import de.timesnake.library.entities.generator.PlaceholderException;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;

@Placeholder
public interface ExEntityType<NmsType extends Entity, ExClass extends Entity & org.bukkit.entity.Entity> {

  static ExEntityType<?, ?> getByExClass(Class<? extends ExEntity> clazz) {
    throw new PlaceholderException();
  }

  static ExEntityType<?, ?>[] getByExClasses(Class<? extends ExEntity>... exClasses) {
    throw new PlaceholderException();
  }

  static ExEntityType<?, ?> getByNmsClass(
      Class<? extends net.minecraft.world.entity.Entity> clazz) {
    throw new PlaceholderException();
  }

  static ExEntityType<?, ?>[] getByNmsClasses(
      Class<? extends net.minecraft.world.entity.Entity>... nmsClasses) {
    throw new PlaceholderException();
  }

  EntityTypes<NmsType> getNMSType();

  Class<NmsType> getNMSClass();

  Class<ExClass> getExClass();

}
