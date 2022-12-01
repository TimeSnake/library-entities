<#include "../Header.ftl">

package ${moduleName};

<#include "ExEntityImports.ftl">

public class ${entityName} extends ${craftName} implements ExtendedCraftEntity<${extensionEntity.getName()}> {

    public ${entityName}(World world, boolean loadDefaultPathfinders) {
        super(((CraftServer) Bukkit.getServer()), new ${nmsName}(EntityTypes.${nmsTypeName},
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinders) {
                    super.u();
                }
            }
        });
    }

<#include "ExEntityExtension.ftl">

}