package edu.ant.patterns.design.singleton;

import edu.ant.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        LoggingService.logMessage(DoubleCheckedQueen.getInstance() == DoubleCheckedQueen.getInstance());
        LoggingService.logMessage(Queen.INSTANCE == Queen.INSTANCE);
    }

}
