/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.generator;

import freemarker.template.Configuration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.commons.io.FileUtils;

public class WrapperGenerator implements EntitiesGenerator {

    public static final String WRAPPER_MODULE = "de.timesnake.library.entities.wrapper";

    private final Configuration cfg;
    private final File srcDir;
    private final File outputDir;

    public WrapperGenerator(Configuration cfg, File srcDir, File outputDir) {
        this.cfg = cfg;
        this.srcDir = srcDir;
        this.outputDir = outputDir;
    }

    @Override
    public boolean clean() {
        if (outputDir.exists()) {
            for (File file : outputDir.listFiles()) {
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
            if (!outputDir.exists()) {
                Files.createDirectory(outputDir.toPath());
            }
            FileUtils.copyDirectory(srcDir, outputDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
