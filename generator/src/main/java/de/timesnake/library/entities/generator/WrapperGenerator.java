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
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
