/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.level.material.Material;

public class ExMaterial {

  private final Material material;

  public ExMaterial(Material material) {
    this.material = material;
  }

  public Material getNMS() {
    return this.material;
  }

  public boolean isLiquid() {
    return this.material.a();
  }
}
