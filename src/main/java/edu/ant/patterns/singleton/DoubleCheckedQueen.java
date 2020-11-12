package edu.ant.patterns.singleton;

/**
 * Singleton is considered to be anti-pattern.
 * Double-checked implementation in particular.
 * Other solutions are possible
 * See java:S2168 Sonar complaint.
 * Weaknesses of anti-pattern:
 * - difficult testing if singleton is stateful
 * - more tight coupling
 * - single responsibility principle is broken
 * - open / close principle is broken (unless factory method implemented)
 * - it's a kind of object-related public static variable (which is very bad)
 */

// NotThreadSafe
public class DoubleCheckedQueen {

    private final int year;
    private final Enum mark;
    private final String breed;

    // Static field initialized by only one instance of DoubleCheckedQueen. No more instances can be created.
    private static DoubleCheckedQueen instance;

    // Private constructor does not allow to create instances at will
    private DoubleCheckedQueen() {
        year = 2019;
        mark = Mark.GREEN;
        breed = "Sklenar";
    }

    // Method to get the only instance of class
    public static DoubleCheckedQueen getInstance() {
        // Double check:
        // first, multiple threads can enter the if
        if(instance == null) {
            // more than one thread can invoke the block, so second check uses synchronized keyword
            synchronized (DoubleCheckedQueen.class) {
                if(instance == null) {
                    instance = new DoubleCheckedQueen();
                }
            }
        }

        return instance;
    }


}
