<#include "../Header.ftl">

package ${moduleName};

<#include "../core/ExEntityImports.ftl">

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.PathfinderGoalEatTile;
import net.minecraft.world.entity.animal.EntitySheep;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.CraftWorld;
import org.bukkit.craftbukkit.${version}.entity.CraftSheep;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyDamageScaler;
import net.minecraft.world.entity.EnumMobSpawn;
import net.minecraft.world.entity.GroupDataEntity;
import net.minecraft.world.level.WorldAccess;

import javax.annotation.Nullable;

@NmsReflection(usesReflection = true)
public class ExSheep extends CraftSheep implements ExtendedCraftEntity<ExEntityAnimal> {

    public ExSheep(World world, boolean loadDefaultPathfinderGoals, boolean randomizeData) {
        super(((CraftServer) Bukkit.getServer()), new EntitySheep(EntityTypes.aA,
                ((CraftWorld) world).getHandle()) {
            @Override
            protected void u() {
                if (loadDefaultPathfinderGoals) {
                    super.u();
                }
            }

            @Override
            public @Nullable GroupDataEntity a(WorldAccess worldaccess, DifficultyDamageScaler difficultydamagescaler, EnumMobSpawn enummobspawn, @Nullable GroupDataEntity groupdataentity, @Nullable NBTTagCompound nbttagcompound) {
                if (randomizeData) {
                    return super.a(worldaccess, difficultydamagescaler, enummobspawn, groupdataentity, nbttagcompound);
                }
                return null;
            }
        });

        if (!loadDefaultPathfinderGoals) {
            this.getExtension().setNMSField("cd", new PathfinderGoalEatTile(this.getExtension().getNMS()));
        }
    }

    public ExSheep(EntitySheep entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

<#include "../core/ExEntityExtension.ftl">

}
