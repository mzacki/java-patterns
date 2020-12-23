package edu.ant.patterns.basic.reflection;

public abstract class Step<T> {

    private final Class<T> klazz;

    public Step (Class<T> klazz) {
        this.klazz = klazz;
    }

    public Class<T> getKlazz() {
        return klazz;
    }

    public String getType() {
        return klazz.getTypeName();
    }

}
