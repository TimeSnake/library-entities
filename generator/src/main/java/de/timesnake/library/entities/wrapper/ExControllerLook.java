package de.timesnake.library.entities.wrapper;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.control.ControllerLook;

@NmsReflection
public class ExControllerLook {

    private final ControllerLook controller;

    public ExControllerLook(ControllerLook controller) {
        this.controller = controller;
    }

    public ControllerLook getNMS() {
        return this.controller;
    }

    public void a(Entity entity, float f1, float f2) {
        this.controller.a(entity, f1, f2);
    }

    public void a(ExEntity entity, float f1, float f2) {
        this.a(entity.getNMS(), f1, f2);
    }

    public void a(double d1, double d2, double d3) {
        this.controller.a(d1, d2, d3);
    }

    public double d() {
        return this.controller.e();
    }

    public double e() {
        return this.controller.f();
    }

    public double f() {
        return this.controller.g();
    }

}
