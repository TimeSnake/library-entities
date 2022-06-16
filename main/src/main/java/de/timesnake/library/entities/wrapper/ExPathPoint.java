package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.pathfinder.PathPoint;

@NmsReflection
public class ExPathPoint {

    private final PathPoint point;

    public ExPathPoint(PathPoint pathPoint) {
        this.point = pathPoint;
    }

    public BlockPosition getPosition() {
        return this.point.a();
    }

    public ExBlockPosition getExPosition() {
        return new ExBlockPosition(this.point.a());
    }

    public int getX() {
        return this.point.a;
    }

    public int getY() {
        return this.point.b;
    }

    public int getZ() {
        return this.point.c;
    }
}
