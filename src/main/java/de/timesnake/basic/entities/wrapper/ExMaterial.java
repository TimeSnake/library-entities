package de.timesnake.basic.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.level.material.Material;

@NmsReflection
public class ExMaterial {

    private final Material material;

    public ExMaterial(Material material) {
        this.material = material;
    }

    public Material getNMS() {
        return this.material;
    }

    public boolean isLiquid() {
        return this.material.a();
    }
}
