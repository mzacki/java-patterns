package edu.ant.patterns.design.singleton;

/**
 * No need to use public static field - static factory method returns
 * always the same instance.
 * Pros:
 * + more elastic way - generic factory method can be implemented
 * + possible to change Singleton class to standard class with no API change
 * + Singleton::instance as a supplier
 * Cons:
 * - eager initialization
 * */

public class QueenFromStaticFactory {

    private static final QueenFromStaticFactory INSTANCE = new QueenFromStaticFactory();

    private QueenFromStaticFactory() {
    }

    public static QueenFromStaticFactory getInstance() {
        return INSTANCE;
    }

}
