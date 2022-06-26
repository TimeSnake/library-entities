/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.extension.ExEntity;
import net.minecraft.world.entity.Entity;

public interface ExtendedEntity {

    ExEntity getExtension();

    Entity getNMS();

}
