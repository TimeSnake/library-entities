<#list pathfinder.getPathfinderFields() as field>
    protected final ${field.getTypeClassName()} ${field.getName()}<#if field.hasDefaultValue()> = ${field.getDefaultValue()}</#if>;
</#list>

<#if pathfinder.getConstructorsParametersSize() != 0>
<#list pathfinder.getConstructorsParameters() as parameters>
<#assign first = true>
    public ${exName}(<#list parameters as parameter><#if !first && !parameter.hasDefaultValue()>, </#if><#if !parameter.hasDefaultValue()>${parameter.getTypeClassName()} ${parameter.getName()}<#assign first = false></#if></#list>) {
    <#list parameters as parameter>
    <#list parameter.getFieldNames() as field>
        this.${field} = ${parameter.getValue()};
    </#list>
    </#list>
    }

</#list>
<#else>
    public ${exName}() {

    }
</#if>

    @Override
    public void injectEntity(Mob entity) {
        super.pathfinderGoal = new ${name}((${pathfinder.getEntityFieldClass().getName()}) entity.getNMS()<#list pathfinder.getPathfinderFields() as field>, ${field.getName()}</#list>);
    }
