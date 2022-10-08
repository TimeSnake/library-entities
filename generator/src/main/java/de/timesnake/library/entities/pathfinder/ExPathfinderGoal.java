/*
 * library-entities.generator.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

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
