package de.timesnake.library.entities;

import freemarker.template.*;
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

public class LibraryEntityGenerator {

    public static void main(String[] args) throws IOException, TemplateException, ClassNotFoundException {
        new LibraryEntityGenerator().generate(args);
    }

    public static void modifyFile(File fileToBeModified, File result, String oldString, String newString) {
        StringBuilder oldContent = new StringBuilder();

        BufferedReader reader = null;

        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            String line = reader.readLine();

            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }


            String newContent = oldContent.toString().replaceFirst(oldString, newString);

            writer = new FileWriter(result);

            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private final String extensionModule = "de.timesnake.library.entities.entity.extension";
    private final String wrapperModule = "de.timesnake.library.entities.wrapper";
    private final String version = "v1_19_R1";
    private final String entityTemplateDir = "templates/entities";
    private final String outputEntityDir = "bukkit";
    private final String destExtensionDir = "extension";
    private String outputDir;
    private String outputModule;
    private String srcExtensionDir;
    private String srcWrapperDir;
    private String outputWrapperDir;

    public void generate(String[] args) throws TemplateException, IOException {

        if (args.length < 5) {
            throw new IOException("too few arguments");
        }

        int i = 0;

        outputDir = args[i++];
        outputModule = args[i++];
        srcExtensionDir = args[i++];
        srcWrapperDir = args[i++];
        outputWrapperDir = args[i++];

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        if (new File(outputDir).exists()) {
            for (File file : new File(outputDir).listFiles()) {
                if (file.isDirectory()) {FileUtils.deleteDirectory(file);} else {file.delete();}
            }
        }

        File outputEntityDirFile = new File(outputDir + File.separator + outputEntityDir);

        if (!outputEntityDirFile.exists()) {
            Files.createDirectories(outputEntityDirFile.toPath());
        }

        if (new File(outputWrapperDir).exists()) {
            for (File file : new File(outputWrapperDir).listFiles()) {
                if (file.isDirectory()) {FileUtils.deleteDirectory(file);} else {file.delete();}
            }
        }

        File outputWrapperDirFile = new File(outputWrapperDir);

        if (!outputWrapperDirFile.exists()) {
            Files.createDirectory(outputWrapperDirFile.toPath());
        }

        copyEntityExtension();

        LinkedList<GenerateEntityType<?>> generatedTypes = generateExEntities(cfg);

        generateEntityTypes(cfg, generatedTypes);

        generatePlayerExtension(cfg);
    }

    private void generatePlayerExtension(Configuration cfg) throws IOException, TemplateException {
        Template temp = cfg.getTemplate("templates/ExPlayer.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", outputModule + "." + outputEntityDir);
        root.put("extensionModuleName", extensionModule);
        root.put("version", version);


        Writer out =
                new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + outputEntityDir + File.separator + "ExPlayer.java"));
        temp.process(root, out);
        out.close();
    }

    private void copyEntityExtension() throws IOException {
        File src = new File(srcExtensionDir);
        File dest = new File(outputDir + "/" + destExtensionDir);

        FileUtils.copyDirectory(src, dest);

        src = new File(srcWrapperDir);
        dest = new File(outputWrapperDir);

        FileUtils.copyDirectory(src, dest);
    }

    public LinkedList<GenerateEntityType<?>> generateExEntities(Configuration cfg) throws TemplateException,
            IOException {

        LinkedList<GenerateEntityType<?>> generatedTypes = new LinkedList<>();

        for (GenerateEntityType<?> generateEntityType : GenerateEntityType.TYPES) {
            Class<? extends Entity> bukkitClass = generateEntityType.getBukkitClass();

            if (Modifier.isFinal(bukkitClass.getModifiers())) {
                System.out.println("Skipped " + generateEntityType.getName() + ", craft bukkit class is final");
                continue;
            }

            Class<? extends net.minecraft.world.entity.Entity> nmsClass = generateEntityType.getNmsClass();
            generateExEntity(cfg, generateEntityType.getName(), generateEntityType.getNmsTypeName(), bukkitClass,
                    nmsClass);

            generatedTypes.add(generateEntityType);
        }

        return generatedTypes;
    }

    public void generateExEntity(Configuration cfg, String name, String nmsType, Class<? extends Entity> bukkitClass,
                                 Class<? extends net.minecraft.world.entity.Entity> nmsClass) throws IOException,
            TemplateException {

        String entityClassName = "Ex" + name;

        // search extension class
        Class<?> extensionClass = null;
        try {
            extensionClass = Class.forName(extensionModule + ".Ex" + nmsClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            Class<?> superNmsClass = nmsClass.getSuperclass();
            do {
                try {
                    extensionClass = Class.forName(extensionModule + ".Ex" + superNmsClass.getSimpleName());
                } catch (ClassNotFoundException ignored) {
                }

                superNmsClass = superNmsClass.getSuperclass();
            } while (extensionClass == null);

        }

        NmsExtensionBasis extension = new NmsExtensionBasis(extensionClass, bukkitClass);

        // search template

        Template temp = null;

        try {
            temp = cfg.getTemplate(entityTemplateDir + File.separator + entityClassName + ".ftl");
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
        root.put("moduleName", outputModule + "." + outputEntityDir);
        root.put("extensionModuleName", extensionModule);
        root.put("wrapperModuleName", wrapperModule);
        root.put("version", version);
        root.put("craftName", bukkitClass.getName());
        root.put("entityName", entityClassName);
        root.put("nmsName", nmsClass.getName());
        root.put("nmsTypeName", nmsType);
        root.put("extensionEntity", extension);


        Writer out =
                new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + outputEntityDir + File.separator + entityClassName + ".java"));
        temp.process(root, out);
        out.close();
    }

    public void generateEntityTypes(Configuration cfg, List<GenerateEntityType<?>> types) throws IOException,
            TemplateException {
        Template temp = cfg.getTemplate("templates/ExEntityType.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", outputModule);
        root.put("extensionModuleName", extensionModule);
        root.put("entities", types);

        Writer out = new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + "ExEntityType.java"));
        temp.process(root, out);
        out.close();
    }
}
