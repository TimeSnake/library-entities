package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.phys.Vec3D;

@NmsReflection
public class ExVec3D {

    private final Vec3D vec;

    public ExVec3D(Vec3D vec) {
        this.vec = vec;
    }

    public double getX() {
        return this.vec.a();
    }

    public double getY() {
        return this.vec.b();
    }

    public double getZ() {
        return this.vec.c();
    }

    public Vec3D getNMS() {
        return vec;
    }
}
