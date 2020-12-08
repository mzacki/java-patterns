package edu.ant.patterns.design.chainofresponsibility;

import edu.ant.utils.logger.LoggingService;

public class Monitor extends AlertChain {

    @Override
    void perform() {
        LoggingService.logMessage("Monitor receives hint from sensor.");
        callNextLink();
    }

}
