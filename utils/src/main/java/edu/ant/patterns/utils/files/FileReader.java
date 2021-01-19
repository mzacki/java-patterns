package edu.ant.patterns.utils.files;

import edu.ant.patterns.utils.logger.LoggingService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    private FileReader() {}

    // we do not use try catch here, according to throw early catch late principle
    public static void read(String file) throws IOException {
        Path path = Paths.get(file);
        List<String> lines = Files.readAllLines(path);
        lines.forEach(LoggingService::logMsg);
    }

    public static List<String> list(String file) throws IOException {
        Path path = Paths.get(file);
        return Files.readAllLines(path);
    }

    // return direct Stream
    public static Stream<String> stream(String file) throws IOException {
        Path path = Paths.get(file);
        return Files.lines(path);
    }

}
