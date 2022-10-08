/*
 * library-entities.generator.main
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

package de.timesnake.library.entities.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import net.minecraft.world.entity.EntityInsentient;
import org.apache.commons.io.FileUtils;
import org.bukkit.entity.Entity;

import java.io.*;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EntityGenerator implements EntitiesGenerator {

    public static final String ENTITY_MODULE = "de.timesnake.library.entities.entity";
    public static final String EXTENSION_MODULE = "de.timesnake.library.entities.entity.extension";
    public static final String ENTITY_TEMPLATE_DIR = "templates/entity";
    public static final String DEST_ENTITY_DIR = "bukkit";
    public static final String DEST_EXTENSION_DIR = "extension";

    private final Configuration cfg;

    private final String entitySrcDir;
    private final String entityOutputDir;
    private final String entityOutputModule;

    public EntityGenerator(Configuration cfg, String entitySrcDir, String entityOutputDir, String entityOutputModule) {
        this.cfg = cfg;
        this.entityOutputDir = entityOutputDir;
        this.entityOutputModule = entityOutputModule;
        this.entitySrcDir = entitySrcDir;
    }

    public boolean clean() {
        if (new File(entityOutputDir).exists()) {
            for (File file : new File(entityOutputDir).listFiles()) {
                if (file.isDirectory()) {
                    try {
                        FileUtils.deleteDirectory(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    file.delete();
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate() {
        try {
            File outputEntityDirFile = new File(entityOutputDir + File.separator + DEST_ENTITY_DIR);

            if (!outputEntityDirFile.exists()) {
                Files.createDirectories(outputEntityDirFile.toPath());
            }

            this.copyEntityExtensions();
            this.copyEntityExtras();
            LinkedList<GenerateEntityType<?>> generatedTypes = this.generateExEntities();
            this.generateEntityTypes(generatedTypes);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private void copyEntityExtensions() throws IOException {
        File src = new File(entitySrcDir + File.separator + DEST_EXTENSION_DIR);
        File dest = new File(entityOutputDir + File.separator + DEST_EXTENSION_DIR);

        FileUtils.copyDirectory(src, dest);
    }

    private void copyEntityExtras() throws IOException {

        List<String> files = List.of("ExAbstractEntityType.java", "ExtendedCraftEntity.java", "ExtendedEntity.java");

        File src = new File(entitySrcDir);
        File dest = new File(entityOutputDir);

        for (File file : src.listFiles(f -> f.isFile() && files.contains(f.getName()))) {
            FileUtils.copyFile(file, new File(dest.getAbsolutePath() + File.separator + file.getName()));
        }
    }

    public LinkedList<GenerateEntityType<?>> generateExEntities() throws TemplateException,
            IOException {

        LinkedList<GenerateEntityType<?>> generatedTypes = new LinkedList<>();

        for (GenerateEntityType<?> generateEntityType : GenerateEntityType.TYPES) {
            Class<? extends Entity> bukkitClass = generateEntityType.getBukkitClass();

            if (Modifier.isFinal(bukkitClass.getModifiers())) {
                System.out.println("Skipped " + generateEntityType.getName() + ", craft bukkit class is final");
                continue;
            }

            Class<? extends net.minecraft.world.entity.Entity> nmsClass = generateEntityType.getNmsClass();
            generateExEntity(generateEntityType.getName(), generateEntityType.getNmsTypeName(), bukkitClass,
                    nmsClass);

            generatedTypes.add(generateEntityType);
        }

        return generatedTypes;
    }

    public void generateExEntity(String name, String nmsType, Class<? extends Entity> bukkitClass,
                                 Class<? extends net.minecraft.world.entity.Entity> nmsClass) throws IOException,
            TemplateException {

        String entityClassName = "Ex" + name;

        // search extension class
        Class<?> extensionClass = null;
        try {
            extensionClass = Class.forName(EXTENSION_MODULE + ".Ex" + nmsClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            Class<?> superNmsClass = nmsClass.getSuperclass();
            do {
                try {
                    extensionClass = Class.forName(EXTENSION_MODULE + ".Ex" + superNmsClass.getSimpleName());
                } catch (ClassNotFoundException ignored) {
                }

                superNmsClass = superNmsClass.getSuperclass();
            } while (extensionClass == null);

        }

        NmsExtensionBasis extension = new NmsExtensionBasis(extensionClass, bukkitClass);

        // search template

        Template temp = null;

        try {
            temp = cfg.getTemplate(ENTITY_TEMPLATE_DIR + File.separator + entityClassName + ".ftl");
        } catch (TemplateNotFoundException ignored) {

        }

        if (temp == null) {
            if (EntityInsentient.class.isAssignableFrom(nmsClass)) {
                temp = cfg.getTemplate("templates/core/ExEntityInsentient.ftl");
            } else {
                temp = cfg.getTemplate("templates/core/ExEntity.ftl");
            }
        }

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", entityOutputModule + "." + DEST_ENTITY_DIR);
        root.put("entityModuleName", ENTITY_MODULE);
        root.put("extensionModuleName", EXTENSION_MODULE);
        root.put("wrapperModuleName", WrapperGenerator.WRAPPER_MODULE);
        root.put("version", LibraryEntityGenerator.VERSION);
        root.put("craftName", bukkitClass.getName());
        root.put("entityName", entityClassName);
        root.put("nmsName", nmsClass.getName());
        root.put("nmsTypeName", nmsType);
        root.put("extensionEntity", extension);


        Writer out =
                new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator + DEST_ENTITY_DIR + File.separator + entityClassName + ".java"));
        temp.process(root, out);
        out.close();
    }

    public void generateEntityTypes(List<GenerateEntityType<?>> types) throws IOException,
            TemplateException {
        Template temp = cfg.getTemplate("templates/ExEntityType.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", entityOutputModule);
        root.put("entityModuleName", ENTITY_MODULE);
        root.put("extensionModuleName", EXTENSION_MODULE);
        root.put("entities", types);

        Writer out = new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator + "ExEntityType" +
                ".java"));
        temp.process(root, out);
        out.close();
    }
}
