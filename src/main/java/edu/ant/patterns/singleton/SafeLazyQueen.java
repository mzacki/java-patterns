package edu.ant.patterns.singleton;

// ThreadSafe
public class SafeLazyQueen {

    private static Resource instance;

    public static synchronized Resource getInstance() {
        if (instance == null) {
            instance = new Resource();
        }
        return instance;
    }

    static class Resource {

    }
}
