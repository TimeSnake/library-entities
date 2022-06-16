package de.timesnake.library.entities.pathfinder;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class EntityConfigFile {

    public static final String ENTITIES = "entities";
    public static final String ATTRIBUTES = "attributes";
    public static final String PATHFINDERS = "pathfinders";

    protected final File configFile;
    protected final YamlConfiguration config;

    public EntityConfigFile(String path, String name) {
        this.configFile = new File(path + File.separator + name);

        if (!this.configFile.exists()) {
            try {
                this.configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }

    public void load() {
        try {
            this.config.load(this.configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            this.config.save(this.configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> getEntityIds() {
        Set<Integer> ids = new HashSet<>();

        for (String value : this.config.getConfigurationSection(ENTITIES).getKeys(false)) {
            try {
                ids.add(Integer.parseInt(value));
            } catch (NumberFormatException ignore) {
            }
        }

        return ids;
    }

    public String getEntityAttributeString(Integer id, String attribute) {
        return this.config.getString(this.getEntityAttributesPath(id) + "." + attribute);
    }

    public Integer getEntityAttributeInteger(Integer id, String attribute) {
        return this.config.getInt(this.getEntityPath(id) + "." + attribute);
    }

    public Set<String> getEntityPathfinders(Integer id) {
        return this.config.getConfigurationSection(this.getEntityPathfindersPath(id)).getKeys(false);
    }

    protected String getEntityPath(Integer id) {
        return ENTITIES + "." + id;
    }

    protected String getEntityAttributesPath(Integer id) {
        return this.getEntityPath(id) + "." + ATTRIBUTES;
    }

    protected String getEntityPathfindersPath(Integer id) {
        return this.getEntityPath(id) + "." + PATHFINDERS;
    }
}
