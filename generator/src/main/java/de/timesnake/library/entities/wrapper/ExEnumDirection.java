/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.EnumDirection;

public enum ExEnumDirection {

    DOWN(EnumDirection.a),
    UP(EnumDirection.b),
    NORTH(EnumDirection.c),
    SOUTH(EnumDirection.d),
    WEST(EnumDirection.e),
    EAST(EnumDirection.f);

    private final EnumDirection direction;

    ExEnumDirection(EnumDirection direction) {
        this.direction = direction;
    }

    public EnumDirection getNMS() {
        return this.direction;
    }

    public BaseBlockPosition getBaseBlockPosition() {
        return this.direction.q();
    }

    public ExBaseBlockPosition getExBaseBlockPosition() {
        return new ExBaseBlockPosition(this.getBaseBlockPosition());
    }

    public int getAdjacentX() {
        return this.getExBaseBlockPosition().getX();
    }

    public int getAdjacentY() {
        return this.getExBaseBlockPosition().getY();
    }

    public int getAdjacentZ() {
        return this.getExBaseBlockPosition().getZ();
    }
}
