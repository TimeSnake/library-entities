package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.animal.EntityFishSchool;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftFish;

public class ExEntityFishSchool extends ExEntityFish {

    public ExEntityFishSchool(CraftFish entity) {
        super(entity);
    }

    public ExEntityFishSchool(EntityFishSchool entity) {
        super(entity);
    }
}
