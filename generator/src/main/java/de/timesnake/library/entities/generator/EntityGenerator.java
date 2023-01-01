/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.generator;

import de.timesnake.library.entities.entity.extension.ExEntity;
import de.timesnake.library.entities.entity.extension.ExEntityHuman;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.world.entity.EntityInsentient;
import org.apache.commons.io.FileUtils;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;

public class EntityGenerator implements EntitiesGenerator {

    public static final String ENTITY_MODULE = "de.timesnake.library.entities.entity";
    public static final String EXTENSION_CLASS_MODULE = "de.timesnake.library.entities.entity.extension";
    public static final String EXTENSION_INTERFACE_MODULE = "de.timesnake.library.entities.entity.extension";
    public static final String ENTITY_TEMPLATE_DIR = "templates/entity";
    public static final String DEST_ENTITY_DIR = "bukkit";
    public static final String DEST_EXTENSION_INTERFACE_DIR = "extension";
    public static final String DEST_EXTENSION_DIR = "extension";
    public static final String DEST_TYPE_DIR = "type";

    private final Configuration cfg;

    private final String entitySrcDir;
    private final String entityOutputDir;
    private final String entityOutputModule;

    private final Map<Class<?>, String> interfaceNameByAbstractEntityClass = new HashMap<>();

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
            this.copyEntityTypes();
            this.generateExAbstractEntityInterfaces();
            // generate entity classes
            LinkedList<Generator_Entity<?, ?>> generatedTypes = this.generateExEntities();
            // generate types for generated classes
            this.generateEntityTypes(generatedTypes);
            this.generatePlayerExtension();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private void generatePlayerExtension() throws IOException, TemplateException {
        Template temp = cfg.getTemplate("templates/ExPlayer.ftl");

        Generator_NmsExtension extension = new Generator_NmsExtension(ExEntityHuman.class,
                EXTENSION_INTERFACE_MODULE + "." + HumanEntity.class.getSimpleName(), CraftPlayer.class);

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", entityOutputModule + "." + EntityGenerator.DEST_ENTITY_DIR);
        root.put("entityModuleName", entityOutputModule);
        root.put("extensionModuleName", EntityGenerator.EXTENSION_CLASS_MODULE);
        root.put("version", LibraryEntityGenerator.VERSION);
        root.put("wrapperModuleName", WrapperGenerator.WRAPPER_MODULE);
        root.put("craftName", CraftPlayer.class.getName());
        root.put("extension", extension);
        root.put("exName", "ExPlayer");

        Writer out = new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator +
                EntityGenerator.DEST_ENTITY_DIR + File.separator + "ExPlayer.java"));
        temp.process(root, out);
        out.close();
    }

    private void generateExAbstractEntityInterfaces() throws TemplateException, IOException {
        File outputEntityDirFile = new File(entityOutputDir + File.separator + DEST_EXTENSION_INTERFACE_DIR);

        if (!outputEntityDirFile.exists()) {
            Files.createDirectories(outputEntityDirFile.toPath());
        }

        // generate for each abstract entity type
        for (Generator_ExAbstractEntityType<?> type : Generator_ExAbstractEntityType.ABSTRACT_TYPES) {
            String interfaceName = generateExAbstractEntityInterface(type);
            this.interfaceNameByAbstractEntityClass.put(type.getExClass(), interfaceName);
        }
    }

    private String generateExAbstractEntityInterface(Generator_ExAbstractEntityType<?> type) throws TemplateException, IOException {
        Class<? extends net.minecraft.world.entity.Entity> nmsClass = type.getNMSClass();
        Class<? extends ExEntity> exClass = type.getExClass();
        Class<? extends Entity> bukkitInterface = type.getBukkitInterface();
        String name = bukkitInterface.getSimpleName();

        String superInterfaceName = null;
        Class<?> superExClass = exClass.getSuperclass();

        while (superInterfaceName == null && ExEntity.class.isAssignableFrom(superExClass)) {
            Generator_ExAbstractEntityType<?> superType = Generator_ExAbstractEntityType.getByExClass(((Class<? extends ExEntity>) superExClass));
            if (superType != null) {
                superInterfaceName = EXTENSION_INTERFACE_MODULE + "." + superType.getBukkitInterface().getSimpleName();
            } else {
                superExClass = superExClass.getSuperclass();
            }
        }

        // fallback super interface
        if (superInterfaceName == null && !exClass.equals(ExEntity.class)) {
            superInterfaceName = EXTENSION_INTERFACE_MODULE + "." +
                    Generator_ExAbstractEntityType.getByExClass(ExEntity.class).getBukkitInterface().getSimpleName();
        }


        // get methods from extension class
        Map<Integer, Generator_Method> methodsByHash = new LinkedHashMap<>();

        for (Method method : exClass.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }

            Generator_Method extensionMethod = new Generator_Method(method);
            int hashCode = extensionMethod.hashCode();
            // if method is already parsed, check for return type, else skip
            if (!methodsByHash.containsKey(hashCode)) {
                methodsByHash.put(hashCode, extensionMethod);
            } else {
                Generator_Method existingMethod = methodsByHash.get(hashCode);
                // check if return type is more specific
                if (existingMethod.getMethod().getReturnType().isAssignableFrom(method.getReturnType())) {
                    methodsByHash.put(hashCode, extensionMethod);
                }
            }
        }

        // generate interface via template
        Template interfaceTemplate = cfg.getTemplate("templates/core/AbstractEntityInterface.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", EXTENSION_INTERFACE_MODULE);
        root.put("name", name);
        root.put("bukkitInterface", bukkitInterface);
        root.put("nmsClass", nmsClass);
        root.put("methods", methodsByHash.values());
        root.put("superInterface", Optional.ofNullable(superInterfaceName));

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator +
                DEST_EXTENSION_INTERFACE_DIR + File.separator + name + ".java"));
        interfaceTemplate.process(root, out);
        out.close();

        return EXTENSION_INTERFACE_MODULE + "." + name;
    }

    private void copyEntityExtensions() throws IOException {
        File src = new File(entitySrcDir + File.separator + DEST_EXTENSION_DIR);
        File dest = new File(entityOutputDir + File.separator + DEST_EXTENSION_DIR);

        FileUtils.copyDirectory(src, dest);
    }

    private void copyEntityTypes() throws IOException {

        List<String> files = List.of("ExAbstractEntityType.java", "ExtendedEntity.java", "EntityMapper.java");

        File src = new File(entitySrcDir + File.separator + DEST_TYPE_DIR);
        File dest = new File(entityOutputDir + File.separator + DEST_TYPE_DIR);

        for (File file : src.listFiles(f -> f.isFile() && files.contains(f.getName()))) {
            FileUtils.copyFile(file, new File(dest.getAbsolutePath() + File.separator + file.getName()));
        }
    }


    public LinkedList<Generator_Entity<?, ?>> generateExEntities() throws TemplateException,
            IOException {

        LinkedList<Generator_Entity<?, ?>> generatedTypes = new LinkedList<>();

        // generate entities based on generator entity class
        for (Generator_Entity<?, ?> generatorEntity : Generator_Entity.TYPES) {
            Class<? extends Entity> bukkitClass = generatorEntity.getBukkitClass();

            if (Modifier.isFinal(bukkitClass.getModifiers())) {
                LibraryEntityGenerator.LOGGER.info("Skipped " + generatorEntity.getName() + ", craft bukkit class is final");
                continue;
            }

            generateExEntity(generatorEntity);

            generatedTypes.add(generatorEntity);
        }

        return generatedTypes;
    }

    public void generateExEntity(Generator_Entity<?, ?> generatorEntity) throws IOException,
            TemplateException {

        String simpleName = generatorEntity.getName();
        String exName = "Ex" + simpleName;
        Class<? extends net.minecraft.world.entity.Entity> nmsClass = generatorEntity.getNmsClass();
        Class<? extends CraftEntity> bukkitClass = generatorEntity.getBukkitClass();
        Class<? extends Entity> bukkitInterface = generatorEntity.getBukkitInterface();

        // search extension class
        Class<? extends ExEntity> exClass = null;
        try {
            exClass = (Class<? extends ExEntity>) Class.forName(EXTENSION_CLASS_MODULE + ".Ex" + nmsClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            Class<?> superNmsClass = nmsClass.getSuperclass();
            do {
                try {
                    exClass = (Class<? extends ExEntity>) Class.forName(EXTENSION_CLASS_MODULE + ".Ex" + superNmsClass.getSimpleName());
                } catch (ClassNotFoundException ignored) {
                }

                superNmsClass = superNmsClass.getSuperclass();
            } while (exClass == null);
        }

        String superExInterfaceName = this.interfaceNameByAbstractEntityClass.get(exClass);

        if (superExInterfaceName == null) {
            LibraryEntityGenerator.LOGGER.warning("Could not find super interface '" + superExInterfaceName + "' for entity '" + simpleName + "'");
            return;
        }

        // collect extension stuff, like methods
        Generator_NmsExtension extension = new Generator_NmsExtension(exClass, superExInterfaceName, bukkitClass);

        // search template

        Template classTemplate = null;
        Template interfaceTemplate = null;

        try {
            classTemplate = cfg.getTemplate(ENTITY_TEMPLATE_DIR + File.separator + exName + ".ftl");
            interfaceTemplate = cfg.getTemplate(ENTITY_TEMPLATE_DIR + File.separator + "I" + exName + ".ftl");
        } catch (TemplateNotFoundException ignored) {

        }

        // use fallback template
        if (classTemplate == null) {
            if (EntityInsentient.class.isAssignableFrom(nmsClass)) {
                classTemplate = cfg.getTemplate("templates/core/ExEntityInsentient.ftl");
            } else {
                classTemplate = cfg.getTemplate("templates/core/ExEntity.ftl");
            }
        }

        // use fallback interface template
        if (interfaceTemplate == null) {
            if (EntityInsentient.class.isAssignableFrom(nmsClass)) {
                interfaceTemplate = cfg.getTemplate("templates/core/IExEntityInsentient.ftl");
            } else {
                interfaceTemplate = cfg.getTemplate("templates/core/IExEntity.ftl");
            }
        }

        // generate class and interface via templates
        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", entityOutputModule + "." + DEST_ENTITY_DIR);
        root.put("entityModuleName", ENTITY_MODULE);
        root.put("extensionModuleName", EXTENSION_CLASS_MODULE);
        root.put("wrapperModuleName", WrapperGenerator.WRAPPER_MODULE);
        root.put("version", LibraryEntityGenerator.VERSION);
        root.put("craftName", bukkitClass.getName());
        root.put("bukkitName", bukkitInterface.getName());
        root.put("exName", exName);
        root.put("name", simpleName);
        root.put("nmsName", nmsClass.getName());
        root.put("nmsTypeName", generatorEntity.getNmsTypeName());
        root.put("extension", extension);


        Writer out = new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator +
                DEST_ENTITY_DIR + File.separator + exName + ".java"));
        classTemplate.process(root, out);
        out.close();

        out = new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator +
                DEST_ENTITY_DIR + File.separator + simpleName + ".java"));
        interfaceTemplate.process(root, out);
        out.close();

        LibraryEntityGenerator.LOGGER.info("Generated classes for entity '" + simpleName + "'");
    }

    public void generateEntityTypes(List<Generator_Entity<?, ?>> types) throws IOException,
            TemplateException {
        Template temp = cfg.getTemplate("templates/ExEntityType.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", entityOutputModule + "." + DEST_TYPE_DIR);
        root.put("entityModuleName", ENTITY_MODULE);
        root.put("extensionModuleName", EXTENSION_CLASS_MODULE);
        root.put("entities", types);

        Writer out = new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator + DEST_TYPE_DIR
                + File.separator + "ExEntityType.java"));
        temp.process(root, out);
        out.close();

        LibraryEntityGenerator.LOGGER.info("Generated entity type class");
    }

}
