package edu.ant.patterns.design.chainofresponsibility;


import edu.ant.patterns.utils.logger.LoggingService;

public class Sensor extends AlertChain {

    @Override
    void perform() {
        LoggingService.logMessage("Sensor discovers event....");
        callNextLink();
    }

}
