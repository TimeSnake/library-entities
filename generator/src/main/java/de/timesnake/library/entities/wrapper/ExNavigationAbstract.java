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

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.wrapper;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.navigation.NavigationAbstract;
import net.minecraft.world.level.pathfinder.PathEntity;

@NmsReflection
public class ExNavigationAbstract {

    protected final NavigationAbstract navigation;

    public ExNavigationAbstract(NavigationAbstract navigationAbstract) {
        this.navigation = navigationAbstract;
    }

    public NavigationAbstract getNMS() {
        return navigation;
    }

    public boolean walkTo(double x, double y, double z, double speed) {
        return this.navigation.a(x, y, z, speed);
    }

    public boolean walkTo(Entity entity, double speed) {
        return this.navigation.a(entity, speed);
    }

    public boolean walkTo(ExEntity entity, double speed) {
        return this.walkTo(entity.getNMS(), speed);
    }

    public boolean walkTo(PathEntity pathEntity, double speed) {
        return this.navigation.a(pathEntity, speed);
    }

    public boolean walkTo(ExPathEntity pathEntity, double speed) {
        return this.walkTo(pathEntity.getNMS(), speed);
    }

    public PathEntity getCurrentPathEntity() {
        return this.navigation.j();
    }

    public PathEntity calcPathTo(BlockPosition position) {
        return this.navigation.a(position, 1);
    }

    public PathEntity calcPathTo(Entity entity) {
        return this.navigation.a(entity, 1);
    }

    public PathEntity calcPathTo(double x, double y, double z, int i) {
        return this.navigation.a(x, y, z, i);
    }

    public ExPathEntity getCurrentExPathEntity() {
        return ExWrapper.wrapPathEntity(this.getCurrentPathEntity());
    }

    public ExPathEntity calcExPathTo(ExBlockPosition position) {
        return ExWrapper.wrapPathEntity(this.calcPathTo(position.getNMS()));
    }

    public ExPathEntity calcExPathTo(double x, double y, double z, int i) {
        return ExWrapper.wrapPathEntity(this.calcPathTo(x, y, z, i));
    }

    public ExPathEntity calcExPathTo(Entity entity) {
        return ExWrapper.wrapPathEntity(this.calcPathTo(entity));
    }

    public boolean isPathFinished() {
        return this.navigation.m();
    }

    public void o() {
        this.navigation.n();
    }

    public boolean m() {
        return this.navigation.l();
    }

    public void setSpeed(double speed) {
        this.navigation.a(speed);
    }

    public PathEntity k() {
        return this.navigation.j();
    }

    public ExPathEntity exk() {
        return ExWrapper.wrapPathEntity(this.navigation.j());
    }

    public BlockPosition h() {
        return this.navigation.h();
    }

    public boolean a(BlockPosition blockPosition) {
        return this.navigation.a(blockPosition);
    }

    public boolean a(ExBlockPosition blockPosition) {
        return this.a(blockPosition.getNMS());
    }

    public void d(boolean b) {
        this.navigation.a(b);
    }

}
