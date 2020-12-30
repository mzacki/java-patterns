package edu.ant.patterns.design.decorator;

import edu.ant.patterns.utils.logger.LoggingService;

// another decorator class
// adds new option for some selected bees
// that is ruling the beehive as queens do
// in nature, it happens when young bee
// is fed with royal jelly
public class QueenBee implements Bee{

    private final Bee bee;

    public QueenBee(Bee bee) {
        this.bee = bee;
    }

    // implements specific method
    @Override
    public void bzzz() {
        LoggingService.logMsg("Queen's bzzz is different that others'");
    }

    public void reign() {
        LoggingService.logMsg("I can rule the beehive!");
    }

}
