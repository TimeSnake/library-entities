<#include "../Header.ftl">

package ${moduleName};

<#include "ExEntityImports.ftl">

public class ${entityName} extends ${craftName} implements ExtendedCraftEntity<${extensionEntity.getName()}> {

    public ${entityName}(World world) {
        super(((CraftServer) Bukkit.getServer()), new ${nmsName}(EntityTypes.${nmsTypeName}, ((CraftWorld) world).getHandle()));
    }

<#include "ExEntityExtension.ftl">

}