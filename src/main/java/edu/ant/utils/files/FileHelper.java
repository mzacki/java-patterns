package edu.ant.utils.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    private FileHelper() {}

    public static void create(String file) throws IOException {
        Path path = Paths.get(file);
        Files.createFile(path);
    }

    public static boolean isFile(String file) {
        Path path = Paths.get(file);
        return Files.isRegularFile(path);
    }

    public static boolean isDir(String dir) {
        Path path = Paths.get(dir);
        return Files.isDirectory(path);
    }


}
