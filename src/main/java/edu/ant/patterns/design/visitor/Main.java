package edu.ant.patterns.design.visitor;

import edu.ant.patterns.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {

        AngrySwarm angrySwarm = new AngrySwarm();
        CalmBeehive calmBeehive = new CalmBeehive();

        Beekeeper beekeeper = new Beekeeper();
        LoggingService.logMessage("Beekeeper to visit angry swarm:");
        angrySwarm.accept(beekeeper);
        LoggingService.logMessage("Beekeeper to visit calm beehive:");
        calmBeehive.accept(beekeeper);

        LoggingService.logMessage("---------------------");
        Amateur amateur = new Amateur();
        LoggingService.logMessage("Amateur approached by angry swarm:");
        angrySwarm.accept(amateur);
        LoggingService.logMessage("Amateur looking at calm bees:");
        calmBeehive.accept(amateur);

    }

}
