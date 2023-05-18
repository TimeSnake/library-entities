/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.entity.ai.control.ControllerMove;

public class ExControllerMove {

  private final ControllerMove controller;

  public ExControllerMove(ControllerMove controller) {
    this.controller = controller;
  }

  public ControllerMove getNMS() {
    return this.controller;
  }

  public void a(double var0, double var2, double var4, double var6) {
    this.controller.a(var0, var2, var4, var6);
  }
}
