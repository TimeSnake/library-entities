/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.BlazeBuilder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class BlazeAttackGoal extends Goal {

  private final Blaze blaze;
  private int attackStep;
  private int attackTime;
  private int lastSeen;

  public BlazeAttackGoal(Blaze blaze) {
    this.blaze = blaze;
    this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
  }

  @Override
  public boolean canUse() {
    LivingEntity livingEntity = this.blaze.getTarget();
    return livingEntity != null && livingEntity.isAlive() && this.blaze.canAttack(livingEntity);
  }

  @Override
  public void start() {
    this.attackStep = 0;
  }

  @Override
  public void stop() {
    BlazeBuilder.setCharged(this.blaze, false);
    this.lastSeen = 0;
  }

  @Override
  public boolean requiresUpdateEveryTick() {
    return true;
  }

  @Override
  public void tick() {
    --this.attackTime;
    LivingEntity livingEntity = this.blaze.getTarget();
    if (livingEntity != null) {
      boolean bl = this.blaze.getSensing().hasLineOfSight(livingEntity);
      if (bl) {
        this.lastSeen = 0;
      } else {
        ++this.lastSeen;
      }

      double d = this.blaze.distanceToSqr(livingEntity);
      if (d < 4.0D) {
        if (!bl) {
          return;
        }

        if (this.attackTime <= 0) {
          this.attackTime = 20;
          this.blaze.doHurtTarget(livingEntity);
        }

        this.blaze.getMoveControl().setWantedPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0D);
      } else if (d < this.getFollowDistance() * this.getFollowDistance() && bl) {
        double e = livingEntity.getX() - this.blaze.getX();
        double f = livingEntity.getY(0.5D) - this.blaze.getY(0.5D);
        double g = livingEntity.getZ() - this.blaze.getZ();
        if (this.attackTime <= 0) {
          ++this.attackStep;
          if (this.attackStep == 1) {
            this.attackTime = 60;
            BlazeBuilder.setCharged(this.blaze, true);
          } else if (this.attackStep <= 4) {
            this.attackTime = 6;
          } else {
            this.attackTime = 100;
            this.attackStep = 0;
            BlazeBuilder.setCharged(this.blaze, false);
          }

          if (this.attackStep > 1) {
            double h = Math.sqrt(Math.sqrt(d)) * 0.5D;
            if (!this.blaze.isSilent()) {
              this.blaze.level().levelEvent(null, 1018, this.blaze.blockPosition(), 0);
            }

            for (int i = 0; i < 1; ++i) {
              Vec3 vec3 = new Vec3(this.blaze.getRandom().triangle(e, 2.297 * h), f,
                  this.blaze.getRandom().triangle(g, 2.297 * h));
              SmallFireball smallFireball = new SmallFireball(this.blaze.level(), this.blaze, vec3.normalize());
              smallFireball.setPos(smallFireball.getX(), this.blaze.getY(0.5D) + 0.5D, smallFireball.getZ());
              this.blaze.level().addFreshEntity(smallFireball);
            }
          }
        }

        this.blaze.getLookControl().setLookAt(livingEntity, 10.0F, 10.0F);
      } else if (this.lastSeen < 5) {
        this.blaze.getMoveControl().setWantedPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0D);
      }

      super.tick();
    }
  }

  private double getFollowDistance() {
    return this.blaze.getAttributeValue(Attributes.FOLLOW_RANGE);
  }
}