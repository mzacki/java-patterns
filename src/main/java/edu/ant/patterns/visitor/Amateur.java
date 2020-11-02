package edu.ant.patterns.visitor;

public class Amateur implements Visitor {

    @Override
    public void visit(AngrySwarm angrySwarm) {
        System.out.println("Bees are everywhere! Let's run!");
    }

    @Override
    public void visit(CalmBeehive calmBeehive) {
        System.out.println("A lot of them inside the beehive!");
    }

}
