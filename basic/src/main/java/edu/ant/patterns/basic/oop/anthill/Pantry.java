package edu.ant.patterns.basic.oop.anthill;

/**
 * Created by Matt on 29.12.2018 at 10:36.
 */

public class Pantry {

    private final Jar jar;

    public Pantry(Jar jar) {
        this.jar = jar;
    }

    public Jar getJar() {
        return jar;
    }

    public void enter() {
        System.out.println("Cat enters the Pantry!");
    }

    public void openJar() {
        System.out.println("In the Pantry: Cat opens a jar!");
        jar.open();
    }

}
