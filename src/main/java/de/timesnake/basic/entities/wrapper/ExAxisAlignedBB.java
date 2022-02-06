package de.timesnake.basic.entities.wrapper;

import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.phys.AxisAlignedBB;

public class ExAxisAlignedBB {

    private final AxisAlignedBB axis;

    public ExAxisAlignedBB(AxisAlignedBB axis) {
        this.axis = axis;
    }

    public AxisAlignedBB getNMS() {
        return this.axis;
    }

    public ExAxisAlignedBB grow(double x, double y, double z) {
        return new ExAxisAlignedBB(this.axis.a(x, y, z));
    }

    public ExAxisAlignedBB grow(double size) {
        return this.grow(size, size, size);
    }

    public AxisAlignedBB a(BlockPosition position) {
        return this.axis.a(position);
    }

    public ExAxisAlignedBB a(ExBlockPosition position) {
        return new ExAxisAlignedBB(this.a(position.getNMS()));
    }
}
