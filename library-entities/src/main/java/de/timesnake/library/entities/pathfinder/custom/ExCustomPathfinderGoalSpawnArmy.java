/*
 * de.timesnake.workspace.library-entities.main
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

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.entity.type.EntityMapper;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;
import java.util.List;

@NmsReflection
public abstract class ExCustomPathfinderGoalSpawnArmy extends ExPathfinderGoal {

    public ExCustomPathfinderGoalSpawnArmy(Class<? extends Mob> armyClass, int amountOnRespawn) {
        this(armyClass, amountOnRespawn, 0);
    }

    public ExCustomPathfinderGoalSpawnArmy(Class<? extends Mob> armyClass, int amountOnRespawn, int cooldownInTicks) {
        super();
        super.pathfinderGoal = new PathfinderGoalSpawnArmy(null,
                EntityMapper.mapExClassToNmsClass(armyClass), amountOnRespawn, cooldownInTicks) {

            @Override
            public List<? extends de.timesnake.library.entities.entity.extension.Mob> getArmy() {
                return ExCustomPathfinderGoalSpawnArmy.this.getArmee(this.getExEntity());
            }
        };
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("exEntity", entity.getBukkitEntity());
    }


    public abstract List<? extends de.timesnake.library.entities.entity.extension.Mob> getArmee(de.timesnake.library.entities.entity.extension.Mob entity);


    public abstract static class PathfinderGoalSpawnArmy extends PathfinderGoal {

        private final de.timesnake.library.entities.entity.extension.Mob exEntity;
        private final Class<? extends EntityInsentient> armyClass;
        private final PathfinderTargetCondition targetCondition;

        private final int spawn;

        private final int cooldown;
        private int currentCooldown = 0;

        public PathfinderGoalSpawnArmy(de.timesnake.library.entities.entity.extension.Mob entity, Class<?
                extends EntityInsentient> armyClass, int spawn) {
            this(entity, armyClass, spawn, 0);
        }

        public PathfinderGoalSpawnArmy(de.timesnake.library.entities.entity.extension.Mob entity, Class<?
                extends EntityInsentient> armyClass, int spawn, int cooldown) {
            this.exEntity = entity;
            this.armyClass = armyClass;
            this.spawn = spawn;
            this.cooldown = cooldown;
            this.targetCondition = PathfinderTargetCondition.a().a(8.0D).c().e().a().b();
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
        }

        @Override
        public boolean a() {
            int var0 = exEntity.getNMSWorld().a(this.armyClass, this.targetCondition,
                    exEntity.getNMS(), exEntity.getExtension().getExBoundingBox().grow(8.0D).getNMS()).size();
            this.currentCooldown--;
            return exEntity.getExtension().getRandom().nextInt(spawn) >= var0 && this.currentCooldown <= 0;
        }

        @Override
        public void c() {
            for (de.timesnake.library.entities.entity.extension.Mob entity : this.getArmy()) {
                ExBlockPosition position =
                        new ExBlockPosition(this.exEntity.getExtension().getChunkCoordinates().b(-2 +
                                this.exEntity.getRandom().nextInt(5), 0, -2 +
                                this.exEntity.getRandom().nextInt(5)));

                entity.setTarget(this.exEntity.getNMSTarget(),
                        EntityTargetEvent.TargetReason.CUSTOM, true);
                entity.setPositionRotation(position, 0, 0);

                this.exEntity.getExWorld().addEntity(entity.getExtension().getNMS());
            }

            this.currentCooldown = this.cooldown;
        }

        public de.timesnake.library.entities.entity.extension.Mob getExEntity() {
            return exEntity;
        }

        public abstract List<? extends de.timesnake.library.entities.entity.extension.Mob> getArmy();


    }
}
