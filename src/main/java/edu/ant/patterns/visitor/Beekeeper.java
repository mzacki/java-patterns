package edu.ant.patterns.visitor;


public class Beekeeper implements Visitor {

    public void visit(AngrySwarm angrySwarm) {
        System.out.println("They are angry bees bzzzzzzzz!!!");
    }

    public void visit(CalmBeehive calmBeehive) {
        System.out.println("Very calm beez inside bzzzzzzzz....");
    }

}
