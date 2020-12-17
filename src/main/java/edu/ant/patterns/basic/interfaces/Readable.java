package edu.ant.patterns.basic.interfaces;

import edu.ant.patterns.utils.logger.LoggingService;

/**
 * Interface does not have a constructor.
 * One cannot create instance of an interface.
 * */

public interface Readable {

    // all fields are implicitly PUBLIC STATIC FINAL
    // HOWEVER
    // The constant interface pattern is a poor use of interfaces
    // no need to implement details here or to couple classes with interfaces by the constants
    // move it to ENUM or SEPARATE CLASS
    String NAME = "READABLE_INTERFACE";

    // no need to implement default methods in child classes
    default void check() {
        LoggingService.logMessage("Checking " + getName());
    }

    // interface method is implicitly PUBLIC and ABSTRACT - such keywords are redundant
    void read();

    // interface can have private helper methods
    private String getName() {
        return NAME;
    }

}
