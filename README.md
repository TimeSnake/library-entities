# library-entities

This module is part of the plugin-project and won't run without
the [root module](https://git.timesnake.de/timesnake/plugin-root-project) [1].

---

This module consists of two submodules. The generator module generates a main part of the main (
library-entities)
module. The generator is only used for generating the entity library and is not a usable library for
plugins.
The library-entities submodule provides an improved api for creating and controlling entities.

## Library

The library-entities allows creating custom entities, like mobs or players.
For each minecraft/bukkit entity exists a wrapper class called `Ex{EntityName}`. These extended
classes are inheriting
their corresponding craft-bukkit class. Furthermore, they are abstracted by an interface (
named `{EntityName}`) which
combines the corresponding bukkit entity interface and the extended class of their superclass. The
extended superclasses
contains methods to access attributes and methods of the minecraft entity class. The corresponding
extended superclass
of
an entity can be accessed by invoking the `getExtension()` method. All extension method can also be
directly called on
the entity class, due to delegation.

The following example show the class structure of the zombie entity.

``` java
public class ExZombie extends org.bukkit.craftbukkit.v1_19_R1.entity.CraftZombie 
        implements de.timesnake.library.entities.entity.bukkit.Zombie {

    private final ExEntityMonster extension = new ExEntityMonster(this) {
        @Override
        public ExZombie getExEntity() {
            return ExZombie.this;
        }
    };

    public ExZombie(World world, boolean loadDefaultPathfinders, boolean randomizeData) {
        super(((CraftServer) Bukkit.getServer()), new EntityZombie(EntityTypes.bj,
                ((CraftWorld) world).getHandle()) { ... });
    }

    public ExEntityMonster getExtension() {
        return extension;
    }
    
    ...
}
```

To create an extended entity, use the given constructors in the entity class.
The `defaultPathfinderGoals`
and `randomizeData` attributes of mob-entities (like monsters and animals) determines if the default
pathfinders should
be loaded and if the entity data should be randomized.
After created a mob-entity, you can add predefined or custom pathfinder goals.

The following example shows, how to create a zombie with own pathfinder goals.

``` java

//                           load default pathfinders
// create a new entity                  |
ExZombie zombie = new ExZombie(world, false, false);
//                                             |
//                                      randomize data

// add pathfinder goals
zombie.addPathfinderGoal(1, new ExPathfinderGoalZombieAttack(speed, false));
//                       |                      |
//                    priority              pathfinder

zombie.addPathfinderGoal(3, new ExPathfinderGoalRandomStrollLand(speed));
zombie.addPathfinderGoal(5, new ExPathfinderGoalLookAtPlayer(HumanEntity.class, 8.0F));
zombie.addPathfinderGoal(5, new ExPathfinderGoalRandomLookaround());

// add target pathfinder goals, determines which entity will be attacked
zombie.addPathfinderGoal(1, new ExPathfinderGoalHurtByTarget(Monster.class));
zombie.addPathfinderGoal(3, new ExCustomPathfinderGoalNearestAttackableTarget(HumanEntity.class, true, true, 1D));

// set custom health
zombie.setMaxHealth(40);
zombie.setHealth(40);

// set custom attack damage
zombie.getBukkitAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10);

```

## Generator

The generator builds a runnable jar file, which can be executed with the `runFinalJar` gradle task.
The task generates all entities and pathfinder goals in the library-entities module. Furthermore,
the wrapper classes
are being copied to the library module.

### Structure

**[de.timesnake.library.entities.entity.extension]**

This package contains the extensions for the abstract entity classes. The hierarchy is a mirror of
the bukkit ones.
The base class [ExEntity] holds a reference to the NMS-entity.

**[de.timesnake.library.entities.wrapper]**

This package contains wrappers for some NMS classes. This allows an easier use of these classes.

**[de.timesnake.library.entities.generator]**

This package contains all information about the generation of the entities and pathfinder goals.

### Production

[ExEntity]: generator/src/main/java/de/timesnake/library/entities/entity/extension/ExEntity.java

[de.timesnake.library.entities.entity.extension]: generator/src/main/java/de/timesnake/library/entities/entity/extension

[de.timesnake.library.entities.generator]: generator/src/main/java/de/timesnake/library/entities/generator

[de.timesnake.library.entities.wrapper]: generator/src/main/java/de/timesnake/library/entities/wrapper

[templates]: generator/src/main/resources/templates

---

## Code Style

The code style guide can be found in the plugin root project [1].

## License

- The source is licensed under the GNU GPLv2 license that can be found in the [LICENSE](LICENSE)
  file.

[1] https://git.timesnake.de/timesnake/plugin-root-project