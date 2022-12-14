/*
 * Copyright (C) 2022 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityMonsterPatrolling;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftMonster;

public class ExEntityMonsterPatrolling extends ExEntityMonster {

    public ExEntityMonsterPatrolling(CraftMonster entity) {
        super(entity);
    }

    public ExEntityMonsterPatrolling(EntityMonsterPatrolling entity) {
        super(entity);
    }
}
