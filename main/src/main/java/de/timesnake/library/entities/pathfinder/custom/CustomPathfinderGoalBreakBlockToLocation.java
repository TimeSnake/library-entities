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

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.entities.wrapper.ExIBlockData;
import de.timesnake.library.entities.wrapper.ExNavigation;
import de.timesnake.library.entities.wrapper.ExPathEntity;
import de.timesnake.library.entities.wrapper.ExWrapper;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

@NmsReflection
public class CustomPathfinderGoalBreakBlockToLocation extends PathfinderGoal {

    private static final Integer[][] NEAR_BLOCK_VECTORS = new Integer[][]{{1, 1, 0}, {-1, 1, 0}, {0, 1, 1}, {0, 1,
            -1}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    private final ExEntityInsentient entity;
    private final List<Material> materials;
    private final double speedModifier;

    private final double targetX;
    private final double targetY;
    private final double targetZ;

    private Block currentBlock;
    private ExBlockPosition position;
    private Material currentBlockType;
    private double remainTime;
    private int soundDelay;

    public CustomPathfinderGoalBreakBlockToLocation(ExEntityInsentient entity, double x, double y, double z,
                                                    double speedModifier, Material... materials) {
        this.entity = entity;
        this.targetX = x;
        this.targetY = y;
        this.targetZ = z;
        this.speedModifier = speedModifier;
        this.materials = Arrays.asList(materials);
        this.a(EnumSet.of(ExCustomPathfinderGoal.Type.JUMP.getNMS(), ExCustomPathfinderGoal.Type.MOVE.getNMS(),
                ExCustomPathfinderGoal.Type.LOOK.getNMS()));
    }

    public List<Material> getMaterials() {
        return materials;
    }

    @Override
    public boolean a() {
        double x = this.entity.getX();
        double y = this.entity.getY();
        double z = this.entity.getZ();

        ExBlockPosition target = ExWrapper.wrapBlockPosition(this.entity.getNavigation().h());

        if (target == null) {
            return false;
        }

        ExNavigation navigation = (ExNavigation) this.entity.getNavigation();
        ExPathEntity pathEntity = navigation.exk();

        if (remainTime > 0) {
            return false;
        }

        if (pathEntity != null && navigation.f()) {
            if (pathEntity.getPathLength() <= 1) {
                this.position = new ExBlockPosition(x, y, z);

                if (this.isBlockBreakable(position)) {
                    this.setCurrentBlock(position);
                    return true;
                }

                // calc look block, check reachable
                double deltaX = this.targetX - x;
                double deltaY = this.targetY - y;
                double deltaZ = this.targetZ - z;

                if (deltaX * deltaX > deltaZ * deltaZ) {
                    x = deltaX > 0 ? x + 1 : x - 1;
                } else {
                    z = deltaZ > 0 ? z + 1 : z - 1;
                }

                y++; //select head block

                ExBlockPosition position = new ExBlockPosition(x, y, z);

                //System.out.println("first");
                //System.out.println(position.getX() + " " + position.getY() + " " + position.getZ());

                if (this.isBlockBreakable(position)) {
                    this.setCurrentBlock(position);
                    return true;
                }

                if (deltaY > 0) {
                    position = new ExBlockPosition(x, y + 1, z); // make stairs
                } else {
                    position = new ExBlockPosition(x, y - 1, z);// make tunnel
                }

                //System.out.println("second");
                // System.out.println(position.getX() + " " + position.getY() + " " + position.getZ());

                if (this.isBlockBreakable(position)) {
                    // System.out.println("second break");
                    this.setCurrentBlock(position);
                    return true;
                }

            }
        }
        return false;
    }

    private void setCurrentBlock(ExBlockPosition block) {
        this.currentBlock = this.entity.getNMSWorld().getWorld().getBlockAt(block.getX(), block.getY(), block.getZ());
        this.currentBlockType = this.currentBlock.getType();
        this.remainTime = this.currentBlock.getType().getHardness();
        this.soundDelay = 0;
    }

    private boolean isBlockBreakable(ExBlockPosition block) {
        ExIBlockData blockData = this.entity.getExWorld().getType(block);
        if (blockData.isAir() || blockData.getExMaterial().isLiquid()) {
            return false;
        }

        if (this.materials.isEmpty()) {
            return true;
        }

        if (this.materials.contains(this.entity.getNMSWorld().getWorld().getBlockAt(block.getX(), block.getY(),
                block.getZ()).getType())) {
            return true;
        }

        return false;
    }

    @Override
    public void c() {
    }

    @Override
    public boolean b() {
        this.remainTime -= this.speedModifier / 20;
        this.entity.getControllerLook().a(this.currentBlock.getX() + 0.5, this.currentBlock.getY() + 0.5,
                this.currentBlock.getZ() + 0.5);
        this.entity.getNavigation().a(this.position);
        if (this.soundDelay <= 0) {
            this.entity.swingHand(ExEnumHand.MAIN_HAND);
            this.currentBlock.getWorld().playSound(this.currentBlock.getLocation(),
                    Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 0.5F, 1F);
            this.soundDelay = 20;
        }
        this.soundDelay--;

        boolean cancel =
                !(this.currentBlock.getType().equals(this.currentBlockType) && this.entity.distanceSquared(this.currentBlock.getX() + 0.5, this.currentBlock.getY(), this.currentBlock.getZ() + 0.5) < 2.5);

        if (cancel) {
            this.currentBlock = null;
        }

        return this.remainTime > 0 && !cancel;
    }

    @Override
    public void d() {
        if (this.currentBlock != null) {
            this.currentBlock.getWorld().playEffect(this.currentBlock.getLocation(), Effect.STEP_SOUND,
                    this.currentBlock.getType());
            this.currentBlock.setType(Material.AIR);
        }

        this.remainTime = 0;
        this.soundDelay = 0;
        this.currentBlockType = null;
        this.currentBlock = null;
    }
}
