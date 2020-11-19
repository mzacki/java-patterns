package edu.ant.utils.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingService {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingService.class);

    private LoggingService() {}

    public static void logMessage(Object... args) {
        LOG.info("Logging service msg: {}", args);
    }

}
