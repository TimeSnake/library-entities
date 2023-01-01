/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import net.minecraft.network.syncher.DataWatcher;

public class ExDataWatcher {

    private final DataWatcher watcher;

    public ExDataWatcher(DataWatcher watcher) {
        this.watcher = watcher;
    }

    public DataWatcher getNMS() {
        return this.watcher;
    }

}
