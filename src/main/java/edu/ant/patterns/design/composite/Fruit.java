package edu.ant.patterns.design.composite;

import edu.ant.utils.logger.LoggingService;

public class Fruit implements  BranchPart{

    // you can pick (actually cut) fruit
    @Override
    public boolean cut() {
        LoggingService.logMessage("Fruit has been picked");
        return true;
    }

}
