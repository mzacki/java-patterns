package edu.ant.patterns.design.factory;

import edu.ant.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        BeeFactory beeFactory = new BeeFactory();
        Bee bee = beeFactory.create(BeeRole.WORKER);
        LoggingService.logMessage(bee.getClass().getSimpleName());
    }

}
