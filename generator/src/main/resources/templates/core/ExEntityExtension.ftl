    private final ${extensionEntity.getName()} extension = new ${extensionEntity.getName()}(this);

    public ${extensionEntity.getName()} getExtension() {
        return extension;
    }

    // delegation to ${extensionEntity.getName()}

<#list extensionEntity.getMethods() as extensionMethod>
    public ${extensionMethod.getReturnType()} ${extensionMethod.getName()}(${extensionMethod.getParameterList()}) {
        <#if extensionMethod.getReturnType() != "void">return</#if> this.extension.${extensionMethod.getName()}(${extensionMethod.getParameterNameList()});
    }

</#list>