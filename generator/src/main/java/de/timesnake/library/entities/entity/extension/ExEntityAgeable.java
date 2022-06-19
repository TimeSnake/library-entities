package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityAgeable;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAgeable;

@NmsReflection
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

    public int getAge() {
        return this.getNMS().j();
    }

    public void setAge(int age) {
        this.getNMS().a_(age);
    }

    public void setBaby(boolean flag) {
        this.getNMS().a(flag);
    }
}
