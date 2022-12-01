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

import net.minecraft.world.EnumHand;

public enum ExEnumHand {

    MAIN_HAND(EnumHand.a),
    OFF_HAND(EnumHand.b);

    public static ExEnumHand fromNms(EnumHand hand) {
        for (ExEnumHand exHand : ExEnumHand.values()) {
            if (exHand.getNMS().equals(hand)) {
                return exHand;
            }
        }
        return null;
    }

    private final EnumHand hand;

    ExEnumHand(EnumHand hand) {
        this.hand = hand;
    }

    public EnumHand getNMS() {
        return this.hand;
    }
}
