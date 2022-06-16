package de.timesnake.library.entities.entity.extension;

import com.mojang.authlib.GameProfile;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftHumanEntity;

import java.util.UUID;

@NmsReflection
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
        return this.getNMS().fq();
    }
}
