/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.generator;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LibraryEntityGenerator {

  public static final String VERSION = "v1_19_R1";

  public static final Logger LOGGER;

  static {
    LOGGER = Logger.getLogger("library-entities");
    LOGGER.setUseParentHandlers(false);
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new SimpleFormatter() {
      private static final String format = "[%2$-7s] %3$s %n";

      @Override
      public synchronized String format(LogRecord lr) {
        return String.format(format,
            new Date(lr.getMillis()),
            lr.getLevel().getLocalizedName(),
            lr.getMessage()
        );
      }
    });
    LOGGER.addHandler(handler);
  }

  public static void main(String[] args)
      throws IOException, TemplateException, ClassNotFoundException {
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

    // add generators
    generators.addLast(
        new EntityGenerator(cfg, entitySrcDir, entityOutputDir, entityOutputModule));

    generators.addLast(new WrapperGenerator(cfg, new File(wrapperSrcDir),
        new File(wrapperOutputDir)));

    generators.addLast(new PathfinderGenerator(cfg, new File(pathfinderSrcDir),
        new File(pathfinderOutputDir)));

    // run generators
    generators.forEach(EntitiesGenerator::clean);
    generators.forEach(EntitiesGenerator::generate);
  }


}
