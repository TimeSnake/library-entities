<#include "../Header.ftl">

package ${moduleName};

public interface ${name} extends <#if superInterface.isPresent()>${superInterface.get()}, </#if>${bukkitInterface.getName()} {

    Class<${nmsClass.getName()}> NMS_CLASS = ${nmsClass.getName()}.class;

<#list methods as extensionMethod>
    ${extensionMethod.getReturnType()} ${extensionMethod.getName()}(${extensionMethod.getParameterList()});

</#list>
}
