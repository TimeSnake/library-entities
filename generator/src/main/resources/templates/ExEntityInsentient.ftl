package ${moduleName};

import ${extensionModuleName}.EntityExtension;
import ${extensionModuleName}.${extensionEntity.getName()};
import ${nmsName};
import de.timesnake.library.reflection.NmsReflection;
import de.timesnake.library.entities.wrapper.*;
import de.timesnake.library.reflection.wrapper.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.CraftWorld;

import net.minecraft.world.entity.EntityTypes;

import java.util.*;

@NmsReflection
public class ${entityName} extends ${craftName} implements EntityExtension<${extensionEntity.getName()}> {

    private final ${extensionEntity.getName()} extension = new ${extensionEntity.getName()}(this);

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

    public ${extensionEntity.getName()} getExtension() {
        return extension;
    }

    // delegation to ${extensionEntity.getName()}

<#list extensionEntity.getMethods() as extensionMethod>
    public ${extensionMethod.getReturnType()} ${extensionMethod.getName()}(${extensionMethod.getParameterList()}) {
        <#if extensionMethod.getReturnType() != "void">return</#if> this.extension.${extensionMethod.getName()}(${extensionMethod.getParameterNameList()});
    }

</#list>
}