package edu.ant.patterns.design.singleton;

/**
 * Similar to Static Factory Implementation but lazy:
 * - initialized not via the field, but in the factory method
 * - saves the resources
 * - created only if needed
 * */

public class LazyQueen {

    private static LazyQueen INSTANCE;

    private LazyQueen() {}

    public static LazyQueen getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LazyQueen();
        }
        return INSTANCE;
    }

}
