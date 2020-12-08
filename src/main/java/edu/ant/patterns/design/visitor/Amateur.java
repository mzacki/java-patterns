package edu.ant.patterns.design.visitor;

import edu.ant.utils.logger.LoggingService;

public class Amateur implements Visitor {

    @Override
    public void visit(AngrySwarm angrySwarm) {
        LoggingService.logMessage("Bees are everywhere! Let's run!");
    }

    @Override
    public void visit(CalmBeehive calmBeehive) {
        LoggingService.logMessage("A lot of them inside the beehive!");
    }

}
