package edu.ant.patterns.singleton;

// volatile is also compliant solution according to some
public class QueenInstanceFactoryVolatile {

    // BEEware as Sonar complaints that volatile is not enough
    private volatile Resource resource;

    public Resource getResource() {
        Resource localResource = resource;
        if (localResource == null) {
            synchronized (this) {
                localResource = resource;
                if (localResource == null) {
                    resource = localResource = new Resource();
                }
            }
        }
        return localResource;
    }

    static class Resource {
        // empty
    }

}
