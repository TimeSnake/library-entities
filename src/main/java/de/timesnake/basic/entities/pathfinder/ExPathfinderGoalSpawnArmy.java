package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.EntityExtension;
import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.wrapper.EntityClass;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.EnumSet;
import java.util.List;

public abstract class ExPathfinderGoalSpawnArmy extends ExPathfinderGoal {

    public ExPathfinderGoalSpawnArmy(EntityClass<? extends EntityInsentient> armyClass, int amountOnRespawn) {
        this(armyClass, amountOnRespawn, 0);
    }

    public ExPathfinderGoalSpawnArmy(EntityClass<? extends EntityInsentient> armyClass, int amountOnRespawn, int cooldownInTicks) {
        super();
        super.pathfinderGoal = new PathfinderGoalSpawnArmy(null, armyClass.getNMSClass(), amountOnRespawn, cooldownInTicks) {

            @Override
            public List<? extends EntityExtension<? extends ExEntityInsentient>> getArmy() {
                return ExPathfinderGoalSpawnArmy.this.getArmee(this.getExEntity());
            }
        };
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("exEntity", entity.getBukkitEntity());
    }


    public abstract List<? extends EntityExtension<? extends ExEntityInsentient>> getArmee(EntityExtension<? extends ExEntityInsentient> entity);


    public abstract static class PathfinderGoalSpawnArmy extends PathfinderGoal {

        private final EntityExtension<? extends ExEntityInsentient> exEntity;
        private final Class<? extends EntityInsentient> armyClass;
        private final PathfinderTargetCondition targetCondition;

        private final int spawn;

        private final int cooldown;
        private int currentCooldown = 0;

        public PathfinderGoalSpawnArmy(EntityExtension<? extends ExEntityInsentient> entity, Class<? extends EntityInsentient> armyClass, int spawn) {
            this(entity, armyClass, spawn, 0);
        }

        public PathfinderGoalSpawnArmy(EntityExtension<? extends ExEntityInsentient> entity, Class<? extends EntityInsentient> armyClass, int spawn, int cooldown) {
            this.exEntity = entity;
            this.armyClass = armyClass;
            this.spawn = spawn;
            this.cooldown = cooldown;
            this.targetCondition = PathfinderTargetCondition.a().a(8.0D).c().e().a().b();
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS()));
        }

        @Override
        public boolean a() {
            int var0 = exEntity.getExtension().getNMSWorld().a(this.armyClass, this.targetCondition, exEntity.getExtension().getNMS(), exEntity.getExtension().getExBoundingBox().grow(8.0D).getNMS()).size();
            this.currentCooldown--;
            return exEntity.getExtension().getRandom().nextInt(spawn) >= var0 && this.currentCooldown <= 0;
        }

        @Override
        public void c() {
            for (EntityExtension<? extends ExEntityInsentient> entity : this.getArmy()) {
                ExBlockPosition position = new ExBlockPosition(this.exEntity.getExtension().getChunkCoordinates().b(-2 + this.exEntity.getExtension().getRandom().nextInt(5), 0, -2 + this.exEntity.getExtension().getRandom().nextInt(5)));

                entity.getExtension().setTarget(this.exEntity.getExtension().getNMSTarget(), EntityTargetEvent.TargetReason.CUSTOM, true);
                entity.getExtension().setPositionRotation(position, 0, 0);

                this.exEntity.getExtension().getExWorld().addEntity(entity.getExtension().getNMS());
            }

            this.currentCooldown = this.cooldown;
        }

        public EntityExtension<? extends ExEntityInsentient> getExEntity() {
            return exEntity;
        }

        public abstract List<? extends EntityExtension<? extends ExEntityInsentient>> getArmy();


    }
}
