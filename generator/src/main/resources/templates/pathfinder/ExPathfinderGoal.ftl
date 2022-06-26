<#include "../Header.ftl">

package de.timesnake.library.entities.pathfinder;

<#assign exName = pathfinder.getExName()>
<#assign name = pathfinder.getName()>

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import net.minecraft.world.entity.ai.goal.${name};

import java.lang.reflect.Field;
import java.util.Optional;

public class ${exName} extends ExPathfinderGoal {

<#include "PathfinderObject.ftl">

}
