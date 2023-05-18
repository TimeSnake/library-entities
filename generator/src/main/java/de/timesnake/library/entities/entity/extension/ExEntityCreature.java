/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.EntityCreature;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftCreature;

public class ExEntityCreature extends ExEntityInsentient {

  public ExEntityCreature(CraftCreature entity) {
    super(entity);
  }

  public ExEntityCreature(EntityCreature entity) {
    super(entity);
  }

  @Override
  public EntityCreature getNMS() {
    return (EntityCreature) super.getNMS();
  }
}
