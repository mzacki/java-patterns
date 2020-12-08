package edu.ant.patterns.design.adapter;

import edu.ant.patterns.utils.logger.LoggingService;

public class CommonCarder implements Bumblebee {

    @Override
    public void ruffle() {
        LoggingService.logMessage("Furry fur!");
    }
}
