package edu.ant.patterns.utils.yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validator {

    private static final Logger LOG = LoggerFactory.getLogger(Validator.class);
    private static final String FILE = ".cuvet/values.yaml";
    private static int previousIndent=0;

    public static void main(String[] args) throws IOException {
        validate(FILE, false);
    }

    public static void validate(String file, boolean isTooDeepIndent) throws IOException {

        List<char[]> charLines = Files
                .readAllLines(Paths.get(file)).stream()
                .map(String::toCharArray)
                .collect(Collectors.toList());

        for (int line = 0; line < charLines.size(); line++) {

            for (int i = 0; i < charLines.get(line).length; i++) {

                char currentChar = charLines.get(line)[i];

                if (currentChar != ' ' && i % 2 != 0) {
                    LOG.info("Line: {}, char: {}, {} spaces before: {} ", line+1, i+1, i, currentChar);
                    checkIndentation(line, i, isTooDeepIndent);
                    previousIndent = i;
                    break;
                }

                if (currentChar != ' ') {
                    checkIndentation(line, i, isTooDeepIndent);
                    previousIndent = i;
                    break;
                }
            }

        }
        LOG.info("Validation completed.");
    }

    private static void checkIndentation(int line, int i, boolean isTooDeepIndent) {
        if (isTooDeepIndent && i - previousIndent > 2) {
            LOG.info("Indentation too deep, line {}, char {}", line+1, i+1);
        }
    }

}

