package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.navigation.Navigation;

@NmsReflection
public class ExNavigation extends ExNavigationAbstract {

    public ExNavigation(Navigation navigation) {
        super(navigation);
    }

    public boolean f() {
        return ((Navigation) this.navigation).f();
    }
}
