/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.world.entity.ai.navigation.Navigation;

public class ExNavigation extends ExNavigationAbstract {

    public ExNavigation(Navigation navigation) {
        super(navigation);
    }

    public boolean f() {
        return ((Navigation) this.navigation).f();
    }
}
