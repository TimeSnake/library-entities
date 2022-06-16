package de.timesnake.library.entities.entity.bukkit;

import de.timesnake.library.entities.entity.bukkit.ExVillagerBasis;
import de.timesnake.library.entities.wrapper.ExEntityType;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.VillagerType;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

@NmsReflection
public class ExVillager extends ExVillagerBasis {

    public ExVillager(org.bukkit.World world, Type type,
                      boolean loadDefaultPathfinders, boolean loadAI) {
        super(((CraftServer) Bukkit.getServer()), new EntityVillager(ExEntityType.VILLAGER.getNMSType(),
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

}
