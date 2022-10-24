<#include "../Header.ftl">

package ${moduleName};

public interface ${name} extends ${extension.getExInterfaceName()}, ${bukkitName} {

<#include "IExEntityExtension.ftl">

}