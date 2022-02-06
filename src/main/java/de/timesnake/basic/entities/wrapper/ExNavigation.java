package de.timesnake.basic.entities.wrapper;

import net.minecraft.world.entity.ai.navigation.Navigation;

public class ExNavigation extends ExNavigationAbstract {

    public ExNavigation(Navigation navigation) {
        super(navigation);
    }

    public boolean f() {
        return ((Navigation) this.navigation).f();
    }
}
