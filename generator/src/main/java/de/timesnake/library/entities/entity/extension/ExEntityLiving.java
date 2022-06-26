/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;

@NmsReflection
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

    public void addDeathLoot(Collection<ItemStack> items) {
        this.getNMS().drops.addAll(items);
    }

    public List<ItemStack> getDeathLoot() {
        return this.getNMS().drops;
    }

    public void setDeathLoot(Collection<ItemStack> items) {
        this.getNMS().drops.clear();
        this.getNMS().drops.addAll(items);
    }

    public int getMaxNoDamageTicks() {
        return this.getNMS().aU;
    }

    public void setMaxNoDamageTicks(int ticks) {
        this.getNMS().aU = ticks;
    }

    public void swingHand(ExEnumHand hand) {
        this.getNMS().a(hand.getNMS());
    }

    public boolean a(EntityLiving entity, PathfinderTargetCondition condition) {
        return this.getNMS().a(entity, condition);
    }

    public EntityLiving getLastDamager() {
        return this.getNMS().dU();
    }

    public ExEntityLiving getExLastDamager() {
        return new ExEntityLiving(this.getNMS().dU());
    }

    public int getHurtTimestamp() {
        return this.getNMS().dV();
    }

    public boolean eX() {
        return this.getNMS().ff();
    }
}
