package edu.ant.patterns.basic.abstracts;

import edu.ant.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        // Class Insect is abstract, cannot be instantiated
        // Insect insect = new Insect();

        // polymorphysm - child object can be created and referenced by a referency of super class
        Insect insect = new Hymenoptera("Ant", "Antish mandible");
        // subclass inherits final method from abstract class, but cannot override
        insect.buildColony();
        // finally, subclass must implement inherited abstract method
        insect.contact();

        Hymenoptera hymenoptera = new Hymenoptera("Bee", "Bee mandible");
        // fly() cannot be called on Insect class reference, but on Hymenoptera only
        hymenoptera.fly();
        hymenoptera.buildColony();
        // finally, subclass must implement inherited abstract method
        insect.contact();

        LoggingService.logMessage(insect.getName());
        LoggingService.logMessage(hymenoptera.getName());
    }

}
