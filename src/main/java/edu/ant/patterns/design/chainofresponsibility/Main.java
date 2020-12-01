package edu.ant.patterns.design.chainofresponsibility;

public class Main {

    public static void main(String[] args) {

        Sensor sensor = new Sensor();
        Monitor monitor = new Monitor();
        Application application = new Application();

        sensor.appendLink(monitor);
        monitor.appendLink(application);

        sensor.perform();
    }

}
