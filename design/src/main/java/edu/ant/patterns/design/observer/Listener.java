package edu.ant.patterns.design.observer;

public interface Listener {

    String getId();

    void notify(String id, String msg);

}

