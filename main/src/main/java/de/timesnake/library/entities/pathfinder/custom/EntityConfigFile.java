/*
 * library-entities.library-entities.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

package de.timesnake.library.entities.pathfinder.custom;

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
