/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.phys.AxisAlignedBB;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;

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
