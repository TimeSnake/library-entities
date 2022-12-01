<#include "../Header.ftl">

package ${moduleName};

<#include "ExEntityImports.ftl">

public class ${exName} extends ${craftName} implements ${moduleName}.${name} {

    public ${exName}(World world) {
        super(((CraftServer) Bukkit.getServer()), new ${nmsName}(EntityTypes.${nmsTypeName}, ((CraftWorld) world).getHandle()));
    }

<#include "ExEntityExtension.ftl">

}