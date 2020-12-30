package edu.ant.patterns.design.visitor;

import edu.ant.patterns.utils.logger.LoggingService;

public class Amateur implements Visitor {

    @Override
    public void visit(AngrySwarm angrySwarm) {
        LoggingService.logMsg("Bees are everywhere! Let's run!");
    }

    @Override
    public void visit(CalmBeehive calmBeehive) {
        LoggingService.logMsg("A lot of them inside the beehive!");
    }

}
