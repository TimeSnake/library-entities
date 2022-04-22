package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.wrapper.ExIBlockData;
import de.timesnake.basic.entities.wrapper.ExNavigation;
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import de.timesnake.library.reflection.wrapper.ExEnumHand;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.ai.navigation.Navigation;
import net.minecraft.world.level.pathfinder.PathEntity;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;

import java.util.*;

@NmsReflection
public class PathfinderGoalBreakBlock extends PathfinderGoal implements LocationTargetable {

    private static final Integer[][] NEAR_BLOCK_VECTORS = new Integer[][]{{1, 1, 0}, {-1, 1, 0}, {0, 1, 1}, {0, 1, -1}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    private final ExEntityInsentient entity;
    private final List<Material> materials;
    private final double speedModifier;
    private final boolean ignoreTarget;

    private Double targetX;
    private Double targetY;
    private Double targetZ;

    private Block currentBlock;
    private ExBlockPosition position;
    private Material currentBlockType;
    private double remainTime;
    private int soundDelay;

    private final ExPathfinderGoalBreakBlock.BreakEvent event;

    public PathfinderGoalBreakBlock(ExEntityInsentient entity, double speedModifier, boolean ignoreTarget, Material... materials) {
        this(entity, speedModifier, ignoreTarget, null, Arrays.asList(materials));
    }

    public PathfinderGoalBreakBlock(ExEntityInsentient entity, double speedModifier, boolean ignoreTarget, Collection<Material> materials) {
        this(entity, speedModifier, ignoreTarget, null, materials);
    }

    public PathfinderGoalBreakBlock(ExEntityInsentient entity, double speedModifier, boolean ignoreTarget, ExPathfinderGoalBreakBlock.BreakEvent event, Collection<Material> materials) {
        this.entity = entity;
        this.speedModifier = speedModifier;
        this.ignoreTarget = ignoreTarget;
        this.materials = new ArrayList<>(materials);
        this.event = event;
        this.a(EnumSet.of(ExPathfinderGoal.Type.JUMP.getNMS(), ExPathfinderGoal.Type.MOVE.getNMS(), ExPathfinderGoal.Type.LOOK.getNMS()));
    }

    public List<Material> getMaterials() {
        return materials;
    }

    @Override
    public boolean a() {
        if (targetX == null || targetY == null || targetZ == null) {
            return false;
        }

        double x = this.entity.getX();
        double y = this.entity.getY();
        double z = this.entity.getZ();

        BlockPosition target = this.entity.getNavigation().h();

        if (target == null && !this.ignoreTarget) {
            return false;
        }

        ExNavigation navigation = new ExNavigation((Navigation) this.entity.getNavigation().getNMS());
        PathEntity pathEntity = navigation.k();

        if (remainTime > 0) {
            return false;
        }

        if (pathEntity != null && navigation.f()) {
            this.position = new ExBlockPosition(x, y, z);

            if (this.isBlockBreakable(this.position)) {
                this.setCurrentBlock(this.position);
                return true;
            }

            // calc look block, check reachable
            double deltaX = this.targetX - x;
            double deltaZ = this.targetZ - z;

            if (deltaX != 0) {
                if (deltaX > 0) {
                    if (this.checkBlock(x + 1, y, z)) {
                        return true;
                    }
                } else {
                    if (this.checkBlock(x - 1, y, z)) {
                        return true;
                    }
                }
            }

            if (deltaZ != 0) {
                if (deltaZ > 0) {
                    if (this.checkBlock(x, y, z + 1)) {
                        return true;
                    }
                } else {
                    if (this.checkBlock(x, y, z - 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean checkBlock(double x, double y, double z) {
        ExBlockPosition position = new ExBlockPosition(x, y, z);

        double deltaY = this.targetY - y;

        if (this.isBlockBreakable(position)) {
            this.setCurrentBlock(position);
            return true;
        }

        position = new ExBlockPosition(x, y + 1, z);

        if (this.isBlockBreakable(position)) {
            this.setCurrentBlock(position);
            return true;
        }

        if (deltaY > 0) {
            position = new ExBlockPosition(x, y + 2, z); // make stairs
        } else {
            position = new ExBlockPosition(x, y - 1, z);// make tunnel
        }

        if (this.isBlockBreakable(position)) {
            this.setCurrentBlock(position);
            return true;
        }

        return false;
    }

    private void setCurrentBlock(ExBlockPosition block) {
        this.position = block;
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

        if (this.materials.contains(this.entity.getNMSWorld().getWorld().getBlockAt(block.getX(), block.getY(), block.getZ()).getType())) {
            return true;
        }

        return false;
    }

    @Override
    public void c() {


    }

    @Override
    public boolean b() {
        boolean cancel = !(this.currentBlock.getType().equals(this.currentBlockType) || this.entity.distanceSquared(this.currentBlock.getX() + 0.5, this.currentBlock.getY(), this.currentBlock.getZ() + 0.5) > 3.5);

        if (cancel) {
            this.currentBlock = null;
        }

        if (this.remainTime <= 0 || cancel) {
            return false;
        }

        this.entity.setAggressive(true);
        this.entity.setTarget((EntityLiving) null);
        this.remainTime -= this.speedModifier / 20;
        this.entity.getControllerLook().a(this.currentBlock.getX() + 0.5, this.currentBlock.getY() + 0.5, this.currentBlock.getZ() + 0.5);
        this.entity.getNavigation().a(this.position);
        if (this.soundDelay <= 0) {
            this.entity.swingHand(ExEnumHand.MAIN_HAND);
            this.currentBlock.getWorld().playSound(this.currentBlock.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 0.5F, 1F);
            this.soundDelay = 20;
        }
        this.soundDelay--;

        return true;
    }

    @Override
    public void d() {
        if (this.currentBlock != null) {
            this.currentBlock.getWorld().playEffect(this.currentBlock.getLocation(), Effect.STEP_SOUND, this.currentBlock.getType());
            this.currentBlock.setType(Material.AIR);

            if (this.event != null) {
                this.event.onBlockBreak(this.currentBlock);
            }
        }

        this.entity.setAggressive(false);

        this.remainTime = 0;
        this.soundDelay = 0;
        this.currentBlockType = null;
        this.currentBlock = null;

        this.targetX = null;
        this.targetY = null;
        this.targetZ = null;
    }

    public void setTarget(Double x, Double y, Double z) {
        this.targetX = x;
        this.targetY = y;
        this.targetZ = z;
    }
}
