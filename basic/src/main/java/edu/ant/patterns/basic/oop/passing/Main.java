package edu.ant.patterns.basic.oop.passing;

public class Main {

    // example from Evans, Flanagan: Java in a Nutshell. A Desktop Quick Reference 7th Edition
    // Java is pass-by-value languange
    // when a reference type (object) is involved, the value that is passed is a copy of the reference (as a value)
    // (not a reference to the reference)
    public static void manipulate(Circle circle) {
        circle = new Circle(1, 1, 3);
        System.out.println(circle);
    }

    // hence value contained in variable c remains unaltered
    public static void main(String[] args) {
        Circle c = new Circle(0, 0, 2);
        manipulate(c);
        System.out.println("Radius: " + c.getRadius());
    }

}
