/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import com.mojang.authlib.GameProfile;

import java.util.UUID;

public interface HumanEntity extends LivingEntity, org.bukkit.entity.HumanEntity {
    net.minecraft.world.entity.player.EntityHuman getNMS();

    UUID getUniqueID();

    GameProfile getProfile();
}
