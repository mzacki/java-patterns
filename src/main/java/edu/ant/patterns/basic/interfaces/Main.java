package edu.ant.patterns.basic.interfaces;

public class Main {

    public static void main(String[] args) {

        Readable readable = new Temperature();
        readable.read();
        readable.check();

        Readable pressure = new Pressure();
        pressure.read();
        pressure.check();
    }

}
