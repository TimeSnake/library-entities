package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.raid.EntityRaider;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftRaider;

@NmsReflection
public class ExEntityRaider extends ExEntityMonsterPatrolling {

    public ExEntityRaider(CraftRaider entity) {
        super(entity);
    }

    public ExEntityRaider(EntityRaider entity) {
        super(entity);
    }
}
