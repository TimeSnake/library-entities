/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.entity.EnumItemSlot;
import org.bukkit.inventory.EquipmentSlot;

public enum ExEnumItemSlot {

  MAIN_HAND(EnumItemSlot.a),
  OFFHAND(EnumItemSlot.b),
  HEAD(EnumItemSlot.f),
  FEET(EnumItemSlot.c),
  LEGS(EnumItemSlot.d),
  CHEST(EnumItemSlot.e);

  public static ExEnumItemSlot parseEquipmentSlot(EquipmentSlot slot) {
    switch (slot) {
      case HAND:
        return ExEnumItemSlot.MAIN_HAND;
      case OFF_HAND:
        return ExEnumItemSlot.OFFHAND;
      case FEET:
        return ExEnumItemSlot.FEET;
      case LEGS:
        return ExEnumItemSlot.LEGS;
      case CHEST:
        return ExEnumItemSlot.CHEST;
      case HEAD:
        return ExEnumItemSlot.HEAD;

    }
    return null;
  }

  private final EnumItemSlot nmsSlot;

  ExEnumItemSlot(EnumItemSlot nmsSlot) {
    this.nmsSlot = nmsSlot;
  }

  public EnumItemSlot getNmsSlot() {
    return nmsSlot;
  }
}
