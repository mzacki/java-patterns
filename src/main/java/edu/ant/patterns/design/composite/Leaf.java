package edu.ant.patterns.design.composite;

import edu.ant.utils.logger.LoggingService;

public class Leaf implements BranchPart {

    // you can cut single leaf on a branch
    @Override
    public boolean cut() {
        LoggingService.logMessage("Leaf has been cut");
        return true;
    }
}
