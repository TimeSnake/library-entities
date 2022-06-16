package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEnumDirection;
import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.material.Material;

@NmsReflection
public class ExIBlockData {

    private final IBlockData data;

    public ExIBlockData(IBlockData data) {
        this.data = data;
    }

    public IBlockData getNMS() {
        return this.data;
    }

    public Material getMaterial() {
        return this.data.c();
    }

    public ExMaterial getExMaterial() {
        return new ExMaterial(this.data.c());
    }

    public boolean isAir() {
        return this.data.g();
    }

    public boolean d(IBlockAccess iblockaccess, ExBlockPosition blockposition, ExEnumDirection enumdirection) {
        return this.data.d(iblockaccess, blockposition.getNMS(), enumdirection.getNMS());
    }

    public Block getBlock() {
        return this.data.b();
    }

}
