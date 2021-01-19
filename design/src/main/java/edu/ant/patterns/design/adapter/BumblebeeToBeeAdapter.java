package edu.ant.patterns.design.adapter;


public class BumblebeeToBeeAdapter implements Bee {

    private final Bumblebee bumblebee;

    public BumblebeeToBeeAdapter(Bumblebee bumblebee) {
        this.bumblebee = bumblebee;
    }

    // implementing unique methods of honey bees
    // bumblebees will do their best!
    @Override
    public void dance() {
        bumblebee.ruffle();
    }
}
