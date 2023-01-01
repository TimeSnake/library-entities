/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

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
