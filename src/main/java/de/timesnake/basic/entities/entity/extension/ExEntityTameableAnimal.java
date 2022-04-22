package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.advancements.CriterionTriggers;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTameableAnimal;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftTameableAnimal;

import javax.annotation.Nullable;
import java.util.UUID;

@NmsReflection
public class ExEntityTameableAnimal extends ExEntityAnimal {

    public ExEntityTameableAnimal(EntityTameableAnimal entity) {
        super(entity);
    }

    public ExEntityTameableAnimal(CraftTameableAnimal entity) {
        super(entity);
    }

    @Override
    public EntityTameableAnimal getNMS() {
        return (EntityTameableAnimal) super.getNMS();
    }

    public boolean isTamed() {
        return this.getNMS().q();
    }

    public void setTamed(boolean tag) {
        this.getNMS().w(tag);
    }

    public boolean isSitting() {
        return this.getNMS().fz();
    }

    public void setSitting(boolean tag) {
        this.getNMS().x(tag);
    }

    public UUID getOwnerUUID() {
        return this.getNMS().d();
    }

    public void setOwnerUUID(@Nullable UUID uuid) {
        this.getNMS().b(uuid);
    }

    public void tame(ExEntityHuman entity) {
        this.setTamed(true);
        this.setOwnerUUID(entity.getUniqueID());
        if (entity.getNMS() instanceof EntityPlayer) {
            CriterionTriggers.x.a(((EntityPlayer) entity.getNMS()), this.getNMS());
        }

    }

    public EntityLiving getOwner() {
        return this.getNMS().fA();
    }

    public boolean isWillSit() {
        return this.getNMS().fB();
    }

    public void setWillSit(boolean tag) {
        this.getNMS().y(tag);
    }
}
