package edu.ant.patterns.design.chainofresponsibility;

import edu.ant.patterns.utils.logger.LoggingService;

public class Application extends AlertChain {

    @Override
    void perform() {
        LoggingService.logMsg("Application receives alert from monitor");
    }

}
