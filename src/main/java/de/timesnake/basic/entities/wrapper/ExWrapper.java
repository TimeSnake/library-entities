package de.timesnake.basic.entities.wrapper;

import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.Position;
import net.minecraft.world.entity.ai.navigation.NavigationAbstract;
import net.minecraft.world.level.pathfinder.PathEntity;
import net.minecraft.world.level.pathfinder.PathPoint;

@NmsReflection
public class ExWrapper {

    public static ExNavigationAbstract wrapNavigationAbstract(NavigationAbstract navigationAbstract) {
        if (navigationAbstract == null) {
            return null;
        }
        return new ExNavigationAbstract(navigationAbstract);
    }

    public static ExPathEntity wrapPathEntity(PathEntity pathEntity) {
        if (pathEntity == null) {
            return null;
        }
        return new ExPathEntity(pathEntity);
    }

    public static ExPathPoint wrapPathPoint(PathPoint pathPoint) {
        if (pathPoint == null) {
            return null;
        }
        return new ExPathPoint(pathPoint);
    }

    public static Position getPosition(double x, double y, double z) {
        return new Position(x, y, z);
    }

    public static ExBlockPosition wrapBlockPosition(BlockPosition position) {
        if (position == null) {
            return null;
        }
        return new ExBlockPosition(position);
    }
}
