package edu.ant.patterns.visitor;

public class CalmBeehive implements Bee {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
