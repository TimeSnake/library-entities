package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import de.timesnake.library.reflection.NmsReflection;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Collection;

@NmsReflection
public class ExPathfinderGoalBreakBlock extends ExPathfinderGoal {

    public ExPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget) {
        super(new PathfinderGoalBreakBlock(null, speedModifier, ignoreTarget));
    }

    public ExPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget, Material... materials) {
        super(new PathfinderGoalBreakBlock(null, speedModifier, ignoreTarget, materials));
    }

    public ExPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget, Collection<Material> materials) {
        super(new PathfinderGoalBreakBlock(null, speedModifier, ignoreTarget, materials));
    }

    public ExPathfinderGoalBreakBlock(double speedModifier, boolean ignoreTarget, BreakEvent event,
                                      Collection<Material> materials) {
        super(new PathfinderGoalBreakBlock(null, speedModifier, ignoreTarget, event, materials));
    }

    public ExPathfinderGoalBreakBlock(PathfinderGoalBreakBlock pathfinderGoalBreakBlock) {
        super(pathfinderGoalBreakBlock);
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
