/*
 * library-entities.library-entities.main
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

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.bukkit.ExPlayer;
import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import org.bukkit.entity.Player;

import java.util.EnumSet;

@NmsReflection
public class CustomPathfinderGoalPet extends PathfinderGoal {

    private final ExEntityInsentient pet;
    private final double speed;
    private final double teleportDistance;
    private final double minDistance;
    private ExPlayer owner;
    private double x;
    private double y;
    private double z;

    public CustomPathfinderGoalPet(ExEntityInsentient pet, Player owner, double speed, float minDistance,
                                   float teleportDistance) {
        this.pet = pet;
        this.owner = new ExPlayer(owner);
        this.speed = speed;
        this.minDistance = minDistance;
        this.teleportDistance = teleportDistance;
        this.a(EnumSet.of(ExCustomPathfinderGoal.Type.MOVE.getNMS()));
    }


    @Override
    public boolean a() {
        if (this.owner == null || !this.owner.isAlive()) {
            this.owner = null;
            return false;

        } else if (this.owner.distanceSquared(this.pet) > (this.teleportDistance * this.teleportDistance) && this.teleportDistance > 0) {
            pet.setPosition(this.owner.getX(), this.owner.getY(), this.owner.getZ());
            return false;

        } else if (this.owner.distanceSquared(this.pet) < (this.minDistance * this.minDistance)) {
            return false;
        } else {

            this.x = this.owner.getX();
            this.y = this.owner.getY();
            this.z = this.owner.getZ();

            return true;
        }

    }

    @Override
    public void c() {
        this.pet.getNavigation().walkTo(this.x, this.y, this.z, this.speed);
    }

    @Override
    public boolean b() {
        return !this.pet.getNavigation().m() && this.owner.distanceSquared(this.pet) < (this.teleportDistance * this.teleportDistance);
    }
}
