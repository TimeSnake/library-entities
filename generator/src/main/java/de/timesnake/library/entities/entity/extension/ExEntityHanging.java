/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.decoration.EntityHanging;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHanging;

public class ExEntityHanging extends ExEntity {

  public ExEntityHanging(CraftHanging entity) {
    super(entity);
  }

  public ExEntityHanging(EntityHanging entity) {
    super(entity);
  }

  @Override
  public EntityHanging getNMS() {
    return (EntityHanging) super.getNMS();
  }

  @Override
  public void setPosition(double x, double y, double z) {
    super.setPosition(x, y, z);
    this.getNMS().c = new BlockPosition(x, y, z);
  }

  @Override
  public void setPosition(double x, double y, double z, boolean fixSpawnInBlock) {
    super.setPosition(x, y, z, fixSpawnInBlock);
    this.getNMS().c = new BlockPosition(x, y, z);
  }
}
