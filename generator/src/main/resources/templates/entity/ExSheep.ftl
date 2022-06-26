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

@NmsReflection(usesReflection = true)
public class ExSheep extends CraftSheep implements ExtendedCraftEntity<ExEntityAnimal> {

    public ExSheep(World world, boolean loadDefaultPathfinderGoals) {
        super(((CraftServer) Bukkit.getServer()), new EntitySheep(EntityTypes.aA,
                ((CraftWorld) world).getHandle()) {
            @Override
            protected void u() {
                if (loadDefaultPathfinderGoals) {
                    super.u();
                }
            }
        });

        if (!loadDefaultPathfinderGoals) {
            this.getExtension().setNMSField("cb", new PathfinderGoalEatTile(this.getExtension().getNMS()));
        }
    }

    public ExSheep(EntitySheep entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

<#include "../core/ExEntityExtension.ftl">

}
