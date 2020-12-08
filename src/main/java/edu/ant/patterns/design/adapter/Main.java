package edu.ant.patterns.design.adapter;

public class Main {

    public static void main(String[] args) {

        // a bumblebee of type common carder: males are ginger-brown, female creamy-white
        Bumblebee bumblebee = new CommonCarder();

        // the bumblebee must become a honey bee (otherwise he would not be allowed in to the beehive)
        Bee bee = new BumblebeeToBeeAdapter(bumblebee);

        // normally, this bee would dance
        // however, don't be mistaken by the name itself: this is a bumblebee disguised as a bee
        // he will pretend he can dance
        bee.dance();
    }

}
