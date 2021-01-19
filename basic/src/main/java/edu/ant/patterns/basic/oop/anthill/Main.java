package edu.ant.patterns.basic.oop.anthill;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Matt on 29.12.2018 at 10:44.
 *
 * Object Oriented Programming (abbreviated as OOP) is one of the most important features of Java.
 * It consists of following principles:
 * 1. Abstraction
 * 2. Encapsulation
 * 3. Inheritance
 * 4. Polymorphism
 * 5. Association
 * 6. Aggregation
 * 7. Composition
 */

public class Main {

    public static void main(String[] args) {

        Jar jar = new Jar("Raspberries");
        Pantry pantry = new Pantry(jar);
        Set<Dweller> dwellers = new HashSet<>();

        // Polymorphism: instance that inherits can be created
        // and assigned to reference of parent class.
        Dweller ant = new Ant();
        Dweller cat = new Cat();
        dwellers.add(ant);
        dwellers.add(cat);

        Anthill anthill = new Anthill(pantry, dwellers);

        anthill.getPantry().enter();
        pantry.getJar().open();
        pantry.openJar();
    }

}
