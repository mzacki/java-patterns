package edu.ant.patterns.design.composite;

import edu.ant.patterns.utils.logger.LoggingService;

public class Fruit implements  BranchPart{

    // you can pick (actually cut) fruit
    @Override
    public boolean cut() {
        LoggingService.logMsg("Fruit has been picked");
        return true;
    }

}
