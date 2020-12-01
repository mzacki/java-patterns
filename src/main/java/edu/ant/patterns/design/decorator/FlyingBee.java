package edu.ant.patterns.design.decorator;

import edu.ant.patterns.utils.logger.LoggingService;

// Decorator class that improve behaviour of OrdinaryBee class
// by adding new method fly()
public class FlyingBee implements Bee {

    // can bee any bee (even ordinary bee) that implements Bee interface
    private final Bee bee;

    public FlyingBee(Bee bee) {
        this.bee = bee;
    }

    // Needs to be overriden when implementing Bee interface
    // this way any bee behaves like A BEE!
    @Override
    public void bzzz() {
        bee.bzzz();
    }

    // Here is how Decorator class (FlyingBee in this case)
    // improves behaviour of oridnary class:
    // by adding new functionality
    public void fly() {
        LoggingService.logMessage("I can fly!");
    }

}
