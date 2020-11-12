package edu.ant.patterns.singleton;

/**
* Private contructor prevents creation of other instances.
* Access to the instance via public static final field.
 * In minus:
 * - eager initialization - the instance is crated once the class has been loaded
 * - exposed public static field
 * */
public class QueenInPublic {

    public static final QueenInPublic INSTANCE = new QueenInPublic();

    private QueenInPublic() {
        // in order to prevent duplication by the use of reflection setAccessible() method
        if (INSTANCE != null) {
            throw new IllegalStateException("Queen Bee already exists!");
        }
    }

}
