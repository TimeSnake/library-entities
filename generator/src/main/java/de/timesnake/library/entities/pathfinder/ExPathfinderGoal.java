package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.RefUtil;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;

@NmsReflection
public abstract class ExPathfinderGoal {

    public static final String PATHFINDER_GOAL_PREFIX = "ExPathfinderGoal";

    public static final String NAME_SEPERATOR = "/";

    public static ExPathfinderGoal fromConfigString(String configString) {
        String name = configString.split("/")[0];
        return null;
    }

    protected int priority = 1;
    protected PathfinderGoal pathfinderGoal;

    public ExPathfinderGoal(int priority, PathfinderGoal pathfinderGoal) {
        this.priority = priority;
        this.pathfinderGoal = pathfinderGoal;
    }

    public ExPathfinderGoal(int priority) {
        this.priority = priority;
    }

    public ExPathfinderGoal(PathfinderGoal pathfinderGoal) {
        this.pathfinderGoal = pathfinderGoal;
    }

    public ExPathfinderGoal() {

    }

    public PathfinderGoal getNMS() {
        return this.pathfinderGoal;
    }

    public void setNMSField(String name, Object value) {
        RefUtil.setInstanceField(this.getNMS(), name, value);
    }

    public Object invokeNMSMethod(String name, Object... args) {
        return RefUtil.invokeMethod(this, name, args);
    }

    public Object invokeNMSMethod(String name, Class<?>[] argClasses, Object... args) {
        return RefUtil.invokeMethod(this, name, argClasses, args);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public abstract void injectEntity(ExEntityInsentient entity);

    public enum Type {
        MOVE(PathfinderGoal.Type.a),
        LOOK(PathfinderGoal.Type.b),
        JUMP(PathfinderGoal.Type.c),
        TARGET(PathfinderGoal.Type.d);

        private final PathfinderGoal.Type nmsType;

        Type(PathfinderGoal.Type nmsType) {
            this.nmsType = nmsType;
        }

        public PathfinderGoal.Type getNMS() {
            return nmsType;
        }
    }


}
