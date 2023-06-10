/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.material.Material;

public class ExIBlockData {

	private final IBlockData data;

	public ExIBlockData(IBlockData data) {
		this.data = data;
	}

	public IBlockData getNMS() {
		return this.data;
	}

	public Material getMaterial() {
		return this.data.d();
	}

	public ExMaterial getExMaterial() {
		return new ExMaterial(this.getMaterial());
	}

	public boolean isAir() {
		return this.data.h();
	}

	public boolean d(IBlockAccess iblockaccess, ExBlockPosition blockposition,
									 ExEnumDirection enumdirection) {
		return this.data.d(iblockaccess, blockposition.getNMS(), enumdirection.getNMS());
	}

	public Block getBlock() {
		return this.data.b();
	}

}
