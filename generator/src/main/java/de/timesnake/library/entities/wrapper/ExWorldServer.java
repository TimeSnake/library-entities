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

package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.Entity;

@NmsReflection
public class ExWorldServer extends ExWorld {

    public ExWorldServer(WorldServer world) {
        super(world);
    }

    @Override
    public WorldServer getNMS() {
        return (WorldServer) super.getNMS();
    }

    public boolean isEmpty(BlockPosition position) {
        return this.getNMS().x(position);
    }

    public boolean addEntity(Entity entity) {
        return this.getNMS().b(entity);
    }
}
