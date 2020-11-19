package edu.ant.patterns.visitor;


import edu.ant.utils.logger.LoggingService;

public class Beekeeper implements Visitor {

    @Override
    public void visit(AngrySwarm angrySwarm) {
        LoggingService.logMessage("They are angry bees bzzzzzzzz!!!");
    }

    @Override
    public void visit(CalmBeehive calmBeehive) {
        LoggingService.logMessage("Very calm beez inside bzzzzzzzz....");
    }

}
