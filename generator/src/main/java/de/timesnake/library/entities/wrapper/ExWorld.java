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

package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.phys.AxisAlignedBB;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;

@NmsReflection
public class ExWorld {

    protected final World world;

    public ExWorld(World world) {
        this.world = world;
    }

    public World getNMS() {
        return this.world;
    }

    public ExIBlockData getType(ExBlockPosition blockPosition) {
        return new ExIBlockData(this.getType(blockPosition.getNMS()));
    }

    public IBlockData getType(BlockPosition blockPosition) {
        return this.world.a_(blockPosition);
    }

    public CraftServer getServer() {
        return this.world.getCraftServer();
    }

    public boolean getCubes(Entity entity, AxisAlignedBB axis) {
        return this.world.a(entity, axis);
    }

}
