# library-entities

This module consists of two submodules. The generator module generates a main part of the main (library-entities)
module. The generator is only used for generating the entity library and is not a usable library for plugins.
The library-entities submodule provides an improved api for creating and controlling entities.

## Generator

The generator builds a runnable jar file, which can be executed with the `runFinalJar` gradle task.

### Structure

**[de.timesnake.library.entities.entity.extension]**

This package contains the extensions for the abstract entity classes. The hierarchy is a mirror of the bukkit ones.
The base class [ExEntity] holds a reference to the NMS-entity.

**[de.timesnake.library.entities.wrapper]**

**[de.timesnake.library.entities.generator]**

### Production

## Library

[ExEntity]: generator/src/main/java/de/timesnake/library/entities/entity/extension/ExEntity.java

[de.timesnake.library.entities.entity.extension]: generator/src/main/java/de/timesnake/library/entities/entity/extension

[de.timesnake.library.entities.generator]: generator/src/main/java/de/timesnake/library/entities/generator

[de.timesnake.library.entities.wrapper]: generator/src/main/java/de/timesnake/library/entities/wrapper

[templates]: generator/src/main/resources/templates

## License

- The source is licensed under the GNU GPLv2 license that can be found in the [LICENSE](LICENSE) file.
