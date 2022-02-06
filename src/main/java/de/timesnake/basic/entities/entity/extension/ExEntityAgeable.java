package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.EntityAgeable;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftAgeable;

public abstract class ExEntityAgeable extends ExEntityInsentient {

    public ExEntityAgeable(CraftAgeable entity) {
        super(entity);
    }

    public ExEntityAgeable(EntityAgeable entity) {
        super(entity);
    }

    @Override
    public EntityAgeable getNMS() {
        return (EntityAgeable) super.getNMS();
    }

    public void createChild(ExEntityAgeable entity) {
        this.getNMS().a(super.getNMSWorld(), entity.getNMS());
    }

    public void setAge(int age) {
        this.getNMS().a_(age);
    }

    public int getAge() {
        return this.getNMS().j();
    }

    public void setBaby(boolean flag) {
        this.getNMS().a(flag);
    }
}
