/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.BlockPosition;

public class ExBaseBlockPosition {

    protected final BaseBlockPosition block;

    public ExBaseBlockPosition(BaseBlockPosition block) {
        this.block = block;
    }

    public ExBaseBlockPosition(int x, int y, int z) {
        this.block = new BlockPosition(x, y, z);
    }

    public ExBaseBlockPosition(double x, double y, double z) {
        this.block = new BlockPosition(x, y, z);
    }

    public BaseBlockPosition getNMS() {
        return this.block;
    }

    public int getX() {
        return this.block.u();
    }

    public int getY() {
        return this.block.v();
    }

    public int getZ() {
        return this.block.w();
    }

    public boolean inRange(BaseBlockPosition position, double range) {
        return this.block.a(position, range);
    }

    public boolean inRange(ExBaseBlockPosition position, double range) {
        return this.inRange(position, range);
    }
}
