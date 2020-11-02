package edu.ant.patterns.visitor;

public class AngrySwarm implements Bee {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
