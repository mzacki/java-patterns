package edu.ant.patterns.design.visitor;

import edu.ant.patterns.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {

        AngrySwarm angrySwarm = new AngrySwarm();
        CalmBeehive calmBeehive = new CalmBeehive();

        Beekeeper beekeeper = new Beekeeper();
        LoggingService.logMsg("Beekeeper to visit angry swarm:");
        angrySwarm.accept(beekeeper);
        LoggingService.logMsg("Beekeeper to visit calm beehive:");
        calmBeehive.accept(beekeeper);

        LoggingService.logMsg("---------------------");
        Amateur amateur = new Amateur();
        LoggingService.logMsg("Amateur approached by angry swarm:");
        angrySwarm.accept(amateur);
        LoggingService.logMsg("Amateur looking at calm bees:");
        calmBeehive.accept(amateur);

    }

}
