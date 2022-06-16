package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.control.ControllerJump;

@NmsReflection
public class ExControllerJump {

    private final ControllerJump controller;

    public ExControllerJump(ControllerJump controller) {
        this.controller = controller;
    }

    public ControllerJump getNMS() {
        return this.controller;
    }

    public void jump() {
        this.controller.a();
    }
}
