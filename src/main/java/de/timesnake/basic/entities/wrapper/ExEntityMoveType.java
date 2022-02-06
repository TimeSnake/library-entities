package de.timesnake.basic.entities.wrapper;

import net.minecraft.world.entity.EnumMoveType;

public enum ExEntityMoveType {

    SELF(EnumMoveType.a), PLAYER(EnumMoveType.b), PISTON(EnumMoveType.c), SHULKER_BOX(EnumMoveType.d), SHULKER(EnumMoveType.e);

    private EnumMoveType type;

    ExEntityMoveType(EnumMoveType type) {
        this.type = type;
    }

    public EnumMoveType getNMSType() {
        return type;
    }
}
