package de.timesnake.library.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.network.syncher.DataWatcher;

@NmsReflection
public class ExDataWatcher {

    private final DataWatcher watcher;

    public ExDataWatcher(DataWatcher watcher) {
        this.watcher = watcher;
    }

    public DataWatcher getNMS() {
        return this.watcher;
    }

}
