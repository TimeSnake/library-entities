package de.timesnake.basic.entities.entity.extension;

import net.minecraft.world.entity.monster.EntityMonsterPatrolling;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftMonster;

public class ExEntityMonsterPatrolling extends ExEntityMonster {

    public ExEntityMonsterPatrolling(CraftMonster entity) {
        super(entity);
    }

    public ExEntityMonsterPatrolling(EntityMonsterPatrolling entity) {
        super(entity);
    }
}
