/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.Mob;
import de.timesnake.library.entities.pathfinder.ExPathfinderGoal;
import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ExCustomPathfinderGoalBreakBlock extends ExPathfinderGoal {

    public ExCustomPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget) {
        super(new CustomPathfinderGoalBreakBlock(null, speedModifier, ignoreTarget));
    }

    public ExCustomPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget, Material... materials) {
        super(new CustomPathfinderGoalBreakBlock(null, speedModifier, ignoreTarget, materials));
    }

    public ExCustomPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget,
                                            Collection<Material> materials) {
        super(new CustomPathfinderGoalBreakBlock(null, speedModifier, ignoreTarget, materials));
    }

    public ExCustomPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget, BreakEvent event,
                                            Collection<Material> materials) {
        super(new CustomPathfinderGoalBreakBlock(null, speedModifier, ignoreTarget, event, materials));
    }

    public ExCustomPathfinderGoalBreakBlock(CustomPathfinderGoalBreakBlock customPathfinderGoalBreakBlock) {
        super(customPathfinderGoalBreakBlock);
    }

    @Override
    public void injectEntity(Mob entity) {
        super.setNMSField("entity", entity);
    }

    @FunctionalInterface
    public interface BreakEvent {
        void onBlockBreak(Block block);
    }
}
