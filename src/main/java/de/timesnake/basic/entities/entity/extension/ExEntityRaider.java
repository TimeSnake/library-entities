package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.raid.EntityRaider;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftRaider;

public class ExEntityRaider extends ExEntityMonsterPatrolling {

    public ExEntityRaider(CraftRaider entity) {
        super(entity);
    }

    public ExEntityRaider(EntityRaider entity) {
        super(entity);
    }
}
