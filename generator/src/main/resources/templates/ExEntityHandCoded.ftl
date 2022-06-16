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
public abstract class ${entityName} extends ${craftName} implements EntityExtension<${extensionEntity.getName()}> {

    private final ${extensionEntity.getName()} extension = new ${extensionEntity.getName()}(this);

    public ${entityName}(${nmsName} entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

        public ${entityName}(CraftServer server, ${nmsName} entity) {
            super(server, entity);
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