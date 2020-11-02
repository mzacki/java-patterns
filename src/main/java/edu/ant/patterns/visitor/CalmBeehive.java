package edu.ant.patterns.visitor;

public class CalmBeehive implements Bee {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
