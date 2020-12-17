package edu.ant.patterns.utils.files;

import edu.ant.patterns.utils.logger.LoggingService;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static final String INPUT = "src/main/resources/input.txt";
    private static final String OUTPUT = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {

        FileReader.read(INPUT);
        FileReader.list(INPUT);
        FileReader.stream(INPUT);

        FileWriter.write(FileReader.list(INPUT), OUTPUT);
        FileWriter.add(Arrays.asList(" ", "Zbigniew Herbert"), OUTPUT);

        // in classpath
        if (!FileHelper.isFile("new.txt")) {
            FileHelper.create("new.txt");
        }

        LoggingService.logMessage(FileHelper.isFile("src/main/resources"));
        LoggingService.logMessage(FileHelper.isFile(INPUT));
        LoggingService.logMessage(FileHelper.isDir(INPUT));
        LoggingService.logMessage(FileHelper.isDir("src/main/resources"));
    }

}