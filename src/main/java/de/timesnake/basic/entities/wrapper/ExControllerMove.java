package de.timesnake.basic.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.control.ControllerMove;

@NmsReflection
public class ExControllerMove {

    private final ControllerMove controller;

    public ExControllerMove(ControllerMove controller) {
        this.controller = controller;
    }

    public ControllerMove getNMS() {
        return this.controller;
    }

    public void a(double var0, double var2, double var4, double var6) {
        this.controller.a(var0, var2, var4, var6);
    }
}
