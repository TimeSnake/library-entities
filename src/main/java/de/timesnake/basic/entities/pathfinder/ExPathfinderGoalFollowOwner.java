package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import de.timesnake.basic.entities.entity.extension.ExEntityLiving;
import de.timesnake.basic.entities.entity.extension.ExEntityTameableAnimal;
import de.timesnake.basic.entities.wrapper.ExIBlockData;
import de.timesnake.basic.entities.wrapper.ExNavigationAbstract;
import de.timesnake.basic.entities.wrapper.ExPathType;
import de.timesnake.basic.entities.wrapper.ExWorldServer;
import de.timesnake.library.reflection.wrapper.ExBlockPosition;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.level.block.BlockLeaves;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfinderNormal;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.event.entity.EntityTeleportEvent;

import java.util.EnumSet;

public class ExPathfinderGoalFollowOwner extends ExPathfinderGoal {

    public ExPathfinderGoalFollowOwner(double speed, float distance, float cancelDistance, boolean teleportOnLeaves) {
        super(new PathfinderGoalFollowOwner(null, speed, distance, cancelDistance, teleportOnLeaves));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        ((PathfinderGoalFollowOwner) super.getNMS()).inject(((ExEntityTameableAnimal) entity));
    }

    public static class PathfinderGoalFollowOwner extends PathfinderGoal {
        private ExEntityTameableAnimal entity;
        private ExEntityLiving owner;
        private ExWorldServer worldReader;
        private final double speed;
        private ExNavigationAbstract navigation;
        private int f;
        private final float cancelDistance;
        private final float distance;
        private float i;
        private final boolean teleportOnLeaves;

        public PathfinderGoalFollowOwner(ExEntityTameableAnimal entitytameableanimal, double speed, float distance, float cancelDistance, boolean teleportOnLeaves) {
            this.entity = entitytameableanimal;
            this.speed = speed;
            this.distance = distance;
            this.cancelDistance = cancelDistance;
            this.teleportOnLeaves = teleportOnLeaves;
            this.a(EnumSet.of(ExPathfinderGoal.Type.MOVE.getNMS(), ExPathfinderGoal.Type.LOOK.getNMS()));
        }

        public void inject(ExEntityTameableAnimal entityTameableAnimal) {
            this.entity = entityTameableAnimal;
            this.worldReader = entityTameableAnimal.getExWorld();
            this.navigation = this.entity.getNavigation();
        }

        public boolean a() {
            EntityLiving entitylive = this.entity.getOwner();
            if (entitylive == null) {
                return false;
            }

            ExEntityLiving entityliving = new ExEntityLiving(entitylive);

            if (entityliving.isSpectator()) {
                return false;
            } else if (this.entity.isWillSit()) {
                return false;
            } else if (this.entity.distanceSquared(entityliving) < (double) (this.distance * this.distance)) {
                return false;
            } else {
                this.owner = entityliving;
                return true;
            }
        }

        public boolean b() {
            return !this.navigation.m() && (!this.entity.isWillSit() && this.entity.distanceSquared(this.owner) > (double) (this.cancelDistance * this.cancelDistance));
        }

        public void c() {
            this.f = 0;
            this.i = this.entity.a(ExPathType.WATER);
            this.entity.a(ExPathType.WATER, 0.0F);
        }

        public void d() {
            this.owner = null;
            this.navigation.o();
            this.entity.a(ExPathType.WATER, this.i);
        }

        public void e() {
            this.entity.getControllerLook().a(this.owner, 10.0F, (float) this.entity.O());
            if (--this.f <= 0) {
                this.f = 10;
                if (!this.entity.isLeashed() && !this.entity.isPassenger()) {
                    if (this.entity.distanceSquared(this.owner) >= 144.0D) {
                        this.g();
                    } else {
                        this.navigation.walkTo(this.owner, this.speed);
                    }
                }
            }

        }

        private void g() {
            ExBlockPosition blockposition = this.owner.getExChunkCoordinates();

            for (int i = 0; i < 10; ++i) {
                int j = this.a(-3, 3);
                int k = this.a(-1, 1);
                int l = this.a(-3, 3);
                boolean flag = this.a(blockposition.getX() + j, blockposition.getY() + k, blockposition.getZ() + l);
                if (flag) {
                    return;
                }
            }

        }

        private boolean a(int i, int j, int k) {
            if (Math.abs((double) i - this.owner.getX()) < 2.0D && Math.abs((double) k - this.owner.getZ()) < 2.0D) {
                return false;
            } else if (!this.a(new ExBlockPosition(i, j, k))) {
                return false;
            } else {
                CraftEntity entity = this.entity.getBukkitEntity();
                Location to = new Location(entity.getWorld(), (double) i + 0.5D, j, (double) k + 0.5D, this.entity.getYaw(), this.entity.getPitch());
                EntityTeleportEvent event = new EntityTeleportEvent(entity, entity.getLocation(), to);
                this.entity.getExWorld().getServer().getPluginManager().callEvent(event);
                if (event.isCancelled()) {
                    return false;
                } else {
                    to = event.getTo();
                    this.entity.setPositionRotation(to.getX(), to.getY(), to.getZ(), to.getYaw(), to.getPitch());
                    this.navigation.o();
                    return true;
                }
            }
        }

        private boolean a(ExBlockPosition blockposition) {
            PathType pathtype = PathfinderNormal.a(this.worldReader.getNMS(), blockposition.i());
            if (pathtype != ExPathType.WALKABLE.getNMS()) {
                return false;
            } else {
                ExIBlockData iblockdata = this.worldReader.getType(blockposition.exdown());
                if (!this.teleportOnLeaves && iblockdata.getBlock() instanceof BlockLeaves) {
                    return false;
                } else {
                    BlockPosition blockposition1 = blockposition.b(this.entity.getChunkCoordinates());
                    return this.worldReader.getCubes(this.entity.getNMS(), this.entity.getExBoundingBox().a(blockposition1));
                }
            }
        }

        private int a(int i, int j) {
            return this.entity.getRandom().nextInt(j - i + 1) + i;
        }
    }

}
