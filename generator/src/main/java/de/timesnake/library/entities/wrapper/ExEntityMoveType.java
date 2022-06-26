/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EnumMoveType;

@NmsReflection
public enum ExEntityMoveType {

    SELF(EnumMoveType.a),
    PLAYER(EnumMoveType.b),
    PISTON(EnumMoveType.c),
    SHULKER_BOX(EnumMoveType.d),
    SHULKER(EnumMoveType.e);

    private final EnumMoveType type;

    ExEntityMoveType(EnumMoveType type) {
        this.type = type;
    }

    public EnumMoveType getNMSType() {
        return type;
    }
}
