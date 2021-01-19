package edu.ant.patterns.design.singleton;

import edu.ant.patterns.utils.logger.LoggingService;

public class Main {

    public static void main(String[] args) {
        LoggingService.logMsg(DoubleCheckedQueen.getInstance() == DoubleCheckedQueen.getInstance());
        LoggingService.logMsg(Queen.INSTANCE == Queen.INSTANCE);
    }

}
