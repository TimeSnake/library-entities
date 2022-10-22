<#include "../Header.ftl">

package ${moduleName};

<#include "../core/ExEntityImports.ftl">

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.VillagerType;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.CraftWorld;
import org.bukkit.craftbukkit.${version}.entity.CraftVillager;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyDamageScaler;
import net.minecraft.world.entity.EnumMobSpawn;
import net.minecraft.world.entity.GroupDataEntity;
import net.minecraft.world.level.WorldAccess;

import javax.annotation.Nullable;

@NmsReflection
public class ExVillager extends CraftVillager implements ExtendedCraftEntity<ExEntityVillagerAbstract> {

    public ExVillager(org.bukkit.World world, Type type, boolean loadDefaultPathfinders, boolean loadAI, boolean randomizeData) {
        super(((CraftServer) Bukkit.getServer()), new EntityVillager(EntityTypes.aZ,
                ((CraftWorld) world).getHandle(), type.getNMS()) {
            @Override
            protected void u() {
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

        this.setAI(loadAI);
    }

    public ExVillager(EntityVillager entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

    public enum Type {
        DESERT(VillagerType.a),
        JUNGLE(VillagerType.b),
        PLAINS(VillagerType.c),
        SAVANNA(VillagerType.d),
        SNOW(VillagerType.e),
        SWAMP(VillagerType.f),
        TAIGA(VillagerType.g);

        private final VillagerType type;

        Type(VillagerType type) {
            this.type = type;
        }

        public VillagerType getNMS() {
            return type;
        }
    }

<#include "../core/ExEntityExtension.ftl">

}
