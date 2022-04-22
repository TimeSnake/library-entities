package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.wrapper.ExPathType;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfinderNormal;

@NmsReflection
public class ExPathfinderRavager extends ExPathfinderNormal {

    public ExPathfinderRavager() {
        super(new PathfinderRavager());
    }

    protected static class PathfinderRavager extends PathfinderNormal {
        private PathfinderRavager() {
        }

        protected PathType a(IBlockAccess iblockaccess, boolean flag, boolean flag1, BlockPosition blockposition, PathType pathtype) {
            return pathtype == ExPathType.LEAVES.getNMS() ? ExPathType.OPEN.getNMS() : super.a(iblockaccess, flag, flag1, blockposition, pathtype);
        }
    }
}
