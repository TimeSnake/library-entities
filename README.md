# library-entities

## Setup

This module is part of the plugin-project [1]. You can use it as standalone project or as bundle.

### Standalone

Clone this project and enter your gitlab credentials in your gradle user home
properties (`~/.gradle/gradle.propreties`):

```
timesnakeUser=<user>
timesnakePassword=<access_token>

timesnakePluginDir=<plugins_dir>
```

Replace `<user>` with your gitlab username and `<access_token>` with an access-token.
You can optionally replace `<plugins_dir>` with a directory to export the plugin directly (therefore run the
gradle `exportAsPlugin` task).

### Bundle

To use this project in the multimodule plugin-project, read the setup guide in the root module [1].

## Testing

To test this module, you must set up a test server, therefore read regarding guide in the root module [1].


This module consists of two submodules. The generator module generates a main part of the main (
library-entities)
module. The generator is only used for generating the entity library and is not a usable library for
plugins.
The library-entities submodule provides an improved api for creating and controlling entities.

## Code Style

The code style guide can be found in the plugin root project [1].

## License

The source is licensed under the GNU GPLv2 license that can be found in the [LICENSE](LICENSE)
  file.

[1] https://git.timesnake.de/timesnake/minecraft/plugin-root-project