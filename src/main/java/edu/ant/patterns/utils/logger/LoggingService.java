package edu.ant.patterns.utils.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingService {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingService.class);

    private LoggingService() {}

    public static void logMessage(Object... args) {
        LOG.info("Logging service msg: {}", args);
    }

    public static void logTwoArgs(Object... args) {
        LOG.info("Logging service msg: {} {}", args);
    }

    public static void logThreeArgs(Object... args) {
        LOG.info("Logging service msg: {} {} {}", args);
    }

    public static Logger getLogger() {
        return LOG;
    }

    public static void logError(Exception e) {
        LOG.error("ERROR {} {}", e.getClass().getName(), e.getMessage());
    }

}
