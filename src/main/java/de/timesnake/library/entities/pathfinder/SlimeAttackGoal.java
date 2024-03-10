/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent;
import de.timesnake.library.entities.proxy.ProxyManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;

import java.util.EnumSet;

public class SlimeAttackGoal extends Goal {

  private final Slime slime;
  private int growTiredTimer;

  public SlimeAttackGoal(Slime slime) {
    this.slime = slime;
    this.setFlags(EnumSet.of(Goal.Flag.LOOK));
  }

  @Override
  public boolean canUse() {
    LivingEntity entityliving = this.slime.getTarget();

    // Paper start
    if (entityliving == null || !entityliving.isAlive()) {
      return false;
    }
    if (!this.slime.canAttack(entityliving)) {
      return false;
    }
    return this.slime.canWander() && new SlimeTargetLivingEntityEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity(),
        (org.bukkit.entity.LivingEntity) entityliving.getBukkitEntity()).callEvent();
    // Paper end
  }

  @Override
  public void start() {
    this.growTiredTimer = reducedTickDelay(300);
    super.start();
  }

  @Override
  public boolean canContinueToUse() {
    LivingEntity entityliving = this.slime.getTarget();

    // Paper start
    if (entityliving == null || !entityliving.isAlive()) {
      return false;
    }
    if (!this.slime.canAttack(entityliving)) {
      return false;
    }
    return --this.growTiredTimer > 0 && this.slime.canWander()
        && new SlimeTargetLivingEntityEvent((org.bukkit.entity.Slime) this.slime.getBukkitEntity(),
        (org.bukkit.entity.LivingEntity) entityliving.getBukkitEntity()).callEvent();
    // Paper end
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    LivingEntity entityliving = this.slime.getTarget();

    if (entityliving != null) {
      this.slime.lookAt(entityliving, 10.0F, 10.0F);
    }

    ProxyManager.getInstance().getSlimeMoveControlProxy().setDirection(this.slime.getMoveControl(), this.slime.getYRot(),
        ProxyManager.getInstance().getSlimeProxy().isDealsDamage(this.slime));


  }

  // Paper start - clear timer and target when goal resets
  public void stop() {
    this.growTiredTimer = 0;
    this.slime.setTarget(null);
  }
  // Paper end
}
