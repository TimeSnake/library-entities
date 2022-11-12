/*
 * workspace.library-entities.library-entities.main
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

import de.timesnake.library.entities.entity.extension.ExEntityIllagerWizard;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.core.BlockPosition;
import net.minecraft.server.level.WorldServer;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.sounds.SoundEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EnumMobSpawn;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import net.minecraft.world.entity.monster.EntityVex;
import org.bukkit.event.entity.CreatureSpawnEvent;

@NmsReflection(usesReflection = true)
public class ExCustomPathfinderGoalEvokerCastSpellVex extends ExCustomPathfinderGoalIllagerWizardCastSpell {

    public ExCustomPathfinderGoalEvokerCastSpellVex() {
        super(new PathfinderGoalEvokerCastSpellVex(null));
    }

    protected static class PathfinderGoalEvokerCastSpellVex extends PathfinderGoalIllagerWizardCastSpell {

        private final PathfinderTargetCondition e = PathfinderTargetCondition.b().a(16.0).d().e();

        PathfinderGoalEvokerCastSpellVex(ExEntityIllagerWizard entity) {
            super(entity);
        }

        public boolean a() {
            if (!super.a()) {
                return false;
            } else {
                int i = this.entity.getNMS().s.a(EntityVex.class, this.e, this.entity.getNMS(),
                        this.entity.getNMS().cz().g(16.0)).size();
                return this.entity.getRandomSource().a(8) + 1 > i;
            }
        }

        protected int h() {
            return 100;
        }

        protected int i() {
            return 340;
        }

        protected void k() {
            WorldServer worldserver = (WorldServer) this.entity.getNMS().s;

            for (int i = 0; i < 3; ++i) {

                RandomSource rs = this.entity.getRandomSource();
                BlockPosition blockposition = this.entity.getNMS().db().b(-2 + rs.a(5), 1, -2 + rs.a(5));
                EntityVex entityvex = EntityTypes.aY.a(this.entity.getNMS().s);
                entityvex.a(blockposition, 0.0F, 0.0F);
                entityvex.a(worldserver, this.entity.getNMS().s.d_(blockposition), EnumMobSpawn.f, null,
                        null);
                entityvex.a(this.entity.getNMS());
                entityvex.g(blockposition);
                entityvex.a(20 * (30 + rs.a(90)));
                worldserver.addFreshEntityWithPassengers(entityvex, CreatureSpawnEvent.SpawnReason.SPELL);
            }

        }

        protected SoundEffect l() {
            return SoundEffects.fY;
        }

        protected EntityIllagerWizard.Spell m() {
            return EntityIllagerWizard.Spell.b;
        }
    }
}
