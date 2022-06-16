package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.level.pathfinder.PathType;

@NmsReflection
public enum ExPathType {

    BLOCKED(PathType.a),
    OPEN(PathType.b),
    WALKABLE(PathType.c),
    WALKABLE_DOOR(PathType.d),
    TRAPDOOR(PathType.e),
    FENCE(PathType.f),
    LAVA(PathType.g),
    WATER(PathType.h),
    WATER_BORDER(PathType.i),
    RAIL(PathType.j),
    UNPASSABLE_RAIL(PathType.k),
    DANGER_FIRE(PathType.l),
    DAMAGE_FIRE(PathType.m),
    DANGER_CACTUS(PathType.n),
    DAMAGE_CACTUS(PathType.o),
    DANGER_OTHER(PathType.p),
    DAMAGE_OTHER(PathType.q),
    DOOR_OPEN(PathType.r),
    DOOR_WOOD_CLOSED(PathType.s),
    DOOR_IRON_CLOSED(PathType.t),
    BREACH(PathType.u),
    LEAVES(PathType.v),
    STICKY_HONEY(PathType.w),
    COCOA(PathType.x);

    private final PathType type;

    ExPathType(PathType type) {
        this.type = type;
    }

    public PathType getNMS() {
        return this.type;
    }
}
