package edu.ant.patterns.design.observer;

import edu.ant.utils.logger.LoggingService;

/**
 * Any device listening to the monitor - able to receive messages.
 */

public class Observer implements Listener {

    private final String id;

    public Observer(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Once Monitor publishes new msg, it notifies all attached listeners
     * by calling notify method that launches some business logic.
     */
    @Override
    public void notify(String name, String text) {
        LoggingService.logMessage("Observer id " + id + " has been notified");
    }

}
