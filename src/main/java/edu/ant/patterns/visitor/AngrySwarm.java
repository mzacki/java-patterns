package edu.ant.patterns.visitor;

public class AngrySwarm implements Bee {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
