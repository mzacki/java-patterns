package edu.ant.patterns.basic.abstract_class;

/**
 * Abstract class cannot be instanciated
 * Objects cannot be initialized
 * */
public abstract class Insect {

    // Abstract class can have non-static fields...
    // ... both final...
    private final String name;
    // ... and non-final
    private String discoveredBy;
    // and static.
    private static final String STATIC_FIELD = "INSECT";
    private static String staticButNonFinalField;

    // Abstract class can have constructors...
    // Interfaces cannot have constructors
    public Insect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    // Abstract classs can have final method implemented
    // Such method cannot be overriden
    // but can be inherited
    public final void buildColony() {
        // instantiated
    }

    // MOST IMPORTANT PART:
    // abstract method to be implemented by subclasses
    // abstract methods cannot have body
    public abstract void contact();

}
