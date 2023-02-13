package edu.ant.patterns.basic.oop.passing;

import java.util.Objects;

public class Circle implements Comparable<Circle> {

    private final int coordinateX;
    private final int coordinateY;
    private final int radius;

    public Circle(int x, int y, int r) {
        if (r < 0) throw new IllegalArgumentException("Circle radius cannot be negative");
        this.coordinateX = x;
        this.coordinateY = y;
        this.radius = r;
    }

    // copy constructor instead of clone() overriding
    public Circle(Circle original) {
        this.coordinateX = original.coordinateX;
        this.coordinateY = original.coordinateY;
        this.radius = original.radius;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getRadius() {
        return radius;
    }

    // Object class method toString() to override
    @Override
    public String toString() {
        return "x: " + coordinateX +
                    ", y: " + coordinateY +
                    ", r: " + radius;
    }

    // Object class method equals() to override
    @Override
    public boolean equals(Object o) {
        // same references == same object
        if (o == this) return true;
        // cannot be null
        if (Objects.equals(o, null)) return false;
        // must be of the same class
        if (!(o instanceof Circle)) return false;
        // Cast to class to further comparing...
        Circle that = (Circle) o;
        // and compare internals.
        return this.coordinateX == that.coordinateX &&
                this.coordinateY == that.coordinateY &&
                this.radius == that.radius;
    }

    // if equals() is overriden, then hashCode should be overriden, too
    // hashing algorithm from J. Bloch Effective Java
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + coordinateX;
        result = 37 * result + coordinateY;
        result = 37 * result + radius;

        return result;
    }

    // override compareTo from Comparable
    @Override
    public int compareTo(Circle that) {
        return this.radius - that.radius;
    }

}
