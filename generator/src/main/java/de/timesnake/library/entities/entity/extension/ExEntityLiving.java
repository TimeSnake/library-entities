/*
 * workspace.library-entities-generator.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.entities.wrapper.ExEnumHand;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftLivingEntity;
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

    @Override
    public EntityLiving getNMS() {
        return (EntityLiving) super.getNMS();
    }

    @Override
    public de.timesnake.library.entities.entity.extension.LivingEntity getExEntity() {
        return (de.timesnake.library.entities.entity.extension.LivingEntity) super.getExEntity();
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
        return new ExEntityLiving(this.getNMS().dU()) {};
    }

    public int getHurtTimestamp() {
        return this.getNMS().dV();
    }

    public boolean eX() {
        return this.getNMS().ff();
    }
}
