/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.entity.EntityPose;

public enum ExEntityPose {

    STANDING(EntityPose.a),
    FALL_FLYING(EntityPose.b),
    SLEEPING(EntityPose.c),
    SWIMMING(EntityPose.d),
    SPIN_ATTACK(EntityPose.e),
    CROUCHING(EntityPose.f),
    DYING(EntityPose.g);

    private final EntityPose pose;

    ExEntityPose(EntityPose pose) {
        this.pose = pose;
    }

    public EntityPose getPose() {
        return pose;
    }

}
