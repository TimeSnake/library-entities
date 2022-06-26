package de.timesnake.library.entities.entity;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.generator.Placeholder;
import de.timesnake.library.entities.generator.PlaceholderException;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;

@Placeholder
public interface ExEntityType<NmsType extends Entity> {

    static ExEntityType<? extends Entity> getTypeByString(String type) {
        throw new PlaceholderException();
    }

    static ExEntityType<? extends Entity> getTypeByNMSType(EntityTypes<?> nmsType) {
        throw new PlaceholderException();
    }

    static ExEntityType<? extends Entity> getTypeByExClass(Class<? extends ExEntity> clazz) {
        throw new PlaceholderException();
    }

    static Class<? extends Entity> getNmsClasByExClass(Class<? extends ExEntity> clazz) {
        throw new PlaceholderException();
    }

    EntityTypes<NmsType> getNMSType();

    Class<NmsType> getNMSClass();

    Class<? extends org.bukkit.entity.Entity> getExClass();

}
