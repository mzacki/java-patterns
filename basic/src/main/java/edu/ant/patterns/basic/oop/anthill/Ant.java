package edu.ant.patterns.basic.oop.anthill;

/**
 * Created by Matt on 29.12.2018 at 10:40.
 * Inheritance: Ant inherits (extends) Dweller class, which is more abstract.
 */

public class Ant extends Dweller{

    private String chitinColour;

    // Ant adds something that parent Dweller cannot have: chitin.
    // Not every Dweller has chitin (Cat doesn't).
    // According to Eckel, it's IS-LIKE-A relationship: imperfect inheritance

}
