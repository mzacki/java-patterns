package edu.ant.patterns.design.decorator;

import edu.ant.utils.logger.LoggingService;

public class OrdinaryBee implements Bee {

    @Override
    public void bzzz() {
        LoggingService.logMessage("Bzzzz....");
    }
}
