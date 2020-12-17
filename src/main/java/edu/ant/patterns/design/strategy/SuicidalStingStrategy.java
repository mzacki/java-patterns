package edu.ant.patterns.design.strategy;


import edu.ant.patterns.utils.logger.LoggingService;

public class SuicidalStingStrategy implements StingStrategy {

    @Override
    public void sting() {
        LoggingService.logMessage("Sting with full strength (but you won't survive the attack)");
    }

}
