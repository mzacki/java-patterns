package edu.ant.patterns.design.singleton;

/**
 * INNER STATIC HOLDER IMPLEMENTATION
 * If you prefer to avoid using synchronized altogether, you can use an inner static
 * class to hold the reference instead. Inner static classes are guaranteed to load lazily.
 */

// ThreadSafe
public class QueenInstanceFactory {

    private static class ResourceHolder {

        public static final Resource resource = new Resource();
        // This will be lazily initialised
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }

    static class Resource {
        // empty
    }

}
