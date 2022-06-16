package de.timesnake.library.entities.entity.bukkit.extension;

import de.timesnake.library.entities.entity.bukkit.ExSheepBasis;
import de.timesnake.library.entities.entity.extension.EntityExtension;
import de.timesnake.library.entities.entity.extension.ExEntityAnimal;
import de.timesnake.library.entities.wrapper.ExEntityType;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.entity.ai.goal.PathfinderGoalEatTile;
import net.minecraft.world.entity.animal.EntitySheep;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;

@NmsReflection(usesReflection = true)
public class ExSheep extends ExSheepBasis implements EntityExtension<ExEntityAnimal> {

    public ExSheep(World world, boolean loadDefaultPathfinderGoals) {
        super(((CraftServer) Bukkit.getServer()), new EntitySheep(ExEntityType.SHEEP.getNMSType(),
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

}
