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
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class LibraryEntityGenerator {

    public static final String VERSION = "v1_19_R1";

    public static final Logger LOGGER = Logger.getLogger("library-entities");

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
        generators.addLast(new EntityGenerator(cfg, entitySrcDir, entityOutputDir, entityOutputModule));

        generators.addLast(new WrapperGenerator(cfg, new File(wrapperSrcDir),
                new File(wrapperOutputDir)));

        generators.addLast(new PathfinderGenerator(cfg, new File(pathfinderSrcDir), new File(pathfinderOutputDir)));

        // run generators
        generators.forEach(EntitiesGenerator::clean);
        generators.forEach(EntitiesGenerator::generate);
    }


}
