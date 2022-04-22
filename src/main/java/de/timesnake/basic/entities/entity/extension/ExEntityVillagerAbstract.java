package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.npc.EntityVillagerAbstract;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftAbstractVillager;

@NmsReflection
public class ExEntityVillagerAbstract extends ExEntityAgeable {

    public ExEntityVillagerAbstract(CraftAbstractVillager entity) {
        super(entity);
    }

    public ExEntityVillagerAbstract(EntityVillagerAbstract entity) {
        super(entity);
    }

    @Override
    public EntityVillagerAbstract getNMS() {
        return ((EntityVillagerAbstract) super.getNMS());
    }
}
