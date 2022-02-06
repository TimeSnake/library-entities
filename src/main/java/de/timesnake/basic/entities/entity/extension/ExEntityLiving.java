package de.timesnake.basic.entities.entity.extension;

import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;

public class ExEntityLiving extends ExEntity {

    public ExEntityLiving(CraftLivingEntity entity) {
        super(entity);
    }

    public ExEntityLiving(EntityLiving entity) {
        super(entity);
    }

    public EntityLiving getNMS() {
        return (EntityLiving) super.getNMS();
    }

    public void setMaxHealth(float maxHealth) {
        ((LivingEntity) this.getNMS().getBukkitEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    }

    public AttributeInstance getBukkitAttribute(Attribute attribute) {
        return ((LivingEntity) this.getNMS().getBukkitEntity()).getAttribute(attribute);
    }

    public void setDeathLoot(Collection<ItemStack> items) {
        this.getNMS().drops.clear();
        this.getNMS().drops.addAll(items);
    }

    public void addDeathLoot(Collection<ItemStack> items) {
        this.getNMS().drops.addAll(items);
    }

    public List<ItemStack> getDeathLoot() {
        return this.getNMS().drops;
    }

    public void setMaxNoDamageTicks(int ticks) {
        this.getNMS().aV = ticks;
    }

    public int getMaxNoDamageTicks() {
        return this.getNMS().aV;
    }

    public void swingHand(ExEnumHand hand) {
        this.getNMS().a(hand.getNMS());
    }

    public boolean a(EntityLiving entity, PathfinderTargetCondition condition) {
        return this.getNMS().a(entity, condition);
    }

    public EntityLiving getLastDamager() {
        return this.getNMS().dL();
    }

    public ExEntityLiving getExLastDamager() {
        return new ExEntityLiving(this.getNMS().dL());
    }

    public int getHurtTimestamp() {
        return this.getNMS().dM();
    }

}
