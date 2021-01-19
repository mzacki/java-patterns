package edu.ant.patterns.basic.interfaces;

import edu.ant.patterns.utils.logger.LoggingService;

public class Pressure implements Readable {

    // overriding default methods is allowed
    @Override
    public void check() {
        LoggingService.logMsg("Checking pressure...");
    }

    // overriding abstract methods is a must
    @Override
    public void read() {
        LoggingService.logMsg("Reading pressure...");
    }

}
