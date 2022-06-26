package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Collection;

@NmsReflection
public class ExCustomPathfinderGoalBreakBlock extends ExCustomPathfinderGoal {

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
    public void injectEntity(ExEntityInsentient entity) {
        super.setNMSField("entity", entity);
    }

    @FunctionalInterface
    public interface BreakEvent {
        void onBlockBreak(Block block);
    }
}
