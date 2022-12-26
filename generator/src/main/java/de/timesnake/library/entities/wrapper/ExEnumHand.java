/*
 * Copyright (C) 2022 timesnake
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
