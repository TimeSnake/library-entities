package de.timesnake.library.entities_generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import net.minecraft.world.entity.EntityInsentient;
import org.bukkit.entity.Entity;

import java.io.*;
import java.lang.reflect.Modifier;
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

    private String outputDir;
    private String outputModule;
    private String handCodeDir;
    private String handCodeModule;
    private String extensionModule;
    private String version;

    public void generate(String[] args) throws TemplateException, IOException, ClassNotFoundException {

        if (args.length < 4) {
            throw new IOException("too few arguments");
        }

        int i = 0;

        outputDir = args[i++];
        outputModule = args[i++];

        handCodeDir = args[i++];
        handCodeModule = args[i++];

        extensionModule = args[i++];

        version = args[i++];

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        for (File file : new File(outputDir).listFiles()) {
            file.delete();
        }

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

        generateEntityTypes(cfg, generatedTypes);
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

        // search handed classes
        Class<?> entityClass = null;

        try {
            entityClass = Class.forName(handCodeModule + "." + entityClassName);
        } catch (ClassNotFoundException ignored) {

        }

        Template temp;

        if (entityClass != null) {
            temp = cfg.getTemplate("templates/ExEntityHandCoded.ftl");
            // copy hand coded to output module

            File src = new File(handCodeDir + File.separator + entityClassName + ".java");
            File dest = new File(outputDir + File.separator + entityClassName + ".java");

            modifyFile(src, dest, "package " + handCodeModule + ";", "package " + outputModule + ";");

            // rename delegation class
            entityClassName = entityClassName + "Basis";
        } else {
            if (EntityInsentient.class.isAssignableFrom(nmsClass)) {
                temp = cfg.getTemplate("templates/ExEntityInsentient.ftl");
            } else {
                temp = cfg.getTemplate("templates/ExEntity.ftl");
            }

        }

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", outputModule);
        root.put("extensionModuleName", extensionModule);
        root.put("version", version);
        root.put("craftName", bukkitClass.getName());
        root.put("entityName", entityClassName);
        root.put("nmsName", nmsClass.getName());
        root.put("nmsTypeName", nmsType);
        root.put("extensionEntity", extension);


        Writer out = new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + entityClassName +
                ".java"));
        temp.process(root, out);
        out.close();
    }

    public void generateEntityTypes(Configuration cfg, List<GenerateEntityType<?>> types) throws IOException,
            TemplateException {
        Template temp = cfg.getTemplate("templates/ExEntityType.ftl");
        ;

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", outputModule);
        root.put("extensionModuleName", extensionModule);
        root.put("entities", types);

        Writer out = new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + "ExEntityType.java"));
        temp.process(root, out);
        out.close();
    }
}
