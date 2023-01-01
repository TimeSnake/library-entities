/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.type;

import de.timesnake.library.entities.entity.extension.ExEntity;
import net.minecraft.world.entity.Entity;

public interface ExtendedEntity {

    ExEntity getExtension();

    Entity getNMS();

}
