/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftHumanEntity;

public class ExEntityHuman extends ExEntityLiving {

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
    return this.getNMS().cp();
  }

  public GameProfile getProfile() {
    return this.getNMS().fz();
  }
}
