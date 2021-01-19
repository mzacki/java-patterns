package edu.ant.patterns.design.factory;

import edu.ant.patterns.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        BeeFactory beeFactory = new BeeFactory();
        Bee bee = beeFactory.create(BeeRole.WORKER);
        LoggingService.logMsg(bee.getClass().getSimpleName());
    }

}
