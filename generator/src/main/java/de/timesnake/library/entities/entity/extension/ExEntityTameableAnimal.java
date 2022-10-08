/*
 * library-entities.generator.main
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

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.advancements.CriterionTriggers;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTameableAnimal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftTameableAnimal;

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
        return this.getNMS().fL();
    }

    public boolean isWillSit() {
        return this.getNMS().fB();
    }

    public void setWillSit(boolean tag) {
        this.getNMS().y(tag);
    }
}
