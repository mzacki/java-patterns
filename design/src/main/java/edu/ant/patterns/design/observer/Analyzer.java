package edu.ant.patterns.design.observer;

import edu.ant.patterns.utils.logger.LoggingService;

public class Analyzer implements Listener {

    private final String id;

    public Analyzer(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void notify(String name, String msg) {
        LoggingService.logMsg("Message received by analyzer: " + msg);
        process(msg);
    }

    private void process(String msg) {
        LoggingService.logMsg("Message is being parsed and processed...");
        LoggingService.logMsg("Analysis completed.");
    }

}
