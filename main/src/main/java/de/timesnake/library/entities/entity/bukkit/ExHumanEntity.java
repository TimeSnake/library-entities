package de.timesnake.library.entities.entity.bukkit;

import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;

public class ExHumanEntity extends ExHumanEntityBasis {

    public ExHumanEntity(EntityHuman entity) {
        super(entity);
    }

    public ExHumanEntity(CraftServer server, EntityHuman entity) {
        super(server, entity);
    }
}
