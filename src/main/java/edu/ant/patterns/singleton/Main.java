package edu.ant.patterns.singleton;

import edu.ant.solutions.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        LoggingService.logMessage(DoubleCheckedQueen.getInstance() == DoubleCheckedQueen.getInstance());
        LoggingService.logMessage(Queen.INSTANCE == Queen.INSTANCE);
    }

}
