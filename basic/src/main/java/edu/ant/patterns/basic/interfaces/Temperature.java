package edu.ant.patterns.basic.interfaces;

import edu.ant.patterns.utils.logger.LoggingService;

public class Temperature implements Readable{

    private static final String TEMPERATURE = "T";

    // all interface methods has to be implemented
    @Override
    public void read() {
        LoggingService.logMsg("Reading " + TEMPERATURE);
    }
}
