<#include "../Header.ftl">

package ${moduleName};

<#include "ExEntityImports.ftl">
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyDamageScaler;
import net.minecraft.world.entity.EnumMobSpawn;
import net.minecraft.world.entity.GroupDataEntity;
import net.minecraft.world.level.WorldAccess;

import javax.annotation.Nullable;


@NmsReflection
public class ${entityName} extends ${craftName} implements ExtendedCraftEntity<${extensionEntity.getName()}> {

    public ${entityName}(World world, boolean loadDefaultPathfinders, boolean randomizeData) {
        super(((CraftServer) Bukkit.getServer()), new ${nmsName}(EntityTypes.${nmsTypeName},
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinders) {
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
    }

<#include "ExEntityExtension.ftl">

}