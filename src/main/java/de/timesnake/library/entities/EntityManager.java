/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities;

import net.minecraft.world.entity.Entity;
import org.bukkit.World;

public class EntityManager {

  public static void spawnEntity(World world, Entity entity) {
    ((org.bukkit.craftbukkit.v1_20_R1.CraftWorld) world).getHandle().addFreshEntity(entity);
  }
}
