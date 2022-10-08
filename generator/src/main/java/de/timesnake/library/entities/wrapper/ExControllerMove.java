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

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.control.ControllerMove;

@NmsReflection
public class ExControllerMove {

    private final ControllerMove controller;

    public ExControllerMove(ControllerMove controller) {
        this.controller = controller;
    }

    public ControllerMove getNMS() {
        return this.controller;
    }

    public void a(double var0, double var2, double var4, double var6) {
        this.controller.a(var0, var2, var4, var6);
    }
}
