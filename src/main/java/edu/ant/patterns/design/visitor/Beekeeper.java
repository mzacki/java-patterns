package edu.ant.patterns.design.visitor;


import edu.ant.patterns.utils.logger.LoggingService;

public class Beekeeper implements Visitor {

    @Override
    public void visit(AngrySwarm angrySwarm) {
        LoggingService.logMsg("They are angry bees bzzzzzzzz!!!");
    }

    @Override
    public void visit(CalmBeehive calmBeehive) {
        LoggingService.logMsg("Very calm beez inside bzzzzzzzz....");
    }

}
