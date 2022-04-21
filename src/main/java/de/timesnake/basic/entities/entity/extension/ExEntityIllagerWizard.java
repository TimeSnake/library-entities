package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftIllager;

public class ExEntityIllagerWizard extends ExEntityIllagerAbstract {

    public ExEntityIllagerWizard(CraftIllager entity) {
        super(entity);
    }

    public ExEntityIllagerWizard(EntityIllagerWizard entity) {
        super(entity);
    }

    @Override
    public EntityIllagerWizard getNMS() {
        return (EntityIllagerWizard) super.getNMS();
    }

    public boolean eX() {
        return this.getNMS().eX();
    }
}
