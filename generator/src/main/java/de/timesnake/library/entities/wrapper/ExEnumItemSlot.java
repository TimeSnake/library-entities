/*
 * workspace.library-entities-generator.main
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
