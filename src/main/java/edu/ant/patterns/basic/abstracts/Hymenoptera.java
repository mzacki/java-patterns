package edu.ant.patterns.basic.abstracts;


public class Hymenoptera extends Insect {

    private String mandibleType;

    public Hymenoptera(String name, String mandibleType) {
        super(name);
        this.mandibleType = mandibleType;
    }

    public void fly() {
        // implementation
    }

    @Override
    public void contact() {
        // obligatory implementation of abstract method in abstract class
        // if not overrides, this class would be declared abstract itself
    }


}
