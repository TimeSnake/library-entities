/*
 * workspace.library-entities-generator.main
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.control.ControllerLook;

public class ExControllerLook {

    private final ControllerLook controller;

    public ExControllerLook(ControllerLook controller) {
        this.controller = controller;
    }

    public ControllerLook getNMS() {
        return this.controller;
    }

    public void a(Entity entity, float f1, float f2) {
        this.controller.a(entity, f1, f2);
    }

    public void a(ExEntity entity, float f1, float f2) {
        this.a(entity.getNMS(), f1, f2);
    }

    public void a(double d1, double d2, double d3) {
        this.controller.a(d1, d2, d3);
    }

    public double d() {
        return this.controller.e();
    }

    public double e() {
        return this.controller.f();
    }

    public double f() {
        return this.controller.g();
    }

}
