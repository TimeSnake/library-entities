    private final ${extension.getExClass().getName()} extension = new ${extension.getExClass().getName()}(this) {
        @Override
        public ${exName} getExEntity() {
            return ${exName}.this;
        }
    };

    public ${extension.getExClass().getName()} getExtension() {
        return extension;
    }

    // delegation to ${extension.getExClass().getName()}

<#list extension.getMethods() as extensionMethod>
    public ${extensionMethod.getReturnType()} ${extensionMethod.getName()}(${extensionMethod.getParameterList()}) {
        <#if extensionMethod.getReturnType() != "void">return</#if> this.extension.${extensionMethod.getName()}(${extensionMethod.getParameterNameList()});
    }

</#list>