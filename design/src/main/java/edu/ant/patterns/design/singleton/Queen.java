package edu.ant.patterns.design.singleton;

/**Singleton implemented as enum. Simple and acceptable solution.
 * Best way according to Effective Java (Bloch)
* IN PLUS:
*  + consistent
 *  + serializable
 *  + can implement interfaces
 *  + reflexion- and cloning proof
 *  IN MINUS:
*  + no lazy loading
 *  + cannot extend classes
 * */

public enum Queen implements Bee {
    INSTANCE;

    private final int year;
    private final Enum mark;
    private final String breed;

    Queen() {
        year = 2020;
        mark = Mark.BLUE;
        breed = "PK";
    }

}
