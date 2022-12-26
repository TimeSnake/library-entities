/*
 * Copyright (C) 2022 timesnake
 */

package de.timesnake.library.entities.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class PathfinderGenerator implements EntitiesGenerator {

    private final List<String> FILES_TO_COPY = List.of("ExPathfinderGoal.java", "ExPathfinderGoalTarget.java");

    private final Configuration cfg;

    private final File srcDir;
    private final File outputDir;

    public PathfinderGenerator(Configuration cfg, File srcDir, File outputDir) {
        this.cfg = cfg;
        this.srcDir = srcDir;
        this.outputDir = outputDir;
    }

    @Override
    public boolean clean() {
        if (outputDir.exists()) {
            for (File file : outputDir.listFiles()) {
                if (file.isFile()) {
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

            for (Generator_PathfinderGoal<?> pathfinderGoal : Generator_PathfinderGoal.TYPES) {
                this.copyPathfinderBasis();
                this.generatePathfinderGoal(pathfinderGoal, false);
            }

            for (Generator_PathfinderGoal<?> pathfinderGoal : Generator_PathfinderGoal.TARGET_TYPES) {
                this.generatePathfinderGoal(pathfinderGoal, true);
            }

        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private void generatePathfinderGoal(Generator_PathfinderGoal<?> pathfinderGoal, boolean isTargetGoal) throws IOException,
            TemplateException {

        Template temp;

        if (isTargetGoal) {
            temp = cfg.getTemplate("templates/pathfinder/ExPathfinderGoalTarget.ftl");
        } else {
            temp = cfg.getTemplate("templates/pathfinder/ExPathfinderGoal.ftl");
        }

        HashMap<String, Object> root = new HashMap<>();

        root.put("pathfinder", pathfinderGoal);

        Writer out =
                new OutputStreamWriter(new FileOutputStream(outputDir.getAbsolutePath() + File.separator +
                        pathfinderGoal.getExName() + ".java"));
        temp.process(root, out);
        out.close();
    }


    private void copyPathfinderBasis() throws IOException {
        for (File file : srcDir.listFiles(f -> f.isFile() && FILES_TO_COPY.contains(f.getName()))) {
            FileUtils.copyFile(file, new File(outputDir.getAbsolutePath() + File.separator + file.getName()));
        }
    }
}
