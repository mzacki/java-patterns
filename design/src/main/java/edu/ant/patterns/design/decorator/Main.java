package edu.ant.patterns.design.decorator;

public class Main {

    public static void main(String[] args) {

        // STEP ONE
        // young ordinary bee
        Bee bee = new OrdinaryBee();
        bee.bzzz();

        // STEP TWO
        // bee can fly
        FlyingBee flyingBee = new FlyingBee(bee);
        flyingBee.bzzz();
        flyingBee.fly();

        // STEP THREE
        // she becomes the queen
        QueenBee queenBee = new QueenBee(bee);
        queenBee.bzzz();
        queenBee.reign();
    }

}
