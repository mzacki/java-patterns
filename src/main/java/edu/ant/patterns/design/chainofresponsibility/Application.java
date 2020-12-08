package edu.ant.patterns.design.chainofresponsibility;

import edu.ant.utils.logger.LoggingService;

public class Application extends AlertChain {

    @Override
    void perform() {
        LoggingService.logMessage("Application receives alert from monitor");
    }

}
