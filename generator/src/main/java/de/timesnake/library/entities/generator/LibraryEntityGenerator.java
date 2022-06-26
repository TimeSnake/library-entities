package de.timesnake.library.entities.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LibraryEntityGenerator {

    public static final String VERSION = "v1_19_R1";

    public static void main(String[] args) throws IOException, TemplateException, ClassNotFoundException {
        new LibraryEntityGenerator().generate(args);
    }

    public static List<Class<?>> getClasses(File directory, String packageName) {
        LinkedList<Class<?>> classes = new LinkedList<>();

        if (directory.exists()) {
            for (String file : directory.list()) {
                if (file.endsWith(".java") || file.endsWith(".class")) {
                    try {
                        classes.add(Class.forName(packageName + '.' +
                                file.replace(".java", "").replace(".class", "")));
                    } catch (ClassNotFoundException ignored) {
                    }
                }
            }
        }
        return classes;
    }

    private final String extensionModule = "de.timesnake.library.entities.entity.extension";
    private final String destEntityDir = "bukkit";
    private Configuration cfg;

    private String entityOutputDir;
    private String entityOutputModule;

    private String entitySrcDir;

    private String wrapperSrcDir;
    private String wrapperOutputDir;

    private String pathfinderSrcDir;
    private String pathfinderOutputDir;

    public void generate(String[] args) throws TemplateException, IOException {

        if (args.length < 6) {
            throw new IOException("too few arguments");
        }

        int i = 0;

        entityOutputDir = args[i++];
        entityOutputModule = args[i++];
        entitySrcDir = args[i++];
        wrapperSrcDir = args[i++];
        wrapperOutputDir = args[i++];
        pathfinderSrcDir = args[i++];
        pathfinderOutputDir = args[i++];

        this.cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        LinkedList<EntitiesGenerator> generators = new LinkedList<>();

        generators.addLast(new EntityGenerator(cfg, entitySrcDir, entityOutputDir, entityOutputModule));

        generators.addLast(new WrapperGenerator(cfg, new File(wrapperSrcDir),
                new File(wrapperOutputDir)));

        generators.addLast(new PathfinderGenerator(cfg, new File(pathfinderSrcDir), new File(pathfinderOutputDir)));

        generators.forEach(EntitiesGenerator::clean);
        generators.forEach(EntitiesGenerator::generate);

        generatePlayerExtension();
    }

    private void generatePlayerExtension() throws IOException, TemplateException {
        Template temp = cfg.getTemplate("templates/ExPlayer.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("moduleName", entityOutputModule + "." + destEntityDir);
        root.put("entityModuleName", entityOutputModule);
        root.put("extensionModuleName", extensionModule);
        root.put("version", VERSION);


        Writer out =
                new OutputStreamWriter(new FileOutputStream(entityOutputDir + File.separator + destEntityDir + File.separator + "ExPlayer.java"));
        temp.process(root, out);
        out.close();
    }


}
