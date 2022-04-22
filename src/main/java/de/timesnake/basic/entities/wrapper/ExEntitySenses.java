package de.timesnake.basic.entities.wrapper;

import de.timesnake.basic.entities.entity.extension.ExEntity;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.sensing.EntitySenses;

@NmsReflection
public class ExEntitySenses {

    private final EntitySenses senses;

    public ExEntitySenses(EntitySenses senses) {
        this.senses = senses;
    }

    public EntitySenses getNMS() {
        return this.senses;
    }

    public void a() {
        this.senses.a();
    }

    public boolean a(Entity entity) {
        return this.senses.a(entity);
    }

    public boolean a(ExEntity entity) {
        return this.senses.a(entity.getNMS());
    }
}
