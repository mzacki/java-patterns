package edu.ant.patterns.singleton;

import java.io.Serializable;

public class QueenSerializable implements Serializable {

    // transient required in case of serialization
    private final transient int year;
    private final transient Enum mark;
    private final transient String breed;

    private static QueenSerializable INSTANCE;

    private QueenSerializable() {
        year = 2018;
        mark = Mark.RED;
        breed = "Carnica";
    }

    // factory method let us follow Open / Close principle
    public static QueenSerializable getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new QueenSerializable();
        }
        return INSTANCE;
    }

    // method required in case of serialization
    private Object readResolve() {
        return getInstance();
    }

}
