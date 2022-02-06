package de.timesnake.basic.entities.entity.extension;

import com.mojang.authlib.GameProfile;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftHumanEntity;

import java.util.UUID;

public class ExEntityHuman extends ExEntity {

    public ExEntityHuman(CraftHumanEntity entityHuman) {
        super(entityHuman);
    }

    public ExEntityHuman(EntityHuman entityHuman) {
        super(entityHuman);
    }


    public EntityHuman getNMS() {
        return (EntityHuman) super.getNMS();
    }

    public UUID getUniqueID() {
        return this.getNMS().cm();
    }

    public GameProfile getProfile() {
        return this.getNMS().fp();
    }
}
