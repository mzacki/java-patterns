package edu.ant.patterns.utils.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriter {

    private FileWriter() {}

    public static void write(List<String> lines, String outputPath) throws IOException {
        Path path = Paths.get(outputPath);
        Files.write(path, lines);
    }

    public static void add(List<String> lines, String outputPath) throws IOException {
        Path path = Paths.get(outputPath);
        Files.write(path, lines, StandardOpenOption.APPEND);
    }

}
