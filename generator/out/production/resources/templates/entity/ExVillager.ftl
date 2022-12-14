<#include "../Header.ftl">

package ${moduleName};

<#include "../core/ExEntityImports.ftl">

import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.VillagerType;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.CraftWorld;
import org.bukkit.craftbukkit.${version}.entity.CraftVillager;

public class ExVillager extends CraftVillager implements ExtendedCraftEntity<ExEntityVillagerAbstract> {

    public ExVillager(org.bukkit.World world, Type type,
                      boolean loadDefaultPathfinders, boolean loadAI) {
        super(((CraftServer) Bukkit.getServer()), new EntityVillager(EntityTypes.aZ,
                ((CraftWorld) world).getHandle(), type.getNMS()) {
            @Override
            protected void u() {
                if (loadDefaultPathfinders) {
                    super.u();
                }
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
