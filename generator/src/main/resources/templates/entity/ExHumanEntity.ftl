<#include "../Header.ftl">

package ${moduleName};

<#include "../core/ExEntityImports.ftl">

import net.minecraft.world.entity.player.EntityHuman;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.entity.CraftHumanEntity;

public class ExHumanEntity extends CraftHumanEntity implements ${moduleName}.HumanEntity {

    public ExHumanEntity(EntityHuman entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

    public ExHumanEntity(CraftServer server, EntityHuman entity) {
        super(server, entity);
    }

<#include "../core/ExEntityExtension.ftl">
}
