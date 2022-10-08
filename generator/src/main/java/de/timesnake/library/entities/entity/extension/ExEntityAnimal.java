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
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.animal.EntityAnimal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAnimals;

@NmsReflection
public class ExEntityAnimal extends ExEntityAgeable {

    public ExEntityAnimal(CraftAnimals entity) {
        super(entity);
    }

    public ExEntityAnimal(EntityAnimal entity) {
        super(entity);
    }

    @Override
    public EntityAnimal getNMS() {
        return (EntityAnimal) super.getNMS();
    }

    public void setLoveTicks(int i) {
        this.getNMS().s(i);
    }

    public boolean isInLove() {
        return this.getNMS().fQ();
    }

    public void resetLove() {
        this.getNMS().fG();
    }

    public boolean mate(ExEntityAnimal entity) {
        return this.getNMS().a(entity.getNMS());
    }

    public void makeLove(WorldServer worldServer, ExEntityAnimal entity) {
        this.makeLove(worldServer, entity.getNMS());
    }

    public void makeLove(WorldServer worldServer, EntityAnimal entity) {
        this.getNMS().a(worldServer, entity);
    }
}
