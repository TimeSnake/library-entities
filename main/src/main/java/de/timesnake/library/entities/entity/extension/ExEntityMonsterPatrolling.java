package de.timesnake.library.entities.entity.extension;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.monster.EntityMonsterPatrolling;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftMonster;

@NmsReflection
public class ExEntityMonsterPatrolling extends ExEntityMonster {

    public ExEntityMonsterPatrolling(CraftMonster entity) {
        super(entity);
    }

    public ExEntityMonsterPatrolling(EntityMonsterPatrolling entity) {
        super(entity);
    }
}
