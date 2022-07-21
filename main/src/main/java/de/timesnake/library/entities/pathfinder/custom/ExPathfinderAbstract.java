package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.level.pathfinder.PathfinderAbstract;

@NmsReflection
public class ExPathfinderAbstract {

    protected int priority = 1;
    protected PathfinderAbstract pathfinder;

    public ExPathfinderAbstract(PathfinderAbstract pathfinder) {
        this.pathfinder = pathfinder;
    }

    public PathfinderAbstract getNMS() {
        return this.pathfinder;
    }

    public void setNMSField(String name, Object value) {
        RefUtil.setInstanceField(this.getNMS(), name, value);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}