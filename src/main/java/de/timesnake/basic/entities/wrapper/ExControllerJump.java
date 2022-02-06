package de.timesnake.basic.entities.wrapper;

import net.minecraft.world.entity.ai.control.ControllerJump;

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
