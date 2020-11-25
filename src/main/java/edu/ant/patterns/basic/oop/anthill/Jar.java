package edu.ant.patterns.basic.oop.anthill;

/**
 * Created by Matt on 29.12.2018 at 10:39.
 */

public class Jar {

    private final String content;

    public Jar(String content) {
        this.content = content;
    }

    public void open() {
        System.out.println("The jar has been opened!");
    }

}
