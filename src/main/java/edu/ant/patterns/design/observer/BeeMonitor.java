package edu.ant.patterns.design.observer;

import edu.ant.patterns.utils.logger.LoggingService;
import java.util.Collection;
import java.util.HashSet;

/**
 * Publisher that monitors bees behaviour in a beehive
 * and beehive parameters observed by Listeners.
 */

public class BeeMonitor {

    private final String id;
    private final Collection<Listener> listeners;

    public BeeMonitor(String id) {
        this.id = id;
        this.listeners = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    /**
     * Publishes data to listeners (a.k.a. observers)
     */
    public void publish(String msg) {
        listeners.forEach(l -> l.notify(id, msg));
    }

    public void addListener(Listener listener) {
        LoggingService.logThreeArgs(listener.getId(), " listener has been added to ", id);
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

}
