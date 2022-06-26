/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.extension.ExEntity;

public interface ExtendedCraftEntity<ExtensionEntity extends ExEntity> extends ExtendedEntity {

    @Override
    ExtensionEntity getExtension();
}
