package edu.ant.patterns.design.builder;

import edu.ant.patterns.utils.logger.LoggingService;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Beehive myFirstBeehive = new Beehive.Builder()
                .setBoxes(Collections.singletonList(new Box()))
                .setColony(new Colony())
                .setType(Type.OSTROWSKA)
                .build();

        LoggingService.logMessage("Automatically counted no. of boxes as height: " + myFirstBeehive.getHeight());
        LoggingService.logMessage("My first beehive: " + myFirstBeehive.toString());
    }

}
