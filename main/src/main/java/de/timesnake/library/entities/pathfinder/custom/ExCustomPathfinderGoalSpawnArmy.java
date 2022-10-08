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

import de.timesnake.library.entities.entity.ExtendedCraftEntity;
import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;
import java.util.List;

@NmsReflection
public abstract class ExCustomPathfinderGoalSpawnArmy extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalSpawnArmy(EntityClass<? extends EntityInsentient> armyClass, int amountOnRespawn) {
        this(armyClass, amountOnRespawn, 0);
    }

    public ExCustomPathfinderGoalSpawnArmy(EntityClass<? extends EntityInsentient> armyClass, int amountOnRespawn,
                                           int cooldownInTicks) {
        super();
        super.pathfinderGoal = new PathfinderGoalSpawnArmy(null, armyClass.getNMSClass(), amountOnRespawn,
                cooldownInTicks) {

            @Override
            public List<? extends ExtendedCraftEntity<? extends ExEntityInsentient>> getArmy() {
                return ExCustomPathfinderGoalSpawnArmy.this.getArmee(this.getExEntity());
            }
        };
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("exEntity", entity.getBukkitEntity());
    }


    public abstract List<? extends ExtendedCraftEntity<? extends ExEntityInsentient>> getArmee(ExtendedCraftEntity<?
            extends ExEntityInsentient> entity);


    public abstract static class PathfinderGoalSpawnArmy extends PathfinderGoal {

        private final ExtendedCraftEntity<? extends ExEntityInsentient> exEntity;
        private final Class<? extends EntityInsentient> armyClass;
        private final PathfinderTargetCondition targetCondition;

        private final int spawn;

        private final int cooldown;
        private int currentCooldown = 0;

        public PathfinderGoalSpawnArmy(ExtendedCraftEntity<? extends ExEntityInsentient> entity, Class<?
                extends EntityInsentient> armyClass, int spawn) {
            this(entity, armyClass, spawn, 0);
        }

        public PathfinderGoalSpawnArmy(ExtendedCraftEntity<? extends ExEntityInsentient> entity, Class<?
                extends EntityInsentient> armyClass, int spawn, int cooldown) {
            this.exEntity = entity;
            this.armyClass = armyClass;
            this.spawn = spawn;
            this.cooldown = cooldown;
            this.targetCondition = PathfinderTargetCondition.a().a(8.0D).c().e().a().b();
            this.a(EnumSet.of(ExCustomPathfinderGoal.Type.MOVE.getNMS()));
        }

        @Override
        public boolean a() {
            int var0 = exEntity.getExtension().getNMSWorld().a(this.armyClass, this.targetCondition,
                    exEntity.getExtension().getNMS(), exEntity.getExtension().getExBoundingBox().grow(8.0D).getNMS()).size();
            this.currentCooldown--;
            return exEntity.getExtension().getRandom().nextInt(spawn) >= var0 && this.currentCooldown <= 0;
        }

        @Override
        public void c() {
            for (ExtendedCraftEntity<? extends ExEntityInsentient> entity : this.getArmy()) {
                ExBlockPosition position =
                        new ExBlockPosition(this.exEntity.getExtension().getChunkCoordinates().b(-2 + this.exEntity.getExtension().getRandom().nextInt(5), 0, -2 + this.exEntity.getExtension().getRandom().nextInt(5)));

                entity.getExtension().setTarget(this.exEntity.getExtension().getNMSTarget(),
                        EntityTargetEvent.TargetReason.CUSTOM, true);
                entity.getExtension().setPositionRotation(position, 0, 0);

                this.exEntity.getExtension().getExWorld().addEntity(entity.getExtension().getNMS());
            }

            this.currentCooldown = this.cooldown;
        }

        public ExtendedCraftEntity<? extends ExEntityInsentient> getExEntity() {
            return exEntity;
        }

        public abstract List<? extends ExtendedCraftEntity<? extends ExEntityInsentient>> getArmy();


    }
}
