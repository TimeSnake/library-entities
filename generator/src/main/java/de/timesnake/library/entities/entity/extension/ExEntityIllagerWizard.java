/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftIllager;

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
}
