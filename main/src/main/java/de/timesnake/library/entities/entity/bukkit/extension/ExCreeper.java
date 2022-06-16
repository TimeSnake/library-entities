package de.timesnake.library.entities.entity.bukkit.extension;

import de.timesnake.library.entities.entity.bukkit.ExCreeperBasis;
import de.timesnake.library.entities.wrapper.ExEntityType;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.monster.EntityCreeper;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

@NmsReflection
public class ExCreeper extends ExCreeperBasis {

    public ExCreeper(World world, boolean loadDefaultPathfinderGoals) {
        super(((CraftServer) Bukkit.getServer()), new EntityCreeper(ExEntityType.CREEPER.getNMSType(),
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinderGoals) {
                    super.u();
                }
            }
        });
    }

    public ExCreeper(EntityCreeper entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

    public int q() {
        return ((EntityCreeper) this.getNMS()).q();
    }

    public void a(int i) {
        ((EntityCreeper) this.getNMS()).a(i);
    }

    public int eK() {
        return ((EntityCreeper) this.getNMS()).q();
    }

}
