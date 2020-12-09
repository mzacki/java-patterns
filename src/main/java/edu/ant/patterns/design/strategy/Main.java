package edu.ant.patterns.design.strategy;

import edu.ant.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {

        StingerBee stingerBee = new StingerBee(new DeterrenceStingStrategy());
        stingerBee.sting();
        stingerBee.setStingStrategy(new SuicidalStingStrategy());
        stingerBee.sting();

        // custom implementation of sting strategy: as it's functional interface with SAM, we can use lambda
        stingerBee.setStingStrategy(() -> LoggingService.logMessage("Custom sting strategy: just scratch two times."));
        stingerBee.sting();
    }

}
