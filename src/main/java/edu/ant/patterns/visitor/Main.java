package edu.ant.patterns.visitor;

public class Main {

    public static void main(String[] args) {
        AngrySwarm angrySwarm = new AngrySwarm();
        CalmBeehive calmBeehive = new CalmBeehive();

        Beekeeper beekeeper = new Beekeeper();
        System.out.println("Beekeeper to visit angry swarm:");
        angrySwarm.accept(beekeeper);
        System.out.println("Beekeeper to visit calm beehive:");
        calmBeehive.accept(beekeeper);

        System.out.println("---------------------");
        Amateur amateur = new Amateur();
        System.out.println("Amateur approached by angry swarm:");
        angrySwarm.accept(amateur);
        System.out.println("Amateur looking at calm bees:");
        calmBeehive.accept(amateur);

    }
}
